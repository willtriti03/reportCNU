import java.util.Scanner;

/****************************** 
 * 
 *  컴퓨터프로그래밍 1 (11) HW01 
 *  학번 : 201802135 
 *  이름 : 이 정 준 
 *
 ******************************/

public class Mile2Kilometer {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i_mile; 															//마일을 받는 인트형 변수
		
		Scanner sc= new Scanner(System.in); 									//입력을 받기 위한 스캐너 변수 및 변수 초기화
		
		System.out.print("마일을 입력하시오: ");
		i_mile = sc.nextInt(); 													// 마일 입력을 받아옴
		System.out.println(i_mile+"마일 "+((float)i_mile*1.609)+"Km입니다"); 		//마일을 km로 바꿔서 출력
	}

}
