package d;

import java.util.Scanner;

public class Star {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int line;												//출력할 줄의 개수를 입력 받는 변수

		Scanner sc = new Scanner(System.in);					//입력을 받기 위한 스캐너 변수 및 초기화
														
		System.out.print("몇 개의 줄로 별을 출력 할까요?  ");			//입력을 받아오고 받아온만큼 출력
		line = sc.nextInt();
		System.out.println("========== 1번 ==========");
		printStar1(line);

		
		System.out.print("몇 개의 줄로 별을 출력 할까요?  ");			//입력을 받아오고 받아온만큼 출력
		line = sc.nextInt();
		System.out.println("========== 2번 ==========");
		printStar2(line);
		
		
		System.out.print("몇 개의 줄로 별을 출력 할까요?  ");			//입력을 받아오고 받아온만큼 출력
		line = sc.nextInt();
		System.out.println("========== 3번 ==========");
		printStar3(line);
		
	}

	public static void printStar1(int line) {				  	//1번 출력 함수    인자 : line->출력할 줄의 개수 
		if (line <= 0) line = 5;								//줄의 개수의 값이 0이하일 경우 디폴트 값인 5로 변경 
		
		for(int i =0; i< line; ++i) {							//줄의 개수만큼 반복 시켜주기 위한 반복문
			for(int j =0; j <= i; ++j) {						//별을 계단형으로 출력하기 위해 출력될 별의 개수를 조절하는 반복문
				System.out.print("*");
			}
			System.out.println();								//별을 다 찍었으면 한 줄 출력이 끝난 것이므로 줄변경 
		}
	}

	public static void printStar2(int line) {					//2번 출력 함수    인자 : line->출력할 줄의 개수 
		if (line <= 0) line = 5;								//줄의 개수의 값이 0이하일 경우 디폴트 값인 5로 변경 
		
		for(int i =0; i< line; ++i) {							//줄의 개수만큼 반복 시켜주기 위한 반복문
			for(int j =0; j < line - i; ++j) {					//별을 계단형으로 출력하기 위해 출력될 별의 개수를 조절하는 반복문
				System.out.print("*");
			}
			System.out.println();								//별을 다 찍었으면 한 줄 출력이 끝난 것이므로 줄변경 
		}
	}

	public static void printStar3(int line) {					//3번 출력 함수    인자 : line->출력할 줄의 개수 
		if (line <= 0) line = 9;								//줄의 개수의 값이 0이하일 경우 디폴트 값인 9로 변경 
		else if (line % 2 == 0) line += 1;						//줄의 개수가 짝수이면 다이아몬드가 출력되지 않음으로 짝수가 들어왔을시 홀수로 바꿔준다
		
		int starCnt = 1;										//출력될 별의 개수를 조절하는 변수 및 1로 초기화
		
		for(int i =0; i < line/2+1; ++i) {						//다이아몬드의 위쪽 절반과 가운데 줄까지 출력
			for(int j  = 0; j < (line - starCnt) / 2; ++j) {	//별 앞에 들어갈 공백은 줄의 개수에서 별의 개수를 뺀 후 절반이 공백이다
				System.out.print(" ");
			}
			for(int k = 0; k < starCnt; ++k) {					//별의 개수만큼 별 출력
				System.out.print("*");
			}
			System.out.println();								//줄을 바꾸고 
			starCnt+=2;											//다음줄의 별의 개수는 증가함으로 별의 개수를 나타내는 변수의 값을 2 증가
		}
		
		starCnt = line - 2;										// 다음줄을 출력하기 위해 별을 개수를 감소시킨다
		
		
		for(int i =0; i < line/2; ++i) {						//가운데줄 기준으로 밑부분을 출력하기 위한 반복문
			for(int j  = 0; j < (line - starCnt) / 2; ++j) {  	//별 앞에 들어갈 공백은 줄의 개수에서 별의 개수를 뺀 후 절반이 공백
				System.out.print(" ");
			}
			for(int k = 0; k < starCnt; ++k) {				 	//별의 개수만큼 별 출력
				System.out.print("*");
			}
			System.out.println();								//줄을 바꾸고 
			starCnt-=2;											//다음줄의 별의 개수는 감소함으로 별의 개수를 나타내는 변수의 값을 2 감소
		}
	}

}
