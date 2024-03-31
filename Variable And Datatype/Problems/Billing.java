package Problems;

import java.util.Scanner;

public class Billing {
    public static void main(String[] args) {
        Scanner S= new Scanner(System.in);
        int pencil = S.nextInt();
        int pen= S.nextInt();
        int erasr= S.nextInt();

        System.out.println("Pencil :"+pencil);
        System.out.println("Pen :"+pen);
        System.out.println("Erasr :"+erasr);
        int total=pencil+pen+erasr;
        System.out.println("total :"+total);

        float GSTtotal=total+(0.18f*total);
        System.out.println("GSTtotal :"+GSTtotal);
    }
}
