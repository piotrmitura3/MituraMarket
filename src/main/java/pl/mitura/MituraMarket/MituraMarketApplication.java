package pl.mitura.MituraMarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import java.util.Locale;

@SpringBootApplication
public class MituraMarketApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MituraMarketApplication.class);
    }

    @Bean(name = "localeResolver")
    public SessionLocaleResolver getLocaleContextResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("pl", "PL"));
        return localeResolver;
    }

	public static void main(String[] args) {
		SpringApplication.run(MituraMarketApplication.class, args);
	}
}
