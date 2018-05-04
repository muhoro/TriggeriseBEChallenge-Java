/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triggerisebechallange.Domain;

import java.math.BigDecimal;

/**
 *
 * @author Muhoro
 */
public class Price {
       
    private BigDecimal value;
    
    public Price(BigDecimal value){
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal Value) {
        this.value = Value;
    }
}
