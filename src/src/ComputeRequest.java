package src;



public class ComputeRequest {
	
 

  private final InputConfigImplementation inputConfig;
  private final OutputConfigImplementation outputConfig;
 
  

	
//  public ComputeRequest(InputConfigImplementation inputConfig, OutputConfigImplementation  outputConfig) {
//	  this(inputConfig, outputConfig,delimiter); // default delimiter: ;
//  } }
	
  public ComputeRequest(InputConfigImplementation inputConfig, OutputConfigImplementation  outputConfig, String delimiter) {
    inputConfig.setUserInputType();
    outputConfig.setUserOutputType();
	
    this.inputConfig = inputConfig;
    this.outputConfig = outputConfig;
  }

  public ComputeRequest(int inputType, String inputFileName, int numberOfMatrices,int rows, int columns,String delimiter, int outputFileType, String outputFileName,int outputOrComp ) {
    InputConfigImplementation inputConfig = new InputConfigImplementation(inputType,inputFileName,numberOfMatrices, rows, columns,delimiter );
    OutputConfigImplementation  outputConfig = new OutputConfigImplementation(outputFileType,outputFileName,outputOrComp);
    //inputConfig.setUserInputType();
    //outputConfig.setUserOutputType();
		
    this.inputConfig = inputConfig;
    this.outputConfig = outputConfig;

  }
  
	
 

  public InputConfigImplementation getInputConfig() {
    return inputConfig;
  }

  public OutputConfigImplementation getOutputConfig() {
    return outputConfig;
  }

public Object getDelimiter() {
	// TODO Auto-generated method stub
	return null;
}





  
}
