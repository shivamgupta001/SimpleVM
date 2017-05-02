package vm;

import static vm.ByteCode.*;

public class TestVM {
	static int[] hello = {
		ICONST,99,
		PRINT,
		ICONST,98,
		PRINT,
		HALT
	};
	public static void main(String[] args){
		VM vm1 = new VM(hello , 0, 0);
		vm1.trace = true;
		vm1.cpu();
	}
}
