package src;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputConfigImplementation implements InputConfig {

  private int inputType = 0; // 0 is User Input, and 1 is File Input
  private String inputFileName;
  private int numberOfMatrices;
  private int rows;
  private int multiply;
  private int columns;
  private boolean valid = false;

  public InputConfigImplementation() {
  }

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

  @Override
  public void setInputType(int input) {
    this.inputType = input;
  }

  public void setUserInputType() {
    Scanner scanner = new Scanner(System.in);

    // Input Type (User or File Input)
    while (!this.valid) {
      try {
        System.out.println("Input 0 for User input, or 1 for File Input");
        this.inputType = scanner.nextInt();
        if (this.inputType != 0 && this.inputType != 1) {
          throw new InputMismatchException();
        }
        this.valid = true;
      } catch (InputMismatchException e) {
        System.out.println("Invalid Input: Please enter 0 or 1.");
        scanner.nextLine();
      } catch (Exception e) {
        System.out.println("Invalid Input.");
        scanner.nextLine();
      }
    }

    scanner.nextLine(); // Clear the buffer
    this.valid = false; // Reset flag for next input

    // Input mode: File input or user input
    if (this.inputType == 1) {
      // File Input Mode
      // Input File Name (Validate that it ends with .txt)
      while (!this.valid) {
        try {
          System.out.println("Enter the input file name (must end with .txt): ");
          this.inputFileName = scanner.nextLine(); // Read file name

          // Check if the file name ends with .txt
          if (!this.inputFileName.endsWith(".txt")) {
            throw new InputMismatchException("File name must end with .txt");
          }

          this.valid = true; // If file name is valid
        } catch (InputMismatchException e) {
          System.out.println("Invalid Input: " + e.getMessage());
        } catch (Exception e) {
          System.out.println("Invalid Input.");
        }
      }

      this.valid = false; // Reset flag for next input
      scanner.nextLine();

      // Number of Rows
      while (!this.valid) {
        try {
          System.out.println("Enter Number of Rows in each Matrix: ");
          this.rows = scanner.nextInt();
          this.valid = true;
        } catch (InputMismatchException e) {
          System.out.println("Invalid Input: Please enter a valid number.");
          scanner.nextLine();
        } catch (Exception e) {
          System.out.println("Invalid Input.");
          scanner.nextLine();
        }
      }

      this.valid = false; // Reset flag for next input
      scanner.nextLine();

      // Number of Columns
      while (!this.valid) {
        try {
          System.out.println("Enter Number of Columns in each Matrix: ");
          this.columns = scanner.nextInt();
          this.valid = true;
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
      while (!this.valid) {
        try {
          System.out.println("Input the number of matrices you want to generate: ");
          this.numberOfMatrices = scanner.nextInt();
          this.valid = true;
        } catch (InputMismatchException e) {
          System.out.println("Invalid Input: Please enter a valid number.");
          scanner.nextLine();
        } catch (Exception e) {
          System.out.println("Invalid Input.");
          scanner.nextLine();
        }
      }

      this.valid = false; // Reset flag for next input
      scanner.nextLine();

      // Number of Rows
      while (!this.valid) {
        try {
          System.out.println("Enter Number of Rows: ");
          this.rows = scanner.nextInt();
          if (this.rows < 1) {
            throw new InputMismatchException();
          }
          this.valid = true;
        } catch (InputMismatchException e) {
          System.out.println("Invalid Input: Please enter a valid Positive Integer.");
          scanner.nextLine();
        } catch (Exception e) {
          System.out.println("Invalid Input.");
          scanner.nextLine();
        }
      }

      this.valid = false; // Reset flag for next input
      scanner.nextLine();

      // Number of Columns
      while (!this.valid) {
        try {
          System.out.println("Enter Number of Columns: ");
          this.columns = scanner.nextInt();
          if (this.columns < 1) {
            throw new InputMismatchException();
          }
          this.valid = true;
        } catch (InputMismatchException e) {
          System.out.println("Invalid Input: Please enter a valid Positive Integer.");
          scanner.nextLine();
        } catch (Exception e) {
          System.out.println("Invalid Input.");
          scanner.nextLine();
        }
      }

      this.valid = false; // Reset flag for next input
      scanner.nextLine();

      // Multiply Matrices (Yes or No)
      while (!this.valid) {
        try {
          System.out.println("Do you want to Multiply the Matrices? If yes, type 1; if no, type 0");
          this.multiply = scanner.nextInt();
          if (this.multiply != 0 && this.multiply != 1) {
            throw new InputMismatchException();
          }
          this.valid = true;
        } catch (InputMismatchException e) {
          System.out.println("Invalid Input: Please enter 0 or 1.");
          scanner.nextLine();
        } catch (Exception e) {
          System.out.println("Invalid Input.");
          scanner.nextLine();
        }
      }
    }
  }

  // For testing purposes
  public void setUserInputType(int inputType, String fileName, int numberOfMatrices, int rows, int columns, int multiply) {
    this.inputType = inputType;

    // Input Type (User or File Input)
    while (!this.valid) {
      try {
        if (this.inputType != 0 && this.inputType != 1) {
          throw new InputMismatchException("Invalid Input: Please enter 0 for User input or 1 for File Input.");
        }
        this.valid = true;
      } catch (InputMismatchException e) {
        System.out.println(e.getMessage());
      } catch (Exception e) {
        System.out.println("Invalid Input.");
      }
    }

    this.valid = false; // Reset flag for next input

    // Input mode: File input or user input
    if (this.inputType == 1) {
      // File Input Mode

      // Input File Name (Validate that it ends with .txt)
      while (!this.valid) {
        try {
          if (fileName == null || !fileName.endsWith(".txt")) {
            throw new InputMismatchException("Invalid Input: File name must end with .txt");
          }
          this.inputFileName = fileName; // Read file name
          this.valid = true; // If file name is valid
        } catch (InputMismatchException e) {
          System.out.println(e.getMessage());
        } catch (Exception e) {
          System.out.println("Invalid Input.");
        }
      }

      this.valid = false; // Reset flag for next input

      // Number of Rows
      while (!this.valid) {
        try {
          if (rows <= 0) {
            throw new InputMismatchException("Invalid Input: Please enter a valid number of rows.");
          }
          this.rows = rows;
          this.valid = true;
        } catch (InputMismatchException e) {
          System.out.println(e.getMessage());
        } catch (Exception e) {
          System.out.println("Invalid Input.");
        }
      }

      this.valid = false; // Reset flag for next input

      // Number of Columns
      while (!this.valid) {
        try {
          if (columns <= 0) {
            throw new InputMismatchException("Invalid Input: Please enter a valid number of columns.");
          }
          this.columns = columns;
          this.valid = true;
        } catch (InputMismatchException e) {
          System.out.println(e.getMessage());
        } catch (Exception e) {
          System.out.println("Invalid Input.");
        }
      }

    } else {
      // User Input Mode

      // Number of Matrices
      while (!this.valid) {
        try {
          if (numberOfMatrices <= 0) {
            throw new InputMismatchException("Invalid Input: Please enter a valid number of matrices.");
          }
          this.numberOfMatrices = numberOfMatrices;
          this.valid = true;
        } catch (InputMismatchException e) {
          System.out.println(e.getMessage());
        } catch (Exception e) {
          System.out.println("Invalid Input.");
        }
      }

      this.valid = false; // Reset flag for next input

      // Number of Rows
      while (!this.valid) {
        try {
          if (rows <= 0) {
            throw new InputMismatchException("Invalid Input: Please enter a valid number of rows.");
          }
          this.rows = rows;
          this.valid = true;
        } catch (InputMismatchException e) {
          System.out.println(e.getMessage());
        } catch (Exception e) {
          System.out.println("Invalid Input.");
        }
      }

      this.valid = false; // Reset flag for next input

      // Number of Columns
      while (!this.valid) {
        try {
          if (columns <= 0) {
            throw new InputMismatchException("Invalid Input: Please enter a valid number of columns.");
          }
          this.columns = columns;
          this.valid = true;
        } catch (InputMismatchException e) {
          System.out.println(e.getMessage());
        } catch (Exception e) {
          System.out.println("Invalid Input.");
        }
      }

      this.valid = false; // Reset flag for next input

      // Multiply Matrices (Yes or No)
      while (!this.valid) {
        try {
          if (multiply != 0 && multiply != 1) {
            throw new InputMismatchException("Invalid Input: Please enter 0 or 1.");
          }
          this.multiply = multiply;
          this.valid = true;
        } catch (InputMismatchException e) {
          System.out.println(e.getMessage());
        } catch (Exception e) {
          System.out.println("Invalid Input.");
        }
      }
    }
  }

  @Override
  public String getInputType() {
    if (this.inputType == 0) {
      return "User Input Integers";
    } else {
      return "File Input";
    }
  }

  public int getInputTypeValue() {
    return this.inputType;
  }

  public int getMultiply() {
    return multiply;
  }

  public void setMultiply(int multiply) {
    this.multiply = multiply;
  }
}
