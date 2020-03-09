package micreeson.learning.spring.webbasic;

import lombok.extern.slf4j.Slf4j;

public class MultiThreadPut extends Thread {
    private HashMapAndConcurrentHashMap hashmap;
    private Integer threadName;
    private Thread t;

    MultiThreadPut(HashMapAndConcurrentHashMap paraHashmap, int name){
        hashmap = paraHashmap;
        threadName = name;
    }

    @Override
    public void run(){
        hashmap.unsafePut(threadName, threadName.toString());
        hashmap.safePut(threadName,threadName.toString());
    }
}
