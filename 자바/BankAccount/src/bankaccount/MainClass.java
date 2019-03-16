package bankaccount;

public class MainClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     BankAccount account = new BankAccount("이정준", 300000, 0.1);
	      int month;
	      Long money;
	      money = Long.parseUnsignedLong("200");

	      System.out.println("계좌주인은 " + account.getName() + "이고, 잔액은 " + account.getBalance() + "입니다.\n");

	      money = Long.parseUnsignedLong("100000");
	      account.deposit(money);
	      System.out.println("계좌에 " + money + "원을 입금하여, 잔액은 " + account.getBalance() + "입니다.");

	      money = Long.parseUnsignedLong("100000");
	      account.withdraw(money);
	      System.out.println("계좌에 " + money + "원을 출금하여, 잔액은 " + account.getBalance() + "입니다.");

	      money = Long.parseUnsignedLong("10000");
	      month = 12;
	      System.out.println("매월 " + money + "원씩" + month + "개월 적금하면, 잔액이 "
	            + account.installmentSavingPredict(month, money) + "원이 될 것 입니다.");

	      money = Long.parseUnsignedLong("2000000");
	      month = 24;
	      System.out.println("10000원씩 " + month + "개월 정기 예금하면, 잔액이 " + account.fixedDepositPredict(month, 10000)
	            + "원이 될 것 입니다.");

	      money = Long.parseUnsignedLong("200000000000");
	      account.deposit(money);
	      System.out.println("계좌에 " + money + "원을 입금하여, 잔액은 " + account.getBalance() + "입니다.");
	   }


	
}
