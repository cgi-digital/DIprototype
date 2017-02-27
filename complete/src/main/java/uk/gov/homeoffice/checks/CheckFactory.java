package uk.gov.homeoffice.checks;

/**
 * Created by koskinasm on 27/02/2017.
 */
public class CheckFactory {
    public static Check createCheck(String name, CheckSpecification checkSpecification)
    {
        System.out.println("Creating check for " + name);
        return new DeduplicationCheck(checkSpecification);
    }
}
