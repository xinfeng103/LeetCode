import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Hello {
    public void test() {
        Hashtable<String, String> ht = new Hashtable<>();

        ConcurrentHashMap chm = new ConcurrentHashMap();

        Integer i = Integer.valueOf(1);

        ReentrantLock lock = new ReentrantLock();

        HashMap<String, String> hm = new HashMap<>();


        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}

