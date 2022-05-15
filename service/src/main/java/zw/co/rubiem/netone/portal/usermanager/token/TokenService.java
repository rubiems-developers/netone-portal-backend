package zw.co.rubiem.netone.portal.usermanager.token;

import zw.co.rubiem.netone.portal.usermanager.useraccount.UserAccount;

public interface TokenService {

    Token create(UserAccount userAccount);

    void useToken(Token token);

    Token findByValue(String tokenValue);

    void validateToken(Token token);

}
