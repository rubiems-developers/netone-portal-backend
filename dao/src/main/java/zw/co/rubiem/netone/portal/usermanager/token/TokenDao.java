package zw.co.rubiem.netone.portal.dao.usermanager.token;

import org.springframework.stereotype.Repository;
import zw.co.rubiem.netone.portal.commons.jpa.BaseDao;
import zw.co.rubiem.netone.portal.usermanager.token.Token;

import java.util.Optional;

@Repository
public interface TokenDao extends BaseDao<Token> {

    Optional<Token> findByValue(String value);

    boolean existsByValue(String value);

}
