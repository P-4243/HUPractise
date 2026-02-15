import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Map<Integer,Integer> map=new ConcurrentHashMap<>();
    //It uses internal locking mechanism
    //Doesn’t lock entire map
    //Allows concurrent reads
    //Fine-grained synchronization
    public static void main(String[] args) throws InterruptedException {

        Thread t1=new Thread(()->{
            for(int i=0;i<10000;++i)
                map.put(i,i);
        });

        Thread t2=new Thread(()->{
            for(int i=0;i<10000;++i)
                map.put(i,i);
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("map size: "+map.size());
        //map size: 10030 - HashMap is NOT thread safe.
    }
}