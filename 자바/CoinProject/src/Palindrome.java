import java.util.Scanner;

public class Palindrome {

	public static boolean palindrome(String target) {
		if(target.length() == 1 || target.length()==0)					//1글자가 남거나  모두 처리 됐다면 트루
			return true;
		else {
			if(target.charAt(0)== target.charAt(target.length()-1)){		//양끝 글자 비교
				return palindrome(target.substring(1, target.length()-1));	//양끝 글자를 자르고 한번 더 동작
			}
			else
				return false;												//같지 않다면 탈출
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String line;
		while(true){
			System.out.print("회문 검사할 문장을 넣어주세요 : ");
			line= sc.next();
			if(palindrome(line)){
				System.out.println(line +"은(는) 회문입니다");
			}
			else
				System.out.println(line +"은(는) 회문이 아닙니다");
			
		}
	}

}
