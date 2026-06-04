package cams.service;

import cams.domain.Customer;
import java.util.Optional;

public interface CustomerService {
    Optional<Customer> getCustomerFromAcc(long customerId);
}
