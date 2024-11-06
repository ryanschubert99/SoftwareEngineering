package src;
import datatransfer.ComputationCoordinatorServiceGrpc.ComputationCoordinatorServiceImplBase;
import datatransfer.DataTransfer.*;
import io.grpc.stub.StreamObserver;

public class ComputationCoordinatorServiceImpl extends ComputationCoordinatorServiceImplBase {

    public void beginComputation(ComputeRequest request, StreamObserver<ComputeResponse> responseObserver) {
        // Logic to begin computation
        ComputeResponse response = ComputeResponse.newBuilder()
                .setStatus(OperationStatus.SUCCESS)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}