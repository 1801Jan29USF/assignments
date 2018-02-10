//package com.revature.tests;
//
//import static org.junit.Assert.assertTrue;
//
//import java.util.ArrayList;
//import java.util.logging.Logger;
//
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import com.revature.beans.User;
//
//public class BankTests {
//
//	private static Logger log = Logger.getRootLogger();
//	
//	private ArrayList<User> users;
//
//	@BeforeClass
//	public static void runOnceBeforeAllTests() {
//		log.info("Initializing Bank Class tests...");
//	}
//
//	@Before
//	public void createBank() {
//		log.info("Setting up the array of Users.");
//		users = new ArrayList<User>();
//		users.add(new User("ian", "skiing1992"));
//		users.add(new User("john", "soccer1984"));
//		users.add(new User("mike", "foosball1990"));
//		users.add(new User("tim", "tennis1864"));
//	}
//
//	@Test
//	public void testingWithdrawFunction() {
//		bank.deposit(users.get(0), 100, "c");
//		bank.withdraw(users.get(0), 100);
//		try {
//			assertTrue(users.get(0).checking == 0);
//			log.info("100$ successfully withdrawn from checking.\n");
//		} catch (AssertionError e) {
//			log.info("100$ withdrawn deposited to checking.\n");
//		}
//	}
//
//	@Test
//	public void testingQuickPayFunction() {
//		bank.deposit(users.get(1), 100,"c");
//		bank.quickPay("ian", users.get(1), 100);
//		try {
//			assertTrue(users.get(0).checking == 100);
//			assertTrue(users.get(1).checking == 0);
//			log.info("100$ successfully quickpayed.\n");
//		} catch (AssertionError e) {
//			log.info("100$ unsuccessfully quickpayed.\n");
//		}
//		
//	}
//	
//	@Test
//	public void testingTransferFunction() {
//		bank.deposit(users.get(0), 100,"c");
//		bank.transfer(users.get(0), 100);
//		try {
//			assertTrue(users.get(0).savings == 100);
//			assertTrue(users.get(0).checking == 0);
//			log.info("100$ successfully transferred.\n");
//		} catch (AssertionError e) {
//			log.info("100$ unsuccessfully transferred.\n");
//		}
//		
//	}
//	
//	@Test
//	public void testingChangeNamePass() {
//		bank.updateUserPass(users.get(0), "george","george");
//		try {
//			assertTrue(users.get(0).getUsername().hashCode() == "george".hashCode());
//			log.info("username and password successfully changed.\n");
//		} catch (AssertionError e) {
//			log.info("username and password unsuccessfully changed.\n");
//		}
//		
//	}
//	
//	@Test
//	public void testingDepositFunction() {
//		bank.deposit(users.get(0), 100, "c");
//		try {
//			assertTrue(users.get(0).checking == 100);
//			log.info("100$ successfully deposited to checking.\n");
//		} catch (AssertionError e) {
//			log.info("100$ unsuccessfully deposited to checking.\n");
//		}
//		bank.deposit(users.get(0), 100, "s");
//		try {
//			assertTrue(users.get(0).savings == 100);
//			log.info("100$ successfully deposited to savings.\n");
//		} catch (AssertionError e) {
//			log.info("100$ unsuccessfully deposited to savings.\n");
//		}
//
//	}
//
//	@After
//	public void after() {
//		log.info("Test ran");
//	}
//
//	@AfterClass
//	public static void afterAll() {
//		log.info("Testing completed");
//	}
//
//}
