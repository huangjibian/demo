package JDKProxy;

import java.lang.reflect.*;

public class JdkProxyExample implements InvocationHandler {
    private Object target = null;
/*    public Object bind (Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }*/




    @Override
    public Object invoke(Object proxy, Method method ,Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("进入代理逻辑方法");
        System.out.println("调用真是对象之前的服务");
        Object obj = method.invoke(target,args);
        System.out.println("z之后的服务");
        return  obj;
    }

    public  void testJdkProxy(){
        // JdkProxyExample jdk = new JdkProxyExample();
        target = new HelloWorldImpl();
        HelloWorld proxy =  (HelloWorld) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        //HelloWorld proxy = (HelloWorld) obj;
        proxy.sayHelloWorld();
    }





    public static void main(String[] args) {
        new JdkProxyExample().testJdkProxy();
    }
}
