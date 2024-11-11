package oussama.it.account_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import oussama.it.account_service.Entities.BanckAccount;
@Repository
public interface BanckAccountRepository extends JpaRepository<BanckAccount,String> {
}
