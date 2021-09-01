package springmvc.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springmvc.core.discount.DiscountPolicy;
import springmvc.core.discount.FixDiscountPolicy;
import springmvc.core.discount.RateDiscountPolicy;
import springmvc.core.member.*;
import springmvc.core.order.OrderService;
import springmvc.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository()

    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.memberRepository
    //call AppConfig.orderService
    //call AppConfig.memberRepository

    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.orderService

    //역할
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        //구현
        return new MemberServiceImpl(memberRepository());
    }

    // 역할
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        //구현
        return new MemoryMemberRepository();
    }

    //역할
    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        //구현
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }


    //역할
    @Bean
    public DiscountPolicy discountPolicy() {
        //구현
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
