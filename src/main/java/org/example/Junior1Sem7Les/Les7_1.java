package org.example.Junior1Sem7Les;

public class Les7_1 {
    public static void main(String[] args) {
        System.out.println("It nessesory to find factorial ");
        int a = 100;
        long t1 = System.currentTimeMillis();
        System.out.println(fact(a));
        long t2 = System.currentTimeMillis();
        System.out.println(fact1(a));
        long t3 = System.currentTimeMillis();
        System.out.println(t2-t1);
        System.out.println(t3-t2);



    }
    public static long fact(int a){
        System.out.println(a);
        if (a==1)
            return a;// a = 6*5
        return a*fact(a-1);
    }
    public static long fact1(int a){
        int q = 1;
        for (int i = 2; i <=a ; i++) {
            System.out.println(i);
            q*=i;

        }
        return q;
    }
}
