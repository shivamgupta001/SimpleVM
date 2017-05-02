package vm;

import static vm.ByteCode.*;

public class TestVM {
	static int[] hello = {
		HALT
	};
	public static void main(String[] args){
		VM vm1 = new VM(hello , 0, 0);
		vm1.cpu();
	}
}
