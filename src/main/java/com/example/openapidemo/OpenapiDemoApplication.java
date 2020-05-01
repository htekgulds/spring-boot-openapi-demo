package com.example.openapidemo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Fruits API",
                version = "0.1.0",
                description = "Demo Documentation",
                contact = @Contact(
                        name = "Fruits API Support",
                        url = "http://fruitsapi.com/contact",
                        email = "techsupport@fruitsapi.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html"
                )
        ),
        tags = {
                @Tag(name = "fruits")
        }
)
public class OpenapiDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenapiDemoApplication.class, args);
    }

}
