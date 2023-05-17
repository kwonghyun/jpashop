package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B") // dtype이랑 구분해주려고 키? 같은거 넣는 느낌
@Getter @Setter
public class Book extends Item{
    private String author;
    private String isbn;

}
