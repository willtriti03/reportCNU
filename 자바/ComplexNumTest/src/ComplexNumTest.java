import java.util.Scanner;
/****************************** 
 * 
 *  컴퓨터프로그래밍 1 (11) HW06 
 *  학번 : 201802135 
 *  이름 : 이 정 준 
 *  
 *  ******************************/
public class ComplexNumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);					// 복소수들의 데이터값 입력
		System.out.print("복소수 1의 실수값 허수값을 입력하시오 : ");
		int r1 = sc.nextInt();
		int i1= sc.nextInt();
		System.out.print("복소수 2의 실수값 허수값을 입력하시오 : ");
		int r2 = sc.nextInt();
		int i2= sc.nextInt();
				
		ComplexNum c1 = new ComplexNum(r1, i1);			//입력받은 데이터로 복소수 객체 생성
		ComplexNum c2 = new ComplexNum(r2, i2);
		
		System.out.println("복소수 1 : "+ c1.getComplexNum());		//복소수 출력
		System.out.println("복소수 2 : "+ c2.getComplexNum());
		
		System.out.println("복소수1 + 복소수2 = "+ c1.add(c2));		//덧셈 출력
		System.out.println("복소수1 - 복소수2 = "+ c1.sub(c2));		//뺄셈 출력
		System.out.println("복소수1 * 복소수2 = "+ c1.mul(c2));		//곱셈 출력
		System.out.println("복소수1 / 복소수2 = "+ c1.div(c2));		//나눗셈 출력
	}

}
