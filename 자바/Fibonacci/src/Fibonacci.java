import java.util.Scanner;
/****************************** 
 * 
 * ��ǻ�����α׷��� 1 (11) HW05 
 * �й� : 201802135 
 * �̸� : �� �� �� 
 * 
 * ******************************/
public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("����� ���� ����: ");
		int cnt = sc.nextInt();							//���� ���� �Է�
		int a=0,b=1,c;
		for(int i=1; i<=cnt; ++i) {						//�� ������ŭ �ݺ�
			if(i==1) {									//1���ϰ��
				a=0;
				System.out.println("f"+i+": "+a);
			}
			else if(i==2) {								//2���ϰ��
				b=1;
				System.out.println("f"+i+": "+b);
			}
			else {										//3���̻��� ���
				c= a+b;									//3���̻��� ���� �����
				System.out.println("f"+i+": "+c);
				a=b;									//����� ���� ������ �� ���� ���� ����� ���� ù ������ ����
				b=c;									//���� ���� �ι�° ������ ����
			}
		}
	}

}
