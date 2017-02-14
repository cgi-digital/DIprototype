package hello;

import hello.checks.*;

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

    public Pipeline(String originalSource, String output, Map<String,CheckSpecification> checks)
    {
        this.originalSource = originalSource;
        this.output = output;
//        validatePipeline(checks);
    }

    public void validatePipeline(List<CheckSpecification> checks)
    {
        checkOrder = new LinkedHashMap<>();
        checkOrder.put(this.originalSource,null);

        boolean allValid = false;
//        while(!allValid)
//        {
////            validate the checkOrder of checks
//            for(int i=0 ; i<checks.size() ; i++)
//            {
//
//            }
////            or throw exception if the checkOrder is invalid
//        }

        checkOrder.put(output,null);
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
