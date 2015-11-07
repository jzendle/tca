package com.level3.datanucleusprototype;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zendle.joe
 */
public class HelloTest {

  static EntityManager em;

  static EntityManagerFactory emf;

  public HelloTest() {
  }

  @BeforeClass
  public static void setUpClass() {
    emf = Persistence.createEntityManagerFactory("MyUnit");
    em = emf.createEntityManager();
    
  }

  @AfterClass
  public static void tearDownClass() {
    emf.close();
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  @Test
  public void hello() {
 
  }
}
