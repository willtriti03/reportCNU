import java.util.*;

public class BankTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menu;

		Scanner sc = new Scanner(System.in);
		ArrayList<BankAccount> baArrayList = new ArrayList<BankAccount>();
		BankUtilMethod bum = new BankUtilMethod(sc,baArrayList);

		while(true) {
			System.out.println("�泲�� ���࿡ ���� ���� ȯ���մϴ�.");
			System.out.println("[1]���»��� [2]������ȸ [3]���¼۱� [4]����");
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
				System.out.println("1~4�� ���ڰ� �ƴմϴ�. �ٽ� �Է����ּ���");
				break;
			}
		}
	}

	

}