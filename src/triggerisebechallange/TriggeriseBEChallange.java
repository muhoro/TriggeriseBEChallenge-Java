/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triggerisebechallange;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import triggerisebechallange.BusinessLayer.BulkPurchasePriceRule;
import triggerisebechallange.BusinessLayer.Checkout;
import triggerisebechallange.BusinessLayer.ProductPricingRuleFactory;
import triggerisebechallange.BusinessLayer.TwoForOnePromotionPricingRule;
import triggerisebechallange.Data.Repository;

/**
 *
 * @author Muhoro
 */
public class TriggeriseBEChallange {

    /**
     * @param args the command line arguments
     */
    
    private static String[] example1 = {"TICKET", "HOODIE", "HAT"};
    private static String[] example2 = {"TICKET", "HOODIE", "TICKET"};
    private static String[] example3 = {"HOODIE", "HOODIE", "HOODIE", "TICKET", "HOODIE"};
    private static String[] example4 = {"TICKET", "HOODIE", "TICKET", "TICKET", "HAT", "HOODIE", "HOODIE"};
    
    
    public static void main(String[] args) {
        
        // APPLYING Pricing for products
        ProductPricingRuleFactory pricingFactory = new ProductPricingRuleFactory();
        pricingFactory.add(Repository.Products().stream().filter(p -> p.getCode().equals("TICKET")).findFirst().get(),  
                new TwoForOnePromotionPricingRule());
        
        pricingFactory.add(Repository.Products().stream().filter(p -> p.getCode().equals("HOODIE")).findFirst().get(),  
                new BulkPurchasePriceRule(3, BigDecimal.valueOf(19.00)));
        
        runExample(example1, pricingFactory);
        runExample(example2, pricingFactory);
        runExample(example3, pricingFactory);
        runExample(example4, pricingFactory);
    }
    
    private static void runExample(String[] productCodesToScan, ProductPricingRuleFactory pricingFactory){
        
        Checkout checkout = new Checkout(pricingFactory);
        for(String productCode : productCodesToScan){
            checkout.scan(productCode);
        }
        System.out.println("Products : "+Arrays.toString(productCodesToScan) + " TOTAL = $ "+ checkout.GetTotal());
    }
    
}
