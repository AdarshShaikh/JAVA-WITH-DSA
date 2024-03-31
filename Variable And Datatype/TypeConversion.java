public class TypeConversion {
    public static void main(String[] args) {
        /*byte->short->int->float->long->double
        a.type compatability
        b. Destination type > Source type
        */
        byte a=10;
        short b=a;
        int c=b;
        float d=c;
        long e=(long) d;
        double f=e;
        System.out.println(f);
    }
}
