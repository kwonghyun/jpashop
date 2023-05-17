package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A") // dtype이랑 구분해주려고 키? 같은거 넣는 느낌
@Getter @Setter
public class Album extends Item {
    private String artist;
    private String etc;

}
