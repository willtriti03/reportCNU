import java.util.Scanner;

public class Palindrome {

	public static boolean palindrome(String target) {
		if(target.length() == 1 || target.length()==0)					//1���ڰ� ���ų�  ��� ó�� �ƴٸ� Ʈ��
			return true;
		else {
			if(target.charAt(0)== target.charAt(target.length()-1)){		//�糡 ���� ��
				return palindrome(target.substring(1, target.length()-1));	//�糡 ���ڸ� �ڸ��� �ѹ� �� ����
			}
			else
				return false;												//���� �ʴٸ� Ż��
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String line;
		while(true){
			System.out.print("ȸ�� �˻��� ������ �־��ּ��� : ");
			line= sc.next();
			if(palindrome(line)){
				System.out.println(line +"��(��) ȸ���Դϴ�");
			}
			else
				System.out.println(line +"��(��) ȸ���� �ƴմϴ�");
			
		}
	}

}
