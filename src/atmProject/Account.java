package atmProject;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    private int accountNumber;
    private int pinNumber;

    private double checkingBalance; //vadesiz hesap bakiyesi
    private double savingBalance; //vadeli hesap bakiyesi

    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    Scanner input = new Scanner(System.in);


    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }


//------------------------- para cekme (vadesiz) -------------------------

    private double calculateCheckingBalanceAfterWithdraw(double amount) {

        checkingBalance = checkingBalance - amount;
        return checkingBalance;
    }

//------------------------- para yatirma (vadesiz) -------------------------

    private double calculateCheckingBalanceAfterDeposit(double amount) {

        checkingBalance = checkingBalance + amount;
        return checkingBalance;
    }

//------------------------- para cekme (vadeli) -------------------------

    private double calculateSavingBalanceAfterWithdraw(double amount) {

        savingBalance = savingBalance - amount;
        return savingBalance;
    }

//------------------------- para yatirma (vadeli) -------------------------

    private double calculateSavingBalanceAfterDeposit(double amount) {

        savingBalance = savingBalance + amount;
        return savingBalance;
    }

//------------------------- son bakiyeyi goster -------------------------

    public void displayCurrentBalance(double balance) {

        System.out.println("Checking hesabinizda bulunan bakiye: " + moneyFormat.format(balance));

    }

//--------------- musteri ile interaction (para cekme (vadesiz)) ------------

    public void getCheckingWithdraw() {
        displayCurrentBalance(checkingBalance);
        System.out.println("Cekmek istediginiz miktari giriniz:");
        double amount = input.nextDouble();

        if (amount <= 0) {

            System.out.println("Sifir veya eksi rakamlar gecersizdir");
            getCheckingWithdraw();

        } else if (amount <= checkingBalance) {

            calculateCheckingBalanceAfterWithdraw(amount);
            System.out.println();
            displayCurrentBalance(checkingBalance);

        } else {

            System.out.println("Yetersiz bakiye!");

        }
    }

//--------------- musteri ile interaction (para yatirma (vadesiz)) ------------

    public void getCheckingDeposit() {
        displayCurrentBalance(checkingBalance);
        System.out.println("Yatirmak istediginiz miktari giriniz:");
        double amount = input.nextDouble();

        if (amount <= 0) {

            System.out.println("Sifir veya eksi rakamlar gecersizdir");
            getCheckingDeposit();

        } else {

            calculateCheckingBalanceAfterDeposit(amount);
            System.out.println();
            displayCurrentBalance(checkingBalance);

        }
    }

//--------------- musteri ile interaction (para cekme (vadeli)) ------------

    public void getSavingWithdraw() {
        displayCurrentBalance(savingBalance);
        System.out.println("Cekmek istediginiz miktari giriniz:");
        double amount = input.nextDouble();

        if (amount <= 0) {

            System.out.println("Sifir veya eksi rakamlar gecersizdir");
            getSavingWithdraw();

        } else if (amount <= savingBalance) {

            calculateSavingBalanceAfterWithdraw(amount);
            System.out.println();
            displayCurrentBalance(savingBalance);

        } else {

            System.out.println("Yetersiz bakiye!");

        }
    }

//--------------- musteri ile interaction (para yatirma (vadeli)) ------------

    public void getSavingDeposit() {
        displayCurrentBalance(savingBalance);
        System.out.println("Yatirmak istediginiz miktari giriniz:");
        double amount = input.nextDouble();

        if (amount <= 0) {

            System.out.println("Sifir veya eksi rakamlar gecersizdir");
            getSavingDeposit();

        } else {

            calculateSavingBalanceAfterDeposit(amount);
            System.out.println();
            displayCurrentBalance(savingBalance);

        }
    }
}
