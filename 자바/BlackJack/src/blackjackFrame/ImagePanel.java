package blackjackFrame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{
	private Image img;								//이미지를 저장해둘 변수
	public ImagePanel(){}							//생성자
	public ImagePanel(String path){					//이미지 경로가 들어오면 이미지로 바꿔서 처리
		this(new ImageIcon(path).getImage());
	} 
	public ImagePanel(Image img) {					//이미지가 들어오면 처리
		this.img =img;								//이미지 저장
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));	//크기 설정
		setPreferredSize(size);														
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}
	
	public void setImage(String img) {
		// TODO Auto-generated method stub
		this.img = new ImageIcon(img).getImage();
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {			// 이미지 그리기
		// TODO Auto-generated method stub
		g.drawImage(img, 0, 0, null);
	}

}
