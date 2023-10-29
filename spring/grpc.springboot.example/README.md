$ grpcurl --plaintext localhost:9090 list
com.shashwat.grpc.greeting.GreetingService
grpc.health.v1.Health
grpc.reflection.v1alpha.ServerReflection

$ grpcurl --plaintext localhost:9090 list com.shashwat.grpc.greeting.GreetingService
com.shashwat.grpc.greeting.GreetingService.greeting


$ grpcurl --plaintext -d '{"message": "How are you?"}' localhost:9090 com.shashwat.grpc.greeting.GreetingService/greetin
g
{
"message": "Response from service"
}