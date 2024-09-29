package src;

import java.util.Scanner;

public class OutputConfigImplementation implements OutputConfig{

	
	private int outputType; //0 = Output to User Console, 1 = Output to File
	private String outputFileName;
	public OutputConfigImplementation(){
	}
	
	@Override
	public void setOutputTypeValue(int input) {
		this.outputType = input;
	}

	public int getOutputTypeValue() {
		return this.outputType;
	}
	@Override
	public String getOutputType() {
		if(this.outputType == 0) {
			return "Outputs Matrices to User";
		} else {return "Outputs Matrices to txt File";
	  }	
	}

	public String getOutputFileName() {
		return outputFileName;
	}

	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}

	public void setUserOutputType() {
	    Scanner scanner = new Scanner(System.in);
	    
	    // Ask user for output type
	    System.out.println("Input 0 for Console Output, or 1 for File Output");
	    this.outputType = scanner.nextInt();
	    
	    // Consume the leftover newline after nextInt()
	    scanner.nextLine();
	    
	    if (this.outputType == 1) {
	        // File output mode
	        System.out.println("Enter the output file Name: ");
	        this.outputFileName = scanner.nextLine();  // Wait for user to input file name
	    }
	}

	@Override
	public void setInputType(int input) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getInputType() {
		// TODO Auto-generated method stub
		return null;
	}

	
}

