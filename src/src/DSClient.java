package src;

import java.util.concurrent.TimeUnit;

import dataprocessing.DataProcessing.ReadInputFileRequest;
import dataprocessing.DataProcessing.ReadInputFileResponse;
import dataprocessing.DataStorageServiceGrpc;
import dataprocessing.DataStorageServiceGrpc.DataStorageServiceBlockingStub;
import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;

public class DSClient { // Boilerplate TODO: change to <servicename>Client
    private final DataStorageServiceBlockingStub blockingStub; // Boilerplate TODO: update to appropriate blocking stub

    public DSClient(Channel channel) {
        blockingStub = DataStorageServiceGrpc.newBlockingStub(channel);  // Boilerplate TODO: update to appropriate blocking stub
    }

    // Method to read input file and handle the response
    public void readInputFileExample() {
        // Create a request to read the input file
        ReadInputFileRequest request = ReadInputFileRequest.newBuilder()
                .setInputFileName("input.txt") // Set the input file name as needed
                .build();
        
        ReadInputFileResponse response;
        try {
            // Call the gRPC method to read the input file
            response = blockingStub.readInputFile(request);
        } catch (StatusRuntimeException e) {
            // Handle gRPC errors
            e.printStackTrace();
            return;
        }
        
        // Check the success flag in the response
        if (response.getSuccess()) {
            // Success: Print matrices
            System.out.println("Read input file successfully.");
            response.getMatricesList().forEach(matrix -> {
                System.out.println("Matrix:");
                matrix.getRowsList().forEach(row -> {
                    System.out.println(row.getValuesList());
                });
            });
        } else {
            // Failure: Handle failure case
            System.err.println("Error reading input file. Success flag is false.");
        }
    }

    public static void main(String[] args) throws Exception {
        // Define the target server and port for gRPC communication
        String target = "localhost:50051";  // Make sure the server/port match the server/port you want to connect to

        // Create a channel to communicate with the gRPC server
        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
                .build();
        
        try {
            // Create the client and call the method to read the input file
            DSClient client = new DSClient(channel); // Boilerplate TODO: update to this class name
            client.readInputFileExample();
        } finally {
            // Shutdown the channel after use
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}
