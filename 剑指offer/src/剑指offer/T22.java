package ��ָoffer;

import java.util.Arrays;

//����������������������ϲ�����������ʹ�������еĽڵ���Ȼ�ǵ�������ġ�
//
//ʾ��1��
//
//���룺1->2->4, 1->3->4
//�����1->1->2->3->4->4
public class T22 {
//	public class ListNode {
//		      int val;
//		     ListNode next;
//		    ListNode(int x) { val = x; }
//	}
	//�鲢�����˼��
	 public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 ////����³����
		 if(l1==null) return l2;
		 if(l2==null) return l1;
		 //��������ͷ��� ���û������ͷ��� ��һ���ڵ������l1��Ҳ������l2��
		 ListNode dum = new ListNode(0) , cur = dum;////// dum Ϊ����ͷ���head  
		 while(l1!=null&&l2!=null) {
			 if(l1.val<l2.val) {
				 cur.next = l1;
				 l1=l1.next;
			 }else {
				 cur.next = l2;
				 l2=l2.next;
			 }
			 cur = cur.next;
		 }
		 //�������ڵ�
		 if(l1!=null) cur.next = l1;
		 if(l2!=null) cur.next = l2;
		 return dum.next;
	    }
	 public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode a1 = new ListNode(2);
		ListNode a2 = new ListNode(4);
		ListNode b1 = new ListNode(1);
		ListNode b2 = new ListNode(3);
		ListNode b3 = new ListNode(4);
		a.append(a1).append(a2);
		b1.append(b2).append(b3);
		ListNode g = mergeTwoLists(a, b1);
		g.show();
	}

}
