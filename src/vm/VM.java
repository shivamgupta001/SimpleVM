package vm;
import static vm.ByteCode.*;

public class VM {
	int[] data;
	int[] code;
	int[] stack;
	
	int ip;
	int sp = -1;
	int fp;
	
	public VM(int[] code, int main, int datasize){
		this.code = code;
		this.ip = main;
		data = new int[datasize];
		stack = new int[100];
	}
	
	public void cpu(){
		
		int opcode = code[ip]; //fetch
		ip++;
		
		switch(opcode){
			case HALT : return;
		}
	}
}
