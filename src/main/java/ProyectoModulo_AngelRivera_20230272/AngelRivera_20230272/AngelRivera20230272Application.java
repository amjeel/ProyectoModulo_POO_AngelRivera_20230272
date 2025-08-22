package ProyectoModulo_AngelRivera_20230272.AngelRivera_20230272;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AngelRivera20230272Application {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
		dotenv.entries().forEach(entry->
				System.setProperty(entry.getKey(), entry.getValue())
		);
		SpringApplication.run(AngelRivera20230272Application.class, args);
	}
}
