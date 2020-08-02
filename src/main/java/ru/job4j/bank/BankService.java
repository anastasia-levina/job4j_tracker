package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        List<Account> accounts = new ArrayList<>();
        users.putIfAbsent(user, accounts);
    }

    public void addAccount(String passport, Account account) {
        findByPassport(passport).ifPresent(user -> {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        });
    }

    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        return findByPassport(passport)
                .map(usr -> users.get(usr))
                .orElse(Collections.emptyList())
                .stream()
                .filter(account -> requisite.equals(account.getRequisite()))
                .findFirst();
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        double srcBalance = srcAccount.map(Account::getBalance).orElse(0D);
        double destBalance = destAccount.map(Account::getBalance).orElse(0D);

        if (amount <= srcBalance) {
            srcAccount.ifPresent(account -> account.setBalance(srcBalance - amount));
            destAccount.ifPresent(account -> account.setBalance(destBalance + amount));
            rsl = true;
        }
        return rsl;
    }
}