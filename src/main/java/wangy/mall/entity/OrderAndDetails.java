package wangy.mall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderAndDetails {
    private Orders orders;
    private List<Orderdetails> orderdetailsList;
}
