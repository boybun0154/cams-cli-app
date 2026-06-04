package cams.service;

import cams.domain.Account;
import cams.domain.Customer;
import cams.repository.AccountDAO;
import java.util.List;
import java.util.stream.Collectors;

public class AccountServiceImpl implements AccountService {
    private final AccountDAO accountDAO;
    private final CustomerService customerService;

    public AccountServiceImpl(AccountDAO accountDAO, CustomerService customerService) {
        this.accountDAO = accountDAO;
        this.customerService = customerService;
    }

    @Override
    public List<Account> allAccounts() {
        List<Account> accounts = accountDAO.findAll();
        for (Account account : accounts) {
            Customer customer = customerService.getCustomerFromAcc(account);
            account.setCustomer(customer);
        }
        return accounts.stream()
                .sorted((a1, a2) -> Double.compare(a2.getBalance(), a1.getBalance()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Account> platinumTier() {
        List<Account> accounts = accountDAO.findAll();
        for (Account account : accounts) {
            Customer customer = customerService.getCustomerFromAcc(account);
            account.setCustomer(customer);
        }
        return accounts.stream()
                .filter(a -> "Platinum".equals(a.getTier()))
                .collect(Collectors.toList());
    }

    @Override
    public double calculateLiquidityPosition() {
        return accountDAO.findAll().stream()
                .mapToDouble(Account::getBalance)
                .sum();
    }
}
