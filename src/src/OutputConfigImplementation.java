package src;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OutputConfigImplementation implements OutputConfig {

  private int outputType; // 0 = Output to User Console, 1 = Output to File
  private String outputFileName;
  private boolean valid = false;

  public OutputConfigImplementation(int outputFileType, String outputFileName) {
    this.outputType = outputFileType;
    this.outputFileName = outputFileName;
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
    if (this.outputType == 0) {
      return "Outputs Matrices to User";
    } else {
      return "Outputs Matrices to txt File";
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
    boolean valid = false; // Flag to track valid input

    while (!valid) {
      try {
        // Ask user for output type
        System.out.println("Input 0 for Console Output, or 1 for File Output");
        this.outputType = scanner.nextInt();

        // Consume the leftover newline after nextInt()
        scanner.nextLine();

        // Validate output type
        if (this.outputType != 0 && this.outputType != 1) {
          throw new InputMismatchException("Output type must be 0 or 1.");
        }

        valid = true; // Set valid to true for valid input

        if (this.outputType == 1) {
          // File output mode
          System.out.println("Enter the output file name (must end with .txt): ");
          this.outputFileName = scanner.nextLine(); // Read file name

          // Check if the file name ends with .txt
          if (!this.outputFileName.endsWith(".txt")) {
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
