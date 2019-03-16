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
		setTitle("BlackJack");												//타이틀 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);						//종료설정
		setLayout(new GridLayout(3,1));										//그리드 배치로 수직으로 3개 배치
		
		Dealer dealer = new Dealer();										//딜러 생성
		Player player = new Player();										//플레이어 생성
		
		
		dealer.setDealer(dealer);											//플레이어와 딜러에게 딜러 설정
		player.setDealer(dealer);
		
		DealerPanel dealerPanel = new DealerPanel(dealer);					//패널에 각자 그려낼 플레이어 부여 및 생성
		PlayerPanel playerPanel = new PlayerPanel(player);
		JPanel buttonTabPanel = new JPanel();								//하단 버튼 패널
		
		JLabel score = new JLabel("Dealer : ???, Player : "+player.getSum());	// 점수가 보여질 라벨
		JButton hit = new JButton("Hit");										// 카드 더 받기 버튼
		JButton stand = new JButton("Stand");									// 끝내기 버튼
		
		buttonTabPanel.add(score);												//패널에 버튼들 추가
		buttonTabPanel.add(hit);
		buttonTabPanel.add(stand);
		
		add(dealerPanel);															//메인 프레임에 추가
		add(playerPanel);
		add(buttonTabPanel);
		
		ScoreDetector scoreDetector = new ScoreDetector(score, player, dealer);		//점수 처리해주는 처리 객체 생성
		player.setScoreDetector(scoreDetector);										//점수 처리대상 설정
		dealer.setScoreDetector(scoreDetector);
		
		dealer.setHandPanel(dealerPanel);											//패널과 상호 작용을 위해 플레이어들에게도 패널추가
		player.setHandPanel(playerPanel);
		
		dealer.playFirstTurn();														//딜러의 턴
			
		scoreDetector.startPlayerTurn();											//플레이어 턴을 위해 설정
		player.playFirstTurn();														//플레이어의 첫 턴 진행 (두장 기부
		
		
		hit.addActionListener(new ActionListener() {								//카드 더 받을 시 처리
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				player.playMoreTurn();
			}
		});
		
		stand.addActionListener(new ActionListener() {								//멈추기 처리
			
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
