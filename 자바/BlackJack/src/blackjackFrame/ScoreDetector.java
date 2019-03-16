package blackjackFrame;

import javax.swing.JLabel;

public class ScoreDetector {
	private JLabel score;					//���� ��
	private Player player;					//�÷��̾�
	private Dealer dealer;					//����
	private boolean finished = false;		//���� �� ����

	public ScoreDetector(JLabel score, Player player, Dealer dealer) { //�ν��Ͻ� �޾ƿ���
		this.score = score;
		this.player = player;
		this.dealer = dealer;
	}
	public void startPlayerTurn() {// ������ �����̵Ǹ� ���� ����ó���� �س��� ������ �װ��� �ʱ�ȭ�� ���� �Լ� 
		finished=false;
		detectPlayerScore();
	}

	public void detectPlayerScore() {									//�÷��̾ ī�带 ���������� ���� �ؽ�Ʈ�� �ٲ��ִ� �Լ�
		if(!finished)
			score.setText("Dealer : ???, Player : "+player.getSum());
	}

	public void detectAllScore() {										// ���� ����� ���� ó��
		if(!finished) {														//���������� ��ư �Է� ����
			finished = true;												//������·� ����
			String ment="";
			if(dealer.getSum() == 21 ) {													//������ 21�϶�
				ment = "  ���� �¸�";
			}
			else if(player.getSum() == 21 ) {												//�÷��̾ 21�϶�
				ment = "  �÷��̾� �¸�";
			}
			else if(!dealer.isBlackjack() && !player.isBlackjack() ){								//�Ѵ� 21�� �Ѿ����� ó��
				if(Math.abs(21 - dealer.getSum()) < Math.abs(21 - player.getSum())) {
					ment = "  ���� �¸�";
				}
				else if(Math.abs(21 - dealer.getSum()) > Math.abs(21 - player.getSum())) {
					ment = "  �÷��̾� �¸�";
				}
				else if(Math.abs(21 - dealer.getSum()) == Math.abs(21 - player.getSum())) {
					ment = "  ���� �¸�";
				}
			}
			else if(player.isBlackjack()) {													//�÷��̾ 21�� �Ѿ�����
				ment = "  ���� �¸�";
			}
	
			score.setText("Dealer : "+dealer.getSum()+", Player : "+player.getSum()+ment);		//�ؽ�Ʈ ����
			
		}
	}
	
	public boolean isFinished() {
		return finished;
	}

}
