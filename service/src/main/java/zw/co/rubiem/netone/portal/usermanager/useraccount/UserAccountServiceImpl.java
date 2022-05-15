package zw.co.rubiem.netone.portal.usermanager.useraccount;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import zw.co.trogon.dashboard.commons.exceptions.InvalidRequestException;
import zw.co.trogon.dashboard.commons.exceptions.ItemNotFoundException;
import zw.co.trogon.dashboard.commons.jpa.BaseServiceImpl;
import zw.co.trogon.dashboard.usermanager.token.TokenService;

import java.util.Collection;

@Slf4j
@Service
public class UserAccountServiceImpl extends BaseServiceImpl<UserAccount, UserAccountRequest, UserAccountUpdateRequest> implements UserAccountService {

    private final UserAccountDao userAccountDao;
    private final UserAccountMapper userAccountMapper;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    public UserAccountServiceImpl(UserAccountDao userAccountDao, UserAccountMapper userAccountMapper, TokenService tokenService, PasswordEncoder passwordEncoder) {
        super(userAccountDao);
        this.userAccountDao = userAccountDao;
        this.userAccountMapper = userAccountMapper;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected Class<UserAccount> getEntityClass() {
        return UserAccount.class;
    }

    @Override
    public UserAccount create(UserAccountRequest request) {
        boolean detailsExists = userAccountDao.existsByUsername(request.getUsername());
        if (detailsExists) {
            throw new InvalidRequestException("UserAccount with the same name already exists");
        }
        UserAccount userAccount = userAccountMapper.userAccountFromUserAccountRequest(request);
        return userAccountDao.save(userAccount);
    }

    @Override
    public UserAccount update(UserAccountUpdateRequest request) {
        UserAccount userAccountRecord = findById(request.getId());
        UserAccount userGroup = userAccountMapper.userAccountFromUserAccountUpdateRequest(userAccountRecord, request);
        return userAccountDao.save(userGroup);
    }

    @Override
    public UserAccount findByUsername(String username) {
        return userAccountDao.findByUsername(username)
                .orElseThrow(() -> new ItemNotFoundException("User record was not found for the supplied username"));
    }

    @Override
    public Collection<UserAccount> findByGroup(long groupId) {
        return userAccountDao.findByGroup_Id(groupId);
    }

    @Override
    public void forgotPassword(String username) {

        boolean userByUsernameExists = userAccountDao.existsByUsername(username);

        if (userByUsernameExists) {
            val user = findByUsername(username);
            val token = tokenService.create(user);
            //           applicationEventPublisher.publishEvent(new ForgotPasswordEvent(this, token));
        } else {
            throw new InvalidRequestException("No User record found for the supplied username and or email");
        }
    }

    public void resetPassword(ResetPasswordContext resetPasswordContext) {
        if (!resetPasswordContext.getPassword().equals(resetPasswordContext.getConfirmPassword())) {
            throw new InvalidRequestException("Password and confirm password do not match");
        }
//        passwordValidator.validate(resetPasswordContext.getPassword());
        val token = tokenService.findByValue(resetPasswordContext.getToken());
        tokenService.validateToken(token);
        tokenService.useToken(token);
        val user = token.getUserAccount();
        user.setPassword(passwordEncoder.encode(resetPasswordContext.getPassword()));
        userAccountDao.save(user);
    }


    public UserAccount updatePassword(UpdatePasswordContext updatePasswordContext) {
        if (!updatePasswordContext.getNewPassword().equals(updatePasswordContext.getConfirmNewPassword())) {
            throw new InvalidRequestException("Password and confirm password do not match");
        }
        val user = findByUsername(updatePasswordContext.getUsername());
        if (!passwordEncoder.matches(updatePasswordContext.getOldPassword(), user.getPassword())) {
            throw new InvalidRequestException("Wrong old password has been provided.");
        }
        if (updatePasswordContext.getOldPassword().equals(updatePasswordContext.getNewPassword())) {
            throw new InvalidRequestException("You can not repeat the same password you were using");
        }
        user.setPassword(passwordEncoder.encode(updatePasswordContext.getNewPassword()));
        val updatedUser = userAccountDao.save(user);
        //     applicationEventPublisher.publishEvent(new PasswordUpdatedEvent(this, updatedUser));
        return updatedUser;
    }

    @Override
    public boolean existsByUsername(String username) {
        return userAccountDao.existsByUsername(username);
    }

    @Override
    public UserAccount activateOrDeActivate(long userAccountId, boolean isActive) {
        val user = userAccountDao.findById(userAccountId).get();
        if (user == null) {
            throw new ItemNotFoundException("User Account");
        } else {
            user.setActive(isActive);
            return userAccountDao.save(user);
        }
    }

    @Override
    public void verifyUser(String tokenValue) {
        val token = tokenService.findByValue(tokenValue);
        tokenService.validateToken(token);
        tokenService.useToken(token);
        val user = token.getUserAccount();
        user.setActive(true);
        val verifiedUser = userAccountDao.save(user);
        //       applicationEventPublisher.publishEvent(new UserVerifiedEvent(this, verifiedUser));
    }

}
