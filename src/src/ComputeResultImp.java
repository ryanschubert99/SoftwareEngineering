package src;

public class ComputeResultImp implements ComputeResult {
		  
		  private final ComputeResultStatus status;

		  public ComputeResultImp (boolean isSuccess) {
		    this.status = isSuccess ? ComputeResultStatus.SUCCESS : ComputeResultStatus.FAILURE;
		  }

		  @Override
		  public ComputeResultStatus getStatus() {
		    return this.status;
		  }
}
