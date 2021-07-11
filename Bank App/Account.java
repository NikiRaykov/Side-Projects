import java.util.Scanner;
public class Account {
        //Class Variables
        int balance;
        int previousTransaction;
        String customerName;
        String customerID;

        // Class constructor
        Account(String cname, String cid){
            customerName = cname;
            customerID = cid;
        }

        // Function for depositing money
        void deposit(int amount){
                if (amount != 0){
                    balance = balance + amount;
                    previousTransaction = amount;
                }
    }

        // Function for withdrawing money
        void withdraw(int amount){
            if (amount != 0){
                balance -= amount;
                previousTransaction = -amount;
            }
                }

          // Function for showing the previous transaction
        void getPreviousTransaction(){
            if (previousTransaction > 0){
                System.out.println("Deposited: " + previousTransaction);
            }else if (previousTransaction < 0){
                System.out.println("Withdraw: " + Math.abs(previousTransaction));
            }else {
                System.out.println("No transaction occurred!");
            }
        }

        // Function for calculating interest of current funds after a number of years
        void calculateInterest(int years){
            double interestRate = .0185;
            double newBalance = (balance * interestRate * years) + balance;
            System.out.println("The current interest rate is: " + (interestRate * 100) + "%");
            System.out.println("After " + years + " years, your balance " +
                    "will be " + newBalance);
        }

        // Function to show menu
        void showMenu(){
            char option = '\0';
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome, " + customerName + "!");
            System.out.println("Your ID is: " + customerID);
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println();
            System.out.println("A: Check you balance");
            System.out.println("B: Make a deposit");
            System.out.println("C: Make a withdraw");
            System.out.println("D: View previous transaction");
            System.out.println("E: Calculate interest rate");
            System.out.println("F: EXIT");

            do {
                System.out.println();
                System.out.println("Enter an option:");
                char option1 = scanner.next().charAt(0);
                option = Character.toUpperCase(option1);
                System.out.println();

                switch (option){
                    // Allows the user to check his balance
                    case 'A':
                        System.out.println("=================================");
                        System.out.println("Balance = " + balance + "$");
                        System.out.println("=================================");
                        System.out.println();
                    break;
                    // Allows the user to deposit money
                    case 'B':
                        System.out.println("Enter an amount:");
                        int amount = scanner.nextInt();
                        deposit(amount);
                        System.out.println();
                        break;
                    // Allows the user to withdraw money
                    case 'C':
                        System.out.println("Enter an amount to withdraw: ");
                        int amount2 = scanner.nextInt();
                        withdraw(amount2);
                        System.out.println();
                        break;
                    // Allows the user to view previous transaction
                    case 'D':
                        System.out.println("=================================");
                        getPreviousTransaction();
                        System.out.println("=================================");
                        break;
                    // Allows the user to calculate interest rate
                    case 'E':
                        System.out.println("Enter how many years of accrued interest: ");
                        int years = scanner.nextInt();
                        calculateInterest(years);
                        break;
                    // EXITS the user from their account
                    case 'F':
                        System.out.println("=================================");
                        break;
                    default:
                        System.out.println("Error: Invalid option. Please enter A, B, C, D, E, F");
                        break;
                }
            }while (option != 'F');
            System.out.println("Thank you for banking with us");
        }
}
