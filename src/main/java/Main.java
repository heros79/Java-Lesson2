public class Main {


    public static void main(String[] args) {

        String s = "D";
        StringBuilder builder = new StringBuilder("D");
        String strV = String.valueOf(builder);
        String strN = new String(builder);
        String strT = builder.toString();
        System.out.println(s == strV);
        System.out.println(s == strN);
        System.out.println(s == strT);

    }

}