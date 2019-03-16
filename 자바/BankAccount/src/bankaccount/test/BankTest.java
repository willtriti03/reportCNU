package bankaccount.test;

import static org.junit.Assert.*;

import org.junit.Test;

import bankaccount.BankAccount;

public class BankTest {
	BankAccount bankAccount = new BankAccount("정준", 10000, 1.0);
	BankAccount bk = new BankAccount("asd",300000, 0.1);

	@Test
	public void testGetName() {
		assertEquals("정준", bankAccount.getName());
	}

	@Test
	public void testGetBalance() {
		assertEquals(10000, bankAccount.getBalance());
	}

	@Test
	public void testDeposit() {
		assertEquals(20000, bankAccount.deposit(10000));
	}

	@Test
	public void testWithdraw() {
		BankAccount bankAccount2 = new BankAccount("정준", 10000, 1.0);
		assertEquals(0, bankAccount2.withdraw(10000));
	}

	@Test
	public void testInstallmentSavingPredict() {
		assertEquals(426500,bk.installmentSavingPredict(12, 10000));
	}

	@Test
	public void testFixedDepositPredict() {
		   assertEquals(2806899,bk.fixedDepositPredict(24, 2000000));
	}

}
