/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelTests;

import Model.ProductModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author joao8
 */
public class ProductModelSettersTest {
    
    private ProductModel pm;
    
    public ProductModelSettersTest() {
        this.pm = new ProductModel(01,5,"Celulares",1500f,"Redmi");
    }

    
    
    @BeforeAll
    public static void setUpClass() {
        
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        
    }
    
    @AfterEach
    public void tearDown() {
    }

    

    /**
     * Test of setId method, of class ProductModel.
     */
    @org.junit.jupiter.api.Test
    public void testSetId() {
        pm.setId(20);
        assertEquals(20, pm.getId());
    }

    /**
     * Test of setName method, of class ProductModel.
     */
    @org.junit.jupiter.api.Test
    public void testSetName() {
        pm.setName("Iphone");
        assertEquals("Iphone",pm.getName());
    }
    /*
     /* Test of setCategory method, of class ProductModel.
     */
    @org.junit.jupiter.api.Test
    public void testSetCategory() {
        pm.setCategory("Fones");
        assertEquals("Fones", pm.getCategory());
    }

    
    /**
     * Test of setPrice method, of class ProductModel.
     */
    @org.junit.jupiter.api.Test
    public void testSetPrice() {
        pm.setPrice(3000f);
        assertEquals(3000f, pm.getPrice());
    }

    /**
     * Test of setAmount method, of class ProductModel.
     */
    @org.junit.jupiter.api.Test
    public void testSetAmount() {
        pm.setAmount(6);
        assertEquals(6, pm.getAmount());
    }
    
}
