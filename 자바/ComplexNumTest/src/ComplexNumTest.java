import java.util.Scanner;
/****************************** 
 * 
 *  ��ǻ�����α׷��� 1 (11) HW06 
 *  �й� : 201802135 
 *  �̸� : �� �� �� 
 *  
 *  ******************************/
public class ComplexNumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);					// ���Ҽ����� �����Ͱ� �Է�
		System.out.print("���Ҽ� 1�� �Ǽ��� ������� �Է��Ͻÿ� : ");
		int r1 = sc.nextInt();
		int i1= sc.nextInt();
		System.out.print("���Ҽ� 2�� �Ǽ��� ������� �Է��Ͻÿ� : ");
		int r2 = sc.nextInt();
		int i2= sc.nextInt();
				
		ComplexNum c1 = new ComplexNum(r1, i1);			//�Է¹��� �����ͷ� ���Ҽ� ��ü ����
		ComplexNum c2 = new ComplexNum(r2, i2);
		
		System.out.println("���Ҽ� 1 : "+ c1.getComplexNum());		//���Ҽ� ���
		System.out.println("���Ҽ� 2 : "+ c2.getComplexNum());
		
		System.out.println("���Ҽ�1 + ���Ҽ�2 = "+ c1.add(c2));		//���� ���
		System.out.println("���Ҽ�1 - ���Ҽ�2 = "+ c1.sub(c2));		//���� ���
		System.out.println("���Ҽ�1 * ���Ҽ�2 = "+ c1.mul(c2));		//���� ���
		System.out.println("���Ҽ�1 / ���Ҽ�2 = "+ c1.div(c2));		//������ ���
	}

}
