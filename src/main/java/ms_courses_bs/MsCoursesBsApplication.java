package ms_courses_bs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsCoursesBsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCoursesBsApplication.class, args);
	}

}
