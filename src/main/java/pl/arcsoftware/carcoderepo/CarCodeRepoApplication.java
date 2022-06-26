package pl.arcsoftware.carcoderepo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "CarApi", version = "1.0", description = """
        Api documentation for vehicle management.\r
        To use methods please authorize with "/api/auth/singin"
        then copy token from response to "Authorize". Now you can use endpoints with padlock"""))
public class CarCodeRepoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarCodeRepoApplication.class, args);
    }

}
