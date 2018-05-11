import java.util.*;

public class BankTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menu;

		Scanner sc = new Scanner(System.in);
		ArrayList<BankAccount> baArrayList = new ArrayList<BankAccount>();
		BankUtilMethod bum = new BankUtilMethod(sc,baArrayList);

		while(true) {
			System.out.println("충남대 은행에 오신 것을 환영합니다.");
			System.out.println("[1]계좌생성 [2]계좌조회 [3]계좌송금 [4]종료");
			menu = sc.nextInt();

			switch (menu) {
			case 1:
				bum.createAccount();
				break;
			case 2:
				bum.inquiryAccount();
				break;
			case 3:
				bum.sendMoney();
				break;
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("1~4의 숫자가 아닙니다. 다시 입력해주세요");
				break;
			}
		}
	}

	

}