package src;

public class ComputationCoordinatorPrototype {
  public void prototype(ComputationCoordinator apiToCall) {
    InputConfig inputConfig = new InputConfig() {
    };

    OutputConfig outputConfig = null;
    
    ComputeRequest request = new ComputeRequest(inputConfig, outputConfig, ',');
    
    ComputeResult result = apiToCall.compute(request);
    
    if (result.getStatus().isSuccess()) {
      System.out.println("Yay!");
    }
  }
}
