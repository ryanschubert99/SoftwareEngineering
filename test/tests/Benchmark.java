package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.google.common.base.Stopwatch;

import src.ComputationCoordinatorImp;
import src.DataStorageImp;

public class Benchmark{

  private static int NUM_RUNS = 1;

  @Test
  public void testIntegration() throws IOException{

    ComputationCoordinatorImp slow = new ComputationCoordinatorImp();
    
    ComputationCoordinatorImp faster = new ComputationCoordinatorImp();

    Stopwatch timer = Stopwatch.createStarted();
    for (int i = 0; i < NUM_RUNS; i++){
      slow.beginComputationSingleSlow(0, "matrixout.txt", 99999, 10, 10, ";", 1, "matrixprintmultiply9.txt", 0);
      
    }
    timer.stop();

    double averageElapsedTimeOriginal = timer.elapsed(TimeUnit.MILLISECONDS) / NUM_RUNS;
    System.out.println("Original: " + averageElapsedTimeOriginal);

    
    Stopwatch timer1 = Stopwatch.createStarted();
    for (int i = 0; i < NUM_RUNS; i++){
      faster.beginComputationSingleFast(0, "matrixout.txt", 99999, 10, 10, ";", 1, "matrixprintmultiply9.txt", 0);
    }
    timer1.stop();

    double averageElapsedTimeNew = timer1.elapsed(TimeUnit.MILLISECONDS) / NUM_RUNS;
    System.out.println("New: " + averageElapsedTimeNew);
    double percentDiff = (((averageElapsedTimeOriginal/ averageElapsedTimeNew)*100) - 100);

    double tenPercentDelta = averageElapsedTimeOriginal * .1;
    System.out.println((int)(percentDiff) + "% Faster");
    if (Math.abs(averageElapsedTimeNew - averageElapsedTimeOriginal) < tenPercentDelta){
      Assert.fail();
    }
  }
}
