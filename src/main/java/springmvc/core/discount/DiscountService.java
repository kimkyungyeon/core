package springmvc.core.discount;

import org.springframework.beans.factory.annotation.Autowired;
import springmvc.core.member.Member;

import java.util.List;
import java.util.Map;

public class DiscountService {

    private final Map<String, DiscountPolicy> discountPolicyMap;
    private final List<DiscountPolicy> policies;


//    @Autowired
    public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
        this.discountPolicyMap = policyMap;
        this.policies = policies;
        System.out.println("policyMap = " + policyMap);
        System.out.println("policies = " + policies);
    }




    public int discount(Member member, int price, String discountCode) {
        DiscountPolicy discountPolicy = discountPolicyMap.get(discountCode);
        return discountPolicy.discount(member, price);
    }
}
