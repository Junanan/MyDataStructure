package ����;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		//arraylist��linkedlist���΢����΢ֻ���ڲ�����ṹ��Щ��ͬ
		//add��� �� removeɾ�� �� set �޸� �� get ��ȡ
		List list = new ArrayList();
		list.add("˭��˧");
		list.add("������˧");
		list.add(1, "��Ȼ��");// ���뵽1��λ��
		list.remove(1);//�������¿�λ list��һ����̬������
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		
		//������Iterator �﷨:Iterator<E> i = list.iterator();
		//                            ��        ��
		//                         ���Ϳ�ʡ��   collection������֮�����set��list��
		//hasNext()������пε�����Ԫ���򷵻�true  next():���ص�������һ��Ԫ��
		//�����ص���Ը�Ч�ʵı��������е�Ԫ��
		Collection c = new ArrayList();
		c.add("a");
		c.add("b");
		c.add("c");
		Iterator it =c.iterator();
		while(it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
		
		//Hashsetɢ�м���   �﷨:set<E> set = new Hashset<E>(); �����Ϳ�ʡ�ԣ�
		//HashSet�洢����Ӧ����дhashcode()��equals������������   ����дʹ��object��Ĭ�Ϸ���Ҳ�У������������Ը��Ӹ�Ч�Ŀ��Ƽ���
		Set set = new HashSet();
		Person p1 =new Person(1,"С��");
		Person p2 =new Person(2,"СС��");
		Person p3 =new Person(3,"ССС��");
		Person p4 =new Person(3,"ССС��");
		Person p5 =new Person(4,"������");
		Person p6 =new Person(4,"��");
		set.add(p1);
		set.add(p2);
		set.add(p3);
		set.add(p4);//equals�����б� ��ȫ��ͬ���ܲ���
		set.add(p5);//�������
		set.add(p6);                                                        // hashcode��ͬ ���ֲ�ͬ�����������
		//hashcode ���ܸ���
		System.out.println(set.size());//ID��ͬʱ ��С��ͬ
		Iterator itt = set.iterator() ;
		while(itt.hasNext()) {
			System.out.println(itt.next());
		}
		//Map<k,v>  (��key ֵvalue) 
		//put(k key , v value) ����ֵ���ݴ���map��     cantainKey(Object key) ����map���Ƿ����ĳ����
		//get(Objectkey) ͨ��������ȡֵ      containsValue(Object value)  ����Map���Ƿ����ĳ��ֵ
			Map map = new HashMap();
			map.put("String", "����һ���ַ���");
			map.put("int", 1245);
			map.put(new Object(), new Object());
			map.put(null, null);
			System.out.println("map�е�Ԫ�ظ���"+map.size());
			Set sett =map.keySet();
			Iterator ittt = sett.iterator();
			while(ittt.hasNext()) {
				Object o = ittt.next();
				System.out.println(o+":"+map.get(o));
			}
			System.out.println(map.get("String"));
			
			// �ܽ� ��1.List ���ĵ��������������ظ�
			//        2.set����Ψһ�ԣ����������ظ�
			//        3.Map���ĵ���Ψһ�ı�ʶ����key��
		
	}

}
