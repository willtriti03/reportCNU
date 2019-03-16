package chocolatejar;

import java.util.Random;
import java.util.Scanner;

public class ChocolateJarMain {
	public static void main(String[] args) {
		int pick;																//�÷��̾��� ���� ������ �����ϴ� ����
		int time = 1;															//���� ����ϴ� ����
		int maxMake,take;														//��ǻ���� �ִ� ������, ��ǻ���� ���� ����
		
		Random random = new Random();											//���� �ν��Ͻ� ����		
		Scanner sc = new Scanner(System.in);									//��ĳ�� �ν��Ͻ� ����
		ChocolateJar chocolateJar = new ChocolateJar();							//������ ���� ���ݸ� �׾Ƹ� ����
																					
		System.out.println("������ �����մϴ�.");										//���� �ʱ� ���� Ȯ��
		System.out.println("�׾Ƹ����� "+ chocolateJar.getItem() + "���� �������� �ֽ��ϴ�.");
		System.out.println(chocolateJar.status());
		System.out.println("1~3���� �������� ���� �� ������ ĥ���� ������ �й��մϴ�.");
		System.out.println("����!\n\n");
		
		
		while(true){															//���� ���� �ݺ������ֱ� ���� while��
			System.out.println("+----------- "+time+" ------------+");			//�� �� ǥ��
			System.out.print("�� ���� �������? (1~3) ");
			pick = sc.nextInt();												//�÷��̾��� ���� ���� �Է�
			chocolateJar.takeItem(pick);										//�׾Ƹ����� ������ŭ ����
			System.out.println("�÷��̾ "+pick+"���� ���ݸ��� �������ϴ�. ");				//���
			System.out.println(chocolateJar.status());
			
			if(chocolateJar.getItem() == 1){									//�� �̰� �� ���� �������� �� ���� ĥ�������� �÷��̾��� �¸��� ���� ��
				System.out.println("�÷��̾� �¸�!");
				break;
			}
			else if (chocolateJar.getItem() == 0){								//�� �̰� �� ��������ĥ���� ���� ��������  ��ǻ���� �¸��� ���� ��
				System.out.println("��ǻ�� �¸�!");
				break;
			}
			
			maxMake = Math.min(3,chocolateJar.getItem() - 1);					//��ǻ�Ͱ� ���� ������ �ִ밪 ����
			take = random.nextInt(1000)%maxMake%3+1;							//�ִ밪�̳� ������ ����
			chocolateJar.takeItem(take);										//�׾Ƹ����� take���� ��ŭ ����
			
			System.out.println("��ǻ�ʹ� "+take+"���� ���ݸ��� �������ϴ�. ");					//���
			System.out.println(chocolateJar.status());
			
			if(chocolateJar.getItem() == 1){									//�� �̰� �� ���� �������� �� ���� ĥ�������� ��ǻ���� �¸��� ���� ��
				System.out.println("��ǻ�� �¸�!");
				break;
			}
			else if (chocolateJar.getItem() == 0){								//�� �̰� �� ��������ĥ���� ���� ��������  �÷��̾��� �¸��� ���� ��
				System.out.println("�÷��̾� �¸�!");
				break;
			}
			
			time++;																//ȸ�� ����
		}
	}
}
