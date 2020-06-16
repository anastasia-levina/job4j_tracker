package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        List<Account> newUser = new ArrayList<>();
        users.putIfAbsent(user, newUser);
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> accounts = users.get(user);
        accounts.add(account);
        users.putIfAbsent(user, accounts);
    }

    public User findByPassport(String passport) {
        for (User result : users.keySet()) {
            if (result.getPassport().equals(passport)) {
                return result;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User usr = findByPassport(passport);
        if (usr == null) {
            return null;
        }
        List<Account> accounts = users.get(usr);
        for (Account account : accounts) {
            if (account.getRequisite().equals(requisite)) {
                return account;
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);

        if (amount <= srcAccount.getBalance() && destAccount != null) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
