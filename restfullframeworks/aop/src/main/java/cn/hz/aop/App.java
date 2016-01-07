package cn.hz.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		System.out.println(System.getProperty("user.dir"));
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		IHello hello = context.getBean(IHello.class);
		hello.sayHello();
		hello.sayOther();
	}
}
