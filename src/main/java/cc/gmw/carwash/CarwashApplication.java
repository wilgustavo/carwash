package cc.gmw.carwash;

import cc.gmw.carwash.shared.model.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(
		includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
		value = {"cc.gmw.carwash"}
)
public class CarwashApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarwashApplication.class, args);
	}

}
