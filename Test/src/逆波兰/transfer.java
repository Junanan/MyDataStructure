//package �沨��;
//
//import java.util.Stack;
//
//	 
//	import java.util.ArrayList;
//	import java.util.List;
//	 
//		public class transfer {
//	 
//		//�沨�����ʽ������
//		//���ﲻ���ǲ��������ڵ�����λ��û�жԳ������з�0�жϣ�Ҳû�п��ǵ������Լ�С����
//		//����涨����������ȼ��Ӵ�СΪ��()��*��/��-����ʱֻ�����������㡣
//		/*
//		 * �������£�
//		 * 1.�������ǲ�������ֱ�������
//		 * 2.�������ǲ��������������㣩����Ϊread��������ջ���еĲ���������Ϊtop���������ȼ��Ƚϣ�read>top,
//		 * 	  ��readֱ�ӽ�ջ��������ȡ��һ���ַ������read<=top,top��ջ���������list�����У�read������
//		 * 	  ջ��Ԫ�رȽϣ����topΪ�գ���readֱ�ӽ�ջ�����topΪ"(",��ôreadֱ����ջ����Ϊ"("���ȼ���ߣ�
//		 * 3.���ŵĴ�������������"(",ֱ�ӽ����ջ��ֻ�е�����")"��"("�Żᵯ��������")"ʱ����ջ�д���������
//		 * 	  ����ֵĵ�һ��"("�ϵ�Ԫ��ȫ��һ�ε������������list�����У�������"(",���������list�����С�
//		 * */
//		public static String changeNotation(String notation){
//			//����һ���ַ����飬�����ʽת����һ��һ���ַ�
//			char[] arr=notation.toCharArray();
//			//����һ���ַ������飬���������ַ������е��ַ�
//			String[] myArr=new String[arr.length];
//			//�����ַ������е��ַ�Ϊ������������£����Ȩ�أ���ʾ���ȼ�
//			for(int i=0;i<arr.length;i++){
//				//����ַ�Ϊ0-9����������ֱ�Ӽ��뵽myArr�ַ���������
//				if(arr[i]>='0'&&arr[i]<='9'){
//					myArr[i]=arr[i]+"";
//				}else{//�������ֵ������
//					//�����+��-�Ļ�������ַ���һ��Ȩ��1�������뵽�ַ����������
//					if(arr[i]=='+'||arr[i]=='-'){
//						myArr[i]=arr[i]+"1";
//					}else if(arr[i]=='*'||arr[i]=='/'){//�����*��/�Ļ��ͼ�Ȩ��2
//						myArr[i]=arr[i]+"2";
//					}else if(arr[i]=='('){//�����'('�Ļ����ͼ�Ȩ��3
//						myArr[i]=arr[i]+"3";
//					}else{//����Ļ����ַ�һ����')',ֱ�Ӽ����ַ������飬��������
//						myArr[i]=arr[i]+"";
//					}
//				}
//			}
//			//list������������沨�����ʽ��������
//			List<String> list=new ArrayList<String>();
//			//����һ��ջ��������������������ȼ�
//			Stack<String> stack=new Stack<String>();
//			//ѭ�������������ʽ
//			for(int i=0;i<arr.length;i++){
//				//���read�����֣���ֱ�������list��
//				if(arr[i]>='0'&&arr[i]<='9'){
//					list.add(arr[i]+"");
//				}else if(arr[i]=='('){//���read��'('�Ļ�ֱ��ѹջ����ջ���Ƕ�Ӧλ�õ�myArr�ַ�����
//					stack.push(myArr[i]);
//				}else if(arr[i]==')'){//���read��')'�Ļ����򵯳�ջ�е�һ��'('�ϵ�Ԫ��
//					while(!stack.get().equals("(3")){//���ﲻ��Ҫ����ջ���жϣ���Ϊ������Ϊ��
//						list.add(stack.pop().substring(0,1));//��'('�ϵ�Ԫ�������list�����У�������'('
//					}
//					//����'('
//					stack.pop();
//				}else{//�������Ķ�������Ļ���˵��readΪ���������
//					if(stack.isEmpty()){//���ջΪ�գ���ô��ֱ�ӽ���Ӧλ�õ�myArr�ַ�����ջ
//						stack.push(myArr[i]);
//					}else{//����ջ��Ϊ�գ��Ƚ�top��read��Ȩ��
//						//��ȡread�ַ���Ȩ��
//						int num1=Integer.parseInt(myArr[i].substring(1));
//						//��ȡtop�ַ���Ȩ��
//						int num2=Integer.parseInt(stack.get().substring(1));
//						//���top�ַ���Ȩ��Ϊ3��˵����'('����readֱ�ӽ�ջ������Ȩ��read>top��Ҳֱ�ӽ�ջ
//						if(num2==3||num1>num2){
//							stack.push(myArr[i]);
//						}else{//����Ļ�˵��read<=top,��һֱ����ջ��Ԫ�أ��������list������,ֱ����������ѹջΪֹ
//							while(num1<=num2&&num2!=3){//���top��Ȩ�ز�����3����read<=top����һֱ��ջ
//								list.add(stack.pop().substring(0,1));
//								//���»�ȡtop��Ȩ��
//								num2=Integer.parseInt(stack.get().substring(1));				
//							}
//							//��readѹջ
//							stack.push(myArr[i]);
//						}					
//					}				
//				}
//				System.out.println("�ַ���"+arr[i]);
//				System.out.println("list: "+list.toString());
//				System.out.println("stack: "+stack.toString());
//			}
//			//���ʽѭ���жϽ����󣬵���ջ�е�����Ԫ�أ��������list������
//			while(!stack.isEmpty()){
//				list.add(stack.pop().substring(0,1));
//			}
//			//��list�����е�����תΪ�沨�����ʽ
//			String s="";
//			for(int i=0;i<list.size();i++){
//				s+=list.get(i);
//			}
//			return s;
//		}
//		
//		public static void main(String[] args){
//			String notation="6*(5+(2+3)*8+3)";
//			System.out.println("��׺���ʽΪ�� "+notation);
//			System.out.println("----------ת������-----------");
//			String s=changeNotation(notation);
//			System.out.println("----------ת������-----------");
//			System.out.println("�沨�����ʽΪ�� "+s);
//	                //��μ����沨�����ʽ��������һƪ���ͷ���
////			System.out.println("������Ϊ�� "+transfer.countNotation(s));
//		}
//	}
//
