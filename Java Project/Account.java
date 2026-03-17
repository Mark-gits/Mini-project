import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {

    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'₹'###,##0.00");

    public void setCustomerNumber(int customerNumber){
        this.customerNumber = customerNumber;
    }

    public int getCustomerNumber(){
        return customerNumber;
    }

    public void setPinNumber(int pinNumber){
        this.pinNumber = pinNumber;
    }

    public int getPinNumber(){
        return pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingBalance(){
        return savingBalance;
    }

    public void calcCheckingWithdraw(double amount){
        checkingBalance -= amount;
    }

    public void calcSavingWithdraw(double amount){
        savingBalance -= amount;
    }

    public void calcCheckingDeposit(double amount){
        checkingBalance += amount;
    }

    public void calcSavingDeposit(double amount){
        savingBalance += amount;
    }

    public void getCheckingWithdrawInput() {
        System.out.println("Balance: " + moneyFormat.format(checkingBalance));
        System.out.print("Withdraw: ");
        double amount = input.nextDouble();

        if (amount > 0 && checkingBalance >= amount) {
            calcCheckingWithdraw(amount);
        } else {
            System.out.println("Invalid or insufficient funds.");
        }
    }

    public void getSavingWithdrawInput() {
        System.out.println("Balance: " + moneyFormat.format(savingBalance));
        System.out.print("Withdraw: ");
        double amount = input.nextDouble();

        if (amount > 0 && savingBalance >= amount) {
            calcSavingWithdraw(amount);
        } else {
            System.out.println("Invalid or insufficient funds.");
        }
    }

    public void getCheckingDepositInput(){
        System.out.print("Deposit: ");
        double amount = input.nextDouble();

        if (amount > 0) {
            calcCheckingDeposit(amount);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void getSavingDepositInput(){
        System.out.print("Deposit: ");
        double amount = input.nextDouble();

        if (amount > 0) {
            calcSavingDeposit(amount);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Account account = new Account();

        account.setCustomerNumber(1886014);
        account.setPinNumber(145);

        System.out.println("Welcome to ATM");

        // Login Interface
        while (true) {
            System.out.print("Customer Number: ");
            int cn = input.nextInt();

            System.out.print("PIN: ");
            int pn = input.nextInt();

            if (cn == account.getCustomerNumber() && pn == account.getPinNumber()) {
                break;
            } else {
                System.out.println("Wrong details, try again.\n");
            }
        }

        int choice;
        do {
            System.out.println("\n1. Checking\n2. Saving\n3. Exit");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    checkingMenu(account);
                    break;
                case 2:
                    savingMenu(account);
                    break;
            }
        } while (choice != 3);

        input.close();
    }

    // Checking Menu
    public static void checkingMenu(Account acc) {
        Scanner input = new Scanner(System.in);
        int ch;

        do {
            System.out.println("\n1.View 2.Withdraw 3.Deposit 4.Back");
            ch = input.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Balance: " + acc.getCheckingBalance());
                    break;
                case 2:
                    acc.getCheckingWithdrawInput();
                    break;
                case 3:
                    acc.getCheckingDepositInput();
                    break;
            }
        } while (ch != 4);
    }

    // Saving Menu
    public static void savingMenu(Account acc) {
        Scanner input = new Scanner(System.in);
        int ch;

        do {
            System.out.println("\n1.View 2.Withdraw 3.Deposit 4.Back");
            ch = input.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Balance: " + acc.getSavingBalance());
                    break;
                case 2:
                    acc.getSavingWithdrawInput();
                    break;
                case 3:
                    acc.getSavingDepositInput();
                    break;
            }
        } while (ch != 4);
    }
}