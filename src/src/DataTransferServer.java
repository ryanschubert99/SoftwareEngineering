package src;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;

public class DataTransferServer {
  private Server server;

    private void start() throws IOException {
        int port = 50052;
        server = ServerBuilder.forPort(port)
                .addService(new DataStorageServiceImpl())
                .addService(new ComputationCoordinatorServiceImpl())
                .addService(ProtoReflectionService.newInstance()) 
                .build()
                .start();
        System.out.println("Server started on port " + port);


    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      System.err.println("*** shutting down gRPC server since JVM is shutting down");
      DataTransferServer.this.stop();
      System.err.println("*** server shut down");
    }));
  }

  private void stop() {
    if (server != null) {
      server.shutdown();
    }
  }

  private void blockUntilShutdown() throws InterruptedException {
    if (server != null) {
      server.awaitTermination();
    }
  }

  public static void main(String[] args) throws IOException, InterruptedException {
    final DataTransferServer server = new DataTransferServer();
    server.start();
    server.blockUntilShutdown();
  }
}
