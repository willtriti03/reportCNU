import java.util.Scanner;
/******************************
*
* ��ǻ�����α׷��� 1 (11) HW02
* �й� : 201802135
* �̸� : ������
*
******************************/
public class CylinderVolume {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final float pi = 3.141592f;							//���� �� ����
		int radius;											//������ ����	
		int height;											//���� ����
		float v;											//���� ����
		
		Scanner sc = new Scanner(System.in);				//��ĳ�� ���� �� �ʱ�ȭ
		
		System.out.print("������� �ظ��� �������� �Է��Ͻÿ� :");
		radius = sc.nextInt();
		System.out.print("������� ���̸� �Է��Ͻÿ� : ");
		height = sc.nextInt();								//������ �Է�
		
		v = radius*radius*pi*height;						//���� ���
		System.out.println("������� ���Ǵ� "+v+"�Դϴ�.");
	}

}
