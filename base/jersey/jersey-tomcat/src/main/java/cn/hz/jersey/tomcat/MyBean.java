package cn.hz.jersey.tomcat;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MyBean {

	public String name;
	public int age;

	public MyBean(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public MyBean(){}

	@Override
	public String toString() {
		return "MyBean{" + "name='" + name + '\'' + ", age=" + age + '}';
	}

}
