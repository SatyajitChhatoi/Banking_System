import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. Current balance: "+balance);
    }

    public void withdraw(double amount) { 
        if(balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: "+ balance);  
        } else {
            System.out.println("Insufficient funds. Current balance: "+ balance);
        }
    }

    public void transfer(BankAccount recipient, double amount) {
        if(balance >= amount) {
            balance -= amount;
            recipient.deposit(amount);
            System.out.println("Transfer successful. Curreent balance: "+balance);
        } else {
            System.out.println("Insufficient funds. Current balance: "+balance);
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account number for sender: ");
        String senderAccountNumber = scanner.nextLine();

        System.out.print("Enter initial balance for sender: ");
        double senderInitialBalance = scanner.nextDouble();

        System.out.print("Enter account number for recipient: ");
        scanner.nextLine();
        String recipientAccountNumber = scanner.nextLine();

        System.out.print("Enter initial balance for recipient: ");
        double recipientInitialBalance = scanner.nextDouble();
        System.out.println();

        BankAccount sender = new BankAccount(senderAccountNumber, senderInitialBalance);
        BankAccount recipient = new BankAccount(recipientAccountNumber, recipientInitialBalance);

        System.out.println("Bank accounts created successfully.");
        System.out.println("Sender Account Number: "+ sender.getAccountNumber());
        System.out.println("Recipient Account Number: "+recipient.getAccountNumber());

        int choice = 0;
        while(choice != 5) {
            System.out.println("\nChoose an action: ");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    sender.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    sender.withdraw(withdrawalAmount);
                    break;
                case 3:
                    System.out.print("Enter transfer amount from sender to recipient: ");
                    double transferAmount = scanner.nextDouble();
                    sender.transfer(recipient, transferAmount);
                    break;
                case 4:
                    System.out.println("Sender's Balance: "+sender.getBalance());
                    System.out.println("Recipient's Balance: "+recipient.getBalance());
                    break;
                case 5:
                    System.out.println("Exiting the banking system...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
        // Deposits 500 into the sender's account.
        //  Withdraws 200 from the sender's account.
        //  Transfers 800 from the sender's account to the recipient's account.
        //  Checks the balance of both the sender and recipient accounts.
        //  Exits the banking system.
    }
}