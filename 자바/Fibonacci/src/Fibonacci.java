import java.util.Scanner;
/****************************** 
 * 
 * 컴퓨터프로그래밍 1 (11) HW05 
 * 학번 : 201802135 
 * 이름 : 이 정 준 
 * 
 * ******************************/
public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("출력할 항의 개수: ");
		int cnt = sc.nextInt();							//항의 개수 입력
		int a=0,b=1,c;
		for(int i=1; i<=cnt; ++i) {						//항 개수만큼 반복
			if(i==1) {									//1항일경우
				a=0;
				System.out.println("f"+i+": "+a);
			}
			else if(i==2) {								//2항일경우
				b=1;
				System.out.println("f"+i+": "+b);
			}
			else {										//3항이상일 경우
				c= a+b;									//3항이상의 항을 계산함
				System.out.println("f"+i+": "+c);
				a=b;									//계산한 항의 이전항 값 다음 항의 계산을 위한 첫 항으로 저장
				b=c;									//현재 항을 두번째 항으로 저장
			}
		}
	}

}
