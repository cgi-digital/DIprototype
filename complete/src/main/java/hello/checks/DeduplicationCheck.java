package hello.checks;

/**
 * Created by koskinasm on 09/02/2017.
 */


public class DeduplicationCheck implements Check {


    private String input;
    private String output;
    private boolean enabled;

    public DeduplicationCheck(CheckSpecification specification)
    {
        this.input = specification.getInput();
        this.output = specification.getOutput();
        this.enabled = specification.getStatus();
    }

    @Override
    public boolean runCheck() {
        return true;
    }

    @Override
    public String getInput() {
        return input;
    }

    @Override
    public String getOutput() {
        return output;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
