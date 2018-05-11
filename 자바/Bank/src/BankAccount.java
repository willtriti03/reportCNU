public class BankAccount {

	String owner; // ������
	int balance; // �ܾ� ǥ��
	int password; // ���� ��й�ȣ
	int accountNumber; // ���¹�ȣ
	boolean active;	//���� Ȱ��ȭ ����

	public BankAccount() {	//��Ȱ�� ���� ����
		active = false;
	}
	public BankAccount(int accountNumber, String owner, int balance, int password) {// Ȱ�� ���� ����
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.password = password;
		this.owner = owner;
		active = true;
	}

	public void deposit(int amount) { // ���� ��� �޼ҵ�
		balance += amount; // amount��ŭ �ش� �ܾ� ����
	}

	public void withdraw(int amount) {// ���� ��� �޼ҵ�
		balance -= amount; // amount��ŭ �ش� �ܾ� ����
	}

	public int sendAccount(int amount, BankAccount otherAccount) { // ������ü ��� �޼ҵ�
		if (balance - amount >= 0) {
			withdraw(amount);
			otherAccount.deposit(amount);
			return 1; // �����ϸ� 1��ȯ
		} else
			return 0;
	}
	public boolean matchingAccountNum(int accountNum) {	//���¹�ȣ�� �޾Ƽ� ��ġ�ϸ� �� ��ȯ �ƴҽ� ���� ��ȯ
		if(accountNum == accountNumber) 
			return true;
		else
			return false;
	}
	public boolean matchingAccountNum(int accountNum,int password) { //���¹�ȣ, ��й�ȣ�� �޾Ƽ� ��ġ�ϸ� �� ��ȯ �ƴҽ� ���� ��ȯ
		if(accountNum == accountNumber && password == this.password) 
			return true;
		else
			return false;
	}
	
	public String print() { // ���� ��� �Լ�
		if(active)
			return "*****************************\n"+
				"���¹�ȣ : "+accountNumber+
				"\n������ : "+owner+
				"\n�ܰ� : "+balance+
				"\n*****************************";
		else
			return "��ȸ�� ���°� �������� �ʽ��ϴ�";
	}
	public boolean getActive() {	//���� Ȱ��ȭ ���� ��ȯ
		return active;
	}

}

