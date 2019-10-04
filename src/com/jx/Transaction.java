package com.jx;

import java.sql.Timestamp;
import java.util.Date;

public class Transaction {
    private String customerName;
    private int accountNumber;
    private int transactionAmount;
    private int balance;
    Date date;
    Timestamp ts;

    public Transaction(String customerName, int accountNumber, int transactionAmount, int balance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.transactionAmount = transactionAmount;
        this.balance = balance;
        this.date = new Date();
        this.ts=new Timestamp(date.getTime());
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(int transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "TransactionRecord {" +
                "customerName: '" + customerName + '\'' +
                ", accountNumber: " + accountNumber +
                ", transactionAmount: " + "$" + transactionAmount +
                ", balance: " + "$" + balance +
                ", date: " + date +
                ", time: " + ts +
                '}';
    }
}
