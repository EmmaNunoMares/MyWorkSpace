package guru.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MySpringMvcApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(MySpringMvcApplication.class, args);
        //SpringApplication.run(MySpringMvcApplication.class, args);
    }

}
