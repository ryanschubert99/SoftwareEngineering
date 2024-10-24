package src;

import java.util.List;

//import src.ComputeResult.ComputeResultStatus;

public class DataStorageResponseImpl implements DataStorageResponse {

	private final ResponseStatus status;
	private String failureMessage;
	private List<int[][]> matrix;
		
	public DataStorageResponseImpl(ResponseStatus status, String failureMessage,List<int[][]> matrix) {
	  this.status = status;
	  this.failureMessage = failureMessage;
	  this.matrix= matrix;
			
		}
	@Override
	public ResponseStatus getStatus() {
		 return status;
	}

	@Override
	public String getFailureMessage() {
		return failureMessage;
	}

	@Override
	public List<int[][]> getMatrix() {
		return matrix;
	}

}
