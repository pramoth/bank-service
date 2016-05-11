package th.co.geniustree.bank.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.co.geniustree.bank.service.model.BankAccount;
import th.co.geniustree.bank.service.repo.BankAccountRepo;

/**
 *
 * @author pramoth
 */
@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private BankAccountRepo bankAccountRepo;

    @Override
    public Double withdraw(Integer bankAccountId, Double amount) {
        BankAccount findOne = bankAccountRepo.findOne(bankAccountId);
        if (findOne == null) {
            throw new RuntimeException("NotFound");
        }
        if(findOne.getBalance() >= amount){
            return findOne.getBalance() - amount;
        }else{
            throw new RuntimeException("NotEnought");
        }
    }

}
