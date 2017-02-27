package uk.gov.homeoffice;

import uk.gov.homeoffice.checks.CheckSpecification;
import uk.gov.homeoffice.checks.ContentScanningCheck;
import uk.gov.homeoffice.checks.DeduplicationCheck;
import uk.gov.homeoffice.checks.SchemaValidationCheck;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;

import java.util.Map;

/**
 * Created by koskinasm on 09/02/2017.
 */

@ConfigurationProperties(prefix = "pipeline_configuration")
@Configuration
public class ApplicationConfiguration {

    public static String original_source;
    public static String output;

    public static Map<String,CheckSpecification> checks;

    public String getOriginal_source() {
        return original_source;
    }

    public void setOriginal_source(String original_source) {
        this.original_source = original_source;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public Map<String,CheckSpecification> getChecks() {
        return checks;
    }

    public void setChecks(Map<String,CheckSpecification> checks) {
        this.checks = checks;
    }

//    @Bean(name = "ContentScanningCheck")
//    public ContentScanningCheck configureContentScanning()
//    {
//        return new ContentScanningCheck(checks.get("content_scanning"));
//    }
//
//
//    @Bean(name = "SchemaValidationCheck")
//    public SchemaValidationCheck configureSchemaValidation()
//    {
//        return new SchemaValidationCheck(checks.get("schema_validation"));
//    }
//
//    @Bean(name = "DeduplicationCheck")
//    public DeduplicationCheck configureDeduplicationCheck()
//    {
//        return new DeduplicationCheck(checks.get("deduplication"));
//    }
//
//
//    @Bean(name = "Pipeline")
//    @Scope("prototype")
//    public Pipeline configurePipeline() throws Exception {
//        Pipeline pipeline = new Pipeline(original_source,output,checks);
//        return pipeline;
//    }
}
