package micreeson.learning.spring.webbasic;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class HashMapAndConcurrentHashMap {
    private HashMap<Integer, String> hashmap;
    private ConcurrentHashMap<String, String> concurrentHashMap;

    HashMapAndConcurrentHashMap(){
        hashmap = new HashMap<>();
        concurrentHashMap = new ConcurrentHashMap<>();
    }

    void hashMapTest(){
        hashmap.put(0, "testhashmap-value");
        log.info(hashmap.toString());
    }

    void unsafePut(int key, String value){
        hashmap.put(key, value);
//        log.info(hashmap.get(key));
//        if (key %1000 == 0){
//            System.out.println(hashmap.get(key));
//        }
    }

    void safePut(int key, String value){
        concurrentHashMap.put(String.valueOf(key),value);
    }
    String unsafeGet(int key){
        return hashmap.get(key);
    }

    String safeGet(int key){
        return concurrentHashMap.get(String.valueOf(key));
    }

    int getSize(){
        return hashmap.size();
    }

    int safeGetSize(){
        return concurrentHashMap.size();
    }

    public void compareDiff() {
        hashmap.forEach((key, value) -> {
            if(!key.equals(Integer.valueOf(value))){
                log.info("got you:" + key + ":" + value);
            }
        } );
    }
}
