public class Main {
    public static void main(String[] args) {

        User user = new User("user123", "1234");
        Account account = new Account(10000); // initial balance
        Transaction transaction = new Transaction();

        ATM atm = new ATM(user, account, transaction);
        atm.start();
    }
}
