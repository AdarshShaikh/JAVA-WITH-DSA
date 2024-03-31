import java.util.Scanner;

public class AddWithUserInput {
    public static void main(String[] args) {
        Scanner S=new Scanner(System.in);
        int a=S.nextInt();
        int b=S.nextInt();

        int sum =a+b;
        System.out.println(sum);
    }
}
