package HOT100;

//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
//示例 1：
//
//输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//示例 2：
//
//输入: "cbbd"
//输出: "bb"
public class L5最长回文子串 {
	public class Solution {
//		中心扩散
	    public String longestPalindrome(String s) {
	        int len = s.length();
	        if (len < 2) {
	            return s;
	        }	
	        int maxLen = 1;
	        String res = s.substring(0, 1);
	        // 中心位置枚举到 len - 2 即可
	        for (int i = 0; i < len - 1; i++) {
	            String oddStr = centerSpread(s, i, i);
	            String evenStr = centerSpread(s, i, i + 1);
	            String maxLenStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
	            if (maxLenStr.length() > maxLen) {
	                maxLen = maxLenStr.length();
	                res = maxLenStr;
	            }
	        }
	        return res;
	    }

	    private String centerSpread(String s, int left, int right) {
	        // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
	        // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
	        int len = s.length();
	        int i = left;
	        int j = right;
	        while (i >= 0 && j < len) {
	            if (s.charAt(i) == s.charAt(j)) {
	                i--;
	                j++;
	            } else {
	                break;
	            }
	        }
	        // 这里要小心，跳出 while 循环时，恰好满足 s.charAt(i) != s.charAt(j)，因此不能取 i，不能取 j
	        return s.substring(i + 1, j);
	    }
	}
//	暴力
//	 int maxLen = 1;
//     int begin = 0;
//     // s.charAt(i) 每次都会检查数组下标越界，因此先转换成字符数组
//     char[] charArray = s.toCharArray();
//
//     // 枚举所有长度大于 1 的子串 charArray[i..j]
//     for (int i = 0; i < len - 1; i++) {
//         for (int j = i + 1; j < len; j++) {
//             if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)) {
//                 maxLen = j - i + 1;
//                 begin = i;
//             }
//         }
//     }
//     return s.substring(begin, begin + maxLen);
// }
//
// /**
//  * 验证子串 s[left..right] 是否为回文串
//  */
// private boolean validPalindromic(char[] charArray, int left, int right) {
//     while (left < right) {
//         if (charArray[left] != charArray[right]) {
//             return false;
//         }
//         left++;
//         right--;
//     }
//     return true;
// }
//}
//复杂度分析：
//
//时间复杂度：O(N^3)O(N 
//3
//)，这里 NN 是字符串的长度，枚举字符串的左边界、右边界，然后继续验证子串是否是回文子串，这三种操作都与 NN 相关；
//空间复杂度：O(1)，只使用到常数个临时变量，与字符串长度无关。
	public String longestPalindrome(String s) {
		int len = s.length();
		char[] temp = s.toCharArray();
		boolean[][] dp = new boolean[len][len];
		int maxLen =0;
		int start = 0;
		//初始化对角线  因为一样的字符所以都为true
		for(int i=0;i<len;i++) {
			dp[i][i] = true;
		}
		for(int i=1;i<len;i++) {
			for(int j=0;j<i;j++) {
				if(temp[i]!=temp[j]) {
					dp[i][j] =false;
				}else{
					if(j-i<3) {  //  边界状态 当头尾的字符相等时 长度为2 肯定为 回文串
						dp[i][j] = true; 
					}else {
						dp[i][j] = dp[i+1][j-1]; //  转移状态 判断子串是否i为回文串
					}
				}
				if(dp[i][j]&&(j-i+1>maxLen)) {
					maxLen = j-i+1;
					start = i;
			}
			}
		}
		return s.substring(start, maxLen+start);
    }
}
