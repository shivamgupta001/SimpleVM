package vm;

import static vm.ByteCode.*;

public class TestVM {
	static int[] hello = {
		ICONST,99,
		GSTORE,0,
		GLOAD,0,
		PRINT,
		HALT
	};
	public static void main(String[] args){
		int datasize = 1;
		int mainip = 0;
		VM vm1 = new VM(hello ,mainip, datasize);
		vm1.trace = true;
		vm1.cpu();
	}
}
