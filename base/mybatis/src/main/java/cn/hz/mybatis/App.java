package cn.hz.mybatis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.hz.mybatis.domain.Person;
import cn.hz.mybatis.service.PersonService;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
		PersonService ps = context.getBean(PersonService.class);
		Person p = ps.queryPerson(1);
		if (p != null) {
			System.out.println("Person:");
			System.out.println("	name: " + p.getName());
			System.out.println("	telephone: " + p.getTelephone().getPhoneNum());
		} else {

			System.out.println("No result!");
		}

	}
}
