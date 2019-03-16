import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class NomalCalculator extends JFrame {

	private JPanel contentPane;											//모든 콘텐트를 담는 판넬
	private JPanel p1, p2, p3, p4;										//전체 판넬 안 요소를 관리하기 편하게 묶은 판넬
	private JTextField result;											//결과창 및 입력창 
	protected JButton num[] = new JButton[11];							//숫자버튼 11개 00포함
	protected JButton cancel, equals, plus, minus, multi, divide;		//지우기, = * - / + 버튼
	protected String showText="";										//결과창에 보여질 텍스트
	protected boolean calculCheck = false;								//=을 누른 직후에 숫자를 더 못치게 막는 불린형

	protected int nowNum=0, resultNum=0;								//현재 치고있는 숫자, 결과 값
	protected ArrayList<Integer> numList = new ArrayList<>();			//지금까지 입력한 숫자 리스트
	protected ArrayList<Character> signList = new ArrayList<>();		//계산 기호 리스트
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NomalCalculator frame = new NomalCalculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public int numberKeyPressed(int num) {								//숫자 버튼들이 눌렸을 때 처리
		if(!calculCheck)
			if(num < 10) {												//0~9가 눌렸을 경우	
				nowNum *= 10;											//치고있는 숫자에 10을 곱한 후 입력 받은 숫자를 더한다
				nowNum += num;
				if(nowNum !=0)											//만약 0인 상태에서 0을 입력하면 결과창에 보이는 텍스트를 수정하지 않는다
					showText += num+"";			
			}
			else if (num == 100) {										//지우기 버튼
				nowNum /= 10;											//치고있는 숫자를 10으로 나누어 맨 마지막 숫자를 지우고 텍스트에서도 맨 마지막을 탈락 시킨다
				showText = showText.substring(0,showText.length()-1);
			}
			else {														//00버튼이 눌렸을 경우
				nowNum *= 100;											//100을 곱해 0 두개를 붙여주고
				if(nowNum !=0)											//텍스트에도 0 두개를 붙여준다
					showText += "00";
			}
		refresh();														//결과창 출력 리프레쉬
		return nowNum;
	}
	
	
	

	public String signKeyPressed(char sign) {							//계산기호가 눌렸을 경우
		if (sign =='c') {												//지우기 버튼이 눌렸을 경우 모두 지워버린다
			showText ="";
			nowNum = 0;
			clearList();
			calculCheck = false;
		}
		
		else if(sign !='=') {											//=을 제외한 다른 버튼이 눌렸을 경우
			if(!calculCheck) {											//=을 누른후 계산 기호인지 확인한다 그 이외의 경우 입력하고 있던 숫자를 입력이 완료된 숫자로 취급한다
				numList.add(nowNum);
			}
			signList.add(sign);											//기호 리스트에 추가한다
			
			nowNum = 0;													//입력하고 있던 숫자는 0으로 초기화
			showText += (" "+sign+" ");									//결과창에 기호 출력
			calculCheck = false;										//=이 눌리지 않은 상태로 변경
		}
		
		else {															//=이 눌렸을 경우 처리
			numList.add(nowNum);										//입력하고 있던 숫자를 입력이 완료된 숫자로 취급

			for(int i =0; i<signList.size(); ++i) {						//기호리스트를 돌면서 곱하기 나누기를 먼저 처리하여 더하기 빼기만 남긴다
				if(signList.get(i)=='*') {
					numList.set(i, numList.get(i)*numList.get(i+1)); 
					signList.remove(i);
				}
				else if(signList.get(i)=='/') {
					numList.set(i, numList.get(i)/numList.get(i+1)); 
					signList.remove(i);
				}

			}
			
			
			resultNum = numList.get(0);									//맨첫번째 숫자를 기본 값으로 세팅후 기호에 맞춰서 리스트값들을 계산한다
			for(int i = 0; i<signList.size(); ++i) {
				if(signList.get(i)=='+') {
					resultNum += numList.get(i+1); 
				}
				else if(signList.get(i)=='-') {
					resultNum -= numList.get(i+1); 
				}
			}

			clearList();												//계산이 완료되면 모든 리스트를 초기화하고 결과값을 숫자리스트의 맨처음에 넣는다
			numList.add(resultNum);

			showText = resultNum+"";									//결과값이 나오게 셋팅
			nowNum=0;													//현재 숫자 초기화
			calculCheck = true;											//=이 눌린 상태로 변경
			
		}
		
		
		refresh();
		return showText;
	}

	private void clearList() {											//리스트를 비우는 함수
		signList.clear();
		numList.clear();
	}
	
	
	public void refresh() {												//결과창 리프레쉬
		result.setText(showText);
	}

	/**
	 * Create the frame.
	 */
	public NomalCalculator() {


		setTitle("계산기");											//타이틀 설정
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		p1 = new JPanel();											//상단 판넬 생성
		result = new JTextField(15);								//텍스트필드 생성
		result.setHorizontalAlignment(SwingConstants.RIGHT);		//글자 오른쪽정렬
		result.setAlignmentX(Component.CENTER_ALIGNMENT);			//가운데 배치
		p1.add(result);


		p2 = new JPanel();											//캔슬버튼 하나
		p2.setLayout(new GridLayout(0, 4));
		cancel = new JButton("C");
		p2.add(cancel);


		p3 = new JPanel();											//숫자판을 감싸는 판넬 하나			
		p3.setLayout(new GridLayout(4, 4, 3, 3));					//그리드로 숫자버튼들 배열 

		for(int i = 0; i< 10; ++i) {
			num[i] = new JButton(i+"");
		}
		num[10] = new JButton("00");

		equals = new JButton("=");
		plus = new JButton("+");
		minus = new JButton("-");
		multi = new JButton("*");
		divide = new JButton("/");

		p3.add(num[7]);													//버튼들 판넬에 추가	
		p3.add(num[8]);
		p3.add(num[9]);
		p3.add(divide);
		p3.add(num[4]);
		p3.add(num[5]);
		p3.add(num[6]);
		p3.add(multi);
		p3.add(num[1]);
		p3.add(num[2]);
		p3.add(num[3]);
		p3.add(minus);
		p3.add(num[0]);
		p3.add(num[10]);
		p3.add(equals);
		p3.add(plus);

		p2.setBorder(BorderFactory.createEmptyBorder(0, 3, 3, 0));
		p3.setBorder(BorderFactory.createEmptyBorder(0, 3, 3, 3));

		p4 = new JPanel();											//부모 판넬에 합치기
		p4.setLayout(new BoxLayout(p4, BoxLayout.Y_AXIS));
		p4.add(p1);
		p4.add(p2);
		p4.add(p3);
		
		///////////////////////////이벤트 처리/////////////////////////////////
		KeyPad keypad= new KeyPad();
		SignPad signPad = new SignPad();

		for(int i =0; i< 11; ++i) {
			num[i].addActionListener(keypad);
		}

		equals.addActionListener(signPad);
		plus.addActionListener(signPad);
		minus.addActionListener(signPad);
		multi.addActionListener(signPad);
		divide.addActionListener(signPad);
		cancel.addActionListener(signPad);

		result.addKeyListener(new KeyboardTyping());

		////////////////////////////////////////////////////////////////////////
		getContentPane().add(p4);
		pack();
		setVisible(true);
	}

	class KeyPad implements ActionListener{					//숫자버튼 클릭 처리 

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for(int i = 0; i < 11; ++i) {
				if(e.getSource()==num[i]) {
					numberKeyPressed(i);
					break;
				}
			}
		}

	}

	class SignPad implements ActionListener{				//기호버튼 클릭 처리

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == plus) {
				signKeyPressed('+');
			}
			else if(e.getSource() == minus) {
				signKeyPressed('-');
			}
			else if (e.getSource() == divide) {
				signKeyPressed('/');
			}
			else if (e.getSource() == multi) {
				signKeyPressed('*');
			}
			else if (e.getSource() == equals) {
				signKeyPressed('=');
			}
			else if (e.getSource() == cancel) {
				signKeyPressed('c');
			}

		}

	}


	class KeyboardTyping implements KeyListener{		//키보드 타이핑 처리

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			switch (e.getKeyCode()) {
			case KeyEvent.VK_0:
			case KeyEvent.VK_NUMPAD0:
				numberKeyPressed(0);
				break;
			case KeyEvent.VK_1:
			case KeyEvent.VK_NUMPAD1:
				numberKeyPressed(1);
				break;
			case KeyEvent.VK_2:
			case KeyEvent.VK_NUMPAD2:
				numberKeyPressed(2);
				break;
			case KeyEvent.VK_3:
			case KeyEvent.VK_NUMPAD3:
				numberKeyPressed(3);
				break;
			case KeyEvent.VK_4:
			case KeyEvent.VK_NUMPAD4:
				numberKeyPressed(4);
				break;
			case KeyEvent.VK_5:
			case KeyEvent.VK_NUMPAD5:
				numberKeyPressed(5);
				break;
			case KeyEvent.VK_6:
			case KeyEvent.VK_NUMPAD6:
				numberKeyPressed(6);
				break;
			case KeyEvent.VK_7:
			case KeyEvent.VK_NUMPAD7:
				numberKeyPressed(7);
				break;
			case KeyEvent.VK_8:
			case KeyEvent.VK_NUMPAD8:
				numberKeyPressed(8);
				break;
			case KeyEvent.VK_9:
			case KeyEvent.VK_NUMPAD9:
				numberKeyPressed(9);
				break;
			case KeyEvent.VK_PLUS:
			case KeyEvent.VK_ADD:
				signKeyPressed('+');
				break;
			case KeyEvent.VK_MINUS:
			case KeyEvent.VK_SUBTRACT:
				signKeyPressed('-');
				break;
			case KeyEvent.VK_MULTIPLY:
				signKeyPressed('*');
				break;
			case KeyEvent.VK_DIVIDE:
				signKeyPressed('/');
				break;
			case KeyEvent.VK_ENTER:
				signKeyPressed('=');
				break;
			case KeyEvent.VK_BACK_SPACE:
				numberKeyPressed(100);
				break;
			case KeyEvent.VK_ESCAPE:
				signKeyPressed('c');
				break;
			default:
				break;
			}

			refresh();	

		}

	}

}
