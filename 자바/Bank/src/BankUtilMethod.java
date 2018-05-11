import java.util.ArrayList;
import java.util.Scanner;

public class BankUtilMethod {
	private Scanner sc;
	private ArrayList<BankAccount> baArrayList;
	
	public BankUtilMethod(Scanner sc,ArrayList<BankAccount> baArrayList) {//리스트와 스캐너를 받아옴
		this.sc =sc;
		this.baArrayList = baArrayList;
	}
	
	private String input(String str) { // 받아오는 기능 메소드화
		System.out.print(str+" : ");
		return sc.next();
	}
	
	private int StrToInt(String str) {// 문자를 전부 지우고 숫자로 전환해서 반환
		for(int i=0; i< str.length(); ++i) {
			char now = str.charAt(i);
			if('0'<= now && now <='9') {				
			}
			else 
				str = str.replaceAll(""+now, "");
		}
		return Integer.parseInt(str);		
	}
	
	private BankAccount findAccount(int targetAccountNum) {	 //일치하는 계정을 찾아서 뱅크어카운트 객체로 반환
		BankAccount ba = new BankAccount();
		
		for(int i =0; i< baArrayList.size(); ++i) {
			BankAccount runningAccount = baArrayList.get(i);
			if(runningAccount.matchingAccountNum(targetAccountNum)) {
				return runningAccount;
			}
			else if(i==baArrayList.size()-1) {		// 못찾았을시 비어있는 객체 반환
				return ba;
			}
		}
		return ba;
	}
	
	private BankAccount findAccount(int targetAccountNum, int passoword) {	// 비번까지 입력했을때의 경우
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

		accountNum = StrToInt(input("계좌번호를 입력하세요"));
		while(findAccount(accountNum).getActive()) {
			accountNum = StrToInt(input("이미 존재하는 계좌 번호 입니다 다시 입력하세요"));
		}

		owner = input("예금주를 입력하세요");

		password = StrToInt(input("비밀번호를 입력하세요 (4자리)"));
		while (true) {
			if (0<=password&&password<=9999) {
				break;
			}
			else {
				password = StrToInt(input("다시 비밀번호를 입력하세요 (4자리)"));
			}
		}

		balance = StrToInt(input("잔액을 입력하세요"));


		BankAccount ba = new BankAccount(accountNum, owner, balance, password);
		baArrayList.add(ba);

		return baArrayList;
	}

	public void inquiryAccount() {
		int targetAccountNum = StrToInt(input("조회할 계좌를 입력하세요"));
		System.out.println(findAccount(targetAccountNum).print());
	}
	
	public void sendMoney() {
		BankAccount toAccount;
		BankAccount targetAccount;
		
		int toAccountNum,amount;
		int targetAccountNum = StrToInt(input("본인 계좌를 입력하세요"));
		int pwd= StrToInt(input("비밀번호를 입력하세요"));

		targetAccount=findAccount(targetAccountNum, pwd);
		if(targetAccount.getActive()) {
			toAccountNum = StrToInt(input("송금할 계좌를 입력하세요"));
			amount = StrToInt(input("송금할 금액을 입력하세요"));
			toAccount = findAccount(toAccountNum);
			if(toAccount.getActive()) {
				targetAccount.sendAccount(amount, toAccount);
			}
			else
				System.out.println("없는 계좌입니다");
		}
		else
			System.out.println("없는 계좌입니다");
	}

}
