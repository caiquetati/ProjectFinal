package TokioFinal.ProjectWork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"TokioFinal/ProjectWork/Controller", "TokioFinal/ProjectWork/Service", "TokioFinal/ProjectWork/Repository", "TokioFinal/ProjectWork/entity"})
public class ProjectWorkApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectWorkApplication.class, args);
	}

}
