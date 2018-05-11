public class BankAccount {

	String owner; // 예금주
	int balance; // 잔액 표시
	int password; // 계좌 비밀번호
	int accountNumber; // 계좌번호
	boolean active;	//계정 활성화 여부

	public BankAccount() {	//비활성 계좌 생성
		active = false;
	}
	public BankAccount(int accountNumber, String owner, int balance, int password) {// 활성 계좌 생성
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.password = password;
		this.owner = owner;
		active = true;
	}

	public void deposit(int amount) { // 저금 기능 메소드
		balance += amount; // amount만큼 해당 잔액 증가
	}

	public void withdraw(int amount) {// 인출 기능 메소드
		balance -= amount; // amount만큼 해당 잔액 감소
	}

	public int sendAccount(int amount, BankAccount otherAccount) { // 계좌이체 기능 메소드
		if (balance - amount >= 0) {
			withdraw(amount);
			otherAccount.deposit(amount);
			return 1; // 성공하면 1반환
		} else
			return 0;
	}
	public boolean matchingAccountNum(int accountNum) {	//계좌번호를 받아서 일치하면 참 반환 아닐시 거짓 반환
		if(accountNum == accountNumber) 
			return true;
		else
			return false;
	}
	public boolean matchingAccountNum(int accountNum,int password) { //계좌번호, 비밀번호를 받아서 일치하면 참 반환 아닐시 거짓 반환
		if(accountNum == accountNumber && password == this.password) 
			return true;
		else
			return false;
	}
	
	public String print() { // 계정 출력 함수
		if(active)
			return "*****************************\n"+
				"계좌번호 : "+accountNumber+
				"\n예금주 : "+owner+
				"\n잔고 : "+balance+
				"\n*****************************";
		else
			return "조회한 계좌가 존재하지 않습니다";
	}
	public boolean getActive() {	//계정 활성화 여부 반환
		return active;
	}

}

