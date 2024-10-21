package src;

public class ComputeResultImpl implements ComputeResult {

  private final ComputeResultStatus status;
  private final String failureMessage;

  public ComputeResultImpl(ComputeResultStatus status, String failureMessage) {
    this.status = status;
    this.failureMessage = failureMessage;
  }

  @Override
  public ComputeResultStatus getStatus() {
    return status;
  }

  @Override
  public String getFailureMessage() {
    return failureMessage;
  }

}
