package bankaccount;

public class BankAccount {
	private String name;
	private long balance;
	private double rate;

	public BankAccount(String name, int balance, double rate) { // 생성자 인자값으로 이름 잔액 이자율을 받는다											
		setBankAccount(name, balance, rate);  // 추후 잔액처리를 위해 long형으로 변환한다
	}

	public String getName() {		//이름을 받아오는 접근자
		return name;
	}

	public long getBalance() {		//잔액을 받아오는 접근자
		return balance;
	}

	public void setBankAccount(String name, long balance, double rate) {   // 생성자로 받아온 값들을 저장하고 인트형으로 들어온 잔액을 롱형으로 변환
		this.name = name;
		this.balance = balance;
		this.rate = rate;
	}

	public long deposit(long money) {						// 인자로 받아들여온 값을 잔액에 더하는 입금 함수 
		balance = balance + money;
		return balance;
	}

	public long withdraw(long money) {						//  인자값으로 받아온 값만큼 잔액이 그 이상이 있다면 출금한다	
		if (balance < money)
			System.out.println("잔액이 부족합니다.");
		else
			balance = balance - money;

		return balance;
	}

	public long installmentSavingPredict(int month, long money) {  // 적금할 금액과 달수를 받아서 계산하여  계좌의 잔액과 더해서 적금예상 금액을 리턴한다.
		long num;
		num = (long) (money * rate / 12 * (month * (month + 1) / 2) + money * month);
		num = num + balance;
		return num;
	}

	public long fixedDepositPredict(int month, long money) { // 정기예금할 금액과 달수를 받아서 계산하여  계좌의 잔액과 더해서 정기 예금 예상 금액을 리턴한다.
		long num = 0;
		long n = balance + money;
		double r = Math.pow(1 + (rate / 12), month);
		num = (long) (n * (r - 1));
		n = num + n;
		return n;
	}
}