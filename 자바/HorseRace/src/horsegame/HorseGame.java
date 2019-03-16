package horsegame;

import java.util.Scanner;

public class HorseGame {

	public static void main(String[] args) {
		RankDetector horseRank = new RankDetector();		//랭킹 확인 인스턴스
		int TRACK = 100;
		int choice;									//트랙 길이 선택한 말
		Thread horse[] = new HorseThread[5];				//말 5마리
		Scanner sc = new Scanner(System.in);				//입력 스캐너

		System.out.println("5마리의 말이 " + TRACK + "m 경주를 합니다.");		

		System.out.print("말 번호를 고르세요. (1~5):");				//말 번호 선택 및 랭킹 디텍터에 등록
		choice = sc.nextInt();
		horseRank.setChoice(choice);
		System.out.println(choice + "번 말을 고르셨습니다.");

		System.out.println("=== 경주 시작  ===\n");
		for(int i =0; i< 5; ++i){								//말5마리 쓰레드 생성 및 시작
			horse[i] = new HorseThread(i+1, TRACK, horseRank);		
			horse[i].start();
		}


	}

}
