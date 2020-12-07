package com.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
/**
 * Spring AOP面向切面编程，可以用来配置事务、做日志、权限验证、在用户请求时做一些处理等等。用@Aspect做一个切面，就可以直接实现。
 */
@Aspect
@Component
/**
 * @Slf4j 等同于 private  final Logger logger = LoggerFactory.getLogger(当前类名.class); 可以直接使用log.info();
 */
@Slf4j
public class RequestParamAnnotationImpl {
	
	@Pointcut("@annotation(com.config.RequestParamAnnotation)")
	private void pointcut(){
		
	}
	//&& args(joinpoint,requestParamAnnotation) 
//	@Before(value = "pointcut() && @annotation(requestParamAnnotation) && args=(requestParamAnnotation)",argNames="requestParamAnnotation")
	// ,argNames="joinpoint,requestParamAnnotation"
	@Before(value = "pointcut() && @annotation(requestParamAnnotation)")
	public void before(JoinPoint joinpoint,RequestParamAnnotation requestParamAnnotation){
		Object[] args = joinpoint.getArgs();
		String orgnames =joinpoint.getSignature().getName();
		StringBuilder str = new StringBuilder();
		for(Object object: args){
			str.append(object.toString()+",");
		}
		log.info(requestParamAnnotation.describe()+",传入参数："+str.toString()+"调用方法："+orgnames);
	}
	
	/**另一种写法
	 * @Pointcut("@annotation(com.example.demo.annotation.Run3.Record)")
        public void myAnnotationPointcut(){

        }

        @Before("myAnnotationPointcut()")
        public void before(JoinPoint joinPoint){
            System.out.println(joinPoint.getTarget() + " begin:" + System.currentTimeMillis());
        }

	 * 
	 */

}
