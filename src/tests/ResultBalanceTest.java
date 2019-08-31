package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import algorithm.LCGAlgorithm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import coin.Coin;

class ResultBalanceTest {

	double heads;
	double tails;
	double zero;
	double one;
	double two;
	double three;
	double four;
	double five;
	double six;
	double seven;
	double eight;
	double nine;
	double total;
	
	Coin coin;
	Random rand;
	LCGAlgorithm lcga; 
	
	@BeforeEach
	void SetUp() throws Exception {
		heads = 0;
		tails = 0;
		
		
		//To keep track of our possibilities
		zero = 0;
		one = 0;
		two = 0;
		three = 0;
		four = 0;
		five = 0;
		six = 0;
		seven = 0;
		eight = 0;
		nine = 0;
		
		total = 10000;
		
		coin = new Coin();
		rand = new Random();
		lcga = new LCGAlgorithm();
	}

	@AfterEach
	void TearDown() throws Exception {
		coin = null;
		rand = null;
		
		lcga = null;
	}
	
	@Test
	void TestCoin() throws InterruptedException, IOException {
		System.out.println("Coin test/~50% test begin");
		
		BufferedWriter bw = FileHelper("Coin.txt");
		
		for(int i = 0; i < 10000; i++) {
			//Need to create a buffer so that the test has more of a random input
			TimeUnit.MILLISECONDS.sleep(rand.nextInt(50));
			
			
			if(coin.Flip()) {
				heads++;
			} else {
				tails++;
			}
		}
		
		System.out.println("Finished!");
		bw.write("Heads: " + ((heads/total)*100) + "%\n");
		bw.write("Tails: " + ((tails/total)*100) + "%\n");
	
		bw.close();
	}

	@Test
	void TestLCGAlgorithmBase10() throws InterruptedException, IOException {
		System.out.println("LCG Algorithm test begin");
		
		BufferedWriter bw = FileHelper("LCGABase10.txt");	
		
		for(int i = 0; i < total; i++) {
			//Need to create a buffer so that the test has more of a random input
			TimeUnit.MILLISECONDS.sleep(rand.nextInt(50));

			switch(lcga.GenAndProcessSeedLong()) {
				case 1: one++;
					break;
				case 2: two++;
					break;
				case 3: three++;
					break;
				case 4: four++;
					break;
				case 5: five++;
					break;
				case 6: six++;
					break;
				case 7: seven++;
					break;
				case 8: eight++;
					break;
				case 9: nine++;
					break;
				default: zero++;
					break;
			}
		}
		
		System.out.println("Finished!");
		bw.write("0:\t" + ((zero/total)*100) + "%\n");
		bw.write("1:\t" + ((one/total)*100) + "%\n");
		bw.write("2:\t" + ((two/total)*100) + "%\n");
		bw.write("3:\t" + ((three/total)*100) + "%\n");
		bw.write("4:\t" + ((four/total)*100) + "%\n");
		bw.write("5:\t" + ((five/total)*100) + "%\n");
		bw.write("6:\t" + ((six/total)*100) + "%\n");
		bw.write("7:\t" + ((seven/total)*100) + "%\n");
		bw.write("8:\t" + ((eight/total)*100) + "%\n");
		bw.write("9:\t" + ((nine/total)*100) + "%\n");
	
		bw.close();
	}
	
	//@Test
	void TestCoinWithLCGABuffer() throws InterruptedException, IOException {
		System.out.println("LCG Algorithm as buffer for coin test begin");

		BufferedWriter bw = FileHelper("CoinAndLCGA.txt");
		
		for(int i = 0; i < total; i++) {
			//Need to create a buffer so that the test has more of a random input
			TimeUnit.MILLISECONDS.sleep(rand.nextInt(50));
			
			
			if(coin.Flip()) {
				heads++;
			} else {
				tails++;
			}
		}
		
		System.out.println("Finished!");
		bw.write("Heads: " + ((heads/total)*100) + "%\n");
		bw.write("Tails: " + ((tails/total)*100) + "%\n");
	
		bw.close();
	}
	
	//@Test
	void TestLCGABase10WithLCGABuffer() throws InterruptedException, IOException {
		System.out.println("LCG Algorithm as buffer for LCG algorithm test begin");
		
		BufferedWriter bw = FileHelper("LCGABase10WithLCGA.txt");	
		
		for(int i = 0; i < total; i++) {
			//Need to create a buffer so that the test has more of a random input
			TimeUnit.MILLISECONDS.sleep(rand.nextInt(50));

			switch(lcga.GenAndProcessSeedLong()) {
				case 1: one++;
					break;
				case 2: two++;
					break;
				case 3: three++;
					break;
				case 4: four++;
					break;
				case 5: five++;
					break;
				case 6: six++;
					break;
				case 7: seven++;
					break;
				case 8: eight++;
					break;
				case 9: nine++;
					break;
				default: zero++;
					break;
			}
		}
		
		System.out.println("Finished!");
		bw.write("0:\t" + ((zero/total)*100) + "%\n");
		bw.write("1:\t" + ((one/total)*100) + "%\n");
		bw.write("2:\t" + ((two/total)*100) + "%\n");
		bw.write("3:\t" + ((three/total)*100) + "%\n");
		bw.write("4:\t" + ((four/total)*100) + "%\n");
		bw.write("5:\t" + ((five/total)*100) + "%\n");
		bw.write("6:\t" + ((six/total)*100) + "%\n");
		bw.write("7:\t" + ((seven/total)*100) + "%\n");
		bw.write("8:\t" + ((eight/total)*100) + "%\n");
		bw.write("9:\t" + ((nine/total)*100) + "%\n");
	
		bw.close();
	}
	
	@Test
	void TestLCGAWithRandomBase() throws InterruptedException, IOException {
		System.out.println("LCG Algorithm as buffer for LCG algorithm test begin");
		
		
		int maxRange = 10;
		while(maxRange == 10) {
			maxRange = (int) lcga.GenAndProcessSeedDouble(100);
		}
		
		ArrayList<Double> count = new ArrayList<>(maxRange);

		for(int i = 0; i < maxRange; i++) {
			count.add(0d);
		}
		
		BufferedWriter bw = FileHelper("LCGARandomBase.txt");	
		
		for(int i = 0; i < total; i++) {
			//Need to create a buffer so that the test has more of a random input
			TimeUnit.MILLISECONDS.sleep(rand.nextInt(50));

			int index = (int) lcga.GenAndProcessSeedDouble(maxRange);
			double oldCount = count.get(index);
			count.set(index, ++oldCount);
		}
		
		System.out.println("Finished!");
		for(int i = 0; i < maxRange; i++) {
		bw.write(i + ":\t" + ((count.get(i)/total)*100) + "%\n");
		}
		
		bw.close();
	}
	
	BufferedWriter FileHelper(String fileName) throws IOException{
		//Clear the file of it's old contents
		File f = new File("./src/tests/resources/" + fileName);
		
		System.out.println(f.getAbsolutePath());
		
		return new BufferedWriter(new FileWriter(f));
	}
}