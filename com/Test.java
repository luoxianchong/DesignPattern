package com;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	@Test 
	public void SpringApp(){
		
		System.out.println("--------------【初始化容器】---------------");
        ApplicationContext ctxt = new ClassPathXmlApplicationContext("test-springBean-lifecycle.xml");
        System.out.println("-------------------【容器初始化成功】------------------");
        //得到studentBean，并显示其信息
        TestBean bean = ctxt.getBean("testBean",TestBean.class);
        System.out.println(bean);

        System.out.println("--------------------【销毁容器】----------------------");
        ((ClassPathXmlApplicationContext)ctxt).registerShutdownHook();
	}
	
}
