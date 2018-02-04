package com.revature.unit.tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.beans.Bank;
import com.revature.beans.User;

public class BankTests {
	
	private static Logger log = Logger.getRootLogger();
	private Bank bank = Bank.getBank();
	private ArrayList<User> users;
	
	@BeforeClass
	public static void runOnceBeforeAllTests() {
		log.info("Initializing Bank Class tests...");
	}
	
	@Before
	public void createBank() {
		log.info("Setting up the array of Users.");
		users = new ArrayList<User>();
		users.add(new User("ian", "skiing1992"));
		users.add(new User("john", "soccer1984"));
		users.add(new User("mike", "foosball1990"));
		users.add(new User("tim", "tennis1864"));
		
	}
	
	@Test
	public void testingDepositFunction() {
		bank.deposit(users.get(0), 100, "c");
		bank.deposit(users.get(0), 100, "s");
		assertTrue(users.get(0).checking == 100);
	}
	
	@Test
	public void testingWithdrawFunction() {
		bank.deposit(users.get(0), 100, "c");
		bank.withdraw(users.get(0), 100);
		assertTrue(users.get(0).checking == 0);
	}
	
	@Test
	public void testingViewBalFunction() {
		bank.deposit(users.get(0), 100, "c");
		assertTrue(users.get(0).checking == 100);
		bank.deposit(users.get(0), 100, "s");
		assertTrue(users.get(0).savings == 100);
	}
	
	@After
	public void after() {
		log.info("Test ran");
	}
	
	@AfterClass
	public static void afterAll() {
		log.info("Testing completed");
	}

}
