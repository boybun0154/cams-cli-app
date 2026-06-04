package cams.repository;

import cams.domain.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerDAO {
    List<Customer> findAll();
    Optional<Customer> findById(long customerId);
}
