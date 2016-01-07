package cn.hz.aop;

import org.springframework.beans.factory.annotation.Autowired;

public class HelloImpl implements IHello {
	
	@Autowired
	private Person person; 

	public void sayHello() {
		person.sayHello();
	}

	@Override
	public void sayHi() {
		System.out.println("Hi");
		
	}

	@Override
	public void sayOther() {
		System.out.println("other");
	}

}
