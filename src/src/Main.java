package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException {
//    int i = 2;
//    while (i == 2) {
    	
      setUserInputAndOutputType();
    
      
//      compC.beginComputation(inputType,inputFileName,numberOfMatrices, rows, columns, valid);
    
  }
  public static void setUserInputAndOutputType(int inputType, String inputFileName, int numberOfMatrices,int rows, int columns, int outputType, String outputFileName) throws IOException{
  
  }
  public static void setUserInputAndOutputType() throws IOException {
	  int inputType = 0; // 0 is User Input, and 1 is File Input
	  String inputFileName = null;
	  int numberOfMatrices = 0;
	  int rows = 0;
	  int multiply = 0;
	  int columns = 0;
	  boolean valid = false;
	  int outputType = 0; // 0 = Output to User Console, 1 = Output to File
	  String outputFileName = null;
	  
	    Scanner scanner = new Scanner(System.in);

	    // Input Type (User or File Input)
	    while (!valid) {
	      try {
	        System.out.println("Input 0 for User input, or 1 for File Input");
	        inputType = scanner.nextInt();
	        if (inputType != 0 && inputType != 1) {
	          throw new InputMismatchException();
	        }
	        valid = true;
	      } catch (InputMismatchException e) {
	        System.out.println("Invalid Input: Please enter 0 or 1.");
	        scanner.nextLine();
	      } catch (Exception e) {
	        System.out.println("Invalid Input.");
	        scanner.nextLine();
	      }
	    }

	    scanner.nextLine(); // Clear the buffer
	    valid = false; // Reset flag for next input

	    // Input mode: File input or user input
	    if (inputType == 1) {
	      // File Input Mode
	      // Input File Name (Validate that it ends with .txt)
	      while (!valid) {
	        try {
	          System.out.println("Enter the input file name (must end with .txt): ");
	          inputFileName = scanner.nextLine(); // Read file name

	          // Check if the file name ends with .txt
	          if (!inputFileName.endsWith(".txt")) {
	            throw new InputMismatchException("File name must end with .txt");
	          }

	          valid = true; // If file name is valid
	        } catch (InputMismatchException e) {
	          System.out.println("Invalid Input: " + e.getMessage());
	        } catch (Exception e) {
	          System.out.println("Invalid Input.");
	        }
	      }

	      valid = false; // Reset flag for next input
	      scanner.nextLine();

	      // Number of Rows
	      while (!valid) {
	        try {
	          System.out.println("Enter Number of Rows in each Matrix: ");
	          rows = scanner.nextInt();
	          valid = true;
	        } catch (InputMismatchException e) {
	          System.out.println("Invalid Input: Please enter a valid number.");
	          scanner.nextLine();
	        } catch (Exception e) {
	          System.out.println("Invalid Input.");
	          scanner.nextLine();
	        }
	      }

	      valid = false; // Reset flag for next input
	      scanner.nextLine();

	      // Number of Columns
	      while (!valid) {
	        try {
	          System.out.println("Enter Number of Columns in each Matrix: ");
	          columns = scanner.nextInt();
	          valid = true;
	        } catch (InputMismatchException e) {
	          System.out.println("Invalid Input: Please enter a valid number.");
	          scanner.nextLine();
	        } catch (Exception e) {
	          System.out.println("Invalid Input.");
	          scanner.nextLine();
	        }
	      }

	    } else {
	      // User Input Mode

	      // Number of Matrices
	      while (!valid) {
	        try {
	          System.out.println("Input the number of matrices you want to generate: ");
	          numberOfMatrices = scanner.nextInt();
	          valid = true;
	        } catch (InputMismatchException e) {
	          System.out.println("Invalid Input: Please enter a valid number.");
	          scanner.nextLine();
	        } catch (Exception e) {
	          System.out.println("Invalid Input.");
	          scanner.nextLine();
	        }
	      }

	      valid = false; // Reset flag for next input
	      scanner.nextLine();

	      // Number of Rows
	      while (!valid) {
	        try {
	          System.out.println("Enter Number of Rows: ");
	          rows = scanner.nextInt();
	          if (rows < 1) {
	            throw new InputMismatchException();
	          }
	          valid = true;
	        } catch (InputMismatchException e) {
	          System.out.println("Invalid Input: Please enter a valid Positive Integer.");
	          scanner.nextLine();
	        } catch (Exception e) {
	          System.out.println("Invalid Input.");
	          scanner.nextLine();
	        }
	      }

	      valid = false; // Reset flag for next input
	      scanner.nextLine();

	      // Number of Columns
	      while (!valid) {
	        try {
	          System.out.println("Enter Number of Columns: ");
	          columns = scanner.nextInt();
	          if (columns < 1) {
	            throw new InputMismatchException();
	          }
	          valid = true;
	        } catch (InputMismatchException e) {
	          System.out.println("Invalid Input: Please enter a valid Positive Integer.");
	          scanner.nextLine();
	        } catch (Exception e) {
	          System.out.println("Invalid Input.");
	          scanner.nextLine();
	        }
	      }

	      valid = false; // Reset flag for next input
	      scanner.nextLine();

	      // Multiply Matrices (Yes or No)
	      while (!valid) {
	        try {
	          System.out.println("Do you want to Multiply the Matrices? If yes, type 1; if no, type 0");
	          multiply = scanner.nextInt();
	          if (multiply != 0 && multiply != 1) {
	            throw new InputMismatchException();
	          }
	          valid = true;
	        } catch (InputMismatchException e) {
	          System.out.println("Invalid Input: Please enter 0 or 1.");
	          scanner.nextLine();
	        } catch (Exception e) {
	          System.out.println("Invalid Input.");
	          scanner.nextLine();
	        }
	      }
	      
	    }
	    
	 
	  

	    

	    while (!valid) {
	      try {
	        // Ask user for output type
	        System.out.println("Input 0 for Console Output, or 1 for File Output");
	        outputType = scanner.nextInt();

	        // Consume the leftover newline after nextInt()
	        scanner.nextLine();

	        // Validate output type
	        if (outputType != 0 && outputType != 1) {
	          throw new InputMismatchException("Output type must be 0 or 1.");
	        }

	        valid = true; // Set valid to true for valid input

	        if (outputType == 1) {
	          // File output mode
	          System.out.println("Enter the output file name (must end with .txt): ");
	          outputFileName = scanner.nextLine(); // Read file name

	          // Check if the file name ends with .txt
	          if (!outputFileName.endsWith(".txt")) {
	            throw new InputMismatchException("File name must end with .txt");
	          }
	        }

	      } catch (InputMismatchException e) {
	        System.out.println("Invalid Input: " + e.getMessage());
	        scanner.next(); // Clear invalid input
	        valid = false; // Reset valid to false to continue prompting
	      } catch (Exception e) {
	        System.out.println("Invalid Input.");
	        scanner.next(); // Clear invalid input
	        valid = false; // Reset valid to false to continue prompting

	      }
	    }
	    ComputationCoordinatorImp compC = new ComputationCoordinatorImp();
	    compC.beginComputation(inputType,inputFileName,numberOfMatrices, rows, columns, outputType,outputFileName);
	    
	  }
}
