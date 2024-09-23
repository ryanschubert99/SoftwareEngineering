package src;

public interface ComputeResult {
  static ComputeResult SUCCESS = () -> ComputeResultStatus.SUCCESS;
  static ComputeResult FAILURE = () -> ComputeResultStatus.FAILURE;
	
  public static enum ComputeResultStatus {
		SUCCESS(true),
		FAILURE(false);
		
    private final boolean success;
		
    private ComputeResultStatus(boolean success) {
      this.success = success;
    }
    public boolean isSuccess() {
      return success;
    }
  }
  ComputeResultStatus getStatus();
}