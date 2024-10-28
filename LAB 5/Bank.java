import java.util.Scanner;
class Account {
String customerName;
String accountNumber;
double balance;
public Account(String customerName, String accountNumber) {
this.customerName = customerName;
this.accountNumber = accountNumber;
this.balance = 0.0;
 }
 public void deposit(double amount) {
 if (amount > 0) {
 balance += amount;
 System.out.println("Deposited: " + amount);
}
}
public void displayBalance() {
System.out.println("Current balance: " + balance);
}
}
class SavingsAccount extends Account {
private double interestRate;
public SavingsAccount(String customerName, String accountNumber, double interestRate) {
super(customerName, accountNumber);
this.interestRate = interestRate;
}
public void computeAndDepositInterest() {
double interest = balance * interestRate / 100;
deposit(interest);
System.out.println("Interest deposited: " + interest);
}
public boolean withdraw(double amount) {
if (amount > 0 && amount <= balance) {
balance -= amount;
System.out.println("Withdrawn: " + amount);
return true;
}
 return false;
}
}
class CurrentAccount extends Account {
private static final double MIN_BALANCE = 1000.0;
private static final double SERVICE_CHARGE = 50.0;
public CurrentAccount(String customerName, String accountNumber) {
super(customerName, accountNumber);
}
public boolean withdraw(double amount) {
if (amount > 0 && amount <= balance) {
balance -= amount;
if (balance < MIN_BALANCE) {
balance -= SERVICE_CHARGE;
System.out.println("Service charge imposed. New balance: " + balance);
}
System.out.println("Withdrawn: " + amount);
return true;
}
return false;
}
}
public class Bank {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
        
System.out.print("Enter customer name: ");
String name = scanner.nextLine();
        
System.out.print("Enter account number: ");
String accountNumber = scanner.nextLine();
        
System.out.print("Choose account type (1 for Savings, 2 for Current): ");
int choice = scanner.nextInt();

Account account = (choice == 1)
? new SavingsAccount(name, accountNumber, 5.0) // 5% interest for simplicity
: new CurrentAccount(name, accountNumber);
while (true) {
System.out.println("\nMenu:\n1. Deposit\n2. Display Balance\n3. Withdraw\n4. Compute Interest (Savings only)\n5. Exit");
System.out.print("Choose an option: ");
int option = scanner.nextInt();
switch (option) {
case 1:
System.out.print("Enter amount to deposit: ");
account.deposit(scanner.nextDouble());
break;
case 2:
account.displayBalance();
break;
case 3:
System.out.print("Enter amount to withdraw: ");
double withdrawAmount = scanner.nextDouble();
if (account instanceof SavingsAccount) {
((SavingsAccount) account).withdraw(withdrawAmount);
} else {
((CurrentAccount) account).withdraw(withdrawAmount);
}
break;
case 4:
if (account instanceof SavingsAccount) {
((SavingsAccount) account).computeAndDepositInterest();
} else {
System.out.println("Interest computation not available for Current Account.");
}
break;
case 5:
System.out.println("Exiting...");
scanner.close();
return;
default:
System.out.println("Invalid option. Try again.");
}
}
}
}
