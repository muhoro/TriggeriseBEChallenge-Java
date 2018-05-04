/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triggerisebechallange.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import triggerisebechallange.Domain.Product;

/**
 *
 * @author Muhoro
 */
public class Repository {
    public static List<Product> Products(){
        List<Product> products = new ArrayList<>();
        products.add(new Product(UUID.randomUUID(), "TICKET", "Triggerise Ticket", BigDecimal.valueOf(5.0) ));
        products.add(new Product(UUID.randomUUID(), "HOODIE", "Triggerise Hoodie", BigDecimal.valueOf(20.00) ));
        products.add(new Product(UUID.randomUUID(), "HAT", "Triggerise Hat", BigDecimal.valueOf(7.50) ));
        return products;
    }
}
