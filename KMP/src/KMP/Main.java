package KMP;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class Main {
//    public static void main(String[] args) {
//        Main main = new Main();
//    }
    public static class Student {
        private int id;
        String name;
        protected boolean sex;
        public float score;
    }
        //��ȡ����������ַ�ʽ
        public static void main(String[] args) throws ClassNotFoundException {
            //��ʽһ(ͨ����������)
            Student stu = new Student();
            Class classobj1 = stu.getClass();
            System.out.println(classobj1.getName());
            //��ʽ��������ͨ��·��-���·����
//            Class classobj2 = Class.forName("Main.Student");
//            System.out.println(classobj2.getName());
            //��ʽ����ͨ��������
            Class classobj3 = Student.class;
            System.out.println(classobj3.getName());
        }


}

