package uk.gov.homeoffice.checks;

/**
 * Created by koskinasm on 10/02/2017.
 */
public class CheckPrinter {
    public static void printCheckSpecification(Check check)
    {
        StringBuilder builder = new StringBuilder();
        builder.append(check.getClass().getName()+" ");
        builder.append(check.getInput()+" ");
        builder.append(check.getOutput()+" ");
        builder.append(check.isEnabled());

        System.out.println(builder.toString());
    }
}
