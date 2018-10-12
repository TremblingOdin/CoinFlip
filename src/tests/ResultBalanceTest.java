package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import coin.Coin;

class ResultBalanceTest {

	int heads;
	int tails;
	
	Coin coin;
	Random rand;
	
	//I don't know what good coding standards for tests are so I'm just doing what I did at my last job
	@BeforeEach
	void setUp() throws Exception {
		heads = 0;
		tails = 0;
		
		coin = new Coin();
		rand = new Random();
	}

	@Test
	void test() throws InterruptedException {
		
		
		for(int i = 0; i < 100; i++) {
			//Need to create a buffer so that the test has more of a random input
			TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
			
			
			if(coin.flip()) {
				heads++;
			} else {
				tails++;
			}
			
			if(i % 5 == 0) {
				System.out.println("progress");
			}
		}
		
		System.out.println("Finished! Results: ");
		System.out.println("Heads: " + heads);
		System.out.println("Tails: " + tails);
	}

}
