import java.util.Scanner;

/****************************** 
 * 
 *  ��ǻ�����α׷��� 1 (11) HW01 
 *  �й� : 201802135 
 *  �̸� : �� �� �� 
 *
 ******************************/

public class F2C {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float f_fTemper; 													//ȭ�� �µ� ����
		float f_cTemper; 													//���� �µ� ����
		Scanner sc = new Scanner(System.in);								// ��ĳ�� ���� ���� �� �ʱ�ȭ
		
		System.out.print("ȭ���µ��� �Է��Ͻÿ�: ");
		f_fTemper = sc.nextFloat(); 										//ȭ���µ� �Է�
		f_cTemper = (float) ((5.0/9.0)*(f_fTemper-32.0));					//ȭ���µ��� �����µ� ���
		System.out.println("ȭ�� �µ��� "+f_cTemper+" �����µ��Դϴ�.");
	}

}
