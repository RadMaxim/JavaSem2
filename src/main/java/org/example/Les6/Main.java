package org.example.Les6;

public class Main {
    public static void main(String[] args) {
        FirstClass firstClass = new FirstClass();
        firstClass.start();
    }
    static class FirstClass extends Thread{
        @Override
        public void run() {
            int sec = 0, min = 0 , hour = 0;
            while (true){
                try {
                    sleep(1000);
                    sec++;
                    if (sec>59){
                        sec=0;
                        min++;
                    }
                    if (min>59){
                        min=0;
                        hour++;
                    }
                    if (hour>23){
                        hour=0;

                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(hour).append(":").append(min).append(":").append(sec);
                    System.out.println(stringBuilder);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
