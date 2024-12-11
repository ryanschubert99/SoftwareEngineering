package src;

import io.grpc.stub.StreamObserver;

import src.ComputeResult.ComputeResultStatus;
import userinput.UserInput.ComputationResponse;
import userinput.UserInput.UserInputRequest;
import userinput.UserInputServiceGrpc.UserInputServiceImplBase;

public class UserInputServiceImpl extends UserInputServiceImplBase {

  private final ComputationCoordinator computationCoordinator; // Create an instance of your coordinator

  public UserInputServiceImpl() {
    this.computationCoordinator = new ComputationCoordinatorImp(); // Initialize the coordinator
  }

  public void createUserInput(UserInputRequest request, StreamObserver<ComputationResponse> responseObserver) {
    ComputationResponse response;

    try {
      // Call beginComputation on the coordinator directly
      ComputeResult result = computationCoordinator.beginComputation(new ComputeRequest(
    	  request.getConfigType(),
    	  request.getConfigFile(),
          request.getInputType(),
          request.getInputFileName(),
          request.getNumberOfMatrices(),
          request.getRows(),
          request.getColumns(),
          request.getDelimiter(),
          request.getOutputType(),
          request.getOutputFileName(),
          request.getOutputOrCompute()
      ));
      userinput.UserInput.ComputeResultStatus status;
      
      // switch statement to handle result status
      if (result.getStatus() == ComputeResultStatus.SUCCESS) {
        status = userinput.UserInput.ComputeResultStatus.SUCCESS;
      } else if (result.getStatus() == ComputeResultStatus.INVALID_REQUEST) {
        status = userinput.UserInput.ComputeResultStatus.INVALID_REQUEST;
      } else {
        status = userinput.UserInput.ComputeResultStatus.FAILURE;
      }

      response = ComputationResponse.newBuilder()
          .setResult(status)
          .build();
    } catch (Exception e) {
      System.err.println("Error processing request: " + e.getMessage());
      response = ComputationResponse.newBuilder()
          .setErrorMessage("Computation failed: " + e.getMessage())
          .build();
    }

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
