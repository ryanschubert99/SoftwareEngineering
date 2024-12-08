package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import src.ComputeResult;
import src.ComputeResult.ComputeResultStatus;

public class DataStorageImp implements DataStorage {

  private ComputeRequest computeE;
  private String inputFileName;
  private String outputFileName;
  private int amountToGenerate;
  private List<long[][]> matrices;
  private boolean valid = false;
  private int input;
  private int outputOrCompute;
  private String delimiter;

  public DataStorageImp(ComputeRequest compute, int outputOrComp) throws IOException {
    this.computeE = compute;
    this.outputOrCompute = outputOrComp;
    this.inputFileName = computeE.getInputConfig().getInputFileName();
    this.outputFileName = computeE.getOutputConfig().getOutputFileName();
    this.delimiter = computeE.getInputConfig().getDelimiter();

    if (compute.getInputConfig().getInputTypeValue() == 0) {
      this.amountToGenerate = compute.getInputConfig().getNumberOfMatrices();
      ComputeEngineImp computeEng = new ComputeEngineImp(this);

      if (outputOrCompute == 1) {
        writeOutput(this.outputFileName, delimiter);
      } else {
        this.matrices = computeEng.multiplyMatrixSlow(matrices);
        writeOutput(this.outputFileName, delimiter);
      }
    } else {
      this.matrices = readInputFile();

      if (outputOrCompute == 1) {
        writeOutput(this.outputFileName, delimiter);
      } else {
        ComputeEngineImp computeEng = new ComputeEngineImp(this);
        this.matrices = computeEng.multiplyMatrixFast(matrices);
        writeOutput(this.outputFileName, delimiter);
      }
    }

    // Signal that computation succeeded
    signalComputationSuccess();
  }

  public DataStorageImp(ComputeRequest compute, int outputOrComp, int benchmark) throws IOException {
    this.computeE = compute;
    this.outputOrCompute = outputOrComp;
    this.inputFileName = computeE.getInputConfig().getInputFileName();
    this.outputFileName = computeE.getOutputConfig().getOutputFileName();

    if (compute.getInputConfig().getInputTypeValue() == 0) {
      this.amountToGenerate = compute.getInputConfig().getNumberOfMatrices();
      ComputeEngineImp computeEng = new ComputeEngineImp(this);

      if (outputOrCompute == 1) {
        writeOutput(this.outputFileName, delimiter);
      } else {
        this.matrices = computeEng.multiplyMatrixFast(matrices);
        writeOutput(this.outputFileName, delimiter);
      }
    } else {
      this.matrices = readInputFile();

      if (outputOrCompute == 1) {
        writeOutput(this.outputFileName, delimiter);
      } else {
        ComputeEngineImp computeEng = new ComputeEngineImp(this);
        this.matrices = computeEng.multiplyMatrixFast(matrices);
        writeOutput(this.outputFileName, delimiter);
      }
    }

    // Signal that computation succeeded
    signalComputationSuccess();
  }

  private void signalComputationSuccess() {
    System.out.println("Computation completed successfully");
  }

  public List<long[][]> getMatrices() {
    return matrices;
  }

  public void setMatrices(List<long[][]> genMatrix) {
    this.matrices = genMatrix;
  }

  @Override
  public void writeOutput(String outputFileName, String delimiter) {
    int outputTypeValue = computeE.getOutputConfig().getOutputTypeValue();

    if ((outputTypeValue == 1) && (this.outputFileName == null)) {
      throw new IllegalArgumentException("Output file name cannot be null");
    }

    i
