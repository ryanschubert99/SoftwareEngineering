package src;

public interface ComputeResult {
  static ComputeResult SUCCESS = new ComputeResult() {
    @Override
    public ComputeResultStatus getStatus() {
      return ComputeResultStatus.SUCCESS;
    }

    @Override
    public String getFailureMessage() {
      return "";
    }
  };

  ComputeResultStatus getStatus();
  String getFailureMessage();

  public static enum ComputeResultStatus {
    SUCCESS(true),
    INVALID_REQUEST(false),
    FAILURE(false);

    private final boolean success;

    private ComputeResultStatus(boolean success) {
      this.success = success;
    }

    public boolean isSuccess() {
      return success;
    }
  }
}
