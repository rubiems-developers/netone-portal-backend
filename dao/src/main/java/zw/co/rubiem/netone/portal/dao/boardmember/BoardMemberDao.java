package zw.co.rubiem.netone.portal.dao.boardmember;

import org.springframework.stereotype.Repository;
import zw.co.rubiem.netone.portal.domain.boardmember.BoardMember;
import zw.co.rubiem.netone.portal.domain.commons.jpa.BaseDao;

import java.util.Optional;

@Repository
public interface BoardMemberDao extends BaseDao<BoardMember> {

    Optional<BoardMember> findByTitleIgnoreCaseAndFirstNameIgnoreCaseAndLastNameIgnoreCase(
            String title, String firstName, String lastName);

    Optional<BoardMember> findByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstName, String lastName);

}
