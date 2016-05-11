package th.co.geniustree.bank.service.service;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;
import th.co.geniustree.bank.service.model.BankAccount;
import th.co.geniustree.bank.service.repo.BankAccountRepo;

/**
 *
 * @author pramoth
 */
public class BankAccountServiceTest {

    private BankAccountService bankAccountService;
    private BankAccount bankAccount = new BankAccount();

    @Before
    public void setup() {
        bankAccountService = new BankAccountServiceImpl();
        bankAccount.setId(1);
        BankAccountRepo bankAccountRepo = Mockito.mock(BankAccountRepo.class);
        Mockito.when(bankAccountRepo.findOne(1)).thenReturn(bankAccount);
        ReflectionTestUtils.setField(bankAccountService, "bankAccountRepo", bankAccountRepo);
    }

    @Test(expected = RuntimeException.class)
    public void balance1000_withdraw1001_throw() {
        bankAccount.setBalance(1000D);
        bankAccountService.withdraw(1, 1001D);
    }

    @Test
    public void balance1000_withdraw500_remain500() {
        bankAccount.setBalance(1000D);
        Double withdraw = bankAccountService.withdraw(1, 500D);
        Assertions.assertThat(withdraw).isEqualTo(500D);
    }

    @Test
    public void balance1000_withdraw1000_remain0() {

    }

    // @Test(expected = RuntimeException.class)
    public void not_found_account() {

    }
}
