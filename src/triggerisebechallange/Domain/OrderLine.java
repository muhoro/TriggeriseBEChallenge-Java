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
public class OrderLine {
    private UUID id;
    private Product product;
    private int quantity;
    private BigDecimal price;

    public OrderLine(UUID id, Product product, int quantity, BigDecimal price) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }
    
    public UUID getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }
    
    
}
