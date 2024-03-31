package Problems;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner S=new Scanner(System.in);
        System.out.println("Enter Number");
        int a=S.nextInt();
        int b=S.nextInt();
        int c=S.nextInt();

        double Avg=(a+b+c)/3;
        System.out.println("Average :"+Avg);
    }
}
