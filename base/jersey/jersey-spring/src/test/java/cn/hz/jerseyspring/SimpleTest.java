package cn.hz.jerseyspring;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.spring.SpringLifecycleListener;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

public class SimpleTest extends JerseyTest {


	@Override
	protected Application configure() {
        return new MyApplication().register(SpringLifecycleListener.class).property("contextConfigLocation", "applicationContext.xml");
   
	}

	@Test
	public void test() {
		final String hello = target("hello").request().get(String.class);
		assertEquals("hello, world1!", hello);
	}
}