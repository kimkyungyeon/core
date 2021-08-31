package springmvc.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import springmvc.core.discount.FixDiscountPolicy;
import springmvc.core.member.Grade;
import springmvc.core.member.Member;
import springmvc.core.member.MemoryMemberRepository;

public class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
