package bankaccount;

public class MainClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     BankAccount account = new BankAccount("������", 300000, 0.1);
	      int month;
	      Long money;
	      money = Long.parseUnsignedLong("200");

	      System.out.println("���������� " + account.getName() + "�̰�, �ܾ��� " + account.getBalance() + "�Դϴ�.\n");

	      money = Long.parseUnsignedLong("100000");
	      account.deposit(money);
	      System.out.println("���¿� " + money + "���� �Ա��Ͽ�, �ܾ��� " + account.getBalance() + "�Դϴ�.");

	      money = Long.parseUnsignedLong("100000");
	      account.withdraw(money);
	      System.out.println("���¿� " + money + "���� ����Ͽ�, �ܾ��� " + account.getBalance() + "�Դϴ�.");

	      money = Long.parseUnsignedLong("10000");
	      month = 12;
	      System.out.println("�ſ� " + money + "����" + month + "���� �����ϸ�, �ܾ��� "
	            + account.installmentSavingPredict(month, money) + "���� �� �� �Դϴ�.");

	      money = Long.parseUnsignedLong("2000000");
	      month = 24;
	      System.out.println("10000���� " + month + "���� ���� �����ϸ�, �ܾ��� " + account.fixedDepositPredict(month, 10000)
	            + "���� �� �� �Դϴ�.");

	      money = Long.parseUnsignedLong("200000000000");
	      account.deposit(money);
	      System.out.println("���¿� " + money + "���� �Ա��Ͽ�, �ܾ��� " + account.getBalance() + "�Դϴ�.");
	   }


	
}
