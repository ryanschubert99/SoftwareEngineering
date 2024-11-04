package src;

import java.util.concurrent.TimeUnit;

import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import userinput.UserInput.ComputationResponse;
import userinput.UserInput.UserInputRequest;
import userinputgrpc.UserInputServiceGrpc;
import userinputgrpc.UserInputServiceGrpc.UserInputServiceBlockingStub;
//


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
      System.out.println("Matrix: " + response.getMatrix());
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
    } finally {
      channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
    }
  }
}
