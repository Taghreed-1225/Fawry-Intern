package example.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AccountManagerTest {

    AccountManager accountManager = new AccountManagerImpl();

    @Test
    @DisplayName("Should increase balance when depositing a positive amount")
    public void givenCustomerWithBalance_whenDeposit_thenBalanceIncreases() {
        // arrange
        Customer customer = new Customer();
        customer.setBalance(100);

        // act
        accountManager.deposit(customer, 50);

        // assert
        Assertions.assertEquals(150, customer.getBalance());
    }

    @Test
    public void givenCustomerWithBalance_whenDepositZero_thenBalanceRemainsSame() {
        // arrange
        Customer customer = new Customer();
        customer.setBalance(100);

        // act
        accountManager.deposit(customer, 0);

        // assert
        Assertions.assertEquals(100, customer.getBalance());
    }

    @Test
    public void givenCustomerWithPositiveBalanceAndPositiveAmount_whenWithdraw_thenSuccess() {

        //arrange
        Customer customer = new Customer();
        customer.setBalance(100);

        //act
        String result = accountManager.withdraw(customer, 50);

        //assert
        Assertions.assertEquals("success", result);
        Assertions.assertEquals(50,customer.getBalance());
    }

    @Test
    public void givenCustomerWithNegativeBalanceAndPositiveAmount_whenWithdraw_thenFailer() {

        //arrange
        Customer customer = new Customer();
        customer.setBalance(100);
        customer.setCreditAllowed(false);

        //act
        String result = accountManager.withdraw(customer, 150);

        //assert
        Assertions.assertEquals("insufficient account balance", result);
        Assertions.assertEquals(100,customer.getBalance());
    }

    @Test
    public void givenCustomerWithZeroBalance_whenWithdraw_thenFailure() {
        Customer customer = new Customer();
        customer.setBalance(0);
        String result = accountManager.withdraw(customer, 50);
        Assertions.assertEquals("insufficient account balance", result);
    }

    @Test
    public void givenCustomerWithCreditAllowedAndlowBalance_whenWithdraw_thenFailure() {
        Customer customer = new Customer();
        customer.setBalance(50);
        customer.setCreditAllowed(true);
        String result = accountManager.withdraw(customer, 100);
        Assertions.assertEquals("success", result);
        Assertions.assertEquals(-50,customer.getBalance());
    }
    @Test
    public void givenCustomerWithCreditAllowedAndMaxCredit_whenWithdraw_thenFailure() {
        Customer customer = new Customer();
        customer.setBalance(50);
        customer.setCreditAllowed(true);

        String result = accountManager.withdraw(customer, 1100);
        Assertions.assertEquals("maximum credit exceeded", result);
        Assertions.assertEquals(50,customer.getBalance());
    }

    @Test
    public void givenCustomerWithCreditAllowedAndMaxCreditAndVip_whenWithdraw_thenFailure() {
        Customer customer = new Customer();
        customer.setBalance(50);
        customer.setCreditAllowed(true);
        customer.setVip(true);

        String result = accountManager.withdraw(customer, 1100);
        Assertions.assertEquals("success", result);
        Assertions.assertEquals(-1050,customer.getBalance());
    }


    @Test
    public void givenCustomerWithNegativeAmount_whenWithdraw_thenFailure() {
        Customer customer = new Customer();
        customer.setBalance(50);
        customer.setCreditAllowed(true);
        customer.setVip(true);

        String result = accountManager.withdraw(customer, -1100);
        Assertions.assertEquals("Amount must be greater than 0", result);
        Assertions.assertEquals(50,customer.getBalance());
    }

    @Test
    public void givenVipCustomerWithNegativeBalance_whenWithdraw_thenSuccess() {
        Customer customer = new Customer();
        customer.setBalance(-500);
        customer.setCreditAllowed(true);
        customer.setVip(true);

        String result = accountManager.withdraw(customer, 100);

        Assertions.assertEquals("success", result);
        Assertions.assertEquals(-600, customer.getBalance());
    }


////////////////////////////////////////

    //solve with data provider


    @ParameterizedTest
    @CsvSource({
            "100, 50, true, false, success, 50",
            "100, 100, true, false, success, 0",
            "50, 100, true, false, success, -50",
            "50, 1100, true, true, success, -1050"
    })
    void testSuccessfulWithdrawals(int balance, int amount, boolean creditAllowed, boolean vip, String expectedMessage, int expectedBalance) {
        Customer customer = new Customer();
        customer.setBalance(balance);
        customer.setCreditAllowed(creditAllowed);
        customer.setVip(vip);

        String result = accountManager.withdraw(customer, amount);

        Assertions.assertEquals(expectedMessage, result);
        Assertions.assertEquals(expectedBalance, customer.getBalance());
    }




}
