package blackjackFrame;

import java.util.ArrayList;
import java.util.Iterator;

public class Player {
	private int sum;										//ī�� ������
	private ArrayList<Card> hand = new ArrayList<>();		//�ڵ� 
	private int aCnt= 0;									//a�� ����
	private Dealer dealer;									//����
	private boolean blackjack = false;						//���� ����
	protected HandPanel handPanel;							//��� �г�
	protected ScoreDetector scoreDetector;					//���� ó����

	public int getSum() {									//�ڵ��� �� ��������
		this.sum = checkSum();
		return sum;
	}

	public void addCard() {									//ī�带 �̰� ī�带 �߰��� ���� ���� ����� �����̸� ��� ����ó��
		hand.add(dealer.callCard());
		if(21 <= checkSum()) {
			blackjack = true;
			dealer.handPanel.refresh();
			scoreDetector.detectAllScore();
			
		}
		else {
			handPanel.refresh();
		}
	}

	protected int checkSum() {							//�� ó��
		int sum=0;										//��� �� �ʱ�ȭ
		Iterator iter = hand.iterator();				//�ڵ带 ���δ� ������ ���ͷ�����

		while(iter.hasNext()) {							//������ ������ ����
			int rank =((Card)iter.next()).getRank();	//ī���� ��ũ�� ������ ���
			if(rank == 1)								//���̸� ���� �����  ���� ī��Ʈ ��� 
				aCnt++;
			else
				sum += rank;							//�������� ���
		}

		for(int i =0; i< aCnt; ++i) {					//������ ������ŭ 11�� ���ؼ� 21�� �Ѵ´ٸ� a�� 1�� ���
			if(sum+11 <= 21)
				sum += 11;
			else
				sum += 1;
		}
		aCnt=0;

		return sum;
	}

	public void playFirstTurn() {						//ù���� ī�� ������ �̰� �� ���� ����
		addCard();
		addCard();
		handPanel.refresh();
		scoreDetector.detectPlayerScore();
	}

	public void playMoreTurn() {						//ī�带 �� �̴� ����
		if(!blackjack) {
			addCard();
			handPanel.refresh();
			scoreDetector.detectPlayerScore();
		}
	}
	
	public boolean isBlackjack() {						//���� ���� ����
		return blackjack;
	}
	
	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public void setHandPanel(HandPanel handPanel) {
		this.handPanel = handPanel;
	}

	public void setScoreDetector(ScoreDetector scoreDetector) {
		this.scoreDetector = scoreDetector;
	}




}
