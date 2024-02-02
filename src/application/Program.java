package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        try{
        System.out.println("Enter account data");
        System.out.println("Number: ");
        Integer number = sc.nextInt();
        System.out.println("Holder: ");
        sc.nextLine();
        String holder = sc.nextLine();
        System.out.println("Insert initial balance: ");
        Double initialBalance = sc.nextDouble();
        System.out.println("Insert withdraw limit: ");
        Double withDrawLimit= sc.nextDouble();
        Account account = new Account(holder, number, initialBalance, withDrawLimit);
        System.out.println("Enter amount for withdraw: ");
        Double amount = sc.nextDouble();
        account.withdraw(amount);
        System.out.println("Updated balance: "+ account.getBalance());
        sc.close();
        }
        catch (DomainException e){
            System.out.println("An erro ocurred during the operation. Please check the following problems:\n"+ e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("An unexpected error ocurred.Please contact us for more information");
        }
    }
}
