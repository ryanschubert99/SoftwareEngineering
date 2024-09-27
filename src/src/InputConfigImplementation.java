package src;

import java.util.Scanner;

public class InputConfigImplementation implements InputConfig {

	
	private int inputType = 0; //0 is User Input, and 1 is File Input
	private String inputFileName;
	
	public InputConfigImplementation(){
	}
	
	@Override
	public void setInputType(int input) {
		this.inputType = input;
	}
	public void setUserInputType() {
		Scanner scanner = new Scanner(System.in);
	    //Ask User input and output type
	    System.out.println("Input 0 for User input, or 1 for File Input");
	    this.inputType = scanner.nextInt();
	    if(this.inputType == 1) {
	      System.out.println("Enter the input file Name: ");
	      scanner.nextLine();
	    }
	}

	@Override
	public String getInputType() {
		if(this.inputType == 0) {
			return "User Input Integers";
		} else {return "File Input";
	  }	
	}

}
