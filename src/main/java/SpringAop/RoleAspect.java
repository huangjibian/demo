package SpringAop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by Administrator on 2018/9/20.
 */
@Aspect
public class RoleAspect {

    @Pointcut("execution(* SpringAop.RoleServiceImpl.printRole(..))")
    public void print(){

    }
    @Before("print()")
    public void before(){
        System.out.println("before......");
    }
    @After("execution(* SpringAop.RoleServiceImpl.printRole(..))")
    public void after(){
        System.out.println("after......");
    }
    @AfterReturning("execution(* SpringAop.RoleServiceImpl.printRole(..))")
    public void afterReturning(){
        System.out.println("afterReturning......");
    }
    @AfterThrowing("execution(* SpringAop.RoleServiceImpl.printRole(..))")
    public void afterThrowing(){
        System.out.println("afterThrowing........");
    }
    @Around("print()")
    public void around(ProceedingJoinPoint jp){
        System.out.println("around before ........");
        try {
            jp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("around after .........");
    }
}
