package application;

import java.util.ArrayList;

public class ZozulaWaitNotifyApp {

	private static final int NUM_ZOZULAS = 10;

	public static void main(String[] args) {
	/*	Zozula[] forest = new Zozula[NUM_ZOZULAS];
		for (int i=0; i<NUM_ZOZULAS; i++) forest[i] = new Zozula(i);
		for (int i=1; i<NUM_ZOZULAS; i++) forest[i-1].setNext(forest[i]);
		forest[forest.length - 1].setNext(forest[0]);
		for (int i=0; i<NUM_ZOZULAS; i++) (new Thread(forest[i])).start();
		
		Object mutex0 = forest[0].getMutex();
		synchronized (mutex0) {
			forest[0].setWokeup(true);
			mutex0.notify();
		}*/
		
		ZozulaService.fillForest(NUM_ZOZULAS, ZozulaService::getNextRandom);
		ZozulaService.wakeup(5);
	}

}
