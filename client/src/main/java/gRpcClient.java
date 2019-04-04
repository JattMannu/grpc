import com.example.grpc.HelloRequest;
import com.example.grpc.HelloResponse;
import com.example.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class gRpcClient {

    public static void main(String[] args){
        System.out.println("Client");
        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080")
                .usePlaintext()
                .build();


        //Hello
        HelloServiceGrpc.HelloServiceBlockingStub  stub = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse response = stub.greet(HelloRequest.newBuilder().setName("Manpreet").build());

        System.out.println(response);

        channel.shutdown();


    }
}
