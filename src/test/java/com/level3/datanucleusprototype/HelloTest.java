package com.level3.datanucleusprototype;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.level3.tca.model.Resource;
import com.level3.tca.model.Metric;
import com.level3.tca.model.TcaInstance;
import java.util.Collection;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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

      em.getTransaction().begin();

      TcaInstance tca = new TcaInstance();
      tca.setOwner("fred");

      Resource res = new Resource();
      res.setCircuit("54/HCGS/123456/DEMO");

      Metric met = new Metric();
      met.setThreshold("50");

      tca.setMetric(met);
      tca.setResource1(res);

      //em.persist(met);
      em.persist(tca);

//      em.persist(met);
//      em.persist(res);
      em.getTransaction().commit();

   }

   //@Test
   public void retrieve() {

      em.getTransaction().begin();

      Query tcaByGuid = em.createNamedQuery("TcaInstance.findByGuid");
      tcaByGuid.setParameter("guid", "1");
      Collection tcas = tcaByGuid.getResultList();

      for (Object tca : tcas) {
         System.out.println("tca: " + tca.toString());
      }
      // add to first tca
      TcaInstance tca = (TcaInstance) tcas.iterator().next();
      // add resource
      Resource res = new Resource("1", UUID.randomUUID().toString());
      res.setCircuit("54/HCGS/123456/DEMO");
      tca.setResource(res.getGuid());
      tca.setResource1(res);
      
      em.persist(tca);
      
      em.getTransaction().commit();

   }
}
