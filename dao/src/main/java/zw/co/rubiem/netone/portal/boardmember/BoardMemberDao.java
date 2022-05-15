package zw.co.rubiem.netone.portal.boardmember;

import org.springframework.stereotype.Repository;
import zw.co.rubiem.netone.portal.commons.jpa.BaseDao;

import java.util.Optional;

@Repository
public interface BoardMemberDao extends BaseDao<BoardMember> {

    Optional<BoardMember> findByTitleIgnoreCaseAndFirstNameIgnoreCaseAndLastNameIgnoreCase(
            String title, String firstName, String lastName);

    Optional<BoardMember> findByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstName, String lastName);

}
