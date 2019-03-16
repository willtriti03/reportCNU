package bankaccount;

public class BankAccount {
	private String name;
	private long balance;
	private double rate;

	public BankAccount(String name, int balance, double rate) { // ������ ���ڰ����� �̸� �ܾ� �������� �޴´�											
		setBankAccount(name, balance, rate);  // ���� �ܾ�ó���� ���� long������ ��ȯ�Ѵ�
	}

	public String getName() {		//�̸��� �޾ƿ��� ������
		return name;
	}

	public long getBalance() {		//�ܾ��� �޾ƿ��� ������
		return balance;
	}

	public void setBankAccount(String name, long balance, double rate) {   // �����ڷ� �޾ƿ� ������ �����ϰ� ��Ʈ������ ���� �ܾ��� �������� ��ȯ
		this.name = name;
		this.balance = balance;
		this.rate = rate;
	}

	public long deposit(long money) {						// ���ڷ� �޾Ƶ鿩�� ���� �ܾ׿� ���ϴ� �Ա� �Լ� 
		balance = balance + money;
		return balance;
	}

	public long withdraw(long money) {						//  ���ڰ����� �޾ƿ� ����ŭ �ܾ��� �� �̻��� �ִٸ� ����Ѵ�	
		if (balance < money)
			System.out.println("�ܾ��� �����մϴ�.");
		else
			balance = balance - money;

		return balance;
	}

	public long installmentSavingPredict(int month, long money) {  // ������ �ݾװ� �޼��� �޾Ƽ� ����Ͽ�  ������ �ܾװ� ���ؼ� ���ݿ��� �ݾ��� �����Ѵ�.
		long num;
		num = (long) (money * rate / 12 * (month * (month + 1) / 2) + money * month);
		num = num + balance;
		return num;
	}

	public long fixedDepositPredict(int month, long money) { // ���⿹���� �ݾװ� �޼��� �޾Ƽ� ����Ͽ�  ������ �ܾװ� ���ؼ� ���� ���� ���� �ݾ��� �����Ѵ�.
		long num = 0;
		long n = balance + money;
		double r = Math.pow(1 + (rate / 12), month);
		num = (long) (n * (r - 1));
		n = num + n;
		return n;
	}
}