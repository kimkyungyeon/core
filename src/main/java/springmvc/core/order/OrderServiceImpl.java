package springmvc.core.order;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import springmvc.core.annotation.MainDiscountPolicy;
import springmvc.core.discount.DiscountPolicy;
import springmvc.core.discount.FixDiscountPolicy;
import springmvc.core.discount.RateDiscountPolicy;
import springmvc.core.member.Member;
import springmvc.core.member.MemberRepository;
import springmvc.core.member.MemoryMemberRepository;

@Component
//@RequiredArgsConstructor //final 이 붙은 필드를 포함한 생성자
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); OCP, DIP 위반
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy()

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
