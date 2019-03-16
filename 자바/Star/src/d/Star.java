package d;

import java.util.Scanner;

public class Star {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int line;												//����� ���� ������ �Է� �޴� ����

		Scanner sc = new Scanner(System.in);					//�Է��� �ޱ� ���� ��ĳ�� ���� �� �ʱ�ȭ
														
		System.out.print("�� ���� �ٷ� ���� ��� �ұ��?  ");			//�Է��� �޾ƿ��� �޾ƿ¸�ŭ ���
		line = sc.nextInt();
		System.out.println("========== 1�� ==========");
		printStar1(line);

		
		System.out.print("�� ���� �ٷ� ���� ��� �ұ��?  ");			//�Է��� �޾ƿ��� �޾ƿ¸�ŭ ���
		line = sc.nextInt();
		System.out.println("========== 2�� ==========");
		printStar2(line);
		
		
		System.out.print("�� ���� �ٷ� ���� ��� �ұ��?  ");			//�Է��� �޾ƿ��� �޾ƿ¸�ŭ ���
		line = sc.nextInt();
		System.out.println("========== 3�� ==========");
		printStar3(line);
		
	}

	public static void printStar1(int line) {				  	//1�� ��� �Լ�    ���� : line->����� ���� ���� 
		if (line <= 0) line = 5;								//���� ������ ���� 0������ ��� ����Ʈ ���� 5�� ���� 
		
		for(int i =0; i< line; ++i) {							//���� ������ŭ �ݺ� �����ֱ� ���� �ݺ���
			for(int j =0; j <= i; ++j) {						//���� ��������� ����ϱ� ���� ��µ� ���� ������ �����ϴ� �ݺ���
				System.out.print("*");
			}
			System.out.println();								//���� �� ������� �� �� ����� ���� ���̹Ƿ� �ٺ��� 
		}
	}

	public static void printStar2(int line) {					//2�� ��� �Լ�    ���� : line->����� ���� ���� 
		if (line <= 0) line = 5;								//���� ������ ���� 0������ ��� ����Ʈ ���� 5�� ���� 
		
		for(int i =0; i< line; ++i) {							//���� ������ŭ �ݺ� �����ֱ� ���� �ݺ���
			for(int j =0; j < line - i; ++j) {					//���� ��������� ����ϱ� ���� ��µ� ���� ������ �����ϴ� �ݺ���
				System.out.print("*");
			}
			System.out.println();								//���� �� ������� �� �� ����� ���� ���̹Ƿ� �ٺ��� 
		}
	}

	public static void printStar3(int line) {					//3�� ��� �Լ�    ���� : line->����� ���� ���� 
		if (line <= 0) line = 9;								//���� ������ ���� 0������ ��� ����Ʈ ���� 9�� ���� 
		else if (line % 2 == 0) line += 1;						//���� ������ ¦���̸� ���̾Ƹ�尡 ��µ��� �������� ¦���� �������� Ȧ���� �ٲ��ش�
		
		int starCnt = 1;										//��µ� ���� ������ �����ϴ� ���� �� 1�� �ʱ�ȭ
		
		for(int i =0; i < line/2+1; ++i) {						//���̾Ƹ���� ���� ���ݰ� ��� �ٱ��� ���
			for(int j  = 0; j < (line - starCnt) / 2; ++j) {	//�� �տ� �� ������ ���� �������� ���� ������ �� �� ������ �����̴�
				System.out.print(" ");
			}
			for(int k = 0; k < starCnt; ++k) {					//���� ������ŭ �� ���
				System.out.print("*");
			}
			System.out.println();								//���� �ٲٰ� 
			starCnt+=2;											//�������� ���� ������ ���������� ���� ������ ��Ÿ���� ������ ���� 2 ����
		}
		
		starCnt = line - 2;										// �������� ����ϱ� ���� ���� ������ ���ҽ�Ų��
		
		
		for(int i =0; i < line/2; ++i) {						//����� �������� �غκ��� ����ϱ� ���� �ݺ���
			for(int j  = 0; j < (line - starCnt) / 2; ++j) {  	//�� �տ� �� ������ ���� �������� ���� ������ �� �� ������ ����
				System.out.print(" ");
			}
			for(int k = 0; k < starCnt; ++k) {				 	//���� ������ŭ �� ���
				System.out.print("*");
			}
			System.out.println();								//���� �ٲٰ� 
			starCnt-=2;											//�������� ���� ������ ���������� ���� ������ ��Ÿ���� ������ ���� 2 ����
		}
	}

}
