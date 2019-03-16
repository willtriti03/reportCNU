package horsegame;

import java.util.ArrayList;
import java.util.Random;

public class HorseThread extends Thread {
	Random random = new Random(); //랜덤이동을 위한 랜덤 인스턴스
	private RankDetector raceDetector; 	//랭킹처리
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
					System.out.println(name + "번 말은 지금 " + num + "m에 있습니다.");
				} else {
					Thread.sleep(100);
					System.out.println(name + "번 말은 지금 " + num + "m에 있습니다.");
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		raceDetector.goalIn(name);


	}
}
