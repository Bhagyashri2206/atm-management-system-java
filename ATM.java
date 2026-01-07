import java.util.Scanner;

public class ATM {
    private User user;
    private Account account;
    private Transaction transaction;

    public ATM(User user, Account account, Transaction transaction) {
        this.user = user;
        this.account = account;
        this.transaction = transaction;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter User ID: ");
        String id = sc.next();
        System.out.print("Enter PIN: ");
        String pin = sc.next();

        if (!user.validate(id, pin)) {
            System.out.println("Invalid Credentials ❌");
            return;
        }

        int choice;
        do {
            System.out.println("\n--- ATM MENU ---");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    transaction.showHistory();
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double w = sc.nextDouble();
                    if (account.withdraw(w)) {
                        transaction.add("Withdrawn: " + w);
                        System.out.println("Withdraw successful ✅");
                    } else {
                        System.out.println("Insufficient balance ❌");
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double d = sc.nextDouble();
                    account.deposit(d);
                    transaction.add("Deposited: " + d);
                    System.out.println("Deposit successful ✅");
                    break;

                case 4:
                    System.out.print("Enter amount to transfer: ");
                    double t = sc.nextDouble();
                    Account target = new Account(0); // demo account
                    if (account.transfer(target, t)) {
                        transaction.add("Transferred: " + t);
                        System.out.println("Transfer successful ✅");
                    } else {
                        System.out.println("Transfer failed ❌");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using ATM 😊");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 5);
    }
}
