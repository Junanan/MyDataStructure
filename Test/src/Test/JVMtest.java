package Test;

public class JVMtest {
        public static void main(String[] args) {
            System.out.println("ClassLodarDemo's ClassLoader is " + JVMtest.class.getClassLoader());
            System.out.println("The Parent of ClassLodarDemo's ClassLoader is " + JVMtest.class.getClassLoader().getParent());
            System.out.println("The GrandParent of ClassLodarDemo's ClassLoader is " + JVMtest.class.getClassLoader().getParent().getParent());
        }
}
