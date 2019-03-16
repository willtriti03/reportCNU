import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

public class InterestCalculator extends JFrame {

	private JPanel contentPane;				
	private JPanel p1, p2, p3, p4, p5;
	private JLabel l1, l2;
	private JButton button;
	private JTextField money, rate, result;
	private int i_money,i_rate;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterestCalculator frame = new InterestCalculator();
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
	public InterestCalculator() {


		setTitle("이자 계산기");									//타이틀 설정
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		p1 = new JPanel();										//최상단 판넬 생성및 요소 추가 MileToKM와 유사한 방식
		p1.setLayout(new FlowLayout());
		l1 = new JLabel("원금을 입력하시오.");
		money = new JTextField(10);
		money.setHorizontalAlignment(SwingConstants.RIGHT);
		p1.add(l1);
		p1.add(money);

		
		p2 = new JPanel();										//상단과 동일한 구조
		p2.setLayout(new FlowLayout());
		l2 = new JLabel("이율을 입력하시오.");
		rate = new JTextField(10);
		rate.setHorizontalAlignment(SwingConstants.RIGHT);
		p2.add(l2);
		p2.add(rate);
		
		

		p3 = new JPanel();										//버튼생성및 가운데정렬
		button = new JButton("변환");
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		p3.add(button);

		p4 = new JPanel();										//최하단 결과창 생성, 수정 및 입력 막기, 배경색 설정
		p4.setLayout(new FlowLayout()); 
		result = new JTextField(30);
		result.setBackground(Color.WHITE);
		result.setEditable(false);
		result.setHorizontalAlignment(SwingConstants.CENTER);
		p4.add(result);

		p5 = new JPanel();										//모든 판넬을 부모 판넬에 부착
		p5.setLayout(new BoxLayout(p5, BoxLayout.Y_AXIS));
		p5.add(p1);
		p5.add(p2);
		p5.add(p3);
		p5.add(p4);
		

		rate.addKeyListener(new TextFieldEnter());
		button.addActionListener(new ActionListener() {										//버튼으로 처리
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(money.getText().equals("")) {
					i_money = 0;
				}
				else {
					i_money = Integer.valueOf(money.getText());
				}
				
				if(money.getText().equals("")) {
					i_rate = 0;
				}
				else {
					i_rate = Integer.valueOf(rate.getText());
				}
				
				result.setText(("이자는 연 "+(float)(i_money*(i_rate/100)))+"원 입니다.");
			}
		});

		getContentPane().add(p5);
		pack();
		setVisible(true);
		
		
	}
	
	private class TextFieldEnter implements KeyListener{							//텍스트창에서의 입력 처리

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode()== KeyEvent.VK_ENTER) {
				if(money.getText().equals("")) {
					i_money = 0;
				}
				else {
					i_money = Integer.valueOf(money.getText());
				}
				
				if(money.getText().equals("")) {
					i_rate = 0;
				}
				else {
					i_rate = Integer.valueOf(rate.getText());
				}
				
				result.setText(("이자는 연 "+(float)(i_money*(i_rate/100)))+"원 입니다.");
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

}