package org.example.Les6;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

public class Les6_1 {
    static  HashMap<String,String> hashMap;
   static boolean state = true;
   static  int sec = 0;
    static {
        try {
            hashMap = getQ();
            System.out.println(hashMap);
            System.out.println(hashMap.size());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws Exception{
        WhyWantToBecomeMill whyWantToBecomeMill = new WhyWantToBecomeMill();
        whyWantToBecomeMill.start();
        Answer answer = new Answer();
        answer.start();

    }
    public static HashMap<String,String> getQ() throws Exception{
        URL url = new URL("https://opentdb.com/api.php?amount=10");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        String buf = bufferedReader.readLine();
        JSONObject jsonObject = new JSONObject(buf);
        Object object = jsonObject.get("results");
        JSONArray jsonArray = new JSONArray(object.toString());
        HashMap<String,String> hashMap = new HashMap<>();
        for (Object obj:jsonArray){
            JSONObject jsonObject1 = (JSONObject) obj;
            hashMap.put(jsonObject1.get("question").toString(),jsonObject1.get("correct_answer").toString());

        }
        return hashMap;



    }
    static class Answer extends Thread{
        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            int count = 0;
            while (state){
                for (Map.Entry<String, String> elem:hashMap.entrySet()){
                    System.out.println(elem.getKey());
                    String answer = scanner.nextLine();
                    if (answer.equals(elem.getValue())){
                        count++;
                        sec=0;
                    }
                    else {
                        state=!state;
                    }
                }

            }

            System.out.println(count);
        }
    }
    static class WhyWantToBecomeMill extends Thread {
        @Override
        public void run() {

            while (state) {
                try {
                    Thread.sleep(100);
                    sec++;
                    if (sec>59){
                        state=!state;
                        break;
                    }
                    System.out.println(sec);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
