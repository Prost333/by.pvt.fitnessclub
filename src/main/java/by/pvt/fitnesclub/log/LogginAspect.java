package by.pvt.fitnesclub.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogginAspect {
    @Pointcut(value = "execution(* by.pvt.fitnesclub.controller.SaleController.*(..))")
    public void logSale(){

    }
    @Before(value = "logSale()")
    public  void beforFindById(){
      log.info("start question");
    }
}
