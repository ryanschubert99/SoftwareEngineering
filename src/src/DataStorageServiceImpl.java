package src;

import java.io.IOException;
import java.util.List;

import dataprocessing.DataProcessing.Matrix;
import dataprocessing.DataProcessing.ReadInputFileRequest;
import dataprocessing.DataProcessing.ReadInputFileResponse;
import dataprocessing.DataProcessing.Row;
import dataprocessing.DataProcessing.WriteOutputRequest;
import dataprocessing.DataProcessing.WriteOutputResponse;
import dataprocessing.DataStorageServiceGrpc.DataStorageServiceImplBase;
import io.grpc.stub.StreamObserver;

// Adjusted constructor to pass required arguments to DataStorageImp

public class DataStorageServiceImpl extends DataStorageServiceImplBase {

	  private DataStorageServiceImpl datastorage;

	public DataStorageServiceImpl() {
	        this.datastorage = new DataStorageServiceImpl(); // Initialize the coordinator
	    }

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        
    }

}