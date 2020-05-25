package 哈希表;

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
		//没有使用除留余数法System.out.println(ht);
		//使用除留余数法
		System.out.println(ht);
		//获取想要的目标数据
		StuInfo target =new StuInfo(18);
		StuInfo aaa =  ht.get(target);
		System.out.println(aaa);
	}

}
