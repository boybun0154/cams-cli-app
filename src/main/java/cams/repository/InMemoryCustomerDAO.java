package cams.repository;

import cams.domain.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryCustomerDAO implements CustomerDAO {
    private final List<Customer> customers = new ArrayList<>();

    public InMemoryCustomerDAO() {
        preloadData();
    }

    private void preloadData() {
        customers.add(new Customer(1L, "Bob", "Jones"));
        customers.add(new Customer(2L, "Anna", "Smith"));
        customers.add(new Customer(3L, "Carlos", "Jimenez"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers);
    }

    @Override
    public Optional<Customer> findById(long customerId) {
        return customers.stream()
                .filter(c -> c.getCustomerId() == customerId)
                .findFirst();
    }
}
