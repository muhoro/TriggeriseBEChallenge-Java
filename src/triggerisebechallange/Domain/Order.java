/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triggerisebechallange.Domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Muhoro
 */
public class Order {
    private Order(List<OrderLine> orderLines){
        this.orderLines = orderLines;
    }
    
    public static Order create(List<OrderLine> orderLines) {
       return new Order(orderLines);
    }

    private List<OrderLine> orderLines;
    private Date orderDate;
    private BigDecimal totalPrice;

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public BigDecimal getTotalPrice() {
        double total = 0;
        for(OrderLine orderline : this.orderLines){
            total += orderline.getPrice().doubleValue();
        }
        return BigDecimal.valueOf(total);
    }
    
    
}
