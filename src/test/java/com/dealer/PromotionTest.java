package com.dealer;

import java.util.Date;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.dealer.models.Promotion;

/**
 * Test class for Promotion
 * @author Prabhjot Aulakh, Safin Haque
 */
@SuppressWarnings("unused")
public class PromotionTest {
    @Test
    public void constructor_no_errors() {
        Promotion promotion = new Promotion("50% off", new Date(2023, 11, 10), new Date(2023, 11, 12));
    }

    @Test(expected = IllegalArgumentException.class)
    public void null_name() {
        Promotion promotion = new Promotion(null, new Date(2023, 11, 10), new Date(2023, 11, 12));
    }

    @Test(expected = IllegalArgumentException.class)
    public void empty_name() {
        Promotion promotion = new Promotion("", new Date(2023, 11, 10), new Date(2023, 11, 12));
    }

    @Test(expected = IllegalArgumentException.class)
    public void null_start() {
        Promotion promotion = new Promotion("50% off", null, new Date(2023, 11, 12));
    }  
    
    @Test(expected = IllegalArgumentException.class)
    public void null_end() {
        Promotion promotion = new Promotion("50% off", new Date(2023, 11, 10), null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void start_after_end() {
        Promotion promotion = new Promotion(null, new Date(2024, 11, 10), new Date(2023, 11, 12));
    }

    @Test(expected = IllegalArgumentException.class)
    public void end_before_start() {
        Promotion promotion = new Promotion(null, new Date(2023, 11, 10), new Date(2023, 11, 9));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalid_month_start() {
        Promotion promotion = new Promotion("50% off", new Date(2023, 20, 10), new Date(2023, 11, 12));
    }    

    @Test(expected = IllegalArgumentException.class)
    public void invalid_day_start() {
        Promotion promotion = new Promotion("50% off", new Date(2023, 11, 50), new Date(2023, 11, 12));
    }   

    @Test(expected = IllegalArgumentException.class)
    public void invalid_month_end() {
        Promotion promotion = new Promotion("50% off", new Date(2023, 11, 10), new Date(2023, 18, 12));
    }  

    @Test(expected = IllegalArgumentException.class)
    public void invalid_day_end() {
        Promotion promotion = new Promotion("50% off", new Date(2023, 11, 10), new Date(2023, 11, 50));
    }  

    @Test(expected = IllegalArgumentException.class) 
    public void setter_null_name() {
        Promotion promotion = new Promotion("50% off", new Date(2023, 11, 10), new Date(2023, 11, 12));
        promotion.setName(null);
    }

    @Test(expected = IllegalArgumentException.class) 
    public void setter_empty_name() {
        Promotion promotion = new Promotion("50% off", new Date(2023, 11, 10), new Date(2023, 11, 12));
        promotion.setName("");
    }

    @Test(expected = IllegalArgumentException.class) 
    public void setter_null_start() {
        Promotion promotion = new Promotion("50% off", new Date(2023, 11, 10), new Date(2023, 11, 12));
        promotion.setStart(null);
    }

    @Test(expected = IllegalArgumentException.class) 
    public void setter_null_end() {
        Promotion promotion = new Promotion("50% off", new Date(2023, 11, 10), new Date(2023, 11, 12));
        promotion.setEnd(null);
    }

    @Test(expected = IllegalArgumentException.class) 
    public void setter_invalid_month_start() {
        Promotion promotion = new Promotion("50% off", new Date(2023, 11, 10), new Date(2023, 11, 12));
        promotion.setStart(new Date(2023, 20, 10));
    }

    @Test(expected = IllegalArgumentException.class) 
    public void setter_invalid_day_start() {
        Promotion promotion = new Promotion("50% off", new Date(2023, 11, 10), new Date(2023, 11, 12));
        promotion.setStart(new Date(2023, 12, 35));
    }

    @Test(expected = IllegalArgumentException.class) 
    public void setter_invalid_month_end() {
        Promotion promotion = new Promotion("50% off", new Date(2023, 11, 10), new Date(2023, 11, 12));
        promotion.setEnd(new Date(2023, 20, 10));
    }

    @Test(expected = IllegalArgumentException.class) 
    public void setter_invalid_day_end() {
        Promotion promotion = new Promotion("50% off", new Date(2023, 11, 10), new Date(2023, 11, 12));
        promotion.setEnd(new Date(2023, 12, 35));
    }

    @Test(expected = IllegalArgumentException.class) 
    public void setter_start_after_end() {
        Promotion promotion = new Promotion("50% off", new Date(2023, 11, 10), new Date(2023, 11, 12));
        promotion.setStart(new Date(2023, 11, 15));
    }

    @Test(expected = IllegalArgumentException.class) 
    public void setter_end_before_start() {
        Promotion promotion = new Promotion("50% off", new Date(2023, 11, 10), new Date(2023, 11, 12));
        promotion.setEnd(new Date(2023, 10, 12));
    }

    @Test
    public void getters() {
        Promotion promotion = new Promotion("50% off", new Date(2023, 11, 10), new Date(2023, 11, 12));
        assertEquals("50% off", promotion.getName());
        // 0 means the dates are the same
        assertTrue(new Date(2023, 11, 10).compareTo(promotion.getStart()) == 0);
        assertTrue(new Date(2023, 11, 12).compareTo(promotion.getEnd()) == 0);
    }
}
