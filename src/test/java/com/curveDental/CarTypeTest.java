// package com.curveDental;
//
// import org.junit.After;
// import org.junit.Assert;
// import org.junit.Before;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
// import com.curveDental.dao.CarTypeDAO;
// import com.curveDental.model.CarType;
//
// @RunWith(SpringJUnit4ClassRunner.class)
// public class CarTypeTest {
//
// @Autowired
// CarTypeDAO carTypeDAO;
//
// @Before
// public void setUp() {
// CarType ct1 = new CarType("Gas");
// CarType ct2 = new CarType("Diesel");
// CarType ct3 = new CarType("Electric");
// CarType ct4 = new CarType("Hybrid");
//
// carTypeDAO.insert(ct1);
// carTypeDAO.insert(ct2);
// carTypeDAO.insert(ct3);
// carTypeDAO.insert(ct4);
// }
//
// @Test
// public void testFindById() {
// CarType cartype = carTypeDAO.findById(1);
//
// Assert.assertNotNull(cartype);
// Assert.assertEquals(1, cartype.getCarTypeId().intValue());
// Assert.assertEquals("Gas", cartype.getCarTypeName());
//
// }
//
// @After
// public void tearDown() {
// // db.shutdown();
// }
//
// }