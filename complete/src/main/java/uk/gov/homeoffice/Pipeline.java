package uk.gov.homeoffice;

import uk.gov.homeoffice.checks.Check;
import uk.gov.homeoffice.checks.CheckFactory;
import uk.gov.homeoffice.checks.CheckSpecification;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by koskinasm on 09/02/2017.
 */
public class Pipeline {

    private Map<String,CheckSpecification>  checkOrder;

    private String originalSource;
    private String output;

    private List<Check> checks;

    public Pipeline(String originalSource, String output, Map<String,CheckSpecification> checkOrder)
    {
        this.originalSource = originalSource;
        this.output = output;
        this.checkOrder = checkOrder;

        initializePipeline();
    }

    public void runChecks(String filepath)
    {
        System.out.println("Pipeline will run checks for " + filepath);

        boolean success = true;
        for(int c = 0 ; c < checks.size() && success == true ; c++)
        {
            Check check = checks.get(c);
            success = check.runCheck().isSuccess();
            if(!success)
            {
                System.out.println("I will generate an error report");
            }
            System.out.println("I will audit the check");
        }
    }

    private void initializePipeline()
    {
        checks = new ArrayList<Check>();
        for(String checkName : checkOrder.keySet())
        {
            checks.add(CheckFactory.createCheck(checkName,checkOrder.get(checkName)));
        }
    }


    public String getOriginalSource() {
        return this.originalSource;
    }
    public String getOutput(){
        return this.output;
    }

    public Map<String,CheckSpecification> getCheckOrder()
    {
        return this.checkOrder;
    }
}
