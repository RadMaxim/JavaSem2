package org.example.Junior1Sem8Les;

import java.util.Scanner;

public class Les8_2 {
    static String test = "https://www.youtube.com/";

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Check url...");
        String url = scanner.nextLine();
        System.out.println(checkURL(test));

    }
    public static StringBuilder checkURL(String url){
        StringBuilder mistake = new StringBuilder();
        int first = url.indexOf("/");
        int second = url.indexOf("/", first+2);
        if (first==5)mistake.append("http").append("\n");
        if(second==-1)mistake.append("not correct url").append("\n");
        if (!url.contains(".com") && !url.contains(".ru") && !url.contains(".by"))mistake.append("line end is not correct").append("\n");
        if (url.indexOf("?",second)==-1)mistake.append("This current url not have a variable").append("\n");

        return  mistake;

    }
}
