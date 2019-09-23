//Boolean: false
//Byte: 0
//Short: 0
//Int: 0
//Long: 0
//Char: 0
//Float: 0.0
//Double: 0.0
//Reference object: null
public class InitWithDefaults {

	public InitWithDefaults() {
		System.out.println( "booleanMember = " + booleanMember );
		System.out.println( "byteMember = " + byteMember );
		System.out.println( "shortMember = " + shortMember );
		System.out.println( "intMember = " + intMember );
		System.out.println( "longMember = " + longMember );
		System.out.println( "charMember = " +
		Character.codePointAt( new char[] { charMember }, 0 ) );
		System.out.println( "floatMember = " + floatMember );
		System.out.println( "doubleMember = " + doubleMember );
		System.out.println( "referenceMember = " + referenceMember );
		}

	
	private boolean booleanMember;
	private byte byteMember;
	private short shortMember;
	private int intMember;
	private long longMember;
	private char charMember;
	private float floatMember;
	private double doubleMember;
	private Object referenceMember;
	
}
