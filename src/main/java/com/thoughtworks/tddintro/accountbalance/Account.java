package com.thoughtworks.tddintro.accountbalance;

/**
 * Created by PerlaIvetteVillarreal on 9/13/15.
 */
public class Account {
    private int accountBalance;

    public Account(int initialBalance) {
        accountBalance = initialBalance;
    }

    public int getBalance() {
        return accountBalance;
    }

    public void deposit(int amountDeposited) {
        accountBalance += amountDeposited;

    }

//    public void withdraw(int amountWithdrawn) {
//        int newBalance = accountBalance - amountWithdrawn;
//        if(newBalance>0){
//            accountBalance = newBalance;
//        }
//    }


}
