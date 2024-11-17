package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.ComputeEngineImp;
import src.ComputeEngineImpFaster;
import src.ComputeRequest;
import src.DataStorageImp;
import src.DataStorageImpFaster;

public class BenchmarkCE {

    private int iterations;
    private int matrixSize;
    private List<long[][]> matrices;
    private DataStorageImp dataStore;
    private DataStorageImpFaster dataStoreFaster;

    @BeforeEach
    public void setUp() throws Exception {
        iterations = 100;  // Number of iterations for benchmarking
        matrixSize = 500;  // Adjust matrix dimensions if needed
        matrices = new ArrayList<>();

        // Generate matrices for benchmarking
        for (int i = 0; i < 2; i++) {  // Assuming we want two matrices to multiply
            matrices.add(generateMatrix(matrixSize, matrixSize));
        }

        // Create a mock ComputeRequest for DataStorageImp
        ComputeRequest computeRequest = new ComputeRequest(0, "input.txt", 2, matrixSize, matrixSize, 0, "output.txt", 0);
        dataStore = new DataStorageImp(computeRequest, 0);  // Mock DataStorageImp
        dataStoreFaster = new DataStorageImpFaster(computeRequest, 0); 
    }

    @Test
    public void testComputeEnginePerformance() {
        try {
            // Benchmark the slower version of the compute engine
            ComputeEngineImp slowComputeEngine = new ComputeEngineImp(dataStore);  // Use DataStorageImp instance
            long slowStartTime = System.nanoTime();
            for (int i = 0; i < iterations; i++) {
                slowComputeEngine.multiplyMatrix(matrices);
            }
            long slowEndTime = System.nanoTime();
            long slowDuration = TimeUnit.NANOSECONDS.toMillis(slowEndTime - slowStartTime);

            // Benchmark the faster version of the compute engine
            ComputeEngineImpFaster fastComputeEngine = new ComputeEngineImpFaster(dataStoreFaster);  // Use DataStorageImp instance
            long fastStartTime = System.nanoTime();
            for (int i = 0; i < iterations; i++) {
                fastComputeEngine.multiplyMatrix(matrices);
            }
            long fastEndTime = System.nanoTime();
            long fastDuration = TimeUnit.NANOSECONDS.toMillis(fastEndTime - fastStartTime);

            // Output the benchmark results
            System.out.println("Benchmark Results:");
            System.out.println("----------------------------------------------------");
            System.out.println("Slower Compute Engine: " + slowDuration + " ms (Total for " + iterations + " iterations)");
            System.out.println("Faster Compute Engine: " + fastDuration + " ms (Total for " + iterations + " iterations)");

            // Compare and print the difference
            long diff = slowDuration - fastDuration;
            double percentDifference = ((double) diff / slowDuration) * 100;

            System.out.println("The faster version is faster by: " + diff + " ms (" + percentDifference + "%)");

            // Check if the faster version is at least 10% faster than the original version
            assertTrue(percentDifference >= 10, "The faster version is not at least 10% faster.");

        } catch (Exception e) {
            System.err.println("Error during benchmark: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Helper method to generate a matrix with random values
    private static long[][] generateMatrix(int rows, int columns) {
        long[][] matrix = new long[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = (long) (Math.random() * 100);  // Random value between 0 and 99
            }
        }
        return matrix;
    }
}
