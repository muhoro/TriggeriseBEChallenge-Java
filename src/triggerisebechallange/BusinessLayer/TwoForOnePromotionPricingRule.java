/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triggerisebechallange.BusinessLayer;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.function.Function;
import triggerisebechallange.Domain.OrderLine;
import triggerisebechallange.Domain.Price;

/**
 *
 * @author Muhoro
 */
public class TwoForOnePromotionPricingRule implements IPricingRule{

    private int target = 2;
    
    @Override
    public boolean isApplicable(OrderLine orderLine) {
        return (orderLine.getQuantity() >= target);
    }

    @Override
    public Function<OrderLine, Price> priceFunc() {
        return (od) -> _func(od);
    }
    
    private Price _func(OrderLine orderLine){
        
        if (isApplicable(orderLine)) {
            int quantity = orderLine.getQuantity();
            int pairs = quantity / 2;
            int mod = quantity % 2;
            BigDecimal newprice = BigDecimal.ZERO;
            newprice = BigDecimal.valueOf((pairs * (orderLine.getProduct().getDefaultPrice().doubleValue()) + (mod * orderLine.getProduct().getDefaultPrice().doubleValue())));
            return new Price( newprice);
        }
        
        else
            return new Price(BigDecimal.ZERO);
    }
}
