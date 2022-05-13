package zw.co.rubiem.netone.portal.dao.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import zw.co.rubiem.netone.portal.domain.transaction.Transaction;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionDao extends JpaRepository<Transaction, Long> {

    Optional<Transaction> findByPaymentNumber(String orderNumber);

//    @Query(value = "SELECT * FROM transaction "
//            + "WHERE status != :paymentStatus AND deleted = false "
//            + "ORDER BY payment_date "
//            + "LIMIT :chunkSize"
//            , nativeQuery = true)
//    List<Transaction> findTransactionsDueToBeCheckedOnPayNow(@Param("paymentStatus") String paymentStatus, @Param("chunkSize") Integer chunkSize);

    @Query(value = "SELECT * FROM transaction "
            + "WHERE status != :paymentStatus "
            + "ORDER BY date_created "
            + "LIMIT :chunkSize"
            , nativeQuery = true)
    List<Transaction> findTransactionsDueToBeCheckedOnPayNow(@Param("paymentStatus") String paymentStatus, @Param("chunkSize") Integer chunkSize);


    Transaction findFirstByOrderByIdDesc();

}
