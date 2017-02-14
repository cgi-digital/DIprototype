package hello;

import hello.checks.CheckSpecification;
import hello.checks.ContentScanningCheck;
import hello.checks.DeduplicationCheck;
import hello.checks.SchemaValidationCheck;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;

import java.util.List;
import java.util.Map;

/**
 * Created by koskinasm on 09/02/2017.
 */

@ConfigurationProperties(prefix = "pipeline_configuration")
@Configuration
public class PipelineConfiguration {

    private String original_source;
    private String output;

    Map<String,CheckSpecification> checks;

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

    @Bean(name = "ContentScanningCheck")
    @DependsOn("Pipeline")
    public ContentScanningCheck configureContentScanning()
    {
        return new ContentScanningCheck(checks.get("content_scanning"));
    }


    @Bean(name = "SchemaValidationCheck")
    @DependsOn("Pipeline")
    public SchemaValidationCheck configureSchemaValidation()
    {
        return new SchemaValidationCheck(checks.get("schema_validation"));
    }

    @Bean(name = "DeduplicationCheck")
    @DependsOn("Pipeline")
    public DeduplicationCheck configureDeduplicationCheck()
    {
        return new DeduplicationCheck(checks.get("deduplication"));
    }


    @Bean(name = "Pipeline")
    @Scope("prototype")
    public Pipeline configurePipeline() throws Exception {
        Pipeline pipeline = new Pipeline(original_source,output,checks);
        return pipeline;
    }
}
