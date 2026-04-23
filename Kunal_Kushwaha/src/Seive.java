//PRIME NUMBERS LESS THAN EQUAL TO n
public class Seive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 40;
		boolean[] primes = new boolean[n+1]; //n+1 to include n
		System.out.println(primes[0]);
		seive(n, primes);
	}	
	/*false in array means number is prime
	 *bec By default: boolean array values = false
	 */
	//then make all multiples of that number true, which means not prime
	static void seive(int n, boolean[] primes) {
		for(int i =2; i*i<=n; i++) {
			if(!primes[i]) {
				for(int j = i*2; j<=n; j+=i) {
					primes[j] = true;
				}
			}
		}
		for(int i = 2; i<=n; i++) {
			if(!primes[i]) {
				System.out.print(i + " ");
			}
		}
	}
}
/* AUXILIARY (extra space taken) SPACE COMPLEXITY:
 * O(n)
 */
/* TIME COMPLEXITY:
 * We have to check multiples of numbers from 2 to p, where p is the highest prime
 * number which is less than n
 * so n/2 + n/3 + n/5 + n/7 +.....
 * n(1/2 + 1/3 + 1/5 + 1/7 +..) -> HP for primes
 * so total TIME COMPLEXITY: O(n*log(log n))
 */
