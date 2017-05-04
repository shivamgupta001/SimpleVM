package vm;
import static vm.ByteCode.*;

public class VM {
	int[] data;
	int[] code;
	int[] globals;
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
				case GLOAD  : 	stack[++sp] = globals[code[ip++]];
								break;
				case GSTORE :	globals[code[ip++]] = stack[sp--];
								break;
				case BR     :   ip = code[ip++];
								break;
				case BRT    :  	if(stack[sp--] == 0)
									ip = code[ip++];
								break;
				case BRF    :   if(stack[sp--]== 1)
									ip = code[ip++];
								break;
				case LOAD   :  	int offset = code[ip++];
								stack[++sp] = stack[fp + offset];
								break;
				case CALL   :
					
					//expects all args on stack
					addr = code[ip++];		//targets addr of function
					int nargs = code[ip++];	//how many args got pushed
					stack[++sp] = nargs;	//save num args
					stack[++sp] = fp;		//save frame pointer
					stack[++sp] = ip;		//push return address
					fp = sp;				//fp points to returning address on stack;
					ip = addr;				//jump to function
					break;
				case RET    :
					
					int rvalue = stack[sp--]; //pop return value
					sp = fp;				  // jump over locals to fp
					ip = stack[sp--];		//pop return address jump to fp
					fp = stack[sp--];		//restore fp
					nargs = stack[sp--];	//how many args to throw away
					sp -= nargs;			//pop args
					stack[++sp] = rvalue;	//leave result on stack
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
