package cn.hz.jerseyspring;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class BeanTest {

	public static void main(String[] args) throws IntrospectionException {
		 BeanInfo beanInfo = Introspector.getBeanInfo(AddResult.class);
         PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
         System.out.println(pds);
	}

}
