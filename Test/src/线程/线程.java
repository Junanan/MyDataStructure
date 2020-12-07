package 线程;

public class 线程 {
	public static void main(String[] args) {
		Thread a = new ThreadA();
		// start() 方法自动运行 run() 方法 如果在单独运行run() 它只是在主线程调用了方法 并不是多线程
		//a.start();
		a.run();
		Thread b = new ThreadB();
		b.run();
	}
}

class ThreadA extends Thread{
	public void run(){
		int i=0;
		while(i<100) {
			i++;
			System.out.println(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class ThreadB extends Thread{
	public void run(){
		char i='a';
		while(i<=122) {
			System.out.println(i);
			i++;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
