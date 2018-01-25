
package frontpanel;;



public class LoadStore {	
	
	/* This method implements the Load instruction in the UI
	
	  Load Register From Memory, r = 0..3
		r <- c(EA)
		r <- c(c(EA)), if I bit set
	*/
	 
	public static void instructionLDR(Instruction instruction) throws Throwable{
            //System.out.println("INJAAA");
            //System.out.println("INJAAA "+instruction);
		String ea = BinaryUtil.eaCalculation(instruction);
                
		FrontPanel.setRegister(instruction.getRegisterNumber(), Cache.getInstance().checkCache(ea));
	}
	
	
	
	/**
	 * Store Register To Memory, r = 0..3
	   EA <- c(r)
	   c(c(EA)) <- c(r), if I-bit set
	 * @param instruction
	 * @throws Throwable
	 */
	public static void instructionSTR(Instruction instruction) throws Throwable{
            //System.out.println("INEEE" );
		String ea = BinaryUtil.eaCalculation(instruction);
                
                //System.out.println("hagsdkhd"+instruction);
		Cache.getInstance().updateData(ea, FrontPanel.getRegister(instruction.getRegisterNumber()));
	}
	
	
	
	/**
	 * Load Register with Address, r = 0..3
		r <- EA
		r <- c(EA), if I bit set
	 * @param instruction
	 * @throws Throwable
	 */
	public static void instructionLDA(Instruction instruction) throws Throwable{
          //  System.out.println(instruction);
				
		/*Load Register with Address, r = 0..3
				r <- EA
				r <- c(EA), if I bit set*/	
                //System.out.println("HELLO");
		String ea = BinaryUtil.eaCalculation(instruction);
                
		FrontPanel.setRegister(instruction.getRegisterNumber(), Integer.parseInt(ea, 2));
	}
	
	
	
	/**
	 * Load Index Register from Memory, x = 1..3
		Xx <- c(EA)
	 * @param instruction
	 * @throws Throwable
	 */
	public static void instructionLDX(Instruction instruction) throws Throwable{		
		
		/*Load Index Register from Memory, x = 1..3
				Xx <- c(EA)*/
		//System.out.println("SHAYAN");
		String ea = BinaryUtil.eaCalculation(instruction);		
		FrontPanel.setIndex(instruction.getIndexNumber(), Cache.getInstance().checkCache(ea));
		
		
	}
	
	
	
	/**
	 * Store Index Register to Memory. X = 1..3
		EA <- c(X0)
		C(EA) <- c(Xx), if I-bit set
	 * @param instruction
	 * @throws Throwable
	 */
	public static void instructionSTX(Instruction instruction) throws Throwable{
		
		
		/*Store Index Register to Memory. X = 1..3
				EA <- c(X0)
				C(EA) <- c(Xx), if I-bit set*/
		
		String ea = BinaryUtil.eaCalculation(instruction);
		Cache.getInstance().updateData(ea, FrontPanel.getIndex(instruction.getIndexNumber()));	
		
		
	}
	
	
	

}
