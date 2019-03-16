import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

public class MileToKm extends JFrame {

	private JPanel p1, p2, p3, p4;
	private JLabel l1;
	private JButton button;
	private JTextField mile,result;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MileToKm frame = new MileToKm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MileToKm() {
		setTitle("마일을 키로미터로 변환");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		p1 = new JPanel();										//제일 상단에 들어갈 아이템들을 묶은 판넬
		p1.setLayout(new FlowLayout());							//플로우 레이아웃으로 설정
		l1 = new JLabel("거리를 마일 단위로 입력하시오.");				// 설명 라벨생성
		mile = new JTextField(10);								//텍스트 입력 창 생성
		mile.setHorizontalAlignment(SwingConstants.RIGHT);		//글자 오른쪽 정렬
		p1.add(l1);												//판넬에 추가
		p1.add(mile);						

		
		
		p2 = new JPanel();										//변환버튼이 배치될 판넬 생성
		button = new JButton("변환");								//버튼 생성
		button.setAlignmentX(Component.CENTER_ALIGNMENT);		//가운데에 배치
		p2.add(button);											//판넬에 추가

		
		
		p3 = new JPanel();										//최하단 판넬 생성
		p3.setLayout(new FlowLayout());							//플로우 레이아웃으로 설정 				
		result = new JTextField(30);							//텍스트 패널 생성
		result.setBackground(Color.WHITE);						//배경색 지정
		result.setText("블라블라블라");								//확인용 텍스트
		result.setEditable(false);								//입력 막기
		result.setHorizontalAlignment(SwingConstants.CENTER);	//글자 가운데 정렬
		p3.add(result);											//판넬에 추가

		
		p4 = new JPanel();										//모든 요소를 담을 판넬 생성 및 추가
		p4.setLayout(new BoxLayout(p4, BoxLayout.Y_AXIS));		
		p4.add(p1);
		p4.add(p2);
		p4.add(p3);
		

		getContentPane().add(p4);
		pack();
		setVisible(true);
	}

}
