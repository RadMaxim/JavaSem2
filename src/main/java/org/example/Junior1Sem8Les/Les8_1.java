package org.example.Junior1Sem8Les;

import java.util.Scanner;

public class Les8_1 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("this program need for check password...");

    }
    public static boolean checkLength(String password){
        int lenPassword = password.length();
        if (lenPassword<8){
            return false;
        }
        return true;
    }
    public static boolean checkDigital(String password){
        if (password.replaceAll("[0-9]","").equals(password)){
            return true;
        }
        return false;
    }
    public static boolean checkEnglish(String password){
        if (password.replaceAll("[А-Яа-я]","").equals(password))return true;
        return false;
    }
    public static boolean checkSpecialSymbol(String password){
        if (password.replaceAll("[A-Za-zА-Яа-я0-9]", "").isEmpty()){
            return true;
        }
        return false;

    }
}
