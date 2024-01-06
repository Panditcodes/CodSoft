import java.util.Scanner;

class BankAcct {
    private double balance;

    public BankAcct(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void depositAmount(double depositAmount) {
        balance += depositAmount;
    }

    public boolean withdrawAmount(double withdrawAmount) {
        if (balance >= withdrawAmount) {
            balance -= withdrawAmount;
            return true;
        } else {
            System.out.println("Insufficient balance. Money can't be withdrawn.");
            return false;
        }
    }
}

class ATM {
    private BankAcct account;

    public ATM(BankAcct account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("WELCOME TO ATM");
        System.out.println("==============");
        System.out.println("1. Deposit money\n2. Withdraw money\n3. Check Balance\n4. Exit");
    }

    public void processUserInput(int input) {
        Scanner sc = new Scanner(System.in);

        switch (input) {
            case 1:
                System.out.println("Please enter the amount you want to deposit: ");
                double depositAmount = sc.nextDouble();
                account.depositAmount(depositAmount);
                System.out.println("Deposit successful.\nYour new balance is: " + account.getBalance());
                break;
            case 2:
                System.out.println("Please enter the amount you want to withdraw: ");
                double withdrawAmount = sc.nextDouble();
                if (account.withdrawAmount(withdrawAmount)) {
                    System.out.println("Withdrawal successful.\nYour new balance is: " + account.getBalance());
                }
                break;
            case 3:
                System.out.println("The current balance in your account is: " + account.getBalance());
                break;
            case 4:
                System.out.println("Thank you for using the ATM. See you soon!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please enter a number from the given Menu.");
        }
    }
}

public class AtmInterface {
    public static void main(String[] args) {
        BankAcct userAcct = new BankAcct(20000);
        ATM atm = new ATM(userAcct);
        atm.displayMenu();

        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Please enter your choice:");
            int input = in.nextInt();

            atm.processUserInput(input);
        }
    }
}
