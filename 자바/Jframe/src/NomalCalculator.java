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

	private JPanel contentPane;											//��� ����Ʈ�� ��� �ǳ�
	private JPanel p1, p2, p3, p4;										//��ü �ǳ� �� ��Ҹ� �����ϱ� ���ϰ� ���� �ǳ�
	private JTextField result;											//���â �� �Է�â 
	protected JButton num[] = new JButton[11];							//���ڹ�ư 11�� 00����
	protected JButton cancel, equals, plus, minus, multi, divide;		//�����, = * - / + ��ư
	protected String showText="";										//���â�� ������ �ؽ�Ʈ
	protected boolean calculCheck = false;								//=�� ���� ���Ŀ� ���ڸ� �� ��ġ�� ���� �Ҹ���

	protected int nowNum=0, resultNum=0;								//���� ġ���ִ� ����, ��� ��
	protected ArrayList<Integer> numList = new ArrayList<>();			//���ݱ��� �Է��� ���� ����Ʈ
	protected ArrayList<Character> signList = new ArrayList<>();		//��� ��ȣ ����Ʈ
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

	public int numberKeyPressed(int num) {								//���� ��ư���� ������ �� ó��
		if(!calculCheck)
			if(num < 10) {												//0~9�� ������ ���	
				nowNum *= 10;											//ġ���ִ� ���ڿ� 10�� ���� �� �Է� ���� ���ڸ� ���Ѵ�
				nowNum += num;
				if(nowNum !=0)											//���� 0�� ���¿��� 0�� �Է��ϸ� ���â�� ���̴� �ؽ�Ʈ�� �������� �ʴ´�
					showText += num+"";			
			}
			else if (num == 100) {										//����� ��ư
				nowNum /= 10;											//ġ���ִ� ���ڸ� 10���� ������ �� ������ ���ڸ� ����� �ؽ�Ʈ������ �� �������� Ż�� ��Ų��
				showText = showText.substring(0,showText.length()-1);
			}
			else {														//00��ư�� ������ ���
				nowNum *= 100;											//100�� ���� 0 �ΰ��� �ٿ��ְ�
				if(nowNum !=0)											//�ؽ�Ʈ���� 0 �ΰ��� �ٿ��ش�
					showText += "00";
			}
		refresh();														//���â ��� ��������
		return nowNum;
	}
	
	
	

	public String signKeyPressed(char sign) {							//����ȣ�� ������ ���
		if (sign =='c') {												//����� ��ư�� ������ ��� ��� ����������
			showText ="";
			nowNum = 0;
			clearList();
			calculCheck = false;
		}
		
		else if(sign !='=') {											//=�� ������ �ٸ� ��ư�� ������ ���
			if(!calculCheck) {											//=�� ������ ��� ��ȣ���� Ȯ���Ѵ� �� �̿��� ��� �Է��ϰ� �ִ� ���ڸ� �Է��� �Ϸ�� ���ڷ� ����Ѵ�
				numList.add(nowNum);
			}
			signList.add(sign);											//��ȣ ����Ʈ�� �߰��Ѵ�
			
			nowNum = 0;													//�Է��ϰ� �ִ� ���ڴ� 0���� �ʱ�ȭ
			showText += (" "+sign+" ");									//���â�� ��ȣ ���
			calculCheck = false;										//=�� ������ ���� ���·� ����
		}
		
		else {															//=�� ������ ��� ó��
			numList.add(nowNum);										//�Է��ϰ� �ִ� ���ڸ� �Է��� �Ϸ�� ���ڷ� ���

			for(int i =0; i<signList.size(); ++i) {						//��ȣ����Ʈ�� ���鼭 ���ϱ� �����⸦ ���� ó���Ͽ� ���ϱ� ���⸸ �����
				if(signList.get(i)=='*') {
					numList.set(i, numList.get(i)*numList.get(i+1)); 
					signList.remove(i);
				}
				else if(signList.get(i)=='/') {
					numList.set(i, numList.get(i)/numList.get(i+1)); 
					signList.remove(i);
				}

			}
			
			
			resultNum = numList.get(0);									//��ù��° ���ڸ� �⺻ ������ ������ ��ȣ�� ���缭 ����Ʈ������ ����Ѵ�
			for(int i = 0; i<signList.size(); ++i) {
				if(signList.get(i)=='+') {
					resultNum += numList.get(i+1); 
				}
				else if(signList.get(i)=='-') {
					resultNum -= numList.get(i+1); 
				}
			}

			clearList();												//����� �Ϸ�Ǹ� ��� ����Ʈ�� �ʱ�ȭ�ϰ� ������� ���ڸ���Ʈ�� ��ó���� �ִ´�
			numList.add(resultNum);

			showText = resultNum+"";									//������� ������ ����
			nowNum=0;													//���� ���� �ʱ�ȭ
			calculCheck = true;											//=�� ���� ���·� ����
			
		}
		
		
		refresh();
		return showText;
	}

	private void clearList() {											//����Ʈ�� ���� �Լ�
		signList.clear();
		numList.clear();
	}
	
	
	public void refresh() {												//���â ��������
		result.setText(showText);
	}

	/**
	 * Create the frame.
	 */
	public NomalCalculator() {


		setTitle("����");											//Ÿ��Ʋ ����
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		p1 = new JPanel();											//��� �ǳ� ����
		result = new JTextField(15);								//�ؽ�Ʈ�ʵ� ����
		result.setHorizontalAlignment(SwingConstants.RIGHT);		//���� ����������
		result.setAlignmentX(Component.CENTER_ALIGNMENT);			//��� ��ġ
		p1.add(result);


		p2 = new JPanel();											//ĵ����ư �ϳ�
		p2.setLayout(new GridLayout(0, 4));
		cancel = new JButton("C");
		p2.add(cancel);


		p3 = new JPanel();											//�������� ���δ� �ǳ� �ϳ�			
		p3.setLayout(new GridLayout(4, 4, 3, 3));					//�׸���� ���ڹ�ư�� �迭 

		for(int i = 0; i< 10; ++i) {
			num[i] = new JButton(i+"");
		}
		num[10] = new JButton("00");

		equals = new JButton("=");
		plus = new JButton("+");
		minus = new JButton("-");
		multi = new JButton("*");
		divide = new JButton("/");

		p3.add(num[7]);													//��ư�� �ǳڿ� �߰�	
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

		p4 = new JPanel();											//�θ� �ǳڿ� ��ġ��
		p4.setLayout(new BoxLayout(p4, BoxLayout.Y_AXIS));
		p4.add(p1);
		p4.add(p2);
		p4.add(p3);
		
		///////////////////////////�̺�Ʈ ó��/////////////////////////////////
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

	class KeyPad implements ActionListener{					//���ڹ�ư Ŭ�� ó�� 

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

	class SignPad implements ActionListener{				//��ȣ��ư Ŭ�� ó��

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


	class KeyboardTyping implements KeyListener{		//Ű���� Ÿ���� ó��

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
