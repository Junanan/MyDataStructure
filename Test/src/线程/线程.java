package �߳�;

public class �߳� {
	public static void main(String[] args) {
		Thread a = new ThreadA();
		// start() �����Զ����� run() ���� ����ڵ�������run() ��ֻ�������̵߳����˷��� �����Ƕ��߳�
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
