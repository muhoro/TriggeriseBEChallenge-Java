/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triggerisebechallange.BusinessLayer;

import java.util.function.Function;
import triggerisebechallange.Domain.OrderLine;
import triggerisebechallange.Domain.Price;

/**
 *
 * @author Muhoro
 */
public interface IPricingRule {
    boolean isApplicable(OrderLine orderLine);
    Function<OrderLine, Price> priceFunc();
}
