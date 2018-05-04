/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triggerisebechallange.Domain;

import java.math.BigDecimal;
import java.util.UUID;

/**
 *
 * @author Muhoro
 */
public class Product {
     
    private UUID id;
    private String code;
    private String name;
    private BigDecimal defaultPrice;

    public Product(UUID id, String code, String name, BigDecimal defaultPrice) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.defaultPrice = defaultPrice;
    }
    
    

    public UUID getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getDefaultPrice() {
        return defaultPrice;
    }
    
    
}
