package Problems;

import java.util.Scanner;

public class AreaOfSquare {
    public static void main(String[] args) {
        Scanner S= new Scanner((System.in));
        System.out.println("Enter one side area ");
        int side=S.nextInt();
        int Area=side*side;

        System.out.println("Area of Square:"+Area);
    }
}
