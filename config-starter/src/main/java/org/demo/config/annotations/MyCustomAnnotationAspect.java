package org.demo.config.annotations;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyCustomAnnotationAspect {

    @Before("@within(dynamicBean)")
    public void processAnnotation(JoinPoint joinPoint, DynamicBean dynamicBean) {
        // Accédez à l'annotation et à ses attributs
        var value = dynamicBean.types();
        System.out.println("Custom Annotation Value for class: " + value);
    }
}