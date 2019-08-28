package coin;

import algorithm.FiftyPercentAlgorithm;

public class Coin {
	boolean heads;
	
	public Coin() {
		heads = false;
	}
	
	/**
	 * Calls fiftyPercentAlgorithm and assigns the output to heads
	 * 
	 * @return boolean true or false of whether coin landed on heads
	 */
	public boolean Flip() {
		heads = FiftyPercentAlgorithm.Calculate();
		
		return heads;
	}
	
	/**
	 * When given an amount of trials to be run, executes flip() that many times and returns results
	 * 
	 * @param int trials to be run
	 * @return boolean[] of all flips
	 */
	public boolean[] Flip(int trials) {
		boolean[] flips = new boolean[trials];
		for(int i = 0; i < trials; i++) {
			flips[i] = Flip();
		}
		
		return flips;
		
	}
}
