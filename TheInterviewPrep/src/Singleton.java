//Non-thread safe singleton
public class Singleton {

	private static Singleton instance;
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		if(instance == null) {
			System.out.print("Create a new instance of the singleton");
			instance = new Singleton();
		} else {
			System.out.print("The Singleton instance has already been created");
		}
		return instance;
	}
	
}
