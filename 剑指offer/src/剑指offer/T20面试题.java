package ��ָoffer;
import java.util.regex.Pattern;
public class T20������ {
	////��ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С������
	///���磬�ַ���"+100"��"5e2"��"-123"��"3.1416"��"0123"��"-1E-16"����ʾ��ֵ����"12e"��"1a3.14"��"1.2.3"��"+-5"��"12e+5.4"�����ǡ�
	public boolean isNumber(String s) {
		if(s==null&&s.length()==0) return false;
		char[] a = s.toCharArray();
		boolean numseen = false;
		boolean dotseen = false;
		boolean eseen = false;
		for(int i=0;i<a.length;i++) {
			if(a[i]>='0'&&a[i]<='9') ////�Ƚϵ���ASCII��
			{
				numseen = true;
			}else if(a[i]=='.'){
				if(dotseen||eseen) return false;
				dotseen = true;
			}else if(a[i]=='e'||a[i]=='E') {
				if(dotseen||!numseen) return false;
				eseen = true;
				numseen = false;
			}else if(a[i]=='-'||a[i]=='+') {
				if(i!=0&&a[i-1]!='e'&&a[i-1]!='E') return false;
			}else {
					return false;
			}
		}
		return numseen;
	}
	/////������ʽ
		    public static boolean isNumeric(char[] str) {
		        String pattern = "^[-+]?\\d*(?:\\.\\d*)?(?:[eE][+\\-]?\\d+)?$";
		        String s = new String(str);
		        return Pattern.matches(pattern,s);
		    }
		}
//		^ �� ��Ԫ���ſ�������ʽ����ָ�����������ʽ���ı��е������ַ�������ƥ�䡣���ʡ����Щ��ʶ����ôֻҪһ���ַ����а���һ���������������ʽ�ͻ����ƥ�䡣��������� ^ ������ƥ����һ�����ֿ�ͷ���ַ��������������$ ����ƥ����һ�����ֽ�β���ַ�����
//		1
//		[-+]?
//		�����ź���� ? ��׺��ʾ��������ǿ�ѡ��,��ʾ��0��1�����Ż�������
//
//		1
//		\\d*
//		\d�ĺ����[0-9]һ������ƥ��һ�����֡���׺ * ָ������ƥ��������߶�����֡�
//
//		1
//		(?:\\.\\d*)?
//		(?: ��)?��ʾһ����ѡ�ķǲ����ͷ��顣* ָ����������ƥ���������0�����߶�����ֵ�С���㡣
//
//		1
//		(?:[eE][+\\-]?\d+)?
//		��������һ����ѡ�ķǲ����ͷ��顣����ƥ��һ��e(��E)��һ����ѡ���������Լ�һ���������֡�

