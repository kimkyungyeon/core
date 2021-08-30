package springmvc.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springmvc.core.member.Grade;
import springmvc.core.member.Member;
import springmvc.core.member.MemberService;
import springmvc.core.member.MemberServiceImpl;
import springmvc.core.order.Order;
import springmvc.core.order.OrderService;
import springmvc.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService",OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.BASIC);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order = " + order.calculatePrice());

    }
}
