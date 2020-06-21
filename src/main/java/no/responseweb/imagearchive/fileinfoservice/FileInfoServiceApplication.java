package no.responseweb.imagearchive.fileinfoservice;

import no.responseweb.imagearchive.filestoredbservice.config.DBModuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(DBModuleConfig.class)
public class FileInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileInfoServiceApplication.class, args);
	}

}
