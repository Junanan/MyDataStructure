package 集合;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		//arraylist和linkedlist相差微乎其微只是内部储存结构有些不同
		//add添加 ； remove删除 ； set 修改 ； get 获取
		List list = new ArrayList();
		list.add("谁最帅");
		list.add("俊南最帅");
		list.add(1, "当然是");// 插入到1的位置
		list.remove(1);//不会留下空位 list是一个动态的数组
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		
		//迭代器Iterator 语法:Iterator<E> i = list.iterator();
		//                            ↑        ↑
		//                         泛型可省略   collection的任意之类对象（set与list）
		//hasNext()：如何有课迭代的元素则返回true  next():返回迭代的下一个元素
		//最大的特点可以高效率的遍历集合中的元素
		Collection c = new ArrayList();
		c.add("a");
		c.add("b");
		c.add("c");
		Iterator it =c.iterator();
		while(it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
		
		//Hashset散列集合   语法:set<E> set = new Hashset<E>(); （泛型可省略）
		//HashSet存储对象应该重写hashcode()和equals（）两个方法   不重写使用object的默认方法也行，但是那样可以更加高效的控制集合
		Set set = new HashSet();
		Person p1 =new Person(1,"小杨");
		Person p2 =new Person(2,"小小杨");
		Person p3 =new Person(3,"小小小杨");
		Person p4 =new Person(3,"小小小杨");
		Person p5 =new Person(4,"杨杨洋");
		Person p6 =new Person(4,"杨");
		set.add(p1);
		set.add(p2);
		set.add(p3);
		set.add(p4);//equals方法判别 完全相同不能插入
		set.add(p5);//不能添加
		set.add(p6);                                                        // hashcode相同 名字不同不可以添加吗？
		//hashcode 不能更改
		System.out.println(set.size());//ID相同时 大小不同
		Iterator itt = set.iterator() ;
		while(itt.hasNext()) {
			System.out.println(itt.next());
		}
		//Map<k,v>  (键key 值value) 
		//put(k key , v value) 将键值数据存入map中     cantainKey(Object key) 查找map中是否存在某个键
		//get(Objectkey) 通过键，获取值      containsValue(Object value)  查找Map中是否存在某个值
			Map map = new HashMap();
			map.put("String", "这是一个字符串");
			map.put("int", 1245);
			map.put(new Object(), new Object());
			map.put(null, null);
			System.out.println("map中的元素个数"+map.size());
			Set sett =map.keySet();
			Iterator ittt = sett.iterator();
			while(ittt.hasNext()) {
				Object o = ittt.next();
				System.out.println(o+":"+map.get(o));
			}
			System.out.println(map.get("String"));
			
			// 总结 ：1.List 关心的是索引，可以重复
			//        2.set关心唯一性，它不允许重复
			//        3.Map关心的是唯一的标识符（key）
		
	}

}
