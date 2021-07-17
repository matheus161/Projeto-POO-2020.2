/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelTests;

import Model.PersonModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author joao8
 */
public class PersonModelSettersTest {
    
    public PersonModelSettersTest() {
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
     * Test of setId method, of class PersonModel.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        PersonModel instance = new PersonModelImpl();
        instance.setId(id);
    }

    /**
     * Test of setName method, of class PersonModel.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        PersonModel instance = new PersonModelImpl();
        instance.setName(name);
    }


    /**
     * Test of setEmail method, of class PersonModel.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        PersonModel instance = new PersonModelImpl();
        instance.setEmail(email);
    }

    /**
     * Test of setAddress method, of class PersonModel.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "";
        PersonModel instance = new PersonModelImpl();
        instance.setAddress(address);
    }

    /**
     * Test of setSex method, of class PersonModel.
     */
    @Test
    public void testSetSex() {
        System.out.println("setSex");
        char sex = ' ';
        PersonModel instance = new PersonModelImpl();
        instance.setSex(sex);
    }

    /**
     * Test of setCpf method, of class PersonModel.
     */
    @Test
    public void testSetCpf() {
        System.out.println("setCpf");
        String cpf = "";
        PersonModel instance = new PersonModelImpl();
        instance.setCpf(cpf);
    }

    /**
     * Test of setTel method, of class PersonModel.
     */
    @Test
    public void testSetTel() {
        System.out.println("setTel");
        String tel = "";
        PersonModel instance = new PersonModelImpl();
        instance.setTel(tel);
    }

    /**
     * Test of setDate method, of class PersonModel.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        String date = "";
        PersonModel instance = new PersonModelImpl();
        instance.setDate(date);
    }

    public class PersonModelImpl extends PersonModel {
    }
    
}
