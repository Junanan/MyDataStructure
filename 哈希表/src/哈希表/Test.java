package ��ϣ��;

public class Test {
	public static void main(String[] args) {
		StuInfo S1 = new StuInfo(16, 3);
		StuInfo S2 = new StuInfo(17, 11);
		StuInfo S3 = new StuInfo(18, 23);
		StuInfo S4 = new StuInfo(19, 24);
		StuInfo S5 = new StuInfo(20, 9);
		HashTable ht = new HashTable();
		ht.put(S1);
		ht.put(S2);
		ht.put(S3);
		ht.put(S4);
		ht.put(S5);
		//û��ʹ�ó���������System.out.println(ht);
		//ʹ�ó���������
		System.out.println(ht);
		//��ȡ��Ҫ��Ŀ������
		StuInfo target =new StuInfo(18);
		StuInfo aaa =  ht.get(target);
		System.out.println(aaa);
	}

}
