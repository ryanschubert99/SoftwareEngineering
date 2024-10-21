package src;

public interface ComputeResult {
  static ComputeResult SUCCESS = () -> ComputeResultStatus.SUCCESS;
  static ComputeResult FAILURE = () -> ComputeResultStatus.FAILURE;
	
  public static enum ComputeResultStatus {
		SUCCESS(true),
		FAILURE(false);
		
    private final boolean success;
    private final boolean failure;
		
    private ComputeResultStatus(boolean success) {
      this.success = success;
	  this.failure = failure;
    }
    
    void ComputeResultStatus(boolean failure) {
		this.failure= failure;
    }
		
    public boolean isSuccess() {
    	return success;
    }
	
    public boolean isFailure() {
    	return failure;
    }
		
	
  }
  ComputeResultStatus getStatus();
}