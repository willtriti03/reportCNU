package chocolatejar;

import java.util.Random;
import java.util.Scanner;

public class ChocolateJarMain {
	public static void main(String[] args) {
		int pick;																//플레이어의 뽑은 개수를 저장하는 변수
		int time = 1;															//턴을 기록하는 변수
		int maxMake,take;														//컴퓨터의 최대 랜덤값, 컴퓨터의 뽑을 개수
		
		Random random = new Random();											//랜덤 인스턴스 생성		
		Scanner sc = new Scanner(System.in);									//스캐너 인스턴스 생성
		ChocolateJar chocolateJar = new ChocolateJar();							//게임을 위한 초콜릿 항아리 생성
																					
		System.out.println("게임을 시작합니다.");										//게임 초기 상태 확인
		System.out.println("항아링에는 "+ chocolateJar.getItem() + "개의 아이템이 있습니다.");
		System.out.println(chocolateJar.status());
		System.out.println("1~3개의 아이템을 꺼낼 수 있으며 칠리를 꺼내면 패배합니다.");
		System.out.println("시작!\n\n");
		
		
		while(true){															//게임 턴을 반복시켜주기 위한 while문
			System.out.println("+----------- "+time+" ------------+");			//턴 수 표현
			System.out.print("몇 개를 뽑을까요? (1~3) ");
			pick = sc.nextInt();												//플레이어의 뽑을 개수 입력
			chocolateJar.takeItem(pick);										//항아리에서 개수만큼 꺼냄
			System.out.println("플레이어를 "+pick+"개의 초콜릿을 꺼내습니다. ");				//출력
			System.out.println(chocolateJar.status());
			
			if(chocolateJar.getItem() == 1){									//다 뽑고 한 개만 남았으면 한 개는 칠리임으로 플레이어의 승리로 게임 끝
				System.out.println("플레이어 승리!");
				break;
			}
			else if (chocolateJar.getItem() == 0){								//다 뽑고 안 남았으면칠리를 뽑은 것임으로  컴퓨터의 승리로 게임 끝
				System.out.println("컴퓨터 승리!");
				break;
			}
			
			maxMake = Math.min(3,chocolateJar.getItem() - 1);					//컴퓨터가 뽑을 개수의 최대값 설정
			take = random.nextInt(1000)%maxMake%3+1;							//최대값이내 랜덤값 생성
			chocolateJar.takeItem(take);										//항아리에서 take개수 만큼 꺼냄
			
			System.out.println("컴퓨터는 "+take+"개의 초콜릿을 꺼내습니다. ");					//출력
			System.out.println(chocolateJar.status());
			
			if(chocolateJar.getItem() == 1){									//다 뽑고 한 개만 남았으면 한 개는 칠리임으로 컴퓨터의 승리로 게임 끝
				System.out.println("컴퓨터 승리!");
				break;
			}
			else if (chocolateJar.getItem() == 0){								//다 뽑고 안 남았으면칠리를 뽑은 것임으로  플레이어의 승리로 게임 끝
				System.out.println("플레이어 승리!");
				break;
			}
			
			time++;																//회수 증가
		}
	}
}
