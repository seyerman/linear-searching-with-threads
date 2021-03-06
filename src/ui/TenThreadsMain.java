package ui;

import java.util.LinkedList;
import java.util.List;

import model.Searching;
import thread.SearchingThread;

public class TenThreadsMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Program started.");
		System.out.println("Generating random integer list...");
		List<Integer> intList = generateRandomList(100000, 1000);
		System.out.println("Random integer list generated.");
		
		Searching sch1 = new Searching(intList, 5, 0, 10000);
		Searching sch2 = new Searching(intList, 5, 10000, 20000);
		Searching sch3 = new Searching(intList, 5, 20000, 30000);
		Searching sch4 = new Searching(intList, 5, 30000, 40000);
		Searching sch5 = new Searching(intList, 5, 40000, 50000);
		Searching sch6 = new Searching(intList, 5, 50000, 60000);
		Searching sch7 = new Searching(intList, 5, 60000, 70000);
		Searching sch8 = new Searching(intList, 5, 70000, 80000);
		Searching sch9 = new Searching(intList, 5, 80000, 90000);
		Searching sch10 = new Searching(intList, 5, 90000, 100000);
		
		SearchingThread st1 = new SearchingThread(sch1);
		SearchingThread st2 = new SearchingThread(sch2);
		SearchingThread st3 = new SearchingThread(sch3);
		SearchingThread st4 = new SearchingThread(sch4);
		SearchingThread st5 = new SearchingThread(sch5);
		SearchingThread st6 = new SearchingThread(sch6);
		SearchingThread st7 = new SearchingThread(sch7);
		SearchingThread st8 = new SearchingThread(sch8);
		SearchingThread st9 = new SearchingThread(sch9);
		SearchingThread st10 = new SearchingThread(sch10);
		
		System.out.println("Counting numbers...");
		
		long initTime = System.currentTimeMillis();
		
		st1.start();
		st2.start();
		st3.start();
		st4.start();
		st5.start();
		st6.start();
		st7.start();
		st8.start();
		st9.start();
		st10.start();
		
		st1.join();
		st2.join();
		st3.join();
		st4.join();
		st5.join();
		st6.join();
		st7.join();
		st8.join();
		st9.join();
		st10.join();
		
		long endTime = System.currentTimeMillis();
				
		int output  = sch1.getTotal();
		output += sch2.getTotal();
		output += sch3.getTotal();
		output += sch4.getTotal();
		output += sch5.getTotal();
		output += sch6.getTotal();
		output += sch7.getTotal();
		output += sch8.getTotal();
		output += sch9.getTotal();
		output += sch10.getTotal();
		
		System.out.println("Numbers counted.");
		System.out.println("5 is "+output+" times in the random array");
		System.out.println("Duration with 10 threads: "+(endTime-initTime));
	}
	
	public static List<Integer> generateRandomList(int size, int max) {
		List<Integer> randomArray = new LinkedList<Integer>();
		
		for (int i = 0; i < size; i++) {
			int randomNumber = (int)(Math.random()*max);
			randomArray.add(randomNumber);
		}
		
		return randomArray;
	}
}
