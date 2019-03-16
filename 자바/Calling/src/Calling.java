import java.util.Scanner;
import java.util.StringTokenizer;

public class Calling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		class Node{
			Node next;		//���� ���� ��ȣ 
			Node prev;		//���� ��ȣ 
			int data;		//��ȣ

			public Node(int data){
				this.data = data;
			}

			void add(Node node) { //������ȣ ����
				Node now = this;
				while (now.next!= null) {

					now  = now.next;
				}
				now.next = node;
				node.prev = now;
			}
			int lastNum() { //���� ������ ��ȣ�� ���������� ������ ������ ��ȣ ���
				Node now = this;
				while (now.next!= null) {
					now  = now.next;
				}
				return now.data;
			}

		}

		Scanner sc = new Scanner(System.in); // ��ĳ�� ����
		Node call[] = new Node[10000];	//��ȭ��ȣ�� 
		for(int i =0; i< 10000; ++i) {//����
			call[i] = new Node(i);
		}

		String callNum; 	//��ȭ��ȣ �ΰ�

		System.out.print("���� ������ ��ȭ��ȣ�� �Է��ϼ��� : ");
		callNum = sc.nextLine();
		while(!callNum.equals(" ")) {//������ ���ö����� �ݺ�
			StringTokenizer stringTokenizer = new StringTokenizer(callNum, " ");
			int firstNum = Integer.parseInt(stringTokenizer.nextToken());
			int secondNum = Integer.parseInt(stringTokenizer.nextToken());//���� �������� ����
			call[firstNum].add(call[secondNum]); //���� ��ȣ�� �߰�
			System.out.print("���� ������ ��ȭ��ȣ�� �Է��ϼ��� : ");
			callNum = sc.nextLine();
		}

		System.out.print("��ȭ�� �� ��ȣ�� �Է��ϼ��� : ");
		int calling;
		calling = sc.nextInt();
		System.out.println("��ȭ���� �︱ ��ȣ "+call[calling].lastNum());

	}

}
