package com.amadeus.app.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    public static final String API_TITLE = "notification";
    public static final String SECURITY_SCHEME_NAME = "bearerAuth";
    public static final String SECURITY_SCHEME = "bearer";
    public static final String SECURITY_SCHEME_FORMAT = "bearer";
    public static final String API_VERSION = "JWT";

    @Bean
    public OpenAPI customOpenAPI() {
        final String apiTitle = String.format("%s API", StringUtils.capitalize(API_TITLE));
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))
                .components(
                        new Components()
                                .addSecuritySchemes(SECURITY_SCHEME_NAME,
                                        new SecurityScheme()
                                                .name(SECURITY_SCHEME_NAME)
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme(SECURITY_SCHEME)
                                                .bearerFormat(SECURITY_SCHEME_FORMAT)
                                )
                )
                .info(new Info().title(apiTitle).version(API_VERSION));
    }

}
