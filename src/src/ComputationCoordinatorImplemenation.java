package src;

public class ComputationCoordinatorImplemenation implements ComputationCoordinator{
  private DataStorageCompute dataStore;
  private ComputeEngine computeEngine;
 
  public void ComputationCoordinator(DataStorageCompute dataStore, ComputeEngine computeEngine){
    this.dataStore = dataStore;
    this.computeEngine = computeEngine;
  }
  public ComputeResult compute(ComputeRequest request) {
   // Returning placeholder result
    return  null;
  }
}
