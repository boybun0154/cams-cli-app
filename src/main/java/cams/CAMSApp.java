package cams;

import cams.domain.Account;
import cams.repository.AccountDAO;
import cams.repository.CustomerDAO;
import cams.repository.InMemoryAccountDAO;
import cams.repository.InMemoryCustomerDAO;
import cams.service.AccountService;
import cams.service.AccountServiceImpl;
import cams.service.CustomerService;
import cams.service.CustomerServiceImpl;
import tools.jackson.databind.ObjectMapper;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CAMSApp {
    private static final CustomerDAO customerDAO = new InMemoryCustomerDAO();
    private static final AccountDAO accountDAO = new InMemoryAccountDAO(customerDAO);
    private static final CustomerService customerService = new CustomerServiceImpl(customerDAO);
    private static final AccountService accountService = new AccountServiceImpl(accountDAO, customerService);

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            System.out.print("Enter your choice (1-3): ");
            String input = scanner.nextLine().trim();
            System.out.println();

            switch (input) {
                case "1":
                    displayAllAccounts();
                    break;
                case "2":
                    displayPlatinumAccounts();
                    break;
                case "3":
                    System.out.println("Exiting CAMS Application. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Please enter 1, 2, or 3.");
            }
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("==================================================");
        System.out.println("     Customer Account Management System (CAMS)    ");
        System.out.println("==================================================");
        System.out.println("1. Display All Accounts (Sorted by Balance Desc)");
        System.out.println("2. Display Platinum Tier Accounts Only");
        System.out.println("3. Exit");
        System.out.println("==================================================");
    }

    private static void displayAllAccounts() {
        try {
            List<Account> accounts = accountService.allAccounts();
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(accounts);
            System.out.println("Accounts List (Sorted by Balance Descending):");
            System.out.println(json);
            System.out.println("--------------------------------------------------");
            double liquidity = accountService.calculateLiquidityPosition();
            System.out.println("Total Liquidity Position of the Bank: " + currencyFormatter.format(liquidity));
            System.out.println("--------------------------------------------------");
        } catch (Exception e) {
            System.err.println("Error formatting JSON: " + e.getMessage());
        }
    }

    private static void displayPlatinumAccounts() {
        try {
            List<Account> accounts = accountService.platinumTier();
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(accounts);
            System.out.println("Platinum Tier Accounts:");
            System.out.println(json);
            System.out.println("--------------------------------------------------");
        } catch (Exception e) {
            System.err.println("Error formatting JSON: " + e.getMessage());
        }
    }
}
