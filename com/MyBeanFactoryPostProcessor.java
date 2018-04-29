package com;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	
	public MyBeanFactoryPostProcessor() {
        System.out.println("时间："+System.currentTimeMillis()+"【BeanFactoryPostProcessor接口】调用BeanFactoryPostProcessor实现类构造方法");
    }

	/**
     * 重写BeanFactoryPostProcessor接口的postProcessBeanFactory方法，可通过该方法对beanFactory进行设置
     */
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		 System.out.println("时间："+System.currentTimeMillis()+"【BeanFactoryPostProcessor接口】"
		 		+ "调用BeanFactoryPostProcessor接口的postProcessBeanFactory方法");
	     BeanDefinition beanDefinition = beanFactory.getBeanDefinition("testBean");
	     beanDefinition.getPropertyValues().addPropertyValue("className", "is Test bean");

	}

}
