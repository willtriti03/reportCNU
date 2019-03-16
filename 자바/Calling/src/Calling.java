import java.util.Scanner;
import java.util.StringTokenizer;

public class Calling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		class Node{
			Node next;		//하위 연결 번호 
			Node prev;		//이전 번호 
			int data;		//번호

			public Node(int data){
				this.data = data;
			}

			void add(Node node) { //하위번호 연결
				Node now = this;
				while (now.next!= null) {

					now  = now.next;
				}
				now.next = node;
				node.prev = now;
			}
			int lastNum() { //하위 연결할 번호가 없을때까지 돌린후 최하위 번호 출력
				Node now = this;
				while (now.next!= null) {
					now  = now.next;
				}
				return now.data;
			}

		}

		Scanner sc = new Scanner(System.in); // 스캐너 생성
		Node call[] = new Node[10000];	//전화번호들 
		for(int i =0; i< 10000; ++i) {//생성
			call[i] = new Node(i);
		}

		String callNum; 	//전화번호 두개

		System.out.print("수신 연결할 전화번호를 입력하세요 : ");
		callNum = sc.nextLine();
		while(!callNum.equals(" ")) {//공백이 들어올때까지 반복
			StringTokenizer stringTokenizer = new StringTokenizer(callNum, " ");
			int firstNum = Integer.parseInt(stringTokenizer.nextToken());
			int secondNum = Integer.parseInt(stringTokenizer.nextToken());//공백 기준으로 분할
			call[firstNum].add(call[secondNum]); //하위 번호로 추가
			System.out.print("수신 연결할 전화번호를 입력하세요 : ");
			callNum = sc.nextLine();
		}

		System.out.print("전화를 걸 번호를 입력하세요 : ");
		int calling;
		calling = sc.nextInt();
		System.out.println("전화벨이 울릴 번호 "+call[calling].lastNum());

	}

}
