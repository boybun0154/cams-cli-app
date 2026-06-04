package cams.domain;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "accountId", "accountNumber", "accountType", "dateOpened", "balance", "tier", "customer" })
public class Account {
    private final long accountId;
    private final String accountNumber;
    private final String accountType;

    @JsonIgnore
    private final LocalDate dateOpened;

    private double balance;

    @JsonIgnore
    private long customerId;

    private Customer customer;

    // No-arg constructor to satisfy basic POJO guidelines
    public Account() {
        this.accountId = 0;
        this.accountNumber = "";
        this.accountType = "";
        this.dateOpened = null;
    }

    public Account(long accountId, String accountNumber, String accountType, LocalDate dateOpened, double balance, long customerId) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.dateOpened = dateOpened;
        this.balance = balance;
        this.customerId = customerId;
    }

    public long getAccountId() {
        return accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public LocalDate getDateOpened() {
        return dateOpened;
    }

    @JsonProperty("dateOpened")
    public String getDateOpenedString() {
        return dateOpened != null ? dateOpened.toString() : "";
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @JsonProperty("tier")
    public String getTier() {
        return AccountTier.fromBalance(balance).getDisplayName();
    }
}
