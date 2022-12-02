package atmProject;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Options extends Account{
    Scanner input = new Scanner(System.in);

    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    boolean flag = true;
    HashMap<Integer,Integer> data = new HashMap<>();

    //--------------- login islemleri ------------
    public  void login(){
        System.out.println("Welcome to Techproed ATM");

        do {
            data.put(12345,1234);
            data.put(23456,2345);
            data.put(34567,3456);
            data.put(45678,4567);

            try {

                System.out.println("Enter your account number");
                setAccountNumber(input.nextInt());
                System.out.println("Enter your PIN number");
                setPinNumber(input.nextInt());

            }catch(Exception e){
                System.out.println("Invalid character! Please enter digit or press 'Q' for exit");
                String exit = input.next();
                if (exit.equalsIgnoreCase("Q")){
                    flag = false;
                }
            }

            int count = 0;
            for (Map.Entry<Integer,Integer> w: data.entrySet()){
                if (w.getKey().equals(getAccountNumber()) && w.getValue().equals(getPinNumber())){
                    getAccountTypes(); // hesap islemlerine git
                }else count++;
            }
            if (count == data.size()) System.out.println("Invalid account number or pin number");

        }while (flag);
    }

    //--------------- vadesiz hesap islemleri ------------
    public void checkingOperations() {

        do {
            displayMessage();

            int option =input.nextInt();

            if (option == 4) break;

            switch (option) {
                case 1:
                    System.out.println("Checking hesabinizda kalan bakiye: " + moneyFormat.format(getCheckingBalance()));
                    break;
                case 2:
                    getCheckingWithdraw();
                    break;
                case 3:
                    getCheckingDeposit();
                    break;
                default:
                    System.out.println("Invalid option! Please press 1,2,3 or 4");

            }

        }while (true);
        getAccountTypes();
    }

    //--------------- vadeli hesap islemleri ------------
    public void savingOperations() {
        DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

        do {
            displayMessage();
            int option =input.nextInt();

            if (option == 4) break;

            switch (option) {
                case 1:
                    System.out.println("Checking hesabinizda kalan bakiye: " + moneyFormat.format(getCheckingBalance()));
                    break;
                case 2:
                    getCheckingWithdraw();
                    break;
                case 3:
                    getCheckingDeposit();
                    break;
                default:
                    System.out.println("Invalid option! Please press 1,2,3 or 4");

            }

        }while (true);
        getAccountTypes();
    }

    //--------------- ilgili hesabi sec ------------
    public void getAccountTypes() {
        System.out.println("Select the account you want to trade");
        System.out.println("1: Checking account");
        System.out.println("2: Saving account");
        System.out.println("3: Exit");

        int option = input.nextInt();

        switch (option) {
            case 1:
                System.out.println("Checking account");
                checkingOperations();
                break;
            case 2:
                System.out.println("Saving account");
                savingOperations();
                break;
            case 3:
                System.out.println("Thank you...");
                flag = false;
                break;
            default:
                System.out.println("Invalid option! Please press 1,2 or 3");
        }

    }

    //--------------- kisi icin secenekleri goruntule ------------
    public void displayMessage(){
        System.out.println("Choose option!");
        System.out.println("1: View Balance"); //hesap goruntule
        System.out.println("2: Withdraw"); //para cekme
        System.out.println("3: Deposit"); //para yatirma
        System.out.println("4: Exit");
    }

}
