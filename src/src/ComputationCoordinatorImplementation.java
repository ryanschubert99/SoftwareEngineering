package src;

public class ComputationCoordinatorImplementation implements ComputationCoordinator{
  private DataStorageComputeImplementation dataStore;
  private ComputeEngineImplementation computeEngine;
 
  public ComputationCoordinatorImplementation(DataStorageComputeImplementation dataStore, ComputeEngineImplementation computeEngine){
    this.dataStore = dataStore;
    this.computeEngine = computeEngine;
  }
  public ComputationCoordinatorImplementation() {
	// TODO Auto-generated constructor stub
}
public ComputeResult beginComputation() {
	ComputeRequest compute = new ComputeRequest();
    return  null;
  }
@Override
public ComputeResult beginComputation(ComputeRequest request) {
	// TODO Auto-generated method stub
	return null;
}
}
