import java.util.Scanner;

/****************************** 
 * 
 *  ��ǻ�����α׷��� 1 (11) HW06 
 *  �й� : 201802135 
 *  �̸� : �� �� �� 
 *  
 *  ******************************/
public class CharCountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("���ڿ� : ");
		String str = sc.nextLine(); 		//���ڿ��� �Է¹���
		str = str.toLowerCase();			//ó���� ���ϰ� �ϱ� ���� ��� ���ڸ� �ҹ��ڷ� ����
		int m=0;							//������ ������ ����
		int j=0;							//������ ������ ����
		
		for(int i = 0; i<str.length(); ++i ) {	//���ڿ��� ���ۺ��� ������ �� ������ ����
			char c=str.charAt(i);
			switch(c) {				//�����ϳ��ϳ����� �˻� ����
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				m++;
				break;							//�����̸� ���� ���� �߰�					
			default:							//�������� ��� ��츦 �Ÿ�
				if('a'<=c&&c<='z')				//�������߿� �����̸� ���� ���� �߰�
					j++;
				break;
			}
		}
		System.out.println("���� : "+ j);			//���
		System.out.println("���� : "+ m);
		
	}

}
