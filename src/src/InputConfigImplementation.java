package src;

import java.util.Scanner;

public class InputConfigImplementation implements InputConfig {

	private int inputType = 0; //0 is User Input, and 1 is File Input
	private String inputFileName;
	private int numberOfMatrices;
	private int rows;
	
	public String getInputFileName() {
		return inputFileName;
	}

	public void setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
	}

	public int getNumberOfMatrices() {
		return numberOfMatrices;
	}

	public void setNumberOfMatrices(int numberOfMatrices) {
		this.numberOfMatrices = numberOfMatrices;
	}

	public int getRows() {
		return this.rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}
	

	
	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	private int columns;
	
	public InputConfigImplementation(){
	}
	
	@Override
	public void setInputType(int input) {
		this.inputType = input;
	}
	public void setUserInputType() {
	    Scanner scanner = new Scanner(System.in);
	    
	    // Ask user input and output type
	    System.out.println("Input 0 for User input, or 1 for File Input");
	    this.inputType = scanner.nextInt();
	    
	    // Consume the leftover newline after nextInt()
	    scanner.nextLine();
	    
	    if (this.inputType == 1) {
	        // File input mode
	        System.out.println("Enter the input file name: ");
	        this.inputFileName = scanner.nextLine();  // Read file name
	        
	        System.out.println("Enter Number of Rows in each Matrix: ");
	        this.rows = scanner.nextInt();
	        
	        System.out.println("Enter Number of Columns in each Matrix: ");
	        this.columns = scanner.nextInt();
	    } else {
	        // User input mode
	        System.out.println("Input the number of matrices you want to generate: ");
	        this.numberOfMatrices = scanner.nextInt();
	        
	        System.out.println("Enter Number of Rows: ");
	        this.rows = scanner.nextInt();
	        
	        System.out.println("Enter Number of Columns: ");
	        this.columns = scanner.nextInt();
	    }
	}

	@Override
	public String getInputType() {
		if(this.inputType == 0) {
			return "User Input Integers";
		} else {return "File Input";}
	}
		
	public int getInputTypeValue() {
		return this.inputType;
	  }	
	}


