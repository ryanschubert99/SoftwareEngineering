package src;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import io.grpc.protobuf.services.ProtoReflectionService;


public class UserRequestServer {
//
  private Server server;


  private void start() throws IOException {
    // The port on which the server should run
    int port = 50051; 

    server = Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create())
        .addService(new UserInputServiceImpl()) // Add the implementation service
        .addService(ProtoReflectionService.newInstance()) // Add reflection service
        .build()
        .start();

    System.out.println("Server started on port " + port);

    // Add shutdown hook to stop server when JVM shuts down
    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      System.err.println("*** shutting down gRPC server since JVM is shutting down");
      try {
        if (server != null) {
          server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
      } catch (InterruptedException e) {
        e.printStackTrace(System.err);
      }
      System.err.println("*** server shut down");
    }));
  }

  private void blockUntilShutdown() throws InterruptedException {
    if (server != null) {
      server.awaitTermination();
    }
  }

 
  public static void main(String[] args) throws Exception {
    UserRequestServer server = new UserRequestServer();
    server.start();
    server.blockUntilShutdown();
  }
}
