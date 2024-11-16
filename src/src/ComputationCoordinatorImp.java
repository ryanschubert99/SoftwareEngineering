package src;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import src.ComputeResult.ComputeResultStatus;

public class ComputationCoordinatorImp implements ComputationCoordinator {
  private static final int THREAD_POOL_SIZE = 20; // Number of threads to use in the pool
  private final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

  public ComputationCoordinatorImp() {}

  public ComputeResult beginComputationSingleSlow(int inputType, String inputFileName, int numberOfMatrices, int rows, int columns, int outputType, String outputFileName, int outputOrComp) throws IOException {
    try {
      // Create a new ComputeRequest for this thread
      ComputeRequest compute = new ComputeRequest(inputType, inputFileName, numberOfMatrices, rows, columns, outputType, outputFileName, outputOrComp);
      DataStorageImp dataStorage = new DataStorageImp(compute, outputOrComp);
      ComputeEngineImp computeEng = new ComputeEngineImp(dataStorage);

    } catch (Exception e) {
      e.printStackTrace();
    }
    return ComputeResult.SUCCESS;
  }
  public ComputeResult beginComputationSingleFast(int inputType, String inputFileName, int numberOfMatrices, int rows, int columns, int outputType, String outputFileName, int outputOrComp) throws IOException {
	    try {
	      // Create a new ComputeRequest for this thread
	      ComputeRequest compute = new ComputeRequest(inputType, inputFileName, numberOfMatrices, rows, columns, outputType, outputFileName, outputOrComp);
	      DataStorageImpFaster dataStorageFast = new DataStorageImpFaster(compute, outputOrComp);
//	      ComputeEngineImp computeEng = new ComputeEngineImp(dataStorage);

	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return ComputeResult.SUCCESS;
	  }

  public ComputeResult beginComputationMulti(int inputType, String inputFileName, int numberOfMatrices, int rows, int columns, int outputType, String outputFileName, int outputOrComp) throws IOException {
    // Submit fixed number of tasks to the thread pool
    for (int i = 0; i < THREAD_POOL_SIZE; i++) { // Create THREAD_POOL_SIZE threads
      final int threadIndex = i; // Capture the current index for use inside the lambda

      executorService.submit(() -> {
        String threadName = Thread.currentThread().getName();
        System.out.println("Executing computation on thread: " + threadName);

        try {
          // Create a new ComputeRequest for this thread
          ComputeRequest compute = new ComputeRequest(inputType, inputFileName, numberOfMatrices, rows, columns, outputType, outputFileName, outputOrComp);
          DataStorageImp dataStorage = new DataStorageImp(compute, outputOrComp);

          // Generate the unique output file name for this thread
          String uniqueOutputFileName = generateUniqueFileName(outputFileName, threadIndex);
          ComputeEngineImp computeEng = new ComputeEngineImp(dataStorage);

          // Call the method to perform the computation with the unique output file name
          computeEng.multiplyMatrix(dataStorage.getMatrices());
          dataStorage.writeOutput(uniqueOutputFileName, ";"); // Write output to the unique file

        } catch (Exception e) {
          e.printStackTrace();
        }
      });
    }

    return ComputeResult.SUCCESS; // Return immediately; actual computations will run in the background
  }

  @Override
  public ComputeResult beginComputation(ComputeRequest request) throws IOException {
    return beginComputationMulti(request.getInputConfig().getInputTypeValue(),
                                 request.getInputConfig().getInputFileName(),
                                 request.getInputConfig().getNumberOfMatrices(),
                                 request.getInputConfig().getRows(),
                                 request.getInputConfig().getColumns(),
                                 request.getOutputConfig().getOutputTypeValue(),
                                 request.getOutputConfig().getOutputFileName(),
                                 request.getOutputConfig().getOutputOrCompute());
  }

  // Helper method to generate a unique output file name
  private String generateUniqueFileName(String baseFileName, int index) {
    // Get the extension if it exists
    String extension = "";
    int dotIndex = baseFileName.lastIndexOf('.');
    if (dotIndex != -1) {
      extension = baseFileName.substring(dotIndex); // Get the extension
      baseFileName = baseFileName.substring(0, dotIndex); // Get the base file name without extension
    }

    return baseFileName + index + extension; // Append index before the extension
  }

  // Optional: Shut down the executor when done
  public void shutdown() {
    executorService.shutdown();
  }
}
