import java.util.Set;
import java.util.TreeSet;

public class Test {

    public static int a = 0;
    int b = 0;
    int c = 10;

    static {
        a++;
    }

    public Test () {
        a++;
        Set set = new TreeSet();
        String [] arr = new String [10];
        b = ++c + c++ - --c + ++c;
        System.out.println(c);
    }
}
