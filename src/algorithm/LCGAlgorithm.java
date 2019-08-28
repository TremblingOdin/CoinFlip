package algorithm;

public class LCGAlgorithm {
	//Everything is a double until someone asks for an int then convert
	
	//There are different modulos but the default is base 10
	private final double modulus10 = 10;
	//Square root of 13
	private final double dMultiplier = 3.60555;
	private final double dIncrement = 9;
	
	private final long lMultiplier = 7;
	private final long lIncrement = 1;
	
	
	/**
	 * Initializes the program, should this be a private static?
	 */
	public LCGAlgorithm() {
	}
	
	/**
	 * Processes the seed in a base 10 system turning it into a double
	 */
	public double GenAndProcessSeedDouble() {
		double seed = (double) System.currentTimeMillis();
		return ((this.dMultiplier*seed + this.dIncrement) % this.modulus10);
	}
	
	/**
	 * Process the seed with the desired modulo (which defines the set it's working in I'm pretty sure
	 * @param modulo
	 * @return
	 */
	public double GenAndProcessSeedDouble(int modulo) {
		double seed = (double) System.currentTimeMillis();
		return ((this.dMultiplier*seed + this.dIncrement) % modulo);
	}
	
	/**
	 * Processes the seed in a base 10 system returning an int because modulo 10, uses a different set of numbers to accommodate the long
	 * @return
	 */
	public int GenAndProcessSeedLong() {
		return (int) ((this.lMultiplier*System.currentTimeMillis() + this.lIncrement) 
					% (long) this.modulus10);
	}
	
	/**
	 * Processes the seed with the desired modulo
	 * @param modulo
	 * @return
	 */
	public long GenAndProcessSeedLong(int modulo) {
		return (this.lMultiplier*System.currentTimeMillis() + this.lIncrement)
					% modulo;
	}
}
