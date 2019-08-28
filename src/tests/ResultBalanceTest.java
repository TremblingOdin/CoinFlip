package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import algorithm.LCGAlgorithm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import coin.Coin;

class ResultBalanceTest {

	int heads;
	int tails;
	
	Coin coin;
	Random rand;
	LCGAlgorithm lcga; 
	
	//I don't know what good coding standards for tests are so I'm just doing what I did at my last job
	@BeforeEach
	void SetUp() throws Exception {
		heads = 0;
		tails = 0;
		
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
		
		for(int i = 0; i < 100; i++) {
			//Need to create a buffer so that the test has more of a random input
			TimeUnit.MILLISECONDS.sleep(rand.nextInt(50));
			
			
			if(coin.Flip()) {
				heads++;
			} else {
				tails++;
			}
			
			if(i % 5 == 0) {
			}
		}
		
		System.out.println("Finished!");
		bw.write("Heads: " + heads);
		bw.write("Tails: " + tails);
	
		bw.close();
	}

	@Test
	void TestLCGAlgorithmBase10() throws InterruptedException, IOException {
		System.out.println("LCG Algorithm test begin");
		
		BufferedWriter bw = FileHelper("LCGABase10.txt");
		
		//To keep track of our possibilities
		int zero = 0;
		int one = 0;
		int two = 0;
		int three = 0;
		int four = 0;
		int five = 0;
		int six = 0;
		int seven = 0;
		int eight = 0;
		int nine = 0;
		
		for(int i =0; i < 100; i++) {
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
		bw.write("0:\t" + zero);
		bw.write("1:\t" + one);
		bw.write("2:\t" + two);
		bw.write("3:\t" + three);
		bw.write("4:\t" + four);
		bw.write("5:\t" + five);
		bw.write("6:\t" + six);
		bw.write("7:\t" + seven);
		bw.write("8:\t" + eight);
		bw.write("9:\t" + nine);
	
		bw.close();
	}
	
	@Test
	void TestCoinWithLCGABuffer() throws InterruptedException {
		System.out.println("LCG Algorithm as buffer for coin test begin");
	}
	
	@Test
	void TestLCGABase10WithLCGABuffer() throws InterruptedException {
		System.out.println("LCG Algorithm as buffer for LCG algorithm test begin");
	}
	
	BufferedWriter FileHelper(String fileName) throws IOException{
		//Clear the file of it's old contents
		File f = new File("./src/tests/resources/" + fileName);
		
		System.out.println(f.getAbsolutePath());
		
		return new BufferedWriter(new FileWriter(f));
	}
}