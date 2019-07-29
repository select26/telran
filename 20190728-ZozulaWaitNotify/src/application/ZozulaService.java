package application;

import java.util.Random;
import java.util.function.UnaryOperator;

public class ZozulaService {
	
	private static Random gen = new Random();
	
	private static Zozula[] forest = null;
	
	public static void fillForest(int numZozulas) {
		fillForest(numZozulas, z -> getNextDefault(z) );
	}
	
	public static void fillForest(int numZozulas, UnaryOperator<Zozula> getNextZozula) {
		forest = new Zozula[numZozulas];
		for (int i=0; i<forest.length; i++) forest[i] = new Zozula(i, getNextZozula);
		//for (int i=1; i<NUM_ZOZULAS; i++) forest[i-1].setNext(forest[i]);
		//forest[forest.length - 1].setNext(forest[0]);
		for (int i=0; i<forest.length; i++) (new Thread(forest[i])).start();
	}
	
	public static Zozula getNextDefault(Zozula zozula) {
		return forest[(zozula.getNum()+1)%forest.length];
	}
	
	public static Zozula getNextRandom(Zozula zozula) {
		Zozula result = null;
		do{
			result = forest[gen.nextInt(forest.length)];
		}while(result.equals(zozula));
		return result;
	}
	
	public static void wakeup(int num) {
		Object mutex = forest[num];
		synchronized (mutex) {
			forest[num].setWokeup(true);
			mutex.notify();
		}
	}

}
