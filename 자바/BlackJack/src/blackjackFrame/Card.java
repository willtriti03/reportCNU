package blackjackFrame;

public class Card {
	private int rank;			//스코어 계산을 위한 값
	private char simbol;		//모양
	private String image;		//이미지 링크

	public Card(int rank, char simbol, String image) { // 생성시 전부 받아옴 
		this.rank = rank;
		this.simbol = simbol;
		this.image = image;
	}

	public char getSimbol() {			//심볼모양의 확인이 필요시
		return simbol;
	}

	public int getRank() {					//KQJ 계산 처리
		return rank > 10 ? 10 : rank;
	}


	public String getImage() {				// 이미지 주소 가져오기
		return image;
	}

}
