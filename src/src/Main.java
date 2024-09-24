package src;

import java.io.PrintStream;

public class Main {
  public static void main(String[] args) {
	//Testing Implementation
    MatrixImplementation matrix = new MatrixImplementation();
    matrix.printMatrix(matrix.generateMatrix(5000, 5000), 5000, 5000);
  }

}
