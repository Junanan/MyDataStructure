//package 逆波兰;
//
//import java.util.Stack;
//
//	 
//	import java.util.ArrayList;
//	import java.util.List;
//	 
//		public class transfer {
//	 
//		//逆波兰表达式的生成
//		//这里不考虑操作数大于等于两位，没有对除数进行非0判断，也没有考虑到负数以及小数。
//		//这里规定运算符的优先级从大到小为：()、*、/、-。暂时只考虑四则运算。
//		/*
//		 * 规则如下：
//		 * 1.读到的是操作数，直接输出；
//		 * 2.读到的是操作符（四则运算），记为read，将其与栈顶中的操作符（即为top）进行优先级比较，read>top,
//		 * 	  则read直接进栈，继续读取下一个字符；如果read<=top,top出栈，并输出到list集合中，read继续和
//		 * 	  栈顶元素比较；如果top为空，则read直接进栈；如果top为"(",那么read直接入栈，因为"("优先级最高；
//		 * 3.括号的处理：读到左括号"(",直接将其进栈，只有当遇到")"，"("才会弹出；读到")"时，将栈中从上往下最
//		 * 	  早出现的第一个"("上的元素全部一次弹出，并输出到list集合中，并弹出"(",但不输出到list集合中。
//		 * */
//		public static String changeNotation(String notation){
//			//定义一个字符数组，将表达式转换成一个一个字符
//			char[] arr=notation.toCharArray();
//			//定义一个字符串数组，用来处理字符数组中的字符
//			String[] myArr=new String[arr.length];
//			//处理字符数组中的字符为操作符的情况下，添加权重，表示优先级
//			for(int i=0;i<arr.length;i++){
//				//如果字符为0-9，则不做处理直接加入到myArr字符串数组中
//				if(arr[i]>='0'&&arr[i]<='9'){
//					myArr[i]=arr[i]+"";
//				}else{//不是数字的情况下
//					//如果是+、-的话，则给字符加一个权重1，并加入到字符串数组汇总
//					if(arr[i]=='+'||arr[i]=='-'){
//						myArr[i]=arr[i]+"1";
//					}else if(arr[i]=='*'||arr[i]=='/'){//如果是*、/的话就加权重2
//						myArr[i]=arr[i]+"2";
//					}else if(arr[i]=='('){//如果是'('的话，就加权重3
//						myArr[i]=arr[i]+"3";
//					}else{//否则的话该字符一定是')',直接加入字符串数组，不做处理
//						myArr[i]=arr[i]+"";
//					}
//				}
//			}
//			//list集合用来存放逆波兰表达式的输出结果
//			List<String> list=new ArrayList<String>();
//			//定义一个栈，用来处理操作符的优先级
//			Stack<String> stack=new Stack<String>();
//			//循环遍历整个表达式
//			for(int i=0;i<arr.length;i++){
//				//如果read是数字，则直接输出到list中
//				if(arr[i]>='0'&&arr[i]<='9'){
//					list.add(arr[i]+"");
//				}else if(arr[i]=='('){//如果read是'('的话直接压栈（入栈的是对应位置的myArr字符串）
//					stack.push(myArr[i]);
//				}else if(arr[i]==')'){//如果read是')'的话，则弹出栈中第一个'('上的元素
//					while(!stack.get().equals("(3")){//这里不需要进行栈空判断，因为不可能为空
//						list.add(stack.pop().substring(0,1));//将'('上的元素输出到list集合中，不包括'('
//					}
//					//弹出'('
//					stack.pop();
//				}else{//如果上面的都不满足的话，说明read为四则运算符
//					if(stack.isEmpty()){//如果栈为空，那么则直接将对应位置的myArr字符串入栈
//						stack.push(myArr[i]);
//					}else{//否则栈不为空，比较top和read的权重
//						//获取read字符的权重
//						int num1=Integer.parseInt(myArr[i].substring(1));
//						//获取top字符的权重
//						int num2=Integer.parseInt(stack.get().substring(1));
//						//如果top字符的权重为3，说明是'('，这read直接进栈，或者权重read>top，也直接进栈
//						if(num2==3||num1>num2){
//							stack.push(myArr[i]);
//						}else{//否则的话说明read<=top,则一直弹出栈顶元素，并输出到list集合中,直到将操作符压栈为止
//							while(num1<=num2&&num2!=3){//如果top的权重不等于3或者read<=top，则一直出栈
//								list.add(stack.pop().substring(0,1));
//								//重新获取top的权重
//								num2=Integer.parseInt(stack.get().substring(1));				
//							}
//							//将read压栈
//							stack.push(myArr[i]);
//						}					
//					}				
//				}
//				System.out.println("字符："+arr[i]);
//				System.out.println("list: "+list.toString());
//				System.out.println("stack: "+stack.toString());
//			}
//			//表达式循环判断结束后，弹出栈中的所有元素，并输出到list集合中
//			while(!stack.isEmpty()){
//				list.add(stack.pop().substring(0,1));
//			}
//			//将list集合中的数据转为逆波兰表达式
//			String s="";
//			for(int i=0;i<list.size();i++){
//				s+=list.get(i);
//			}
//			return s;
//		}
//		
//		public static void main(String[] args){
//			String notation="6*(5+(2+3)*8+3)";
//			System.out.println("中缀表达式为： "+notation);
//			System.out.println("----------转换过程-----------");
//			String s=changeNotation(notation);
//			System.out.println("----------转换过程-----------");
//			System.out.println("逆波兰表达式为： "+s);
//	                //如何计算逆波兰表达式我们在下一篇博客分析
////			System.out.println("计算结果为： "+transfer.countNotation(s));
//		}
//	}
//
