import java.util.*;

// BankAccount class to represent individual bank accounts
class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private String Address;
    private String pno;
    private String email;

    // Constructor to initialize the account
    public BankAccount(String accountNumber, String accountHolderName, String Address, String pno, String email) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = 0.0;
        this.Address = Address;
        this.pno = pno;
        this.email = email;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited successfully.");
        } else {
            System.out.println("Invalid amount. Deposit failed.");
        }
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount. Withdrawal failed.");
        }
    }

    // Method to check the current balance
    public double checkBalance() {
        return balance;
    }

    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
        System.out.println("Address: " + Address);
        System.out.println("Phone Number: " + pno);
        System.out.println("E-Mail: " + email);
    }
}

// Main class to demonstrate the banking system
public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating a new bank account
        BankAccount account1 = new BankAccount("12345", "John Doe", "Avadi - Chennai", "+91 9255995254", "john@demo.com");

        int choice;
        do {
            System.out.println("\n**** Banking System Menu ****");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Display Account Information");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account1.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account1.withdraw(withdrawAmount);
                    break;
                case 3:
                    double balance = account1.checkBalance();
                    System.out.println("Current Balance: " + balance);
                    break;
                case 4:
                    account1.displayAccountDetails();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
