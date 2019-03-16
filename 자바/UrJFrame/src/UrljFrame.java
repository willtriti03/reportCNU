import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class UrljFrame extends JFrame{
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UrljFrame frame = new UrljFrame();			//������ ����
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UrljFrame() {
		// TODO Auto-generated constructor stub
		setTitle("�ѿ�");											//Ÿ��Ʋ ����
		setDefaultCloseOperation(EXIT_ON_CLOSE);				//���� ����

		JPanel p1 = new JPanel();								//html��ũ�� �޾ƿ� UI�� ���� �ǳ� ���� 

		TextField txt = new TextField(30);						//�ؽ�Ʈ�ʵ� ����
		JButton jButton = new JButton("HTML ��������");			//��ư ����
		p1.add(new JLabel("URL : "));							//���� �� �߰�
		p1.add(txt);											//�ؽ�Ʈ�ʵ� �ǳڿ� �߰�
		p1.add(jButton);										//��ư �ǳڿ� �߰�

		add(p1,BorderLayout.SOUTH);								//�ǳ��� ���� �ǳ��� �Ʒ��ʿ� ��ġ


		JPanel p2 = new JPanel();								//JEditor�� ���� �ǳ� ����
		p2.setLayout(new GridLayout(2, 1));						//���η� ��ġ�ϱ� ���� �׸��巹�̾ƿ����� ����

		JEditorPane text= new JEditorPane();					//html�ڵ带 �ؽ�Ʈ ���·� ���� JEditor ����
		text.setContentType("text/plain");						//�÷������� ����
		text.setEditable(false);								//�����Ұ�

		JEditorPane htmls = new JEditorPane();					//html�ڵ带 ������ ���·� ������ JEditor ����
		htmls.setContentType("text/html");						//html�� ����
		htmls.setEditable(false);								//������

		p2.add(new JScrollPane(text));							//�ǳڿ� �߰�
		p2.add(new JScrollPane(htmls));

		add(p2,BorderLayout.CENTER);							//���� �ǳ� ����� ��ġ
		setSize(500,400);										//ũ�� ����


		jButton.addActionListener(new ActionListener() {		//��ư�� ��������

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					URL url = new URL(txt.getText());			//url �ּҴ� �ؽ�Ʈ�ʵ忡�� �����´�
					BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));	//�Է¹��ۿ� url��Ʈ���� ����ִ´�
					String inLine,full="";						//inLine�� ���� full�� ��� ���� �����ϴ� �����̴�
					while((inLine= in.readLine())!=null) {		//���̻� �о�� ������ ���������� �о�´�
						full+=inLine+"\n";						//�о�� ���� full�� �����Ѵ� 
					}
					in.close();									//���۸� �ݴ´�
					text.setText(full);							//�о�� �ؽ�Ʈ���� JEditor�� �Ѹ���
					htmls.setText(full);

				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});


	}
}


