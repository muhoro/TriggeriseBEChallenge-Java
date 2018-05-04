/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triggerisebechallange.BusinessLayer;

import java.math.BigDecimal;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import triggerisebechallange.Domain.OrderLine;
import triggerisebechallange.Domain.Price;

/**
 *
 * @author Muhoro
 */
public class BulkPurchasePriceRule implements IPricingRule {

    
    private int target;
    private BigDecimal price;

    public BulkPurchasePriceRule(int target, BigDecimal price) {
        this.target = target;
        this.price = price;
    }
    
    @Override
    public boolean isApplicable(OrderLine orderLine) {
        if (orderLine == null) return false;
            return (orderLine.getQuantity() >= target);
    }

    @Override
    public Function<OrderLine, Price> priceFunc() {
            return (od) -> _func(od);
    }
    
    private Price _func(OrderLine orderLine){
        if(isApplicable(orderLine))
            return new Price(BigDecimal.valueOf(orderLine.getQuantity()).multiply(price));
        return new Price(BigDecimal.ZERO);
    }
    
}
