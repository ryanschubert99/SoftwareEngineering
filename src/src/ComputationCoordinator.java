package src;
//API: network API between user and compute engine
public interface ComputationCoordinator {
	
  ComputeResult beginComputation(ComputeRequest request);

}
