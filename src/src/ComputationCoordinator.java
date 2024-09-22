package src;
//API: network API between user and compute engine
public interface ComputationCoordinator {
	
  ComputeResult compute(ComputeRequest request);

}
