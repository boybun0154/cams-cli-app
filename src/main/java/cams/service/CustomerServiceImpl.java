package cams.service;

import cams.domain.Account;
import cams.domain.Customer;
import cams.repository.CustomerDAO;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerDAO customerDAO;

    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public Customer getCustomerFromAcc(Account account) {
        if (account == null) {
            return null;
        }
        return customerDAO.findById(account.getCustomerId()).orElse(null);
    }
}
