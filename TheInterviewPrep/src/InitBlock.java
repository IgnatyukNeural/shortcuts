//Doesn't replace the constructors, get called BEFORE constructor
//It's possible to create multiple init.blocks
public class InitBlock {

	public InitBlock() {
		System.out.println("The constructor has been called");
	}
	
	{
		System.out.println("Init block has been called");
	}
	
}
