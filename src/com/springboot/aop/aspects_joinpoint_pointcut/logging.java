//package src.com.springboot.aop.aspects_joinpoint_pointcut;
//
//import org.aspectj.lang.annotation.*;
//import org.springframework.stereotype.Component;
//
////logging aspect
//@Aspect
//@Component
//public class logging {
//
//// Take these filters and filter the code and apply these aspects to the filtered code-PointCut
////  Each method execution that matches the pointcut expression-JoinPoint.
//
//    @Before("execution(* com.example.demo.*Service.*(..))")
//    public void logBeforeServiceCall() {
//        System.out.println("Logging before service method execution");
//    }
//
//    @After("execution(* com.example.demo.*Service.*(..))")
//    public void logAfterServiceCall() {
//        System.out.println("Logging after service method execution");
//    }
//}