package cams.service;

import cams.domain.Customer;
import cams.repository.CustomerDAO;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerDAO customerDAO;

    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public Optional<Customer> getCustomerFromAcc(long customerId) {
        return customerDAO.findById(customerId);
    }
}
