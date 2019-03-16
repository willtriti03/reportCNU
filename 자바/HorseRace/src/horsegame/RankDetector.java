package horsegame;

import java.util.ArrayList;
public class RankDetector {
	
	ArrayList<Integer> rank = new ArrayList<>();
	private int choice;
	
	public void goalIn(int num) {
		rank.add(num);
		System.out.println(num + "말이  "+rank.size() + "등으로 들어왔습니다.");
		isFinish();
	}
	
	public void printRank() {
		System.out.println("==경기 결과 ==");
		for(int i =0; i < rank.size(); ++i) {
			System.out.print((i+1)+"등은 "+rank.get(i)+"번 말");
			if(rank.get(i)== choice)
				System.out.println( "<-------- 내가 고른 말");
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
