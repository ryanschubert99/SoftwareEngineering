package src;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import datatransfer.DataStorageServiceGrpc.DataStorageServiceImplBase;
import datatransfer.DataTransfer.Matrix;
import datatransfer.DataTransfer.OperationStatus;
import datatransfer.DataTransfer.ReadInputFileRequest;
import datatransfer.DataTransfer.ReadInputFileResponse;
import datatransfer.DataTransfer.Row;
import datatransfer.DataTransfer.WriteOutputRequest;
import datatransfer.DataTransfer.WriteOutputResponse;
import io.grpc.stub.StreamObserver;

public class DataStorageServiceImpl extends DataStorageServiceImplBase {

    public void writeOutput(WriteOutputRequest request, StreamObserver<WriteOutputResponse> responseObserver) {
        try {
   
            WriteOutputResponse response = WriteOutputResponse.newBuilder()
                    .setStatus(OperationStatus.SUCCESS)
                    .setMessage("Output written successfully")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            WriteOutputResponse response = WriteOutputResponse.newBuilder()
                    .setStatus(OperationStatus.FAILURE)
                    .setMessage("Error writing output: " + e.getMessage())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    public void readInputFile(ReadInputFileRequest request, StreamObserver<ReadInputFileResponse> responseObserver) {
        List<int[][]> matrices = new ArrayList<>();
        boolean success = true;

        try (BufferedReader br = new BufferedReader(new FileReader(request.getInputFileName()))) {
            String line;
            List<Row> rows = new ArrayList<>();
            int[][] currentMatrix = null;
            int rowCount = 0;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    if (currentMatrix != null) {
                        matrices.add(currentMatrix);
                        rowCount = 0;
                    }
                } else {
                    String[] values = line.trim().split(",");
                    if (currentMatrix == null) {
                        currentMatrix = new int[values.length][values.length]; // Assuming a square matrix, adjust as needed.
                    }

                    for (int i = 0; i < values.length; i++) {
                        currentMatrix[rowCount][i] = Integer.parseInt(values[i]);
                    }
                    rowCount++;
                }
            }
        } catch (IOException e) {
            success = false;
            System.err.println("Error reading input file: " + e.getMessage());
        }

        ReadInputFileResponse.Builder responseBuilder = ReadInputFileResponse.newBuilder()
                .setStatus(success);

        if (success) {
            for (int[][] matrix : matrices) {
                Matrix.Builder matrixBuilder = Matrix.newBuilder();
                for (int[] row : matrix) {
                    Row.Builder rowBuilder = Row.newBuilder();
                    for (int value : row) {
                        rowBuilder.addValues(value);
                    }
                    matrixBuilder.addRows(rowBuilder.build());
                }
                responseBuilder.addMatrices(matrixBuilder.build());
            }
        }

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }
}
