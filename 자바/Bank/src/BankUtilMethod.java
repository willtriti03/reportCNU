import java.util.ArrayList;
import java.util.Scanner;

public class BankUtilMethod {
	private Scanner sc;
	private ArrayList<BankAccount> baArrayList;
	
	public BankUtilMethod(Scanner sc,ArrayList<BankAccount> baArrayList) {//����Ʈ�� ��ĳ�ʸ� �޾ƿ�
		this.sc =sc;
		this.baArrayList = baArrayList;
	}
	
	private String input(String str) { // �޾ƿ��� ��� �޼ҵ�ȭ
		System.out.print(str+" : ");
		return sc.next();
	}
	
	private int StrToInt(String str) {// ���ڸ� ���� ����� ���ڷ� ��ȯ�ؼ� ��ȯ
		for(int i=0; i< str.length(); ++i) {
			char now = str.charAt(i);
			if('0'<= now && now <='9') {				
			}
			else 
				str = str.replaceAll(""+now, "");
		}
		return Integer.parseInt(str);		
	}
	
	private BankAccount findAccount(int targetAccountNum) {	 //��ġ�ϴ� ������ ã�Ƽ� ��ũ��ī��Ʈ ��ü�� ��ȯ
		BankAccount ba = new BankAccount();
		
		for(int i =0; i< baArrayList.size(); ++i) {
			BankAccount runningAccount = baArrayList.get(i);
			if(runningAccount.matchingAccountNum(targetAccountNum)) {
				return runningAccount;
			}
			else if(i==baArrayList.size()-1) {		// ��ã������ ����ִ� ��ü ��ȯ
				return ba;
			}
		}
		return ba;
	}
	
	private BankAccount findAccount(int targetAccountNum, int passoword) {	// ������� �Է��������� ���
		BankAccount ba = new BankAccount();
		
		for(int i =0; i< baArrayList.size(); ++i) {
			BankAccount runningAccount = baArrayList.get(i);
			if(runningAccount.matchingAccountNum(targetAccountNum,passoword)) {
				return runningAccount;
			}
			else if(i==baArrayList.size()-1) {
				return ba;
			}
		}
		return ba;
	}
	
	public ArrayList<BankAccount> createAccount(){
		int accountNum;
		int password;
		int balance;
		String owner;

		accountNum = StrToInt(input("���¹�ȣ�� �Է��ϼ���"));
		while(findAccount(accountNum).getActive()) {
			accountNum = StrToInt(input("�̹� �����ϴ� ���� ��ȣ �Դϴ� �ٽ� �Է��ϼ���"));
		}

		owner = input("�����ָ� �Է��ϼ���");

		password = StrToInt(input("��й�ȣ�� �Է��ϼ��� (4�ڸ�)"));
		while (true) {
			if (0<=password&&password<=9999) {
				break;
			}
			else {
				password = StrToInt(input("�ٽ� ��й�ȣ�� �Է��ϼ��� (4�ڸ�)"));
			}
		}

		balance = StrToInt(input("�ܾ��� �Է��ϼ���"));


		BankAccount ba = new BankAccount(accountNum, owner, balance, password);
		baArrayList.add(ba);

		return baArrayList;
	}

	public void inquiryAccount() {
		int targetAccountNum = StrToInt(input("��ȸ�� ���¸� �Է��ϼ���"));
		System.out.println(findAccount(targetAccountNum).print());
	}
	
	public void sendMoney() {
		BankAccount toAccount;
		BankAccount targetAccount;
		
		int toAccountNum,amount;
		int targetAccountNum = StrToInt(input("���� ���¸� �Է��ϼ���"));
		int pwd= StrToInt(input("��й�ȣ�� �Է��ϼ���"));

		targetAccount=findAccount(targetAccountNum, pwd);
		if(targetAccount.getActive()) {
			toAccountNum = StrToInt(input("�۱��� ���¸� �Է��ϼ���"));
			amount = StrToInt(input("�۱��� �ݾ��� �Է��ϼ���"));
			toAccount = findAccount(toAccountNum);
			if(toAccount.getActive()) {
				targetAccount.sendAccount(amount, toAccount);
			}
			else
				System.out.println("���� �����Դϴ�");
		}
		else
			System.out.println("���� �����Դϴ�");
	}

}
