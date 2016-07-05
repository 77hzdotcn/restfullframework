package cn.hz.jerseyspring;

import javax.inject.Named;

import org.springframework.stereotype.Component;

@Component
@Named
public class GreetingServiceImpl implements GreetingService {

	@Override
	public String greet(String who) {
		return String.format("hello, %s!", who);
	}
}
