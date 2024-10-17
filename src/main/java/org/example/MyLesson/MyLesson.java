package org.example.MyLesson;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;

public class MyLesson {
    public static void main(String[] args) {

    }
    public static void getData() throws Exception{
        URL url = new URL("");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        String data = bufferedReader.readLine();
    }
}
