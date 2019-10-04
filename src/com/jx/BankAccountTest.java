package com.jx;

import java.util.ArrayList;
import java.util.List;

public class BankAccountTest {


    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(123, "Jie", "jie@gmail.com", 987654321);
        account1.printAccountInfo();
        System.out.println("------------------------");
        account1.deposit(1009);
        account1.printAccountInfo();
        System.out.println("------------------------");
        account1.withdraw(1200);
        account1.printAccountInfo();
        System.out.println("------------------------");
        account1.deposit(499);
        account1.showTransactionHistory();
        System.out.println("------------------------");
        account1.withdraw(100);
        account1.showTransactionHistory();
        System.out.println("------------------------");
        account1.deposit(49);
        System.out.println("------------------------");
        account1.deposit(500);
        account1.deposit(388);
        account1.deposit(150);
        account1.showTransactionHistory();
    }
}
