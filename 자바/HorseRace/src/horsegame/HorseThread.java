package horsegame;

import java.util.ArrayList;
import java.util.Random;

public class HorseThread extends Thread {
	Random random = new Random(); //�����̵��� ���� ���� �ν��Ͻ�
	private RankDetector raceDetector; 	//��ŷó��
	private int name, track;

	public HorseThread(int name, int track, RankDetector raceDetector) {
		this.name = name;
		this.track = track;
		this.raceDetector = raceDetector;
	}

	public void run() {
		int num = 0, stop;
		while (num < track) {
			try {
				int rand; 
				if(track-num >= 10)
					rand = random.nextInt(11);
				else
					rand = random.nextInt(track - num+1);
				
				num += rand;
				stop = random.nextInt(10);
				
				if (stop == 4) {
					System.out.println(name + "�� ���� ���� " + num + "m�� �ֽ��ϴ�.");
				} else {
					Thread.sleep(100);
					System.out.println(name + "�� ���� ���� " + num + "m�� �ֽ��ϴ�.");
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		raceDetector.goalIn(name);


	}
}
