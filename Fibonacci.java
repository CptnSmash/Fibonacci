import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * @author Michael Dasan
 *
 * A simple calculator for numbers in the Fibonacci sequence.
 * As this is such a simple class, the default constructor is sufficient,
 * so no constructor is declared.
 */
public class Fibonacci {
	
	@SuppressWarnings("javadoc")
	public static void main(String[] args) {
		Fibonacci fb = new Fibonacci();
		fb.calculate();
	}
	
	/**
	 * Requests a position in the Fibonacci sequence to calculate, then prints that number.
	 * and the time taken in seconds.
	 */
	public void calculate() {
		int fibNum = askFibNum();
		LinkedList<BigInteger> fibQ = new LinkedList<BigInteger>();
		//Seed the queue with the two initial values in the sequence
		fibQ.offer(BigInteger.ONE);
		fibQ.offer(BigInteger.ONE);
		//Because there are two values already in the queue, count starts at 2
		int count = 2;
		long start = System.currentTimeMillis();
		while(count < fibNum) {
			fibQ.offer(fibQ.poll().add(fibQ.peek()));
			count++;
		}
		long end = System.currentTimeMillis();
		//The solution is now the second value in the queue, so print that
		System.out.printf("Fibonacci number #%d: %d\n", fibNum, fibQ.get(1));
		System.out.printf("Operation completed in %.3f seconds.\n", (double) (end - start) / 1000);
	}
	
	/**
	 * Asks the user which position in the Fibonacci sequence they would like to calculate.
	 * The value the user provides must be an integer > 0.
	 * 
	 * @return The requested position
	 */
	private int askFibNum() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int fibNum;
		while(true) {
			try {
				System.out.println("Enter the position of the Fibonacci number you would like to calculate: ");
				fibNum = Integer.parseInt(br.readLine());
				if(fibNum <= 0) {
					throw new InvalidNumberException();
				}
				break;
			}catch(IOException ioe) {
				System.out.println("Could not read input, please try again.");
			}catch(InvalidNumberException ine) {
				System.out.println("Number must be greater than 0. Please try again.");
			}catch(NumberFormatException nfe) {
				System.out.println("Input must be a whole number. Please try again..");
			}
		}
		return fibNum;
	}
	
	/**
	 * A simple exception class for when the user-selected number is too low.
	 * Declared as a private nested class because it should never need to be 
	 * used outside of this class.
	 *
	 */
	private class InvalidNumberException extends Exception {

		@SuppressWarnings("javadoc")
		private static final long serialVersionUID = -4862128494261167304L;	
		
	}

}
