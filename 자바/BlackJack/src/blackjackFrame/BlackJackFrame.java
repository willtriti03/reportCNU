package blackjackFrame;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class BlackJackFrame extends JFrame {

	public BlackJackFrame() {
		// TODO Auto-generated constructor stub
		setTitle("BlackJack");												//Ÿ��Ʋ ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);						//���ἳ��
		setLayout(new GridLayout(3,1));										//�׸��� ��ġ�� �������� 3�� ��ġ
		
		Dealer dealer = new Dealer();										//���� ����
		Player player = new Player();										//�÷��̾� ����
		
		
		dealer.setDealer(dealer);											//�÷��̾�� �������� ���� ����
		player.setDealer(dealer);
		
		DealerPanel dealerPanel = new DealerPanel(dealer);					//�гο� ���� �׷��� �÷��̾� �ο� �� ����
		PlayerPanel playerPanel = new PlayerPanel(player);
		JPanel buttonTabPanel = new JPanel();								//�ϴ� ��ư �г�
		
		JLabel score = new JLabel("Dealer : ???, Player : "+player.getSum());	// ������ ������ ��
		JButton hit = new JButton("Hit");										// ī�� �� �ޱ� ��ư
		JButton stand = new JButton("Stand");									// ������ ��ư
		
		buttonTabPanel.add(score);												//�гο� ��ư�� �߰�
		buttonTabPanel.add(hit);
		buttonTabPanel.add(stand);
		
		add(dealerPanel);															//���� �����ӿ� �߰�
		add(playerPanel);
		add(buttonTabPanel);
		
		ScoreDetector scoreDetector = new ScoreDetector(score, player, dealer);		//���� ó�����ִ� ó�� ��ü ����
		player.setScoreDetector(scoreDetector);										//���� ó����� ����
		dealer.setScoreDetector(scoreDetector);
		
		dealer.setHandPanel(dealerPanel);											//�гΰ� ��ȣ �ۿ��� ���� �÷��̾�鿡�Ե� �г��߰�
		player.setHandPanel(playerPanel);
		
		dealer.playFirstTurn();														//������ ��
			
		scoreDetector.startPlayerTurn();											//�÷��̾� ���� ���� ����
		player.playFirstTurn();														//�÷��̾��� ù �� ���� (���� ���
		
		
		hit.addActionListener(new ActionListener() {								//ī�� �� ���� �� ó��
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				player.playMoreTurn();
			}
		});
		
		stand.addActionListener(new ActionListener() {								//���߱� ó��
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				scoreDetector.detectAllScore();
				dealerPanel.refresh();
			}
		});
		
		setSize(700, 500);
		setVisible(true);
	}
	
	
}
