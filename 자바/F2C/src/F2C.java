import java.util.Scanner;

/****************************** 
 * 
 *  컴퓨터프로그래밍 1 (11) HW01 
 *  학번 : 201802135 
 *  이름 : 이 정 준 
 *
 ******************************/

public class F2C {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float f_fTemper; 													//화씨 온도 변수
		float f_cTemper; 													//섭씨 온도 변수
		Scanner sc = new Scanner(System.in);								// 스캐너 변수 선언 및 초기화
		
		System.out.print("화씨온도를 입력하시오: ");
		f_fTemper = sc.nextFloat(); 										//화씨온도 입력
		f_cTemper = (float) ((5.0/9.0)*(f_fTemper-32.0));					//화씨온도로 섭씨온도 계산
		System.out.println("화씨 온도는 "+f_cTemper+" 섭씨온도입니다.");
	}

}
