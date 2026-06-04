package cams.service;

import cams.domain.Account;
import cams.domain.Customer;

public interface CustomerService {
    Customer getCustomerFromAcc(Account account);
}
