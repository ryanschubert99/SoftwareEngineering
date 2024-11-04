package src;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import userinput.UserInput;
import io.grpc.StatusRuntimeException;
import userinput.UserInput.ComputationResponse;
import userinput.UserInput.UserInputRequest;
<<<<<<< Updated upstream
import userinputgrpc.UserInputServiceGrpc;
import userinputgrpc.UserInputServiceGrpc.UserInputServiceBlockingStub;

//
import userinput.UserInputServiceGrpc;
import userinput.UserInputServiceGrpc.UserInputServiceBlockingStub;

>>>>>>> Stashed changes


/**
 * The UserRequestClient class handles sending requests to the user input service
 * and processing responses from the server.
 */
public class UserRequestClient {

  /**
   * Blocking stub for making remote procedure calls.
   */
  private final UserInputServiceBlockingStub blockingStub;

  /**
   * Constructor to initialize the blocking stub using the given channel.
   *
   * @param channel the gRPC channel to connect to the service
   */
  public UserRequestClient(Channel channel) {
    this.blockingStub = UserInputServiceGrpc.newBlockingStub(channel);
  }

  /**
   * Sends a user input request and handles the response.
   */
  public void sendUserInputRequest() {
    UserInputRequest request = UserInputRequest.newBuilder()
        .setInputType(0)
        .setInputFileName("input.txt")
        .setNumberOfMatrices(0)
        .setRows(0)
        .setColumns(0)
        .setOutputType(0)
        .setOutputFileName("output.txt")
        .setOutputOrCompute(0)
        .build();

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
      System.out.println("Matrix: " + response.getResult());
    }
  }

  /**
   * The main method to run the client.
   *
   * @param args the command line arguments
   * @throws Exception if an error occurs during the client operation
   */
  public static void main(String[] args) throws Exception {
    String target = "localhost:50051"; // Ensure this matches the server/port

    ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
        .build();
    try {
      UserRequestClient client = new UserRequestClient(channel);
      client.sendUserInputRequest();
      int inputType = 0; // 0 is User Input, and 1 is File Input
      String inputFileName = null;
      int numberOfMatrices = 0;
      int rows = 0;
      int multiply = 0;
      int columns = 0;
      boolean valid = false;
      int outputType = 0; // 0 = Output to User Console, 1 = Output to File
      String outputFileName = null;
      int outputOrCompute = 0;
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
            } else {

              valid = true; // If file name is valid
            }
          } catch (InputMismatchException e) {
            System.out.println("Invalid Input: " + e.getMessage());
          } catch (Exception e) {
            System.out.println("Invalid Input.");
          }
        }

        // Number of Rows
        scanner.nextLine();
        valid = false;
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

        // Number of Columns
        valid = false;
        scanner.nextLine();
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

        valid = false;
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
      } else {
        // User Input Mode
        // Number of Matrices
        valid = false;
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

        // Number of Rows
        valid = false;
        scanner.nextLine();
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


        valid = false;
        scanner.nextLine();
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

    
        valid = false;
        scanner.nextLine();
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

      valid = false;
      // Output Type (Console or File Output)
      while (!valid) {
        try {
          System.out.println("Input 0 for Console Output, or 1 for File Output");
          outputType = scanner.nextInt();

          // Validate output type
          if (outputType != 0 && outputType != 1) {
            throw new InputMismatchException("Output type must be 0 or 1.");
          }

          valid = true;
          scanner.nextLine(); // Clear the buffer

          if (outputType == 1) {
            // File output mode
            System.out.println("Enter the output file name (must end with .txt): ");
            outputFileName = scanner.nextLine();

            // Check if the file name ends with .txt
            if (!outputFileName.endsWith(".txt")) {
              throw new InputMismatchException("File name must end with .txt");
            }
          }
        } catch (InputMismatchException e) {
          System.out.println("Invalid Input: " + e.getMessage());
          scanner.next(); // Clear invalid input
          valid = false;
        } catch (Exception e) {
          System.out.println("Invalid Input.");
          scanner.next(); // Clear invalid input
          valid = false;
        }
      }

      // Output or Compute
      valid = false;
      while (!valid) {
        try {
          System.out.println("Type 1 to Output Matrices or Type 0 to do Computations");
          outputOrCompute = scanner.nextInt();
          if (outputOrCompute != 0 && outputOrCompute != 1) {
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
    finally {
    channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
    }
  }
}
