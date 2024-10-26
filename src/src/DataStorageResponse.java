package src;

import java.util.ArrayList;
import java.util.List;

public interface DataStorageResponse {
  static DataStorageResponse SUCCESS = new DataStorageResponse() {
    @Override
    public ResponseStatus getStatus() {
      return ResponseStatus.SUCCESS;
    }

    @Override
    public String getFailureMessage() {
      return "";
    }

    @Override
    public List<int[][]> getMatrix() {
      return new ArrayList<>();
    }
  };

  // List[2D array list] 
  ResponseStatus getStatus();
  String getFailureMessage();
  List<int[][]> getMatrix();

  public static enum ResponseStatus {
    SUCCESS(true),
    INVALID_REQUEST(false),
    FAILURE(false);

    private final boolean success;

    private ResponseStatus(boolean success) {
      this.success = success;
    }

    public boolean isSuccess() {
      return success;
    }
  }
}
