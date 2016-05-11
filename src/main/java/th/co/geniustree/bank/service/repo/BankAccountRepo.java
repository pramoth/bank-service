package th.co.geniustree.bank.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import th.co.geniustree.bank.service.model.BankAccount;

/**
 *
 * @author pramoth
 */
public interface BankAccountRepo extends JpaRepository<BankAccount, Integer>{
    
}
