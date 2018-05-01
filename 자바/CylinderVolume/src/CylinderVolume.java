import java.util.Scanner;
/******************************
*
* 컴퓨터프로그래밍 1 (11) HW02
* 학번 : 201802135
* 이름 : 이정준
*
******************************/
public class CylinderVolume {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final float pi = 3.141592f;							//파이 값 설정
		int radius;											//반지름 변수	
		int height;											//높이 변수
		float v;											//부피 변수
		
		Scanner sc = new Scanner(System.in);				//스캐너 선언 및 초기화
		
		System.out.print("원기둥의 밑면의 반지름을 입력하시오 :");
		radius = sc.nextInt();
		System.out.print("원기둥의 높이를 입력하시오 : ");
		height = sc.nextInt();								//데이터 입력
		
		v = radius*radius*pi*height;						//부피 계산
		System.out.println("원기둥의 부피는 "+v+"입니다.");
	}

}
