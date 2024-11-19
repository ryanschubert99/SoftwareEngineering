package src;

import java.io.IOException;
import java.util.List;

public interface DataStorage{
  
  public void writeOutput(String outputFileName, String delimiter);

  List<long[][]> readInputFile() throws IOException;


}
