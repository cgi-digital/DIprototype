package hello;

import java.io.IOException;
import java.util.Arrays;

import com.sun.xml.internal.ws.developer.SchemaValidation;
import hello.checks.CheckPrinter;
import hello.checks.ContentScanningCheck;
import hello.checks.DeduplicationCheck;
import hello.checks.SchemaValidationCheck;
import hello.monitors.DirectoryMonitor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplicationBuilder applicationBuilder = new SpringApplicationBuilder(Application.class).web(false);
        applicationBuilder.run(args);

        Pipeline pipeline = (Pipeline) applicationBuilder.context().getBean("Pipeline");
        ContentScanningCheck contentScanningCheck = (ContentScanningCheck) applicationBuilder.context().getBean("ContentScanningCheck");
        SchemaValidationCheck schemaValidationCheck = (SchemaValidationCheck) applicationBuilder.context().getBean("SchemaValidationCheck");
        DeduplicationCheck deduplicationCheck = (DeduplicationCheck) applicationBuilder.context().getBean("DeduplicationCheck");

        CheckPrinter.printCheckSpecification(contentScanningCheck);
        CheckPrinter.printCheckSpecification(schemaValidationCheck);
        CheckPrinter.printCheckSpecification(deduplicationCheck);

        int x = 0;

        try {
            DirectoryMonitor monitor = new DirectoryMonitor(pipeline.getOriginalSource());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
