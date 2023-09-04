package com.hashTable;

import java.util.*;

public class InvalidTransactions {

    /**
     * A transaction is possibly invalid if:
     * <a href="https://leetcode.com/problems/invalid-transactions/">...</a>
     * the amount exceeds $1000, or;
     * if it occurs within (and including) 60 minutes of another transaction with the same name in a different city.
     * You are given an array of strings transaction where transactions[i] consists of comma-separated values representing the name, time (in minutes), amount, and city of the transaction.
     *
     * Return a list of transactions that are possibly invalid. You may return the answer in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
     * Output: ["alice,20,800,mtv","alice,50,100,beijing"]
     * Explanation: The first transaction is invalid because the second transaction occurs within a difference of 60 minutes, have the same name and is in a different city. Similarly the second one is invalid too.
     * Example 2:
     *
     * Input: transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
     * Output: ["alice,50,1200,mtv"]
     * Example 3:
     *
     * Input: transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
     * Output: ["bob,50,1200,mtv"]
     *
     *
     */
    class SingleTransaction {
        String name;
        int amount;
        int time;
        String city;
        public SingleTransaction(String transaction) {
            if(!transaction.isEmpty()) {
                String[] split = transaction.split(",");
                this.name = split[0];
                this.time = Integer.parseInt(split[1]);
                this.amount = Integer.parseInt(split[2]);
                this.city = split[3];
            }
        }

        public String toString(){
            return String.join(",", new String[]{this.name, this.time+"", this.amount+"", this.city});
        }
    }

    public List<String> invalidTransactions(String[] transactions) {
        List<String> invalid = new ArrayList<>();
        HashMap<String, TreeMap<Integer, SingleTransaction>> validHm = new HashMap<>();
        for(String transaction : transactions) {
            if(transaction==null)
                continue;
            SingleTransaction st = new SingleTransaction(transaction);
            if(!isValidTransaction(st, validHm, invalid)) {
                invalid.add(transaction);
            } else {
                if(!validHm.containsKey(st.name)) validHm.put(st.name, new TreeMap<>());
                validHm.get(st.name).put(st.time, st);
            }
        }
        return invalid;
    }

    public boolean isValidTransaction(SingleTransaction st, HashMap<String, TreeMap<Integer, SingleTransaction>> validHm, List<String> invalid) {
        if(st.amount > 1000)
            return false;
        if(validHm.containsKey(st.name)) {
            TreeMap<Integer, SingleTransaction> tm = validHm.get(st.name);
            SingleTransaction lastEntry = (SingleTransaction) tm.lastEntry().getValue();
            if(!lastEntry.city.equals(st.city))
                while (st.time - lastEntry.time < 60 || tm.size() != 0) {
                    invalid.add(lastEntry.toString());
                    tm.remove(lastEntry.time);
                    return false;
                }
        }
        return true;
    }

    public static void main(String[] args) {
        InvalidTransactions it = new InvalidTransactions();
//        System.out.println("Print InvalidTransactions "+ it.invalidTransactions(new String[] {"alice,20,800,mtv","alice,50,1200,mtv"}));
//        System.out.println("============================================================");
//        System.out.println("Print InvalidTransactions "+ it.invalidTransactions(new String[] {"alice,20,800,mtv","bob,50,1200,mtv"}));
        System.out.println("============================================================");
        System.out.println("Print InvalidTransactions "+ it.invalidTransactions(new String[] {"alice,20,800,mtv","alice,50,100,beijing"}));
        System.out.println("============================================================");
//        ["alice,20,800,mtv","alice,50,100,mtv","alice,51,100,frankfurt"]
        System.out.println("Print InvalidTransactions "+ it.invalidTransactions(new String[] {"alice,20,800,mtv","alice,50,100,mtv","alice,51,100,frankfurt"}));
        System.out.println("============================================================");


    }
}
