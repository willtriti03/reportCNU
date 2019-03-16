package chocolatejar;

public interface  Jar {
	public int getItem();		// 아이템 개수를 반환
	public void takeItem(int hand); 	//hand만큼의 아이템을 뽑는다
	public String status(); 		//아이템 현황  출력
	public boolean isEmpty();		// 비어있는지 확인

}
