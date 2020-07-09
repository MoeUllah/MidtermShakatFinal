package math.problems;

public class PrimeNumber {

	public static void main(String[] args) {
		/*
		 * Find list of Prime numbers from number 2 to 1 million. Try the best solution
		 * as possible.Which will take less CPU life cycle. Out put number of Prime
		 * numbers on the given range.
		 *
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 *
		 */
		int numberOfPrimes = isPrime(100);
		System.out.println("Number of prime number is " + numberOfPrimes);
	}

	public static int isPrime(int num) {
		boolean[] primes = new boolean[num + 1];
		for (int i = 0; i < primes.length; i++) {
			primes[i] = true;
		}
		for (int k = 2; k <= num / k; k++) {
			if (primes[k]) {
				for (int i = k; i <= num / k; i++) {
					primes[k * i] = false;
				}
			}
		}
		int count = 0;
		for (int i = 2; i < primes.length; i++) {
			if (primes[i]) {
				System.out.println(i + " ");
				count++;

			}
		}
		System.out.println("\n" + count + " prime numbers.");
		return count;
	}

}
