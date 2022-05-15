package zw.co.rubiem.netone.portal.usermanager.token;

import lombok.val;
import org.springframework.stereotype.Service;
import zw.co.trogon.dashboard.commons.RandomUtils;
import zw.co.trogon.dashboard.commons.exceptions.InvalidRequestException;
import zw.co.trogon.dashboard.commons.exceptions.ItemNotFoundException;
import zw.co.trogon.dashboard.usermanager.useraccount.UserAccount;

import java.time.LocalDateTime;

@Service
class TokenServiceImpl implements TokenService {

    private final TokenDao tokenDao;

    TokenServiceImpl(TokenDao tokenDao) {
        this.tokenDao = tokenDao;
    }

    @Override
    public Token create(UserAccount userAccount) {
        val token = new Token(userAccount);
        String value;
        boolean notValid;
        do {
            value = RandomUtils.generateToken();
            notValid = tokenDao.existsByValue(value);
        } while (notValid);
        token.setValue(value);
        return tokenDao.save(token);
    }

    @Override
    public void useToken(Token token) {
        token.setUsed(true);
        tokenDao.save(token);
    }

    @Override
    public Token findByValue(String tokenValue) {
        return tokenDao.findByValue(tokenValue)
                .orElseThrow(() -> new ItemNotFoundException("Token record was not found."));
    }

    @Override
    public void validateToken(Token token) {

        if (token.isUsed()) {
            throw new InvalidRequestException("Invalid token has been supplied, token was already used");
        }

        if (LocalDateTime.now().isAfter(token.getExpiryDate())) {
            throw new InvalidRequestException("Token already expired.");
        }

    }
}
