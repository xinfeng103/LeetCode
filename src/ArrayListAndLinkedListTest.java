import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArrayListAndLinkedListTest {
    public static void main(String args[]) {
        Object obj = new Object();
        List aList = new ArrayList();
        List bList = new LinkedList();

        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            aList.add(0, obj);
        }
        long t2 = System.currentTimeMillis() - t1;

        t1 = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            bList.add(0, obj);
        }
        long t3 = System.currentTimeMillis() - t1;
        System.out.println(t2);
        System.out.println(t3);
    }
}
