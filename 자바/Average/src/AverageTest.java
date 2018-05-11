/****************************** 
 * 
 *  컴퓨터프로그래밍 1 (11) HW08 
 *  학번 : 201802135 
 *  이름 : 이 정 준 
 *  
 *  ******************************/
public class AverageTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Average average = new Average();
		System.out.println("두 인수 (10, 5)의 평균 : "+average.getAverage(10, 5));	//2개 평균계산
		System.out.println("세 인수 ( 4, 5, 6)의 평균 :"+average.getAverage(4, 5, 6)); //3개 평균계산
	}

}
