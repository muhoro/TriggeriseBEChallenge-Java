/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triggerisebechallange.BusinessLayer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import triggerisebechallange.Data.Repository;
import triggerisebechallange.Domain.Order;
import triggerisebechallange.Domain.OrderLine;
import triggerisebechallange.Domain.Price;
import triggerisebechallange.Domain.Product;

/**
 *
 * @author Muhoro
 */
public class Checkout {
    
    private ProductPricingRuleFactory factory;
    private List<Product> products = new ArrayList();
    
    public Checkout(ProductPricingRuleFactory factory){
        this.factory = factory;
    }
    
    public void scan(String productCode){
        if(productCode.isEmpty()) return;
        Product product = Repository.Products()
                .stream()
                .filter(p -> p.getCode().equalsIgnoreCase(productCode))
                .findFirst()
                .get();
        
        
        if(product != null) products.add(product);
    }
    
    public BigDecimal GetTotal(){
        List<OrderLine> orderlines = new ArrayList();
        List<OrderLine> orderlinesAppliedPricing = new ArrayList();
        
        Map<String, List<Product>> groupedProducts = 
                products.stream().collect(Collectors.groupingBy((e) -> e.getCode()));
        
        groupedProducts.forEach((k, v) 
                -> orderlines.add(new OrderLine(UUID.randomUUID(), v.get(0), v.size(), v.get(0).getDefaultPrice().multiply(BigDecimal.valueOf(v.size())))));
        
        for(OrderLine ol : orderlines){
            IPricingRule rule = new DefaultPricingRule();
            List<IPricingRule> pricingRules = factory.getPricingRules(ol.getProduct());
            for(IPricingRule rl : pricingRules){
                if(rl.isApplicable(ol)){
                    rule = rl;
                    break;
                }
            }
            Price price = rule.priceFunc().apply(ol);
            orderlinesAppliedPricing.add(
                new OrderLine(ol.getId(), ol.getProduct(), ol.getQuantity(), price.getValue()));
        }
        
        Order order = Order.create(orderlinesAppliedPricing);
        return order.getTotalPrice();
    }
}
