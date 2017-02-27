package uk.gov.homeoffice;

import java.io.IOException;

import uk.gov.homeoffice.monitors.DirectoryMonitor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplicationBuilder applicationBuilder = new SpringApplicationBuilder(Application.class).web(false);
        applicationBuilder.run(args);

    try {
            DirectoryMonitor monitor = new DirectoryMonitor(ApplicationConfiguration.original_source);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
