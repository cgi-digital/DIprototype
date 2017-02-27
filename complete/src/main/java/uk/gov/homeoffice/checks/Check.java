package uk.gov.homeoffice.checks;

/**
 * Created by koskinasm on 09/02/2017.
 */
public interface Check {

    public CheckResult runCheck();

    public String getInput();

    public String getOutput();

    public boolean isEnabled();
    public void setEnabled(boolean enabled);
}
