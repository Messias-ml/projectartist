package com.messiasproject.projectartist.core.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Messias",
                        email = "messias.silva_dev@hotmail.com",
                        url = "https://www.linkedin.com/in/messias-dev-silva/"
                ),
                description = "OpenApi documentation for project artist",
                title = "OpenApi specification - Artist Project Messias",
                version = "1"
        ),
        servers = {
                @Server(
                        description = "local server",
                        url = "http://localhost:8080/artist"
                )
        }
)
public class OpenApiConfig {
}
