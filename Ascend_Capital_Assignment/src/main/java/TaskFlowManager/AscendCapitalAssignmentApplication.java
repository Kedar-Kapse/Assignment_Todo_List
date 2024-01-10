package TaskFlowManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"TaskFlowManager.Repository"})
public class AscendCapitalAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AscendCapitalAssignmentApplication.class, args);
	}

}
