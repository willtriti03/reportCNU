package horsegame;

import java.util.ArrayList;
public class RankDetector {
	
	ArrayList<Integer> rank = new ArrayList<>();
	private int choice;
	
	public void goalIn(int num) {
		rank.add(num);
		System.out.println(num + "����  "+rank.size() + "������ ���Խ��ϴ�.");
		isFinish();
	}
	
	public void printRank() {
		System.out.println("==��� ��� ==");
		for(int i =0; i < rank.size(); ++i) {
			System.out.print((i+1)+"���� "+rank.get(i)+"�� ��");
			if(rank.get(i)== choice)
				System.out.println( "<-------- ���� �� ��");
			else
				System.out.println();
		}
	}
	
	public void isFinish() {
		if(rank.size()==5)
			printRank();
	}
	
	public void setChoice(int choice) {
		this.choice = choice;
	}
}
