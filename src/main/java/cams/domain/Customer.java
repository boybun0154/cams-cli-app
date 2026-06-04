package cams.domain;

public class Customer {
    private final long customerId;
    private final String firstName;
    private final String lastName;

    public Customer(long customerId, String firstName, String lastName) {
        if (customerId <= 0) {
            throw new IllegalArgumentException("Customer ID is required and must be a positive number.");
        }
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name is required.");
        }
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name is required.");
        }
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
