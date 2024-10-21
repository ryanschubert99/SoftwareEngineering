package src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ComputationCoordinatorImp implements ComputationCoordinator {
  private DataStorageImp dataStore;
  private ComputeEngineImp computeEngine;
  private final ExecutorService executor;
  
  private int inputType = 0; // 0 is User Input, and 1 is File Input
  private String inputFileName;
  private int numberOfMatrices;
  private int rows;
  private int multiply;
  private int columns;
  private boolean valid = false;
  
  
  public ComputationCoordinatorImp(DataStorageImp dataStore, ComputeEngineImp compute,int inputType, String inputFileName, int numberOfMatrices,int rows, int columns, boolean valid) {
	
    this.dataStore = dataStore;
    this.computeEngine = compute;
    this.executor = Executors.newFixedThreadPool(4);
  }

  public ComputationCoordinatorImp() {
    this.executor = Executors.newFixedThreadPool(4);
  }

  public ComputeResult beginComputation(int inputType, String inputFileName, int numberOfMatrices,int rows, int columns, int outputType, String outputFileName) throws IOException {
    try {
      List<Callable<ComputeResult>> tasks = new ArrayList<>();

      tasks.add(() -> {
        ComputeRequest compute = new ComputeRequest(inputType,inputFileName,numberOfMatrices, rows, columns, outputType,outputFileName);
        DataStorageImp dataStorage = new DataStorageImp(compute);
        ComputeEngineImp computeEng = new ComputeEngineImp(dataStorage);
        return ComputeResult.SUCCESS;
      });

      List<Future<ComputeResult>> futures = executor.invokeAll(tasks);

      for (Future<ComputeResult> future : futures) {
        ComputeResult result = future.get();
      }

      return null;
    } catch (Exception e) {
      e.printStackTrace();
      throw new IOException("An error occurred during computation.", e);
    }
  }

  @Override
  public ComputeResult beginComputation(ComputeRequest request) {
    return null;
  }
}
