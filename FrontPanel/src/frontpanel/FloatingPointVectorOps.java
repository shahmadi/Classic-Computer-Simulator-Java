package frontpanel;
import java.math.BigInteger;



/*Floating Point Instructions/Vector Operations:

Do not implement floating point numbers until Part IV

We have limited space in our instruction set, with only six bits for opcodes. 
So, we have to limit our floating point and vector operations. This will give 
you a chance to think about how to write a software routine to do multiplication 
and division for both floating point numbers. 

There are two floating point registers: FR0 and FR1. Each is 16 bits in length.

The format of a floating point number is the same as that for a load/store 
instruction, except that the r field takes only 2 values: 0 or 1 to specify 
the two floating point registers.

Vector operations are performed memory to memory. This was used on several 
models of vector processors as opposed to using lots of expensive registers 
to hold vectors.
*/



public class FloatingPointVectorOps {
	
	/* Floating Add Memory to Register */
	public static void instructionFADD(Instruction instruction) throws Throwable{
		
		String ea = BinaryUtil.eaCalculation(instruction); 
		
		Integer addressDecimal = Integer.parseInt(Cache.getInstance().checkCache(ea), 2);	
		FloatRepresentation FRDecimal = new FloatRepresentation(FrontPanel.getFRField(instruction.getRegisterNumber()));

		float floatFR = addressDecimal + FRDecimal.calculateDecimalNumber();
		//System.out.println("HERE  "+floatFR);
		FloatRepresentation result = new FloatRepresentation(floatFR);
		
		//Set OVERFLOW	
		if(result.getExponent() == null){
			FrontPanel.txtCc.setText("1000");
			return;
		}
                
		FrontPanel.setFRField(instruction.getRegisterNumber(), result.toString());
		
	}	
	
	/* Floating Subtract Memory to Register */
	public static void instructionFSUB(Instruction instruction) throws Throwable{
		
		String ea = BinaryUtil.eaCalculation(instruction); 
		
		Integer addressDecimal = Integer.parseInt(Cache.getInstance().checkCache(ea), 2);	
		FloatRepresentation FRDecimal = new FloatRepresentation(FrontPanel.getFRField(instruction.getRegisterNumber()));

		Float floatFR = FRDecimal.calculateDecimalNumber() - addressDecimal;
		//System.out.println("HERE2 "+floatFR);
		FloatRepresentation result = new FloatRepresentation(floatFR);
		
		Float floorLimit = new Float(Math.pow(3.682143, 19));
		floorLimit *= -1;
		//Set UNDERFLOW	
		if(floatFR.compareTo(floorLimit) < 0){
			FrontPanel.txtCc.setText("0100");
			return;
		}
		FrontPanel.setFRField(instruction.getRegisterNumber(), result.toString());
	}
	
	public static void instructionVADD(Instruction instruction) throws Throwable{
		String ea = BinaryUtil.eaCalculation(instruction);
		Integer eaIntegerV2 = Integer.parseInt(ea, 2) + 1;
		String ea2 = Integer.toBinaryString(eaIntegerV2);
		
		Integer startVectorOne = Integer.parseInt(Cache.getInstance().checkCache(ea), 2);
		Integer startVectorTwo = Integer.parseInt(Cache.getInstance().checkCache(ea2), 2);
		
		FloatRepresentation floatLength = new FloatRepresentation(FrontPanel.getFRField(instruction.getRegisterNumber()));
		Integer vectorLength = floatLength.calculateDecimalNumber().intValue();
		
		
		for(int i = 0; i < vectorLength; i++){
			Integer numVectorOne = Integer.parseInt(Cache.getInstance().checkCache(startVectorOne), 2);
			Integer numVectorTwo = Integer.parseInt(Cache.getInstance().checkCache(startVectorTwo), 2);
			
			Integer result = numVectorOne + numVectorTwo;
			Cache.getInstance().updateData(startVectorOne, BinaryUtil.fillBinaryStringParam(Integer.toBinaryString(result), 16));
			
			startVectorOne++;
			startVectorTwo++;
		}
	}
	
	public static void instructionVSUB(Instruction instruction) throws Throwable{
		String ea = BinaryUtil.eaCalculation(instruction);
		Integer eaIntegerV2 = Integer.parseInt(ea, 2) + 1;
		String ea2 = Integer.toBinaryString(eaIntegerV2);
		
		Integer startVectorOne = Integer.parseInt(Cache.getInstance().checkCache(ea), 2);
		Integer startVectorTwo = Integer.parseInt(Cache.getInstance().checkCache(ea2), 2);
		
		FloatRepresentation floatLength = new FloatRepresentation(FrontPanel.getFRField(instruction.getRegisterNumber()));
		Integer vectorLength = floatLength.calculateDecimalNumber().intValue();
		
		
		for(int i = 0; i < vectorLength; i++){
			Integer numVectorOne = Integer.parseInt(Cache.getInstance().checkCache(startVectorOne), 2);
			Integer numVectorTwo = Integer.parseInt(Cache.getInstance().checkCache(startVectorTwo), 2);
			
			Integer result = numVectorOne - numVectorTwo;
			Cache.getInstance().updateData(startVectorOne, BinaryUtil.fillBinaryStringParam(Integer.toBinaryString(result), 16));
			
			startVectorOne++;
			startVectorTwo++;
		}
	}
	
	public static void instructionCNVRT(Instruction instruction) throws Throwable{
		String ea = BinaryUtil.eaCalculation(instruction);
		
		//Integer f = Integer.parseInt(FrontPanel.getRegister(instruction.getRegisterNumber()));
		Integer f=instruction.getRegisterNumber();
		Integer eaInteger = Integer.parseInt(Cache.getInstance().checkCache(ea),2);
                if(f == 0){
                    if(eaInteger>16383)
                        return;
			FrontPanel.setRegister(instruction.getRegisterNumber(), Cache.getInstance().checkCache(ea));
		} else if (f == 1){
			Integer memoryNumber = Integer.parseInt(Cache.getInstance().checkCache(ea), 2);
			FloatRepresentation floatNumber = new FloatRepresentation(new Float(memoryNumber));
			FrontPanel.setFRField(0, floatNumber.toString());
		}
	}
	
	public static void instructionLDFR(Instruction instruction) throws Throwable{
		String ea = BinaryUtil.eaCalculation(instruction);
                Integer eaIntegerV2 = Integer.parseInt(ea, 2) + 1;
		String ea2 = Integer.toBinaryString(eaIntegerV2);
		FrontPanel.setFRField(instruction.getRegisterNumber(), Cache.getInstance().checkCache(ea));
                FrontPanel.setFRField((instruction.getRegisterNumber()+1)%2, Cache.getInstance().checkCache(ea2));
	}
	
	public static void instructionSTFR(Instruction instruction) throws Throwable{
		String ea = BinaryUtil.eaCalculation(instruction);
                Integer eaIntegerV2 = Integer.parseInt(ea, 2) + 1;
		String ea2 = Integer.toBinaryString(eaIntegerV2);
		Cache.getInstance().updateData(ea, FrontPanel.getFRField(instruction.getRegisterNumber()));
                Cache.getInstance().updateData(ea2, FrontPanel.getFRField((instruction.getRegisterNumber()+1)%2));
                
	}

}
