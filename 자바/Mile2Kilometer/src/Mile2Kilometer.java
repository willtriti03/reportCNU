import java.util.Scanner;

/****************************** 
 * 
 *  ��ǻ�����α׷��� 1 (11) HW01 
 *  �й� : 201802135 
 *  �̸� : �� �� �� 
 *
 ******************************/

public class Mile2Kilometer {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i_mile; 															//������ �޴� ��Ʈ�� ����
		
		Scanner sc= new Scanner(System.in); 									//�Է��� �ޱ� ���� ��ĳ�� ���� �� ���� �ʱ�ȭ
		
		System.out.print("������ �Է��Ͻÿ�: ");
		i_mile = sc.nextInt(); 													// ���� �Է��� �޾ƿ�
		System.out.println(i_mile+"���� "+((float)i_mile*1.609)+"Km�Դϴ�"); 		//������ km�� �ٲ㼭 ���
	}

}
