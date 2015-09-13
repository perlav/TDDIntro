package com.thoughtworks.tddintro.accountbalance;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTests {
//Note - There is some repeated code but I could not find a good way of extracting it to a method. 

    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        //Given: I have $100 in my account.
        Account a = new Account(100);
        int oldBalance = a.getBalance();

        //When: I deposit $50
        int amountToDeposit = 50;
        a.deposit(amountToDeposit);

        //Then: I see that my account contains $150.
        assertThat(oldBalance + amountToDeposit, is(a.getBalance()));
    }

    @Test
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
        //Given: I have $100 in my account.
        Account a = new Account(100);
        int oldBalance = a.getBalance();

        //When: I withdraw $50
        int amountToWithdraw = 50;
        a.withdraw(amountToWithdraw);

        //Then: I see that my account contains $50.
        assertThat(oldBalance - amountToWithdraw, is(a.getBalance()));
    }

    @Test
    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){
        //Given: I have $50 in my account.
        Account a = new Account(50);
        int oldBalance = a.getBalance();

        //When: I withdraw $100
        a.withdraw(100);

        //Then: I see that my account contains $50.
        assertThat(oldBalance, is(a.getBalance()));
    }

}
