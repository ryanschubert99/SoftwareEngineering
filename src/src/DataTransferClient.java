package src;

import datatransfer.DataStorageServiceGrpc;
import datatransfer.DataTransfer.WriteOutputRequest;
import datatransfer.DataTransfer.WriteOutputResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class DataTransferClient {

  public static void main(String[] args) {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052)
        .usePlaintext()
        .build();

    DataStorageServiceGrpc.DataStorageServiceBlockingStub stub = DataStorageServiceGrpc.newBlockingStub(channel);

    WriteOutputRequest request = WriteOutputRequest.newBuilder()
        .setOutputFileName()
        .setDelimiter(",")
        .build();

    WriteOutputResponse response = stub.writeOutput(request);
    System.out.println("Response: " + response.getMessage());

    channel.shutdown();
  }
}
