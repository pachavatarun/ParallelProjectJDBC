package com.cg.account.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.cg.account.bean.Account;
import com.cg.account.exception.AccountException;
import com.cg.account.service.AccountServiceImpl;
import com.cg.account.service.AccountService;



public class AccountTest {


	private AccountService service;

	@Before

	public void init() {
		service = new AccountServiceImpl();
	}

 
	
	
	@Test
	public void testAccountCreationForName() {
	Account acc = new Account();
	acc.setMobileNo("9638527410");
	acc.setName("mahi");
	acc.setEmail("mahi28@gmail.com");
	acc.setBalance(500.0);
	try {
	service.createAccount(acc);
	} catch (AccountException e) {
		assertEquals("Name should start with capital letter and should contain only Alphabets", e.getMessage());
	}
	}	
	
	@Test
	public void testCreateAccountForNameIsEmpty() {
		Account acc = new Account();
		acc.setMobileNo("9382710456");
		acc.setName("");
		acc.setEmail("ajay@gmail.com");
		acc.setBalance(200.0);
		try {
			service.createAccount(acc);
		} catch (AccountException e) {
			assertEquals("Name can't be empty", e.getMessage());
		}
	}	
	
	
	
	@Test
	public void testCreateAccount() {
	Account acc = new Account();
	acc.setMobileNo("9876543210");
	acc.setName("Deeraj");
	acc.setEmail("deeru@gmail.com");
	acc.setBalance(200.0);
	 
	try {
	String s=service.createAccount(acc);
	assertNotNull(s);
	} catch (AccountException e) {
	//System.out.println(e.getMessage());
	 
	}
	 
	}
	 
	
	@Test
	public void testShowBalanceForMobileNo() {
		
		try {
			service.showBalance("98059");
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
	}	

	
	@Test
	public void testShowBalanceForMobileNoDoesNotExist() {
		
		try {
			service.showBalance("818580166");
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
	}
	
	
	@Test
	public void testDepositForMobileNo() {
		Account acc=new Account();
		acc.setMobileNo("963874");
		try {
			service.deposit(acc.getMobileNo(), 500);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
	}
	
	
	@Test
	public void testDepositForDepositAmt1() {
		Account acc=new Account();
		acc.setMobileNo("9989796959");
		try {
			service.deposit(acc.getMobileNo(), -300);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("Deposit amount must be greater than zero",e.getMessage());
		}
	}	
	
	@Test
	public void testDeposit() {
		Account acc=new Account();
		acc.setMobileNo("9989796959");
		try {
			Account acc1=service.deposit(acc.getMobileNo(), 200);
			assertNotNull(acc1);
		} catch (AccountException e) {
			System.out.println(e.getMessage());
			}
	}	
	
	
	@Test
	public void testWithDrawForMobileNo() {
		Account acc=new Account();
		acc.setMobileNo("987452");
		try {
			service.withdraw(acc.getMobileNo(), 600);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
	}
	
	@Test
	public void testWithdrawForMobileNoDoesNotExist() {
		Account acc=new Account();
		acc.setMobileNo("9505934512");
		try {
			service.withdraw(acc.getMobileNo(), 230);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertNotEquals("The mobile number does not exist",e.getMessage());
		}
	}
	
	
	@Test
	public void testWithdrawForAmt() {
		Account acc=new Account();
		acc.setMobileNo("9989796959");
		try {
			service.withdraw(acc.getMobileNo(), -230);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("The amount to be withdrawn should be greater than available balance and greater than zero",e.getMessage());
		}
	}
	
	
	@Test
	public void testFundTransferForMobileNo() {
		Account acc=new Account();
		Account acc2=new Account();
		acc.setMobileNo("95059345");
		acc2.setMobileNo("23456");
		try {
			service.fundTransfer(acc.getMobileNo(),acc2.getMobileNo(), 230);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
	}
	
	@Test

	public void testFundTransferForMobileNoDoesNotExist() {
		Account acc=new Account();
		Account acc2=new Account();
		acc.setMobileNo("9989796959");
		acc2.setMobileNo("9849228579");
		try {
			service.fundTransfer(acc.getMobileNo(), acc2.getMobileNo(),  230);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertNotEquals("The mobile number does not exist",e.getMessage());
		}
	}
	
	@Test
	public void testFundTransferForAmt() {
		Account acc=new Account();
		Account acc2=new Account();
		acc.setMobileNo("9989796959");
		acc2.setMobileNo("9849228579");
		try {
			service.fundTransfer(acc.getMobileNo(), acc2.getMobileNo(),  -230);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
		assertEquals("The amount to be withdrawn should be greater than available balance and greater than zero",e.getMessage());
		}
	}
	
	@Test
	public void testFundTransfer() {
		Account acc=new Account();
		Account acc2=new Account();
		acc.setMobileNo("9989796959");
		acc2.setMobileNo("9849228579");
		try {
			assertTrue(service.fundTransfer(acc.getMobileNo(), acc2.getMobileNo(),  230));
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testPrinttransactionDetails() {
		Account acc=new Account();
		acc.setMobileNo("9849228579");
		try {
			Account acc1=service.printTransactionDetails(acc.getMobileNo());
			assertNotNull(acc1);
		} catch (AccountException e) {
			System.out.println(e.getMessage());
		}
	}
	
	}
	
	