package com;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class TestBean implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware {
	private String classID;
	private String className;
	private String beanName; //实现了BeanNameAware接口，Spring可以将BeanName注入该属性中
	private BeanFactory beanFactory; //实现了BeanFactory接口，Spring可将BeanFactory注入该属性中
	
	
	public TestBean(){
		System.out.println("时间："+System.currentTimeMillis()+"TestBean 构造方法");
	}
	
	public void setClassID(String classID) {
		 System.out.println("时间："+System.currentTimeMillis()+"【set注入】注入类的classID属性");
		this.classID = classID;
	}

	public void setClassName(String className) {
		 System.out.println("时间："+System.currentTimeMillis()+"【set注入】注入类的className属性");
		this.className = className;
	}
	
	public void testBeanInit(){
		System.out.println("时间："+System.currentTimeMillis()+"【init-method】  test Bean 初始化");
	}
	
	// 来自BeanFactoryAware
		@Override
		public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
			this.beanFactory = beanFactory;
			System.out.println("时间：" + System.currentTimeMillis()
					+ "【BeanFactoryAware接口】调用BeanFactoryAware的setBeanFactory方法得到beanFactory引用");
		}
		
	
	
	//来自InitializingBean
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("时间："+System.currentTimeMillis()+"【InitializingBean接口】调用InitializingBean接口的afterPropertiesSet方法");
	}
	
	

	//来自BeanNameAware
	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
        System.out.println("时间："+System.currentTimeMillis()+"【BeanNameAware接口】调用BeanNameAware的setBeanName方法得到Bean的名称");
	}
	
	@Override
	public String toString(){
		return "TestBean{" +
                "id='" + classID + '\'' +
                ", name=" + className +
                ", beanName='" + beanName + '\'' +
                '}';
	}

	
	
	//来自DisposableBean
	@Override
	public void destroy() throws Exception {
		System.out.println("时间："+System.currentTimeMillis()+"【DisposableBean接口】调用DisposableBean接口的destroy方法");
	}
	
	public void testBeanDestory(){
		System.out.println("时间："+System.currentTimeMillis()+"【destroy-method】  test Bean 销毁");
	}

}
