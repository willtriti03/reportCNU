package blackjackFrame;

public class Card {
	private int rank;			//���ھ� ����� ���� ��
	private char simbol;		//���
	private String image;		//�̹��� ��ũ

	public Card(int rank, char simbol, String image) { // ������ ���� �޾ƿ� 
		this.rank = rank;
		this.simbol = simbol;
		this.image = image;
	}

	public char getSimbol() {			//�ɺ������ Ȯ���� �ʿ��
		return simbol;
	}

	public int getRank() {					//KQJ ��� ó��
		return rank > 10 ? 10 : rank;
	}


	public String getImage() {				// �̹��� �ּ� ��������
		return image;
	}

}
