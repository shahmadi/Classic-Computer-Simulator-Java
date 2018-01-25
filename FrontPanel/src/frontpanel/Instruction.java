
package frontpanel;

public class Instruction {
	
	/*
	 * Input Area - In this area the user can input individual instructions
	 * Opcode	6 bits	Specifies one of 64 possible instructions; Not all may be defined in this project
	 * IX		2 bits	Specifies one of three index registers; may be referred to by X1 ï¿½ X3. O value indicates no indexing.
	 * R		2 bits	Specifies one of four general purpose registers; may be referred to by R0 ï¿½ R3
	 * I		1 bits	If I =1, specifies indirect addressing; otherwise, no indirect addressing.
	 * Address	7 bits	Specifies one of 32 locations
	 */
	
	private String opCode;
	private String ix;
	private String r;
	private String i;
	private String address;
	private String cc;
	
	private Integer base;
	private Integer ccNumber;
	
	public Instruction(String opCode, String r, String ix, String i, String address){
		this.opCode = opCode;
		this.r = r;
		this.ix = ix;
		this.i = i;
		this.address = address;
		base = 2;
	}
	
	public Instruction(String instruction){
		this.opCode = instruction.substring(0, 6); // give a long instruction, only choose 0~6 of substring to give this part to opcode
		this.r = instruction.substring(6, 8); // give substring 6~8 to Register 2bits. 6 and 7
		this.ix = instruction.substring(8, 10);// give index 2 bits.
		this.i = instruction.substring(10, 11);// index, give 1 bit.
		this.address = instruction.substring(11);// address, give substring.
		base = 2;
	}

	public String getOpCode() {
		return opCode;       //define a method that get opcode
	}

	public void setOpCode(String opCode) {
		this.opCode = opCode;       
	}

	public String getIx() {// getindex 
		return ix;
	}

	public void setIx(String ix) {
		this.ix = ix;
	}
	
	public Integer getIndexNumber() {
		return Integer.parseInt(ix, 2);  // get 2 bits index number then return to integer.
	}
	
	public boolean hasIndex(){// design a method to judge has index or not.
		int index = Integer.parseInt(ix, 2);
		return index == 0 ? false : true;// if index == 0 return false or if index == 1 return true
	}

	public String getR() { // design a method get Register
		return r;
	}
	
	public Integer getRegisterNumber() { // design a method to getRegister's number.
		return Integer.parseInt(r, 2); // return to integer
	}

	public void setR(String r) {
		this.r = r;
	}

	public String getI() { //design a method to get I
		return i;
	}
	
	public Boolean isIndirect(){
		return (getI().equals("1") ? true : false); // if get i ==1 return is indirect address
	}

	public void setI(String i) {// set I
		this.i = i;
	}

	public String getAddress() {
		return address;       // Get address 
	}
	
	public Integer getIntegerAddress() {      //  define a  getting integer address 
		return Integer.parseInt(address, 2); // parse address to integer
	}

	public void setAddress(String address) {
		this.address = address;       // set address 
	}

	public Integer getBase() {
		return base;
	}

	public void setBase(Integer base) {
		this.base = base;
	}
	
	@Override
	public String toString() {
		return "Instruction [opCode=" + opCode + ", ix=" + ix + ", r=" + r + ", i=" + i + ", address=" + address
				+ ", base=" + base + "]";// 
	} 
	
	public String getBinaryInstruction(){  // transfer instruction to binary
		return opCode + r + ix + i + address;
	}
	
	public Integer getCCNumber(int j) { // get cc opcode
		return Integer.parseInt(cc, 2);// return it to integer
	}
	
	public void setCCNumber(Integer ccNumber, int j) {
		this.ccNumber = ccNumber;  //define a setcc method  
	}
	
	public InstructionEnum getIntructionCode(){ //  get 6 bits instructions code.
		String part1 = opCode.substring(0, 3); // split it into 2 parts.
		String part2 = opCode.substring(3); //  each part range 3 bits.
		int decimalValue = Integer.parseInt(part1, 2);
		int decimalValue2 = Integer.parseInt(part2, 2);
		return InstructionEnum.findInstruction(decimalValue + "" + decimalValue2);
	}
	
	

}
