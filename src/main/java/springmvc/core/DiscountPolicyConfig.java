package springmvc.core;

import org.springframework.context.annotation.Bean;
import springmvc.core.discount.DiscountPolicy;
import springmvc.core.discount.DiscountService;
import springmvc.core.discount.FixDiscountPolicy;
import springmvc.core.discount.RateDiscountPolicy;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class DiscountPolicyConfig {

    @Bean
    public DiscountPolicy rateDiscountPolicy() {
        return new RateDiscountPolicy();
    }

    @Bean DiscountPolicy fixDiscountPolicy() {
        return new FixDiscountPolicy();
    }
}
