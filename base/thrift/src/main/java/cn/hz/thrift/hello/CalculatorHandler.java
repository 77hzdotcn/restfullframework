package cn.hz.thrift.hello;


import org.apache.thrift.TException;

public class CalculatorHandler implements HelloService.Iface {

	public CalculatorHandler() {
	}

	@Override
	public HelloStruct sayHello(String name) throws TException {
		System.out.println("from : " + name);
		return new HelloStruct(20, name);
	}

}
