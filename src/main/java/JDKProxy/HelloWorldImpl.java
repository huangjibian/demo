package JDKProxy;

public class HelloWorldImpl implements HelloWorld{
    @Override
    public void sayHelloWorld(){
        System.out.println("Hello World");
    }

    @Override
    public void sayLove() {
        System.out.println("love world");
    }
}
