import java.util.Scanner;

/****************************** 
 * 
 *  ��ǻ�����α׷��� 1 (11) HW03 
 *  �й� : 201802135 
 *  �̸� : �� �� �� 
 *  
 ******************************/

public class Thaies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double ac,ae,bc;
		///////////////////�Է� ó��////////////////
		System.out.print("AC : ");					
		ac = sc.nextDouble();
		System.out.print("AE : ");
		ae = sc.nextDouble();
		System.out.print("BC : ");
		bc = sc.nextDouble();
		////////////////////////////////////////
		System.out.println("DE : "+((ae*bc)/ac));
		/*������ ���� ������ ���� �����Ƿ� ���� ���� de�� ���� �����ϸ�
			 de = (ae*bc)/ac �̴�
		*/
	}

}
