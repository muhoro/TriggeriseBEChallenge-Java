/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triggerisebechallange.BusinessLayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import triggerisebechallange.Domain.Product;

/**
 *
 * @author Muhoro
 */
public class ProductPricingRuleFactory {
    private HashMap<String, List<IPricingRule>> _map
            = new HashMap();
    
    public void add(Product product, IPricingRule rule){
        List<IPricingRule> pricings = _map.get(product.getCode());
        if(pricings != null)
        {
            pricings.add(rule);
            _map.remove(product.getCode().trim());
            _map.put(product.getCode().trim(), pricings);
        }
        
        else {
            List<IPricingRule> list = new ArrayList();
            list.add(rule);
            _map.put(product.getCode().trim(), list);
        }
    }
    
    public List<IPricingRule> getPricingRules(Product product){
        List<IPricingRule> rules = _map.get(product.getCode().trim());
        if(rules == null) {
            rules = new ArrayList<>();
            rules.add(new DefaultPricingRule());
        }
        return rules;
    }
    
}
