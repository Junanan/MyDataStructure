package Daily;

public class L204计数质数 {
	public int countPrimes(int n) {
		if(n < 2) return 0;
		int count = 0;
		for(int i = 2; i < n ;i++) {
			if(isPrimes(i)) {
				count++;
			}
		}
		return count;
    }

	private boolean isPrimes(int i) {
		int max = (int)Math.sqrt(i);
		for(int j = 2; j <= max;j++) {
			if(i%j == 0) {
				return false;
			}
		}
		return true;
	}
}
