package application;

import mode.entities.Account;
import model.exceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner in = new Scanner(System.in);


            System.out.println("Enter account data");
            System.out.print("Number: ");
            int number = in.nextInt();
            System.out.print("Holder: ");
            in.nextLine();
            String name = in.nextLine();
            System.out.print("Initial balance: ");
            double balance = in.nextDouble();
            System.out.print("Withdraw limit: ");
            double withDrawnLimit = in.nextDouble();
            System.out.println();

            Account account = new Account(number, name, balance, withDrawnLimit);

            System.out.print("Enter amount for withdraw: ");
            double withDraw = in.nextDouble();
        try {
            account.whithDrawn(withDraw);
            System.out.println("New balance: " +String.format("%.2f", account.getBalance()));

        } catch (DomainException e){
            System.out.println(e.getMessage());
        } catch (java.util.InputMismatchException e){
            System.out.println("Invalid format number");
        }
    }
}
