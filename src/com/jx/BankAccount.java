package com.jx;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankAccount {

    private int accountNumber;
    private int balance;
    private String customerName;
    private String email;
    private int phoneNumber;
    private int depositCount = 0;
    private int dayDepositAmount = 0;
    private int dayWithdrawAmount = 0;
    private List<Transaction> transactionHistory;



    public BankAccount(int accountNumber, String customerName, String email, int phoneNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.transactionHistory = new ArrayList<>();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // show account balance
    private void showBalance() {
        System.out.println("Your account balance is: " + balance);
    }

    // deposit money to customer's account
    public void deposit(int amount) {
        if (depositCount >= 3) {
            System.out.println("Three times a day is offered, you've reached the top, please deposit tomorrow!");
        } else if (dayDepositAmount >= 1500) {
            System.out.println("$1500 is allowed per day, you cannot deposit today!");
        } else if (amount < 50) {
            System.out.println("Less than $50 is not allowed");
        } else if (amount > 500) {
            System.out.println("Larger than $500 is not allowed");
        } else {
            depositCount++;
            dayDepositAmount += amount;
            balance += amount;
            transactionHistory.add(new Transaction(customerName, accountNumber, dayDepositAmount, balance));
            showBalance();
        }
    }

    // show Time stamp
    private void showTimeStamp() {
        Date date = new Date();
        Timestamp ts=new Timestamp(date.getTime());
        System.out.println(ts);
    }

    // withdraw money from customer's account
    public void withdraw (int amount) {
        if (balance < amount) {
            System.out.println("Dear" + customerName + ", Your account balance is :" + balance + ", not sufficient funds");
        } else if (dayWithdrawAmount >= 1000) {
            System.out.println("Only $1000 is allowed per day, you've reached the top!");
        } else {
            dayWithdrawAmount += amount;
            balance -= amount;
            transactionHistory.add(new Transaction(customerName, accountNumber, dayWithdrawAmount, balance));
            showDailyRemaining();
            showBalance();
            showTimeStamp();
        }
    }

    // show daily remaining
    private void showDailyRemaining() {
        System.out.println("Maximum amount left you can withdraw today is: " + (1000 - dayWithdrawAmount));
    }

    // print method to print the customer's info
    public void printAccountInfo() {
        System.out.println("customerName: " + customerName);
        System.out.println("accountNumber: " + accountNumber);
        System.out.println("balance: " + balance);
        System.out.println("email: " + email);
        System.out.println("phoneNumber: " + phoneNumber);
        showTimeStamp();
    }

    public void showTransactionHistory() {
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction);
        }
        //System.out.println(transactionHistory);
    }
}
