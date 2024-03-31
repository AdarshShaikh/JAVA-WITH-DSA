import java.util.*;
public class Input {
    public static void main(String[] args) {
        Scanner S =new Scanner(System.in); //S is referance variable to accesss Scanner class property

        System.out.println("Enter Numeric Value");
        int a=S.nextInt(); //Accept integer value
        System.out.println(a);

        System.out.println("Enter floting Value");
        float b=S.nextFloat();// Accept Floting Value
        System.out.println(b);

        System.out.println("Enter Sentences");
        String d=S.nextLine(); //Accept Complete Sentence
        System.out.println(d);

        System.out.println("Enter World");
        String c=S.next(); //Accept only one complete World
        System.out.println(c);

        

    }
    
}
