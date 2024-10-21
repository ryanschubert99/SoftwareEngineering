package tests;

import java.io.File;
import java.io.IOException;

import src.ComputationCoordinatorImp;


public class TestUser {
	
	// TODO 3: change the type of this variable to the name you're using for your
	// User <-> ComputeEngine API; also update the parameter passed to the constructor
	private final ComputationCoordinatorImp coordinator;

	public TestUser(ComputationCoordinatorImp coordinator) {
		this.coordinator = coordinator;
	}

	public void run(String outputPath) throws Exception {
		char delimiter = ';';
		String inputPath = "test" + File.separatorChar + "testInputFile.test";
		
		// TODO 4: Call the appropriate method(s) on the coordinator to get it to 
		// run the compute job specified by inputPath, outputPath, and delimiter
		coordinator.beginComputation(delimiter, inputPath, delimiter, delimiter, delimiter, delimiter, inputPath);
	}

}
