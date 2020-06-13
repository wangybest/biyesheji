package wangy.mall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "userid")
    private int userId;
    @Column(name = "goodsid")
    private int goodsId;
    @Column(name = "goodsname")
    private String goodsName;
    private int number;
    @Transient
    private BigDecimal price;
    @Transient
    private String picture;

}
