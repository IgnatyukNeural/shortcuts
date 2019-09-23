
public class Main {
	public static void main(String[] args) {
		TestClass class1 = new TestClass();
		TestClass class2 = new TestClass();
		
		class1.run();
		class2.run();
	}
	
}

class TestClass extends Thread {
	
	@Override
	public void run() {
		Singleton singleton = Singleton.getInstance();
	}
	
}
