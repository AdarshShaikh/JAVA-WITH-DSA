import java.util.*;
public class AreaOfCircle {
    public static void main(String[] args) {
        Scanner S=new Scanner(System.in);
        float pi=3.14f;
        System.out.println("Enter radius of circle");
        float red=S.nextFloat();

        float Area=pi*red*red;

        System.out.println(Area);

    }
}