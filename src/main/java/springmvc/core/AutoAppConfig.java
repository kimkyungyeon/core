package springmvc.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import springmvc.core.discount.DiscountPolicy;
import springmvc.core.member.MemberRepository;
import springmvc.core.order.OrderService;
import springmvc.core.order.OrderServiceImpl;

@Configuration
@ComponentScan(
        basePackages = "springmvc.core",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    DiscountPolicy discountPolicy;

    @Bean
    OrderService orderService() {
        return new OrderServiceImpl(memberRepository, discountPolicy);
    }
}
