package uk.gov.homeoffice.checks;

/**
 * Created by koskinasm on 27/02/2017.
 */
public class CheckResult {

    private boolean success;
    private String errorCode;

    public CheckResult(boolean success, String errorCode)
    {
        this.success = success;
        this.errorCode = errorCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
