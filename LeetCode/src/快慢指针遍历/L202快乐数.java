package 快慢指针遍历;

//编写一个算法来判断一个数 n 是不是快乐数。
//
//「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，
//也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
//
//如果 n 是快乐数就返回 True ；不是，则返回 False 。
//
// 
//
//示例：
//
//输入：19
//输出：true
//解释：
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
public class L202快乐数 {
//	判断循环就用快慢指针
	//不是快乐数的话  会在某个数字进入循环
//	如果 n 是一个快乐数，即没有循环，那么快跑者最终会比慢跑者先到达数字 1。
//
//	如果 n 不是一个快乐的数字，那么最终快跑者和慢跑者将在同一个数字上相遇。
	public boolean isHappy(int n) {
		int fast = n, slow = n;
		do {
			slow = squarenum(slow);
			fast = squarenum(fast);
			fast = squarenum(fast);
		}while(fast!=slow);
		return slow == 1;
	}
	
	private int squarenum(int n) {
		int sum =0,temp = 0;
		while(n!=0) {
			temp = n%10;
			sum += temp*temp;
			n /= 10;
		}
	return sum;
}
//	时间复杂度：O(\log n)O(logn)。该分析建立在对前一种方法的分析的基础上，但是这次我们需要跟踪两个指针而不是一个指针来分析，以及在它们相遇前需要绕着这个循环走多少次。
//	如果没有循环，那么快跑者将先到达 1，慢跑者将到达链表中的一半。我们知道最坏的情况下，成本是 O(2 \cdot \log n) = O(\log n)O(2⋅logn)=O(logn)。
//	一旦两个指针都在循环中，在每个循环中，快跑者将离慢跑者更近一步。一旦快跑者落后慢跑者一步，他们就会在下一步相遇。假设循环中有 kk 个数字。如果他们的起点是相隔 k-1k−1 的位置（这是他们可以开始的最远的距离），那么快跑者需要 k-1k−1 步才能到达慢跑者，这对于我们的目的来说也是不变的。因此，主操作仍然在计算起始 n 的下一个值，即 O(\log n)O(logn)。
//	空间复杂度：O(1)O(1)，对于这种方法，我们不需要哈希集来检测循环。指针需要常数的额外空间。



	//超时
	public boolean isHappyy(int n) {
		while (n != 1) {
			String a = String.valueOf(n);
			for (int i = 0; i < a.length(); i++) {
				n += Math.sqrt(a.charAt(i) - 48);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String a = String.valueOf(123);
		char i = a.charAt(0);
		int q = i - 48;
		char x = 97;
		System.out.println(q);
		System.out.println(x);
	}
}
