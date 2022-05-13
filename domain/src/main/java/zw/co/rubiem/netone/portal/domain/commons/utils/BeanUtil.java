package zw.co.rubiem.netone.portal.domain.commons.utils;

/**
 * @author Nyabinde Nyasha
 * @created 2/4/2021
 * @project boilerplate
 */

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service("utilitiesBeanUtil")
public class BeanUtil implements ApplicationContextAware {

    private static ApplicationContext context;

    public BeanUtil() {
    }

    public static <T> T getBean(Class<T> beanClass) {
        return context.getBean(beanClass);
    }

    public static <T> T getBean(String beanName) {
        return (T) context.getBean(beanName);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

}

