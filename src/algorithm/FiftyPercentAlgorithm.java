package algorithm;

public class FiftyPercentAlgorithm {
	static long startTime;
	
	FiftyPercentAlgorithm() {
		startTime = System.currentTimeMillis();
	}
	
	/**
	 * Algorithm for fifty fifty calculator
	 * It relies a lot on modulo 2 and System time
	 * 
	 * @return
	 */
	public static boolean calculate() {
		long sysTime = System.currentTimeMillis();
		long var = 0;

		if((sysTime%2) == 0) {
		    var = (System.currentTimeMillis() - sysTime) % 2 + 1;
		} else {
		    var = (sysTime - startTime) % 2 + 1;
		}

		if(var % 2 == 0) {
		    return true;
		}

		return false;
	}
}
