package springmvc.core.scan;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springmvc.core.AutoAppConfig;
import springmvc.core.member.MemberRepository;
import springmvc.core.member.MemberService;
import springmvc.core.member.MemberServiceImpl;
import springmvc.core.order.OrderService;
import springmvc.core.order.OrderServiceImpl;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);

//        OrderServiceImpl bean = ac.getBean(OrderServiceImpl.class);
//        Assertions.assertThat(bean).isInstanceOf(OrderService.class);
//        MemberRepository memberRepository = bean.getMemberRepository();
    }
}
