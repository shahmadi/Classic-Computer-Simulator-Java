
package frontpanel;



public class BinaryUtil {
	
	/**
	 * 
	 this method return binary string with requested length and fills the missing bits
	 */
	public static String fillBinaryStringParam(String binary, int lenght){ //
		if (binary.length() == lenght){
			return binary;
		} else if (binary.length() < lenght){
			int zerosNeeded = lenght - binary.length();
			String zeros = "";        // let lenght equals to binary.length, if not long enough +zeros to supply.
			for (int i = 0; i < zerosNeeded; i++) {
				zeros += 0;
			}
			return zeros + binary;
		} else {
			//Exception
			return "";
		}		
	}
	

	//this method return binary string with length 16
	public static String fillBinaryString(String binary){
		if (binary.length() == 16){
			return binary;
		} else if (binary.length() < 16){
			int zerosNeeded = 16 - binary.length();
			String zeros = "";
			for (int i = 0; i < zerosNeeded; i++) {
				zeros += 0;
			}
			return zeros + binary;
		} else {
			//Exception
			return "";
		}		
	}
	//this method adds up to binary string and return sum in string
	public static String sumBinary(String bin1, String bin2){
		Integer sum = Integer.parseInt(bin1, 2) + Integer.parseInt(bin2,2); //get a stringg, then ,return to a interger,throw number format exception 
		                                                                    //if some situation come. return to a unsigned integer format.
		return Integer.toBinaryString(sum);      //return integer to binary format.                          
		                                                                    
	}
	//this method returns sum of two binary number and return sum in Integer
	public static Integer sumBinaryToInteger(String bin1, String bin2){
		return Integer.parseInt(bin1, 2) + Integer.parseInt(bin2,2);
	}
	//this method computes the effecitve address based on instruction fields values and whether it is direct or indirect
	public static String eaCalculation(Instruction instruction) throws Exception{
		
		String indexValue = FrontPanel.getIndex(instruction.getIndexNumber());//getting upcodes
		if(instruction.getIntructionCode() == InstructionEnum.LDX || //Load Index Register from Memory
		   instruction.getIntructionCode() == InstructionEnum.STX){//store index Register to memory
			indexValue = "0";   // No indirect addressing, index=00
		}
		
		if(!instruction.isIndirect()){ //  if index is not indirect addressing, is direct addressing
			if(!instruction.hasIndex()){ // instruction has no index
				return instruction.getAddress();// indirect addressing, but NO indexing
				                                //if IX = 00, c(Address)

			} else {  // instruction is indirect addressing, index value = "1",
				return sumBinary(indexValue, instruction.getAddress());//both index addressing,/ 
			                                                       	/*if IX = 1..3, c(c(Xj) + Address), 
			                                                       	 * where j = c(IX)
			                                                       	 */
			}                                                           
		} else {
			if(!instruction.hasIndex()){// if instruction has no index
				return Cache.getInstance().checkCache(instruction.getIntegerAddress());//cache
			} else {
				Integer eaPos = sumBinaryToInteger(indexValue, instruction.getAddress());
				return Cache.getInstance().checkCache(eaPos);
			}
		}
	}

}
