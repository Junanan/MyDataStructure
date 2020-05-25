package 哈希表;

import java.util.Arrays;

public class HashTable {
	private StuInfo[] data = new StuInfo[100];// 不能确定长度，取最大的Integer.MAX_VALUE,但是运行会出现过大。。

	/**
	 * @param stuInfo
	 */
	public void put(StuInfo stuInfo) {
		// 调用散列函数获取储存位置
		int index = stuInfo.hashCode();
		// 添加元素
		data[index] = stuInfo;
	}

	public StuInfo get(StuInfo stuInfo) {
		return data[stuInfo.hashCode()];
	}



	public void setData(StuInfo[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "HashTable [data=" + Arrays.toString(data) + "]";
	}

}
