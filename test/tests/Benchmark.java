package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.google.common.base.Stopwatch;

import src.ComputationCoordinatorImp;

public class Benchmark{

  private static int NUM_RUNS = 1;

  @Test
  public void testIntegration() throws IOException{

    ComputationCoordinatorImp slow = new ComputationCoordinatorImp();
    ComputationCoordinatorImp faster = new ComputationCoordinatorImp();

    long timeStart = System.currentTimeMillis();
    for (int i = 0; i < NUM_RUNS; i++){
      slow.beginComputationSingleSlow(0, "matrixout.txt", 9999, 10, 10, 1, "matrixprintmultiply9.txt", 0);
    }
    long timeEnd = System.currentTimeMillis();

    long averageElapsedTimeOriginal = (timeEnd - timeStart) / NUM_RUNS;
    System.out.println("Original: " + averageElapsedTimeOriginal);

    Stopwatch timer = Stopwatch.createStarted();
    for (int i = 0; i < NUM_RUNS; i++){
      faster.beginComputationSingleFast(0, "matrixout.txt", 9999, 10, 10, 1, "matrixprintmultiply9.txt", 0);
    }
    timer.stop();

    long averageElapsedTimeNew = timer.elapsed(TimeUnit.MILLISECONDS) / NUM_RUNS;

    System.out.println("New: " + averageElapsedTimeNew);

    double tenPercentDelta = averageElapsedTimeOriginal * .1;

    if (Math.abs(averageElapsedTimeNew - averageElapsedTimeOriginal) < tenPercentDelta){
      Assert.fail();
    }
  }
}
