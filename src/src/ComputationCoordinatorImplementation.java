package src;

public class ComputationCoordinatorImplementation implements ComputationCoordinator{
  private DataStorageCompute dataStore;
  private ComputeEngine computeEngine;
 
  public ComputationCoordinatorImplementation(DataStorageCompute dataStore, ComputeEngine computeEngine){
    this.dataStore = dataStore;
    this.computeEngine = computeEngine;
  }
  public ComputeResult compute(ComputeRequest request) {
   // Returning placeholder result
    return  null;
  }
}
