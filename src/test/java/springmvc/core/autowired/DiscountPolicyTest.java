package springmvc.core.autowired;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springmvc.core.AutoAppConfig;
import springmvc.core.DiscountPolicyConfig;
import springmvc.core.discount.DiscountService;

public class DiscountPolicyTest {

    @Test
    void discountPolicyTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(DiscountService.class, DiscountPolicyConfig.class);
        DiscountService discountService = ac.getBean(DiscountService.class);
        DiscountPolicyConfig bean = ac.getBean(DiscountPolicyConfig.class);
        System.out.println("bean = " + bean);


    }
}
