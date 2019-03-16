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
					UrljFrame frame = new UrljFrame();			//프레임 생성
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UrljFrame() {
		// TODO Auto-generated constructor stub
		setTitle("뿌엑");											//타이틀 설정
		setDefaultCloseOperation(EXIT_ON_CLOSE);				//종료 설정

		JPanel p1 = new JPanel();								//html링크를 받아올 UI를 담을 판낼 생성 

		TextField txt = new TextField(30);						//텍스트필드 생성
		JButton jButton = new JButton("HTML 가져오기");			//버튼 생성
		p1.add(new JLabel("URL : "));							//설명 라벨 추가
		p1.add(txt);											//텍스트필드 판넬에 추가
		p1.add(jButton);										//버튼 판넬에 추가

		add(p1,BorderLayout.SOUTH);								//판넬의 메인 판넬의 아래쪽에 배치


		JPanel p2 = new JPanel();								//JEditor를 담을 판넬 생성
		p2.setLayout(new GridLayout(2, 1));						//가로로 배치하기 위해 그리드레이아웃으로 설정

		JEditorPane text= new JEditorPane();					//html코드를 텍스트 상태로 담을 JEditor 생성
		text.setContentType("text/plain");						//플레인으로 설정
		text.setEditable(false);								//수정불가

		JEditorPane htmls = new JEditorPane();					//html코드를 디버깅된 상태로 보여줄 JEditor 생성
		htmls.setContentType("text/html");						//html로 설정
		htmls.setEditable(false);								//수정블가

		p2.add(new JScrollPane(text));							//판넬에 추가
		p2.add(new JScrollPane(htmls));

		add(p2,BorderLayout.CENTER);							//메인 판넬 가운데에 배치
		setSize(500,400);										//크기 설정


		jButton.addActionListener(new ActionListener() {		//버튼이 눌렸을때

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					URL url = new URL(txt.getText());			//url 주소는 텍스트필드에서 가져온다
					BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));	//입력버퍼에 url스트림을 집어넣는다
					String inLine,full="";						//inLine은 한줄 full은 모든 줄을 저장하는 변수이다
					while((inLine= in.readLine())!=null) {		//더이상 읽어올 라인이 없을때까지 읽어온다
						full+=inLine+"\n";						//읽어온 줄은 full에 저장한다 
					}
					in.close();									//버퍼를 닫는다
					text.setText(full);							//읽어온 텍스트들을 JEditor에 뿌린다
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


