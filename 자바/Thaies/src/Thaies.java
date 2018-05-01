import java.util.Scanner;

/****************************** 
 * 
 *  컴퓨터프로그래밍 1 (11) HW03 
 *  학번 : 201802135 
 *  이름 : 이 정 준 
 *  
 ******************************/

public class Thaies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double ac,ae,bc;
		///////////////////입력 처리////////////////
		System.out.print("AC : ");					
		ac = sc.nextDouble();
		System.out.print("AE : ");
		ae = sc.nextDouble();
		System.out.print("BC : ");
		bc = sc.nextDouble();
		////////////////////////////////////////
		System.out.println("DE : "+((ae*bc)/ac));
		/*외항의 곱과 내항의 곱이 같으므로 곱한 식을 de에 대해 정리하면
			 de = (ae*bc)/ac 이다
		*/
	}

}
