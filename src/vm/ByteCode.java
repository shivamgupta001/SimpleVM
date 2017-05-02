package vm;

public class ByteCode {
	
	//Instruction Byte codes
	public static final short IADD    = 1;
	public static final short ISUB    = 2;
	public static final short IMUL    = 3;
	public static final short ILT  	  = 4;  //int less than
	public static final short IEQ  	  = 5; 	//int equal
	public static final short BR      = 6;
	public static final short BRT     = 7;
	public static final short BRF     = 8;
	public static final short ICONST  = 9;  //push constant integer
	public static final short LOAD    = 10; //load from local
	public static final short GLOAD   = 11;	//load from global
	public static final short STORE   = 12;	//store in local
	public static final short GSTORE  = 13;	//store in global
	public static final short PRINT   = 14;
	public static final short POP     = 15;
	public static final short HALT    = 16;
	
	public static class Instruction{
		String name; //E.g. 'iadd', 'call'
		int nOperands = 0;
		public Instruction(String name){ 
				this(name, 0); 
		}
		public Instruction(String name , int nOperands){
			this.name = name;
			this.nOperands = nOperands;
		}
	}
	
	public static Instruction[] instructions ={
			null,
			new Instruction("iadd"),
			new Instruction("isub"),
			new Instruction("imul"),
			new Instruction("ilt"),
			new Instruction("ieq"),
			new Instruction("br", 1),
			new Instruction("brt", 1),
			new Instruction("brf", 1),
			new Instruction("iconst", 1),
			new Instruction("load", 1),
			new Instruction("gload", 1),
			new Instruction("store", 1),
			new Instruction("gstore", 1),
			new Instruction("print"),
			new Instruction("pop"),
			new Instruction("halt")
	};
}
