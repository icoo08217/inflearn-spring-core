package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    // DI : 의존관계 주입 , 의존성 주입이라고 한다.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // @Autowired // 생성자가 딱 한 개인 경우에는 @Autowired를 삭제할 수 있다.
    //    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
    //        this.memberRepository = memberRepository;
    //        this.discountPolicy = discountPolicy;
    //    }
    // 위의 코드는 @RequiredArgsConstructor 가 만들어준다.

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice , discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
