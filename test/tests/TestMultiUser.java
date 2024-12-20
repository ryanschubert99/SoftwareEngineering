package tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.ComputationCoordinatorImp;

public class TestMultiUser {
  private ComputationCoordinatorImp coordinator;

  @BeforeEach
  public void initializeComputeEngine() {
    this.coordinator = new ComputationCoordinatorImp();
  }

  @Test
  public void compareMultiAndSingleThreaded() throws Exception {
    int numThreads = 1;
    List<TestUser> testUsers = new ArrayList<>();
    for (int i = 0; i < numThreads; i++) {
      testUsers.add(new TestUser(coordinator));
    }

    // Output current working directory
    System.out.println("Current Working Directory: " + new File(".").getAbsolutePath());

    // Run single threaded
    String singleThreadFilePrefix = "testMultiUser.compareMultiAndSingleThreaded.test.singleThreadOut.tmp";
    for (int i = 0; i < numThreads; i++) {
      File singleThreadedOut = new File(singleThreadFilePrefix + i);
      // Run the test user
      singleThreadedOut.deleteOnExit();
      testUsers.get(i).run(singleThreadedOut.getCanonicalPath());

      // Check if the file exists
      if (singleThreadedOut.exists()) {
        System.out.println("Single-threaded temp file created: " + singleThreadedOut.getAbsolutePath());
      } else {
        System.out.println("Single-threaded temp file not found: " + singleThreadedOut.getAbsolutePath());
      }
    }

    // Run multi-threaded
    ExecutorService threadPool = Executors.newCachedThreadPool();
    List<Future<?>> results = new ArrayList<>();
    String multiThreadFilePrefix = "testMultiUser.compareMultiAndSingleThreaded.test.multiThreadOut.tmp";
    for (int i = 0; i < numThreads; i++) {
      File multiThreadedOut = new File(multiThreadFilePrefix + i);
      multiThreadedOut.deleteOnExit();
      String multiThreadOutputPath = multiThreadedOut.getCanonicalPath();
      TestUser testUser = testUsers.get(i);
      results.add(threadPool.submit(() -> {
        try {
          testUser.run(multiThreadOutputPath);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }));

      // Check if the file exists
      if (multiThreadedOut.exists()) {
        System.out.println("Multi-threaded temp file created: " + multiThreadedOut.getAbsolutePath());
      } else {
        System.out.println("Multi-threaded temp file not found: " + multiThreadedOut.getAbsolutePath());
      }
    }

    results.forEach(future -> {
      try {
        future.get();
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    });

    // Check that the output is the same for multi-threaded and single-threaded
    List<String> singleThreaded = loadAllOutput(singleThreadFilePrefix, numThreads);
    List<String> multiThreaded = loadAllOutput(multiThreadFilePrefix, numThreads);
    Assert.assertEquals(singleThreaded, multiThreaded);
  }

  private List<String> loadAllOutput(String prefix, int numThreads) throws IOException {
    List<String> result = new ArrayList<>();
    for (int i = 0; i < numThreads; i++) {
      File outputFile = new File(prefix + i);
      result.addAll(Files.readAllLines(outputFile.toPath()));
    }
    return result;
  }
}
