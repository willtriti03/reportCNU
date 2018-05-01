
public class Point {
	private int x,y;
	
	public void setPoint(int x, int y){ //포인트 좌표 설정
		this.x=x;
		this.y=y;
	}
	public void print() {	//출력
		System.out.println("점의 좌표 (x, y)는 ("+x+", "+y+")입니다.");
	}
}
