/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triggerisebechallange.BusinessLayer;

import java.math.BigDecimal;
import java.util.function.Function;
import triggerisebechallange.Domain.OrderLine;
import triggerisebechallange.Domain.Price;

/**
 *
 * @author Muhoro
 */
public class DefaultPricingRule implements IPricingRule {

    @Override
    public boolean isApplicable(OrderLine orderLine) {
        return orderLine!=null;
    }

    @Override
    public Function<OrderLine, Price> priceFunc() {
        return (od) -> new Price(BigDecimal.valueOf(od.getQuantity()).multiply(od.getProduct().getDefaultPrice()));
    }
    
}
