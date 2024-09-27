package src;

public class ComputeRequest {
	
  private static final char DEFAULT_DELIMITER = ';';

  private final InputConfig inputConfig;
  private final OutputConfig outputConfig;
  private final char delimiter;
	
  public ComputeRequest(InputConfigImplementation inputConfig, OutputConfigImplementation  outputConfig) {
    this(inputConfig, outputConfig, DEFAULT_DELIMITER); // default delimiter: ;
  }
	
  public ComputeRequest(InputConfigImplementation inputConfig, OutputConfigImplementation  outputConfig, char delimiter) {
    inputConfig.setUserInputType();
	outputConfig.setUserOutputType();
	
	this.inputConfig = inputConfig;
    this.outputConfig = outputConfig;
    this.delimiter = delimiter;
  }
  public ComputeRequest() {
	InputConfigImplementation inputConfig = new InputConfigImplementation();
	OutputConfigImplementation  outputConfig = new OutputConfigImplementation();
    inputConfig.setUserInputType();
    outputConfig.setUserOutputType();
		
	this.inputConfig = inputConfig;
	this.outputConfig = outputConfig;
	this.delimiter = DEFAULT_DELIMITER;
  }
  
	
  public char getDelimiter() {
    return delimiter;
  }

  public InputConfig getInputConfig() {
    return inputConfig;
  }

  public OutputConfig getOutputConfig() {
    return outputConfig;
  }
  
}
