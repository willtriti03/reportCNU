import java.util.Scanner;

/****************************** 
 * 
 * ��ǻ�����α׷��� 1 (11) HW05 
 * �й� : 201802135 
 * �̸� : �� �� �� 
 * 
 * ******************************/
public class Datecal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int year,month,date,calDate=0;
		Scanner sc = new Scanner(System.in);    								//����� �Է�
		System.out.print("���� �Է�");
		year = sc.nextInt();
		System.out.print("�� �Է�");
		month= sc.nextInt();
		System.out.print("�� �Է�");
		date = sc.nextInt();
		
		calDate = (year-1900)*365 + (year-1900)/4;								//�⵵�� ��¥ �� ���
		
		for(int i = 1; i<month; ++i ) {											// �� ��¥�� ���
			switch (i) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				calDate+=31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				calDate+=30;
				break;
			case 2:
				if(( year % 4==0 && year%100!=0)||year%400==0) {
					calDate+=29;
				}
				else
					calDate += 28;
				break;
			default:
				break;
			}
			
		
		}
		
		calDate+=date-1;														//��¥�� ����
			
		switch (calDate%7) {													//�ѳ�¥�� 7�� ���� ������ ����
		case 0:
			System.out.println(year+"�� "+month+"�� "+date+"���� �������Դϴ�");
			break;
		case 1:
			System.out.println(year+"�� "+month+"�� "+date+"���� ȭ�����Դϴ�");
			break;
		case 2:
			System.out.println(year+"�� "+month+"�� "+date+"���� �������Դϴ�");
			break;
		case 3:
			System.out.println(year+"�� "+month+"�� "+date+"���� ������Դϴ�");
			break;
		case 4:
			System.out.println(year+"�� "+month+"�� "+date+"���� �ݿ����Դϴ�");
			break;
		case 5:
			System.out.println(year+"�� "+month+"�� "+date+"���� ������Դϴ�");
			break;
		case 6:
			System.out.println(year+"�� "+month+"�� "+date+"���� �Ͽ����Դϴ�");
			break;

		}

	}

}

