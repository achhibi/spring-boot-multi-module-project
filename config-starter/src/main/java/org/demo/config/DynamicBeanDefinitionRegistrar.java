package org.demo.config;

import org.demo.config.component.MyService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;


public class DynamicBeanDefinitionRegistrar implements BeanDefinitionRegistryPostProcessor {

  public static final String PROPERTIES_PREFIX = "beans";



  public DynamicBeanDefinitionRegistrar() {

  }

  @Override
  public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry)
      throws BeansException {

          GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
          beanDefinition.setBeanClass(MyService.class);
          beanDefinition.setInstanceSupplier(() -> new MyService());
          registry.registerBeanDefinition("beanName", beanDefinition);

  }

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
      throws BeansException {}
}