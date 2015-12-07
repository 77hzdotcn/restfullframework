package cn.hz.jersey.tomcat;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import cn.hz.jersey.tomcat.AsynTasks.Task;

@Path("helloworld")
@Produces({ MediaType.APPLICATION_JSON })
public class HelloWorld {
	
	@Context 
	private UriInfo context;
	
	public HelloWorld() {
    }
	
	@GET
    @Produces("text/html")
    public String getHtml() {
		long start = System.currentTimeMillis();
		List<Task> tasks = new ArrayList<AsynTasks.Task>();
		tasks.add(new Task<String>() {

			@Override
			public void execute() {
				try {
					TimeUnit.SECONDS.sleep(5);
					System.out.println("test");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			@Override
			public String result() {
				return null;
			}
		});
		try {
			new AsynTasks(tasks, true,false).execute();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("返回,time: " + (end - start));
        return "<html lang=\"en\"><body><h1>Hello, World!!</h1></body></html>";
    }
	
	@POST
	@Path("post")
    @Produces(MediaType.TEXT_PLAIN)
    public String getPostParam(@FormParam("name") String name,
    		@FormParam("a") @DefaultValue("0") Integer a) {
        return "Hello, " + name + ", age : " + a;
    }
	
	@GET
	@Path("entity")
    public MyBean getEntity() {
        return new MyBean("wangxf", 27);
    }
	
}
