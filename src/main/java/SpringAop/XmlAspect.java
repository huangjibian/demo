package SpringAop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by Administrator on 2018/9/29.
 */
public class XmlAspect {

        public void before() {
            System.out.println("before......");
        }

        public void after() {
            System.out.println("after......");
        }

        public void afterReturning() {
            System.out.println("afterReturning......");
        }

        public void afterThrowing() {
            System.out.println("afterThrowing........");
        }

        public void around(ProceedingJoinPoint jp) {
            System.out.println("around before ........");
            try {
                jp.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            System.out.println("around after .........");
        }

}
