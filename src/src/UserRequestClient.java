package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import userinput.UserInput.ComputationResponse;
import userinput.UserInput.UserInputRequest;
import userinput.UserInputServiceGrpc;
import userinput.UserInputServiceGrpc.UserInputServiceBlockingStub;

public class UserRequestClient {

  private final UserInputServiceBlockingStub blockingStub;

  public UserRequestClient(Channel channel) {
    this.blockingStub = UserInputServiceGrpc.newBlockingStub(channel);
  }

  public void sendUserInputRequest(UserInputRequest request) {
    ComputationResponse response;
    try {
      response = blockingStub.createUserInput(request);
    } catch (StatusRuntimeException e) {
      e.printStackTrace();
      return;
    }

    if (response.hasErrorMessage()) {
      System.err.println("Error: " + response.getErrorMessage());
    } else {
      System.out.println("Computation Result: " + response.getResult());
    }
  }

  public static void main(String[] args) throws Exception {
    String target = "localhost:50051";
    int configType = 0;
    String configFile = "";
    ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
        .build();
    try {
      UserInputRequest.Builder request = UserInputRequest.newBuilder();
      UserRequestClient client = new UserRequestClient(channel);
      Scanner scanner = new Scanner(System.in);
      boolean valid = false;
      while (!valid) {
          try {
            System.out.println("Input 0 to input User Config, or 1 for Config from a File");
            configType = scanner.nextInt();
            //request.setInputType(configType);
            if (configType != 0 && configType != 1) {
              throw new InputMismatchException();
            }
            //request.setInputType(configType);
            valid = true;
          } catch (InputMismatchException e) {
            System.out.println("Invalid Input: Please enter 0 or 1.");
            scanner.nextLine();
          }
        }
      valid = false;
      scanner.nextLine(); // Clear the buffer
      if (configType == 1) {
        while (!valid) {
          try {
            System.out.println("Enter the input file name (must end with .csv):");
            configFile = scanner.nextLine();
            //request.setInputFileName(configFile);
            if (!configFile.endsWith(".csv")) {
              throw new InputMismatchException("File name must end with .csv");
            }
            //request.setInputFileName(configFile);
            valid = true;
          } catch (InputMismatchException e) {
            System.out.println("Invalid Input: " + e.getMessage());
          }
        }
      }
    	  int inputType = 0; // 0 is User Input, and 1 is File Input
    	  String inputFileName;
    	  int numberOfMatrices;
    	  int rows;
    	  int columns;
    	  String delimiter;
    	  int multiply = 0;
    	  
    	  int outputType; // 0 = Output to User Console, 1 = Output to File
    	  String outputFileName;
    	  int outputOrCompute;
      
    	  if(configType == 1) {
    		  String configPath = "src" + File.separatorChar + "src" + File.separatorChar + configFile; // Updated path
    		//They want to use an config file
    		  try (BufferedReader br = new BufferedReader(new FileReader(configPath))) {
    		      br.readLine(); // Skip header row if there is one
    		      String line;
    		      if ((line = br.readLine()) != null) {
    		        String[] config = line.split(",");

    		        // Parse values from CSV line
    		        inputType = Integer.parseInt(config[0].trim());
    		        inputFileName = config[1].trim();
    		        numberOfMatrices = Integer.parseInt(config[2].trim());
    		        rows = Integer.parseInt(config[3].trim());
    		        columns = Integer.parseInt(config[4].trim());
    		        delimiter = config[5].trim();
    		        outputType = Integer.parseInt(config[6].trim());
    		        outputFileName = config[7].trim();
    		        outputOrCompute = Integer.parseInt(config[8].trim());
    		        
    		        request.setInputType(inputType);
    		        request.setInputFileName(inputFileName);
    		        request.setNumberOfMatrices(numberOfMatrices);
    		        request.setRows(rows);
    		        request.setColumns(columns);
    		        request.setDelimiter(delimiter);
    		        request.setOutputType(outputType);
    		        request.setOutputFileName(outputFileName);
    		        request.setOutputOrCompute(outputOrCompute);
    		        
    		        // Print parsed values to console for verification
    		        System.out.println("Parsed Configuration Values:");
    		        System.out.println("Input Type: " + inputType);
    		        System.out.println("Output File: " + inputFileName);
    		        System.out.println("Number to Generate: " + numberOfMatrices);
    		        System.out.println("Number of Rows: " + rows);
    		        System.out.println("Number of Columns: " + columns);
    		        System.out.println("Number of Columns: " + delimiter);
    		        System.out.println("Output Type: " + outputType);
    		        System.out.println("Output File Name: " + outputFileName);
    		        System.out.println("Out or Compute: " + outputOrCompute); 
    		     
    		        client.sendUserInputRequest(request.build());
    		      }}}
      else {
      // Scanner 1: Input Type (User or File Input)
      while (!valid) {
        try {
          System.out.println("Input 0 for User input, or 1 for File Input:");
          inputType = scanner.nextInt();
          request.setInputType(inputType);
          if (inputType != 0 && inputType != 1) {
            throw new InputMismatchException();
          }
          request.setInputType(inputType);
          valid = true;
        } catch (InputMismatchException e) {
          System.out.println("Invalid Input: Please enter 0 or 1.");
          scanner.nextLine();
        }
      }

      // Scanner 2: Input File Name (if applicable)
      valid = false;
      scanner.nextLine(); // Clear the buffer
      if (request.getInputType() == 1) {
        while (!valid) {
          try {
            System.out.println("Enter the input file name (must end with .txt):");
            inputFileName = scanner.nextLine();
            request.setInputFileName(inputFileName);
            if (!inputFileName.endsWith(".txt")) {
              throw new InputMismatchException("File name must end with .txt");
            }
            request.setInputFileName(inputFileName);
            valid = true;
          } catch (InputMismatchException e) {
            System.out.println("Invalid Input: " + e.getMessage());
          }
        }
      }

      // Scanner 3: Number of Matrices
      valid = false;
      while (!valid) {
        try {
          System.out.println("Enter the number of matrices you want to generate:");
          numberOfMatrices = scanner.nextInt();
          request.setNumberOfMatrices(numberOfMatrices);
          valid = true;
        } catch (InputMismatchException e) {
          System.out.println("Invalid Input: Please enter a valid number.");
          scanner.nextLine();
        }
      }

      // Scanner 4: Number of Rows
      valid = false;
      while (!valid) {
        try {
          System.out.println("Enter the number of rows in each matrix:");
          rows = scanner.nextInt();
          request.setRows(rows);
          if (rows < 1) {
            throw new InputMismatchException("Number of rows must be positive.");
          }
          request.setRows(rows);
          valid = true;
        } catch (InputMismatchException e) {
          System.out.println("Invalid Input: " + e.getMessage());
          scanner.nextLine();
        }
      }

      // Scanner 5: Number of Columns
      valid = false;
      while (!valid) {
        try {
          System.out.println("Enter the number of columns in each matrix:");
          columns = scanner.nextInt();
          request.setColumns(columns);
          if (columns < 1) {
            throw new InputMismatchException("Number of columns must be positive.");
          }
          request.setColumns(columns);
          valid = true;
        } catch (InputMismatchException e) {
          System.out.println("Invalid Input: " + e.getMessage());
          scanner.nextLine();
        } finally {
          scanner.nextLine(); // Clear the buffer after nextInt()
        }
     
      }
      
      //  Set Delimiter
      valid = false;
      while (!valid) { 
        try {
          System.out.println("Enter the delimiter you want. Press enter to use defult delimiter.");
          delimiter = scanner.nextLine();
          request.setDelimiter(delimiter);
          if(delimiter.toLowerCase().equals("default") || delimiter.isEmpty() || delimiter.equals(" ")) {
            delimiter=";";
          } else if (!delimiter.matches("[^a-zA-Z0-9]")  && (delimiter.length()>1)) {
            throw new InputMismatchException("Delimiter must be a single non-alphanumeric character.");
          }
          request.setDelimiter(delimiter);
          valid = true;
        } catch (InputMismatchException e) {
          System.out.println("Invalid Input:" + e.getMessage());
          scanner.nextLine();
        }
      }


      // Scanner 6: Multiply the Matrices (Yes or No)
      valid = false;
      while (!valid) {
        try {
          System.out.println("Do you want to multiply the matrices? If yes, type 1; if no, type 0:");
          multiply = scanner.nextInt();
          if (multiply != 0 && multiply != 1) {
            throw new InputMismatchException();
          }
          request.setOutputOrCompute(multiply);
          valid = true;
        } catch (InputMismatchException e) {
          System.out.println("Invalid Input: Please enter 0 or 1.");
          scanner.nextLine();
        }
      }

      // Scanner 7: Output Type (Console or File Output)
      valid = false;
      while (!valid) {
        try {
          System.out.println("Input 0 for Console Output, or 1 for File Output:");
          outputType = scanner.nextInt();
          request.setOutputType(outputType);
          if (outputType != 0 && outputType != 1) {
            throw new InputMismatchException("Output type must be 0 or 1.");
          }
          request.setOutputType(outputType);
          valid = true;
          scanner.nextLine(); // Clear the buffer

          if (outputType == 1) {
            // File output mode: Output File Name
            System.out.println("Enter the output file name (must end with .txt):");
            outputFileName = scanner.nextLine();
            request.setOutputFileName(outputFileName);
            if (!outputFileName.endsWith(".txt")) {
              throw new InputMismatchException("File name must end with .txt");
            }
            request.setOutputFileName(outputFileName);
          }
        } catch (InputMismatchException e) {
          System.out.println("Invalid Input: " + e.getMessage());
          scanner.next(); // Clear invalid input
          valid = false;
        }
      }

      // Scanner 8: Output or Compute
      valid = false;
      while (!valid) {
        try {
          System.out.println("Type 1 to Output Matrices or Type 0 to do Computations:");
          outputOrCompute = scanner.nextInt();
          request.setOutputOrCompute(outputOrCompute);
          if (outputOrCompute != 0 && outputOrCompute != 1) {
            throw new InputMismatchException();
          }
          request.setOutputOrCompute(outputOrCompute);
          valid = true;
        } catch (InputMismatchException e) {
          System.out.println("Invalid Input: Please enter 0 or 1.");
          scanner.nextLine();
        }
      }
      scanner.close();

      // Send the request
      client.sendUserInputRequest(request.build());
    }} finally {
      channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
    }
  }
}
