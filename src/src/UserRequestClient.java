package src;

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

    ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
        .build();
    try {
      UserInputRequest.Builder request = UserInputRequest.newBuilder();
      UserRequestClient client = new UserRequestClient(channel);
      Scanner scanner = new Scanner(System.in);
      boolean valid = false;

      // Scanner 1: Input Type (User or File Input)
      while (!valid) {
        try {
          System.out.println("Input 0 for User input, or 1 for File Input:");
          int inputType = scanner.nextInt();
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
            String inputFileName = scanner.nextLine();
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
          int numberOfMatrices = scanner.nextInt();
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
          int rows = scanner.nextInt();
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
          int columns = scanner.nextInt();
          request.setColumns(columns);
          if (columns < 1) {
            throw new InputMismatchException("Number of columns must be positive.");
          }
          request.setColumns(columns);
          valid = true;
        } catch (InputMismatchException e) {
          System.out.println("Invalid Input: " + e.getMessage());
          scanner.nextLine();
        }
      }
      
      //  Set Delimiter
      valid = false;
      while (!valid) { 
        try {
          System.out.println("Enter the delimiter you want");
          String delimiter = scanner.next();
          request.setDelimiter(delimiter);
          if (delimiter.length() > 1 || delimiter.matches("[^a-zA-Z0-9]")) {
            throw new InputMismatchException("Cannot be alphanumeric, must only be one character");
          }
          request.setDelimiter(delimiter);
          valid = true;
        } catch (InputMismatchException e) {
          System.out.println("Invalid Input: " + e.getMessage());
          scanner.nextLine();
        }
      }


      // Scanner 6: Multiply the Matrices (Yes or No)
      valid = false;
      while (!valid) {
        try {
          System.out.println("Do you want to multiply the matrices? If yes, type 1; if no, type 0:");
          int multiply = scanner.nextInt();
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
          int outputType = scanner.nextInt();
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
            String outputFileName = scanner.nextLine();
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
          int outputOrCompute = scanner.nextInt();
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
    } finally {
      channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
    }
  }
}
