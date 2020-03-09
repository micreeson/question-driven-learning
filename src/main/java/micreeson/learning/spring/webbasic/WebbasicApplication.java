package micreeson.learning.spring.webbasic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;
import java.util.concurrent.ThreadPoolExecutor;

@SpringBootApplication
@Slf4j
public class WebbasicApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WebbasicApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception{
		HashMapAndConcurrentHashMap hashMap = new HashMapAndConcurrentHashMap();
		int i = 0;
		int max = 200000;
		Random rdm = new Random();
		while (i<max) {
//			MultiThreadPut putThread = new MultiThreadPut(hashMap, rdm.nextInt(100000));
			MultiThreadPut putThread = new MultiThreadPut(hashMap, i);
			putThread.start();
			i++;
		}

		log.info("Put done:" + hashMap.safeGetSize());

		i = 0;
		String value;
		while (i < max){
			value = hashMap.safeGet(i);
			if ( !value.equals(String.valueOf(i))){
				log.info("Get you:" + i);
			}
			i++;
		}

//		log.info("Get Done:" + i + ":" + hashMap.getSize());

		while(hashMap.safeGetSize() < max){
			Thread.sleep(1000);
			log.info("size is:" + hashMap.safeGetSize());
		}

		log.info("We Done:" + hashMap.safeGetSize());
	}

}
