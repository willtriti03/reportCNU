package horsegame;

import java.util.Scanner;

public class HorseGame {

	public static void main(String[] args) {
		RankDetector horseRank = new RankDetector();		//��ŷ Ȯ�� �ν��Ͻ�
		int TRACK = 100;
		int choice;									//Ʈ�� ���� ������ ��
		Thread horse[] = new HorseThread[5];				//�� 5����
		Scanner sc = new Scanner(System.in);				//�Է� ��ĳ��

		System.out.println("5������ ���� " + TRACK + "m ���ָ� �մϴ�.");		

		System.out.print("�� ��ȣ�� ������. (1~5):");				//�� ��ȣ ���� �� ��ŷ �����Ϳ� ���
		choice = sc.nextInt();
		horseRank.setChoice(choice);
		System.out.println(choice + "�� ���� ���̽��ϴ�.");

		System.out.println("=== ���� ����  ===\n");
		for(int i =0; i< 5; ++i){								//��5���� ������ ���� �� ����
			horse[i] = new HorseThread(i+1, TRACK, horseRank);		
			horse[i].start();
		}


	}

}
