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
		setTitle("������ Ű�ι��ͷ� ��ȯ");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		p1 = new JPanel();										//���� ��ܿ� �� �����۵��� ���� �ǳ�
		p1.setLayout(new FlowLayout());							//�÷ο� ���̾ƿ����� ����
		l1 = new JLabel("�Ÿ��� ���� ������ �Է��Ͻÿ�.");				// ���� �󺧻���
		mile = new JTextField(10);								//�ؽ�Ʈ �Է� â ����
		mile.setHorizontalAlignment(SwingConstants.RIGHT);		//���� ������ ����
		p1.add(l1);												//�ǳڿ� �߰�
		p1.add(mile);						

		
		
		p2 = new JPanel();										//��ȯ��ư�� ��ġ�� �ǳ� ����
		button = new JButton("��ȯ");								//��ư ����
		button.setAlignmentX(Component.CENTER_ALIGNMENT);		//����� ��ġ
		p2.add(button);											//�ǳڿ� �߰�

		
		
		p3 = new JPanel();										//���ϴ� �ǳ� ����
		p3.setLayout(new FlowLayout());							//�÷ο� ���̾ƿ����� ���� 				
		result = new JTextField(30);							//�ؽ�Ʈ �г� ����
		result.setBackground(Color.WHITE);						//���� ����
		result.setText("�������");								//Ȯ�ο� �ؽ�Ʈ
		result.setEditable(false);								//�Է� ����
		result.setHorizontalAlignment(SwingConstants.CENTER);	//���� ��� ����
		p3.add(result);											//�ǳڿ� �߰�

		
		p4 = new JPanel();										//��� ��Ҹ� ���� �ǳ� ���� �� �߰�
		p4.setLayout(new BoxLayout(p4, BoxLayout.Y_AXIS));		
		p4.add(p1);
		p4.add(p2);
		p4.add(p3);
		

		getContentPane().add(p4);
		pack();
		setVisible(true);
	}

}
