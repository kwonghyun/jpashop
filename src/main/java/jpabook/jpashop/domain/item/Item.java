package jpabook.jpashop.domain.item;

import jpabook.jpashop.domain.Category;
import jpabook.jpashop.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 한테이블에 다 때려박는 전략
@DiscriminatorColumn(name = "dtype")
@Getter @Setter //setter를 이용한 변경이 아닌 비지니스 로직을 이용한 변경만 할것(객체지향적)
public abstract class Item {
    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    // 비지니스 로직 -> 엔티티 안에 넣는 것이 객체지향적임
    public void  addStock(int quatity) {
        this.stockQuantity += quatity;
    }

    public void removeStock(int quatity) {
        int restStock = this.stockQuantity - quatity;
        if (restStock < 0) {
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }


}
