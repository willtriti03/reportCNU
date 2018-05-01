import java.util.Scanner;

/****************************** 
 * 
 *  컴퓨터프로그래밍 1 (11) HW06 
 *  학번 : 201802135 
 *  이름 : 이 정 준 
 *  
 *  ******************************/
public class CharCountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String str = sc.nextLine(); 		//문자열을 입력받음
		str = str.toLowerCase();			//처리를 편하게 하기 위해 모든 문자를 소문자로 변경
		int m=0;							//모음의 개수를 담음
		int j=0;							//자음의 개수를 담음
		
		for(int i = 0; i<str.length(); ++i ) {	//문자열의 시작부터 끝까지 한 바퀴를 돌림
			char c=str.charAt(i);
			switch(c) {				//문자하나하나마다 검사 시작
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				m++;
				break;							//모음이면 모음 개수 추가					
			default:							//나머지의 모두 경우를 거름
				if('a'<=c&&c<='z')				//나머지중에 자음이면 자음 개수 추가
					j++;
				break;
			}
		}
		System.out.println("자음 : "+ j);			//출력
		System.out.println("모음 : "+ m);
		
	}

}
