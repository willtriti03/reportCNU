import java.util.Scanner;

/****************************** 
 *  
 *   ��ǻ�����α׷��� 1 (11) HW04 
 *   �й� : 201802135 
 *   �̸� : �� �� �� 
 *   
 ******************************/
public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�����ϳ� �Է� :");													//�Է�ó��
		char mos = sc.next().charAt(0);
		
		System.out.print("���� �ΰ��� �Է��Ͻÿ�: ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		int answer=-1;																	//���� ���� ����
		if(mos=='+') { 																	//���ϱ��� ���
			answer = num1 +num2;
			System.out.println(num1 + " " + mos + " "+ num2 +" = "+answer);
		}
		else if (mos=='-') {															//�����ϰ��
			answer = num1 - num2;
			System.out.println(num1 + " " + mos + " "+ num2 +" = "+answer);
		}
		else if (mos == '*') {															//���ϱ��� ���
			answer = num1 * num2;
			System.out.println(num1 + " " + mos + " "+ num2 +" = "+answer);
		}	
		else if(mos == '/') {															//�������� ���
			if(num2 ==0) {																//�и� 0�� ���
				System.out.println("�и� 0�̸� ���� �� �����ϴ�.");
			}
			else {																		//�и� 0�� �ƴ� ���
				answer = num1 / num2;
				System.out.println(num1 + " " + mos + " "+ num2 +" = "+answer);
			}
		}
		else {																			//�����ȣ�� �ƴ� �ٸ� ���ڰ� ������ ���
			System.out.println("���� ��ȣ�� �ƴմϴ�.");
			
		}
	}

}
