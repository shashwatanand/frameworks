package com.shashwat.grpc.springboot.example.service;

import com.shashwat.grpc.greeting.GreetingRequest;
import com.shashwat.grpc.greeting.GreetingResponse;
import com.shashwat.grpc.greeting.GreetingServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void greeting(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
        String message = request.getMessage();
        System.out.println("Message received : " + message);

        GreetingResponse response = GreetingResponse.newBuilder().setMessage("Response from service").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
