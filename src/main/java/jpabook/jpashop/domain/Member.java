package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Embedded // 내장타입을 뜻하는 어노테이션
    private Address address;

    private String name;



    @OneToMany(mappedBy = "member") // Order 클래스의 member와 맵핑, 연관관계 주인 아니라 그냥 거울일 뿐이야 라는 뜻
    private List<Order> orders= new ArrayList<>(); // 여기 값을 넣어도 FK값 변경 안됨
}
