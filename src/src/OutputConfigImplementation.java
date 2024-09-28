package src;

import java.util.Scanner;

public class OutputConfigImplementation implements OutputConfig{

	
	private int outputType; //0 = Output to User Console, 1 = Output to File
	private String outputFileName;
	public OutputConfigImplementation(){
	}
	
	@Override
	public void setInputType(int input) {
		this.outputType = input;
	}

	@Override
	public String getInputType() {
		if(this.outputType == 0) {
			return "Outputs Matrices to User";
		} else {return "Outputs Matrices to txt File";
	  }	
	}

	public void setUserOutputType() {
		Scanner scanner = new Scanner(System.in);
	    //Ask User output type
	    System.out.println("Input 0 for Console Output, or 1 for File Ouput");
	    this.outputType = scanner.nextInt();
	    if(this.outputType == 1) {
		  System.out.println("Enter the output file Name: ");
		  scanner.nextLine();
		
	}
	
}
}
