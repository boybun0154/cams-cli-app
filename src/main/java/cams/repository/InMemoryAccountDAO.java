package cams.repository;

import cams.domain.Account;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryAccountDAO implements AccountDAO {
    private final List<Account> accounts = new ArrayList<>();

    public InMemoryAccountDAO(CustomerDAO customerDAO) {
        preloadData(customerDAO);
    }

    private void preloadData(CustomerDAO customerDAO) {
        Account a1 = new Account(1L, "AC1002", "Checking", LocalDate.of(2016, 5, 17), 155900.50, 1L);
        Account a2 = new Account(2L, "AS1001", "Savings", LocalDate.of(2021, 6, 2), 12500.95, 1L);
        Account a3 = new Account(3L, "AS1003", "Savings", LocalDate.of(2016, 7, 11), 75000.00, 3L);
        Account a4 = new Account(4L, "AC1004", "Checking", LocalDate.of(2024, 3, 29), 11700.99, 2L);

        linkCustomer(a1, customerDAO);
        linkCustomer(a2, customerDAO);
        linkCustomer(a3, customerDAO);
        linkCustomer(a4, customerDAO);

        accounts.add(a1);
        accounts.add(a2);
        accounts.add(a3);
        accounts.add(a4);
    }

    private void linkCustomer(Account account, CustomerDAO customerDAO) {
        customerDAO.findById(account.getCustomerId()).ifPresent(account::setCustomer);
    }

    @Override
    public List<Account> findAll() {
        return new ArrayList<>(accounts);
    }

    @Override
    public Optional<Account> findById(long accountId) {
        return accounts.stream()
                .filter(a -> a.getAccountId() == accountId)
                .findFirst();
    }
}
