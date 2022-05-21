package zw.co.rubiem.netone.portal.usermanager;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import zw.co.rubiem.netone.portal.commons.ResponseMessage;
import zw.co.rubiem.netone.portal.commons.exceptions.InvalidRequestException;
import zw.co.rubiem.netone.portal.commons.exceptions.ItemNotFoundException;
import zw.co.rubiem.netone.portal.security.jwt.JwtProvider;
import zw.co.rubiem.netone.portal.security.jwt.JwtResponse;
import zw.co.rubiem.netone.portal.usermanager.useraccount.LoginRequest;
import zw.co.rubiem.netone.portal.usermanager.useraccount.UserAccount;
import zw.co.rubiem.netone.portal.usermanager.useraccount.UserAccountDao;

import javax.validation.Valid;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth/token")
@Api(tags = "Auth Rest")
public class AuthRest {

    private final AuthenticationManager authenticationManager;
    private final UserAccountDao userAccountDao;
    private final JwtProvider jwtProvider;

    public AuthRest(AuthenticationManager authenticationManager, UserAccountDao userAccountDao, JwtProvider jwtProvider) {
        this.authenticationManager = authenticationManager;
        this.userAccountDao = userAccountDao;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        log.info("authenticateUser() request: {} ", loginRequest);

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            UserAccount userAccount = userAccountDao.findByUsername(userDetails.getUsername()).orElseThrow(()-> new ItemNotFoundException("UserAccount"));

            String jwt = jwtProvider.generateJwtToken(authentication, userDetails.getAuthorities());

            return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userAccount, userDetails.getAuthorities()));
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.UNAUTHORIZED);
        }
    }

}
