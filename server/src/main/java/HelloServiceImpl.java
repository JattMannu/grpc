import com.example.grpc.HelloRequest;
import com.example.grpc.HelloResponse;
import com.example.grpc.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void greet(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        System.out.println(request);
        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting("Hello! " + request.getName())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
