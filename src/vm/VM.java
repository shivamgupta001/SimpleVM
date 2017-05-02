package vm;
import static vm.ByteCode.*;

public class VM {
	int[] data;
	int[] code;
	int[] stack;
	
	int ip;
	int sp = -1;
	int fp;
	
	boolean trace = false;
	
	public VM(int[] code, int main, int datasize){
		this.code = code;
		this.ip = main;
		data = new int[datasize];
		stack = new int[100];
	}
	
	public void cpu(){		
		
		while(ip < code.length){
			
			int opcode = code[ip]; //fetch			
			if(trace){
				disassemble(opcode);
			}
			ip++;
			switch(opcode){
				case ICONST : 	stack[++sp] = code[ip++];						 
								break;
				case PRINT  :	System.out.println(stack[sp--]);
								break;
				case HALT   :	return;
			}			
		}		
	}

	private void disassemble(int opcode) {
		
		Instruction instr = ByteCode.instructions[opcode];
		System.err.printf("%04d: %s",ip, instr.name);
		if(instr.nOperands == 1){
			System.err.printf(" %d",code[ip+1]);
		}else if(instr.nOperands == 2){
			System.err.printf(" %d %d",code[ip+1],code[ip+2]);
		}
		System.out.println();
	}
}
