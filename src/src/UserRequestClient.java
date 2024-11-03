package src;
import java.util.concurrent.TimeUnit;

import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import userinput.UserInput.UserInputRequest;
import userinput.UserInput.ComputationResponse;
import userinput.UserInputServiceGrpc;
import userinput.UserInputServiceGrpc.UserInputServiceBlockingStub;

public class UserRequestClient { // Boilerplate TODO: change to <servicename>Client
    private final UserInputServiceBlockingStub blockingStub; // Boilerplate TODO: update to appropriate blocking stub

    public UserRequestClient(Channel channel) {
        blockingStub = UserInputServiceGrpc.newBlockingStub(channel);  // Boilerplate TODO: update to appropriate blocking stub
    }

    // Boilerplate TODO: replace this method with actual client call/response logic
    public void order() {        
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
            System.out.println("Order number: " + response.getMatrix());
        }
    }

    public static void main(String[] args) throws Exception {
        String target = "localhost:50051";  // Boilerplate TODO: make sure the server/port match the server/port you want to connect to

        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
                .build();
        try {
            UserRequestClient client = new UserRequestClient(channel); // Boilerplate TODO: update to this class name
            client.order();
        } finally {
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}
