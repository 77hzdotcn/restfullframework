package cn.hz.jerseyspring;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.web.filter.RequestContextFilter;

public class MyApplication extends ResourceConfig {

    public MyApplication() {
    	register(RequestContextFilter.class);
        register(JerseyResource.class);
    }
}
