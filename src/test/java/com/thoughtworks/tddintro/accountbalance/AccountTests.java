package com.thoughtworks.tddintro.accountbalance;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTests {
    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        //Given: I have $100 in my account.
        Account a = new Account(100);
        int oldBalance = a.getBalance();

        //When: I deposit $50
        int amountToDeposit = 50;
        a.deposit(amountToDeposit);

        //Then: I see that my account contains $150.
        int newBalance = a.getBalance();
        assertThat(oldBalance + amountToDeposit, is(newBalance));
    }

 //   @Test
 //   public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
 //       assertThat(new Account(100).withdraw(50), is(50));
 //   }

 //   @Test
 //   public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){
 //     assertThat(new Account(50).withdraw(100), is(50));
 //   }

}
