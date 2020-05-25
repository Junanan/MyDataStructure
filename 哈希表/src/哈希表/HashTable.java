package ��ϣ��;

import java.util.Arrays;

public class HashTable {
	private StuInfo[] data = new StuInfo[100];// ����ȷ�����ȣ�ȡ����Integer.MAX_VALUE,�������л���ֹ��󡣡�

	/**
	 * @param stuInfo
	 */
	public void put(StuInfo stuInfo) {
		// ����ɢ�к�����ȡ����λ��
		int index = stuInfo.hashCode();
		// ���Ԫ��
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
