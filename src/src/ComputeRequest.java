package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ComputeRequest {
	
 

  private final InputConfigImplementation inputConfig;
  private final OutputConfigImplementation outputConfig;
  
  private int inputType = 0; // 0 is User Input, and 1 is File Input
  private String inputFileName;
  private int numberOfMatrices;
  private int rows;
  private int columns;
  private String delimiter;
  private int multiply = 0;
  private int configType = 0;
  private String configFile;
  private int outputType; // 0 = Output to User Console, 1 = Output to File
  private String outputFileName;
  private boolean valid = false;
  private int outputOrCompute;

	
//  public ComputeRequest(InputConfigImplementation inputConfig, OutputConfigImplementation  outputConfig) {
//	  this(inputConfig, outputConfig,delimiter); // default delimiter: ;
//  } }
	
  public ComputeRequest(InputConfigImplementation inputConfig, OutputConfigImplementation  outputConfig, String delimiter) {
	  InputConfigImplementation inputConfig1 = new InputConfigImplementation(inputConfig.getInputTypeValue(),inputConfig.getInputFileName(),inputConfig.getNumberOfMatrices(), inputConfig.getRows(), inputConfig.getColumns(),delimiter );
      OutputConfigImplementation  outputConfig1 = new OutputConfigImplementation(outputConfig.getOutputTypeValue(),outputConfig.getOutputFileName(),outputConfig.getOutputOrCompute());
	this.delimiter = delimiter;
    this.inputConfig = inputConfig1;
    this.outputConfig = outputConfig1;
  }

  public ComputeRequest(int configType,String configFile,int inputType, String inputFileName, int numberOfMatrices,int rows, int columns,String delimiter, int outputFileType, String outputFileName,int outputOrComp ) throws IOException {
	  if(configType == 1) {
		  String configPath = "src" + File.separatorChar + "src" + File.separatorChar + configFile; // Updated path
		//They want to use an config file
		  try (BufferedReader br = new BufferedReader(new FileReader(configPath))) {
		      br.readLine(); // Skip header row if there is one
		      String line;
		      if ((line = br.readLine()) != null) {
		        String[] config = line.split(",");

		        // Parse values from CSV line
		        this.inputType = Integer.parseInt(config[0].trim());
		        this.inputFileName = config[1].trim();
		        this.numberOfMatrices = Integer.parseInt(config[2].trim());
		        this.rows = Integer.parseInt(config[3].trim());
		        this.columns = Integer.parseInt(config[4].trim());
		        this.outputType = Integer.parseInt(config[5].trim());
		        this.outputFileName = config[6].trim();
		        this.outputOrCompute = Integer.parseInt(config[7].trim());
		        this.delimiter = config[8].trim();

		        // Print parsed values to console for verification
		        System.out.println("Parsed Configuration Values:");
		        System.out.println("Input Type: " + this.inputType);
		        System.out.println("Output File: " + this.inputFileName);
		        System.out.println("Number to Generate: " + this.numberOfMatrices);
		        System.out.println("Number of Rows: " + this.rows);
		        System.out.println("Number of Columns: " + this.columns);
		        System.out.println("Number of Columns: " + this.delimiter);
		        System.out.println("Output Type: " + this.outputType);
		        System.out.println("Output File Name: " + this.outputFileName);
		        System.out.println("Out or Compute: " + this.outputOrCompute); 
		      }
		      InputConfigImplementation inputConfig = new InputConfigImplementation(this.inputType,this.inputFileName,this.numberOfMatrices, this.rows, this.columns,this.delimiter );
		      OutputConfigImplementation  outputConfig = new OutputConfigImplementation(this.outputType,this.outputFileName,this.outputOrCompute);
		      this.inputConfig = inputConfig;
		      this.outputConfig = outputConfig;
		  }
	  } else {
    InputConfigImplementation inputConfig = new InputConfigImplementation(inputType,inputFileName,numberOfMatrices, rows, columns,delimiter );
    OutputConfigImplementation  outputConfig = new OutputConfigImplementation(outputFileType,outputFileName,outputOrComp);

		
    this.inputConfig = inputConfig;
    this.outputConfig = outputConfig;
	  }
  }
  
  public int getConfigType() {
	    return configType;
	  }
  public String getConfigFile() {
	    return configFile;
	  }

  public InputConfigImplementation getInputConfig() {
    return inputConfig;
  }

  public OutputConfigImplementation getOutputConfig() {
    return outputConfig;
  }

  public String getDelimiter() {
	
    return this.delimiter;
  }





  
}
