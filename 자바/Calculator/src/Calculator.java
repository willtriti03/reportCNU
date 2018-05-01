import java.util.Scanner;

/****************************** 
 *  
 *   컴퓨터프로그래밍 1 (11) HW04 
 *   학번 : 201802135 
 *   이름 : 이 정 준 
 *   
 ******************************/
public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자하나 입력 :");													//입력처리
		char mos = sc.next().charAt(0);
		
		System.out.print("숫자 두개를 입력하시오: ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		int answer=-1;																	//정답 저장 변수
		if(mos=='+') { 																	//더하기일 경우
			answer = num1 +num2;
			System.out.println(num1 + " " + mos + " "+ num2 +" = "+answer);
		}
		else if (mos=='-') {															//빼기일경우
			answer = num1 - num2;
			System.out.println(num1 + " " + mos + " "+ num2 +" = "+answer);
		}
		else if (mos == '*') {															//곱하기일 경우
			answer = num1 * num2;
			System.out.println(num1 + " " + mos + " "+ num2 +" = "+answer);
		}	
		else if(mos == '/') {															//나누기일 경우
			if(num2 ==0) {																//분모가 0일 경우
				System.out.println("분모가 0이면 나눌 수 없습니다.");
			}
			else {																		//분모가 0이 아닐 경우
				answer = num1 / num2;
				System.out.println(num1 + " " + mos + " "+ num2 +" = "+answer);
			}
		}
		else {																			//연산기호가 아닌 다른 문자가 들어왔을 경우
			System.out.println("연산 기호가 아닙니다.");
			
		}
	}

}
