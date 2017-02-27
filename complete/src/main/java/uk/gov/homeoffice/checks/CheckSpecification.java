package uk.gov.homeoffice.checks;

/**
 * Created by koskinasm on 10/02/2017.
 */
public class CheckSpecification
{
    private boolean status;
    private String input;
    private String output;

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
