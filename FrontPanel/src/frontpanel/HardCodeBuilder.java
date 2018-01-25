
package frontpanel;

import javax.swing.JOptionPane;
import static frontpanel.InstructionEnum.*;

public class HardCodeBuilder {
	
	private static String PROGRAM_1 = "Program 1";
	private static String AMRs = "AMR";
	private static String SMRs = "SMR";
	private static String AIRs = "AIR";
	private static String SIRs = "SIR";
	private static String MLTs = "MLT";
	private static String DVDs = "DVD";
	private static String TRRs = "TRR";
	private static String ANDs = "AND";	
	private static String ORRs = "ORR";
	private static String NOTs = "NOT";
	private static String JZs = "JZ";
	private static String JNEs = "JNE";
	private static String JCCs = "JCC";
	private static String JMAs = "JMA";
	private static String JSRs = "JSR";
	private static String RFSs = "RFS";
	private static String SOBs = "SOB";
	private static String JGEs = "JGE";
	private static String INs = "IN";
	private static String OUTs = "OUT";
	private static String LDRs = "LDR";
	private static String STRs = "STR";
	private static String LDXs = "LDX";
	private static String STXs = "STX";
	private static String LDAs = "LDA";
	private static String SRCs = "SRC";
	private static String RRCs = "RRC";
	private static String CHKs = "CHK";
	private static String FADDs = "FADD";
	private static String FSUBs = "FSUB";
	private static String LDFRs = "LDFR";
	private static String STFRs = "STFR";
	private static String VADDs = "VADD";
	private static String VSUBs = "VSUB";
	private static String CNVRTs = "CNVRT";
	
	public static void loadProgram(String programName){
		if(programName.equals(PROGRAM_1)){
			loadProgram1();
		}
		if(programName.equals(AMRs)){
			loadAMR();
		}
		if(programName.equals(SMRs)){
			loadSMR();
		}
		if(programName.equals(AIRs)){
                    //System.out.println("SHAAA");
			loadAIR();
		}
		if(programName.equals(SIRs)){
			loadSIR();
		}
		if(programName.equals(MLTs)){
			loadMLT();
		}
		if(programName.equals(DVDs)){
			loadDVD();
		}
		if(programName.equals(TRRs)){
			loadTRR();
		}
		if(programName.equals(ANDs)){
			loadAND();
		}
		if(programName.equals(ORRs)){
			loadORR();
		}
		if(programName.equals(NOTs)){
			loadNOT();
		}
		if(programName.equals(JZs)){
			loadJZ();
		}
		if(programName.equals(JNEs)){
			loadJNE();
		}
		if(programName.equals(JCCs)){
			loadJCC();
		}
		if(programName.equals(JMAs)){
			loadJMA();
		}
		if(programName.equals(JSRs)){
			loadJSR();
		}
		if(programName.equals(RFSs)){
			loadRFS();
		}
		if(programName.equals(SOBs)){
			loadSOB();
		}
		if(programName.equals(JGEs)){
			loadJGE();
		}
		if(programName.equals(INs)){
			loadIN();
		}
		if(programName.equals(LDRs)){
			loadLDR();
		}
		if(programName.equals(STRs)){
			loadSTR();
		}
		if(programName.equals(OUTs)){
			loadOUT();
		}
		if(programName.equals(LDXs)){
                    //System.out.println("SHAYN");
			loadLDX();
		}
		if(programName.equals(STXs)){
			loadSTX();
		}
		if(programName.equals(LDAs)){
			loadLDA();
		}
		if(programName.equals(SRCs)){
			loadSRC();
		}
		if(programName.equals(RRCs)){
			loadRRC();
		}
		if(programName.equals(CHKs)){
			loadCHK();
		}
                
                if(programName.equals(FADDs)){
			loadFADD();
		}
                
		if(programName.equals(FSUBs)){
			loadFSUB();
		}
		if(programName.equals(LDFRs)){
			loadLDFR();
		}
		if(programName.equals(STFRs)){
			loadSTFR();
		}
		if(programName.equals(VADDs)){
			loadVADD();
		}
		if(programName.equals(VSUBs)){
			loadVSUB();
		}
		if(programName.equals(CNVRTs)){
			loadCNVRT();
		}

				
	}
        
        /*below we implement functions to load various instructions for testing them
        */
        
	private static void loadOUT() {
		FrontPanel.setPc(6);
		FrontPanel.memory[6].setText(instUIBuilder(OUT, 1, 0, 1, 0));
		FrontPanel.txtOutput.setText("");
		FrontPanel.setRegister(1, 97);
	}

	private static void loadSTR() {
		FrontPanel.setPc(6);
		FrontPanel.memory[6].setText(instUIBuilder(STR, 2, 0, 8, 0));
		FrontPanel.setRegister(2, 123);
	}

	private static void loadLDR() {
		FrontPanel.setPc(6);
		FrontPanel.memory[6].setText(instUIBuilder(LDR, 1, 0, 7, 0));
		FrontPanel.setMemory(7, 100);
	}

	private static void loadIN() {
		FrontPanel.setPc(6);
		FrontPanel.txtInput.setText("a");
		FrontPanel.memory[6].setText(instUIBuilder(IN, 0, 0, 0, 0));
	}
	
	private static void loadSTX() {
		FrontPanel.setPc(6);
		FrontPanel.memory[6].setText(instUIBuilder(STX, 0, 1, 7, 0));
		FrontPanel.setIndex(1,101);
	}
	
	private static void loadLDX() {
		FrontPanel.setPc(6);
		FrontPanel.memory[6].setText(instUIBuilder(LDX,0,1,8, 0));
		FrontPanel.setMemory(8, 100);
	}
	private static void loadLDA() {
		FrontPanel.setPc(6);
		FrontPanel.memory[6].setText(instUIBuilder(LDA, 2, 0, 7, 0));
		FrontPanel.setRegister(2, 100);
	}
        //implement program1
	public static void loadProgram1() {
		
		//Init PC en 500
		FrontPanel.setPc(10);
		
		//Memory Instructions
                FrontPanel.setIndex(1, 100);
		FrontPanel.setIndex(2, 200);
		FrontPanel.setIndex(3, 63);
                
                //the counter=20 for taking the input
                FrontPanel.memory[10].setText(instUIBuilder(LDA, 3, 0, 20, 0));//initlalize cnt=5
                FrontPanel.memory[11].setText(instUIBuilder(JZ,3,0,31,0));//if cnt==0
                //System.out.println(FrontPanel.memory[12].getText());
                
                //holding the sum
                FrontPanel.memory[12].setText(instUIBuilder(LDA, 0,0,0,0));//initialize sum with 0
                
                //taking digit input and check if its valid
                FrontPanel.memory[13].setText(instUIBuilder(IN, 1, 0, 0, 0));//take the input
                FrontPanel.memory[14].setText(instUIBuilder(OUT, 1, 0, 1, 0));//Output
                
                FrontPanel.memory[15].setText(instUIBuilder(SIR, 1, 0, 30, 0));//check if its space
                FrontPanel.memory[16].setText(instUIBuilder(SIR, 1, 0, 2, 0));//check if its space
                
                FrontPanel.memory[17].setText(instUIBuilder(JZ,1,0,24,0));//if space
                FrontPanel.memory[18].setText(instUIBuilder(SIR, 1, 0, 16, 0));
                FrontPanel.memory[19].setText(instUIBuilder(STR, 1, 1, 0, 0));//copy of input
                
                //FrontPanel.memory[17].setText(instUIBuilder(SIR, 1, 0, 30, 0));
                
                //adding up digits to create entire input number
                FrontPanel.memory[20].setText(instUIBuilder(LDA, 2, 0, 10, 0));//give register 2 value 10
                
                FrontPanel.memory[21].setText(instUIBuilder(MLT, 0, 2, 0, 0));//multiply sum by 10
                
                FrontPanel.memory[22].setText(instUIBuilder(AMR, 0, 1, 0, 0));//add input to sum
                FrontPanel.memory[23].setText(instUIBuilder(JMA, 0, 0, 13, 0));//jump start loop
                
                FrontPanel.memory[24].setText(instUIBuilder(STR, 3, 2, 0, 0));//store cnt at location mem[200]
             
                FrontPanel.memory[25].setText(instUIBuilder(AIR, 3, 2, 0, 0));//cnt+=200
                FrontPanel.memory[26].setText(instUIBuilder(STR, 3, 1, 0, 0));//store new cnt in memory 100
                FrontPanel.memory[27].setText(instUIBuilder(STR, 0,1,0,1));//store sum at mem[cnt]
                FrontPanel.memory[28].setText(instUIBuilder(LDR, 3, 2, 0, 0));//reset cnt from mem[200]
                
                //counter--
                FrontPanel.memory[29].setText(instUIBuilder(SIR, 3, 0, 1, 0));// cnt--
                FrontPanel.memory[30].setText(instUIBuilder(JMA, 0, 0, 11, 0));//jump loop
                
                
                //printing NUM?(requested number)
                FrontPanel.memory[31].setText(instUIBuilder(LDA, 1, 3, 15, 0));
                FrontPanel.memory[32].setText(instUIBuilder(OUT, 1, 0, 1, 0));
                FrontPanel.memory[33].setText(instUIBuilder(LDA, 1, 3, 22, 0));
                FrontPanel.memory[34].setText(instUIBuilder(OUT, 1, 0, 1, 0));
                FrontPanel.memory[35].setText(instUIBuilder(LDA, 1, 3, 14, 0));
                FrontPanel.memory[36].setText(instUIBuilder(OUT, 1, 0, 1, 0));
                FrontPanel.memory[37].setText(instUIBuilder(LDA, 1, 3, 0, 0));
                FrontPanel.memory[38].setText(instUIBuilder(OUT, 1, 0, 1, 0));
                FrontPanel.memory[39].setText(instUIBuilder(JMA, 0, 3, 0, 0));
                
                
                
                //Take the requested NUM
                FrontPanel.memory[63].setText(instUIBuilder(LDA, 0,0,0,0));//initialize sum=0
                FrontPanel.memory[64].setText(instUIBuilder(IN, 1, 0, 0, 0));//take the input
                //FrontPanel.memory[64].setText(instUIBuilder(OUT, 1, 0, 1, 0));//Output
                
                FrontPanel.memory[65].setText(instUIBuilder(SIR, 1, 0, 30, 0));//check if its space
                FrontPanel.memory[66].setText(instUIBuilder(SIR, 1, 0, 2, 0));//check if its space
                
                FrontPanel.memory[67].setText(instUIBuilder(JZ,1,3,11,0));//if space
                FrontPanel.memory[68].setText(instUIBuilder(SIR, 1, 0, 16, 0));
                FrontPanel.memory[69].setText(instUIBuilder(STR, 1, 1, 0, 0));//copy of input
                
                //FrontPanel.memory[17].setText(instUIBuilder(SIR, 1, 0, 30, 0));
                FrontPanel.memory[70].setText(instUIBuilder(LDA, 2, 0, 10, 0));//give register 2 value 10
                
                FrontPanel.memory[71].setText(instUIBuilder(MLT, 0, 2, 0, 0));//multiply sum by 10
                
                FrontPanel.memory[72].setText(instUIBuilder(AMR, 0, 1, 0, 0));//add input to sum
                FrontPanel.memory[73].setText(instUIBuilder(JMA, 0, 3, 1, 0));//jump start loop
                FrontPanel.memory[74].setText(instUIBuilder(STR, 0, 2, 0, 0));//store sum to memory[200]
                
             
                 FrontPanel.memory[75].setText(instUIBuilder(JMA, 0, 0, 1, 0));
                
		FrontPanel.memory[100].setText(instUIBuilder(LDA, 2, 2, 0, 0));//loading NUM from memory
		FrontPanel.memory[101].setText(instUIBuilder(SMR, 2, 2, 1, 0));//compute Mem[201]-NUM
		FrontPanel.memory[102].setText(instUIBuilder(STR, 2, 3, 14, 1));//storing Mem[201]-NUM as min at 77
		FrontPanel.memory[103].setText(instUIBuilder(STR, 2, 3, 13, 0));//storing Mem[201] as M at 76
		
		
                //seting up counter and going through loop 
		FrontPanel.memory[104].setText(instUIBuilder(LDA, 3, 2, 1, 0));//initialize counter=201
                FrontPanel.memory[105].setText(instUIBuilder(AIR, 3, 0, 1, 0));//counter ++
                FrontPanel.memory[106].setText(instUIBuilder(SIR, 3, 0, 20, 0));//check counter<=220
                FrontPanel.memory[107].setText(instUIBuilder(JNE, 3, 1, 25, 0));//jump if counter!=00.
                FrontPanel.memory[108].setText(instUIBuilder(AIR, 3, 0, 20,0));//add 20 back
		FrontPanel.memory[109].setText(instUIBuilder(LDA, 0, 2, 0, 0));////loading NUM from memory
		FrontPanel.memory[110].setText(instUIBuilder(STR, 3, 1, 0, 0));//store counter at 100
		FrontPanel.memory[111].setText(instUIBuilder(SMR, 0, 1, 0, 1));//compute Mem[counter]-NUM
		FrontPanel.memory[112].setText(instUIBuilder(LDR, 2, 3, 14, 0));//Loading min
		FrontPanel.memory[113].setText(instUIBuilder(JGE, 2, 1, 11, 0));//compare with min
		FrontPanel.memory[114].setText(instUIBuilder(JMA, 0, 1, 4, 0));//
		FrontPanel.memory[115].setText(instUIBuilder(STR, 0, 3, 14, 0));//update min
		FrontPanel.memory[116].setText(instUIBuilder(LDR, 2, 1, 0, 1));//update M
                FrontPanel.memory[117].setText(instUIBuilder(STR, 2, 3, 13, 0));//update M
		
                //printing the output from mem[76]
                FrontPanel.memory[118].setText(instUIBuilder(LDA, 1, 3, 15, 0));
                FrontPanel.memory[119].setText(instUIBuilder(OUT, 1, 0, 1, 0));
                FrontPanel.memory[120].setText(instUIBuilder(LDA, 1, 3, 22, 0));
                FrontPanel.memory[121].setText(instUIBuilder(OUT, 1, 0, 1, 0));
                FrontPanel.memory[122].setText(instUIBuilder(LDA, 1, 3, 14, 0));
                FrontPanel.memory[123].setText(instUIBuilder(OUT, 1, 0, 1, 0));
                FrontPanel.memory[124].setText(instUIBuilder(LDA, 1, 3, 0, 0));
                FrontPanel.memory[125].setText(instUIBuilder(OUT, 1, 0, 1, 0));
                FrontPanel.memory[126].setText(instUIBuilder(JMA, 0, 3, 0, 0));
               
	}
        
	public static String initProgram2(){
		//Get paragraph (428 characters)
		String paragraph = FileReaderUtil.getFile("TextProgramTwo.txt");
		//Save in memory 1000+
		int paragraphStart = 1000;
for(int i = 1; i < paragraph.length(); i++){
    if(paragraph.charAt(i-1)=='.' && paragraph.charAt(i)==' ')
        paragraph=paragraph.substring(0,i)+paragraph.substring(i+1);
}
for(int i = 0; i < paragraph.length()-1; i++){
    if(paragraph.charAt(i)==' ' && paragraph.charAt(i+1)=='.')
        paragraph=paragraph.substring(0,i)+paragraph.substring(i+1);
}

    for(int i = 0; i < paragraph.length(); i++){
			char readChar = paragraph.charAt(i);
			int asciiChar = (int) readChar;
			FrontPanel.setMemory(paragraphStart, asciiChar);
			paragraphStart++;
		}
		
		FrontPanel.txtOutput.setText(paragraph);

		//Get word
		String word = (String)JOptionPane.showInputDialog(
				null,
				"Search word: ",
				"Add",
				JOptionPane.PLAIN_MESSAGE,
				null,
				null,
				"");
		//Save in memory 2000+
		int wordStart = 2000;
		for(int i = 0; i < word.length(); i++){
			char readChar = word.charAt(i);
			int asciiChar = (int) readChar;
			FrontPanel.setMemory(wordStart, asciiChar);
			wordStart++;
		}
		
		//Save paragraph and word length in memory
		FrontPanel.setMemory(7, paragraph.length()+998); //Final position of paragraph letters (Windows add \n at the end)
		FrontPanel.setMemory(8, word.length()); //Number of word letters
		return word;
	}
	
	public static void loadProgram2() {
		String word = initProgram2();
		//Initialize indexes
		FrontPanel.setIndex(1, 1000);
		FrontPanel.setIndex(2, 2000);
		FrontPanel.setPc(50);
		
		FrontPanel.setMemory(9, 46); // Dot (.) ascii value
		FrontPanel.setMemory(10, 32); // Space ( ) ascii value
		FrontPanel.setMemory(14, 0); // Letters finder counter
		FrontPanel.setMemory(17, 1); // Words in sentence counter
		FrontPanel.setMemory(18, 1); // Sentence in paragraph counter
		FrontPanel.setMemory(19, 0); // ZERO
		FrontPanel.setMemory(20, 1); // ONE
		FrontPanel.setMemory(21, 64); // 1st continue
		FrontPanel.setMemory(31, 0); // ZERO FINISH
		
		FrontPanel.memory[50].setText(instUIBuilder(LDR, 0, 1, 0, 0)); //Load paragraph letter
		FrontPanel.memory[51].setText(instUIBuilder(LDR, 1, 2, 0, 0)); //Load word letter
		FrontPanel.memory[52].setText(instUIBuilder(TRR, 0, 1, 0, 0)); //Compare
		FrontPanel.memory[53].setText(instUIBuilder(JCC, 3, 0, 11, 1));//If equal to 1 jump
		FrontPanel.setMemory(11, 200);//Call to incrementParagraphAndWordAndFinderIndex()	
		incrementParagraphAndWordAndFinderIndex();
		//Else
		FrontPanel.memory[54].setText(instUIBuilder(STX, 0, 1, 12, 0));//Bring index paragraph to memory
		FrontPanel.memory[55].setText(instUIBuilder(STX, 0, 2, 13, 0));//Bring index word to memory
		FrontPanel.memory[56].setText(instUIBuilder(LDR, 2, 0, 12, 0));//Load from memory to register the indexes
		FrontPanel.memory[57].setText(instUIBuilder(LDR, 3, 0, 13, 0));//Load from memory to register the indexes
		FrontPanel.memory[58].setText(instUIBuilder(AIR, 2, 0, 1, 0));// +1
		FrontPanel.memory[59].setText(instUIBuilder(AIR, 3, 0, 1, 0));// +1
		FrontPanel.memory[60].setText(instUIBuilder(STR, 2, 0, 12, 0));//Store to memory
		FrontPanel.memory[61].setText(instUIBuilder(STR, 3, 0, 13, 0));//Store to memory
		FrontPanel.memory[62].setText(instUIBuilder(LDX, 0, 1, 12, 0));//Store to index
		FrontPanel.memory[63].setText(instUIBuilder(LDX, 0, 2, 13, 0));//Store to index
		
		FrontPanel.memory[64].setText(instUIBuilder(LDR, 0, 1, 0, 0)); //Load paragraph letter
		FrontPanel.memory[65].setText(instUIBuilder(LDR, 1, 0, 7, 0)); //Load paragraph final position
		FrontPanel.memory[66].setText(instUIBuilder(TRR, 1, 2, 0, 0)); //Compare with index
		FrontPanel.memory[67].setText(instUIBuilder(JCC, 3, 0, 15, 1));//If it's last 
		FrontPanel.setMemory(15, 300);
		//Then
		isWordFound(); // Here program will always finish if Jump
		//Else
		FrontPanel.memory[68].setText(instUIBuilder(LDR, 1, 0, 10, 0)); //Load space
		FrontPanel.memory[69].setText(instUIBuilder(TRR, 0, 1, 0, 0)); //Compare with space and letter
		FrontPanel.memory[70].setText(instUIBuilder(JCC, 3, 0, 23, 1));//If it's space
		FrontPanel.setMemory(23, 400);
		//Then
		isWordFoundSpaceReturn();
		//Else
		FrontPanel.memory[71].setText(instUIBuilder(LDR, 1, 0, 9, 0)); //Load dot(.)
		FrontPanel.memory[72].setText(instUIBuilder(TRR, 0, 1, 0, 0)); //Compare with dot and letter
		FrontPanel.memory[73].setText(instUIBuilder(JCC, 3, 0, 24, 1));//If it's dot then
		FrontPanel.setMemory(24, 500);
		//Then
		isWordFoundDotReturn();
		//Else (Go back to POS 51)
		FrontPanel.memory[74].setText(instUIBuilder(JMA, 0, 0, 30, 1));//Jump to POS 51
		FrontPanel.setMemory(30, 50); // LOOP JUMP
                try{
               FileReaderUtil.writeFile2();
                }
                catch(Exception e){
                    System.out.println(e);
                }
		startAutoProgram(word);
        }
	
	public static void startAutoProgram(String word) {
		
		while( !FrontPanel.isPC(16) && !FrontPanel.isPC(31)){
			FrontPanel.autoSingleStepClicker();
		}
		
		if(FrontPanel.isPC(16)){
			//Mostar resultado exito en consola
			Integer wordNumber = Integer.parseInt(FrontPanel.memory[17].getText(), 2);
			Integer sentenceNumber = Integer.parseInt(FrontPanel.memory[18].getText(), 2); 
			FrontPanel.txtOutput.setText("Found: " + word + " S#: "+ sentenceNumber + " W#: " + wordNumber);
		} else {
			//Mostrar resultado fin en consola
			FrontPanel.txtOutput.setText(FrontPanel.txtOutput.getText() + "\nNot found: " + word);
		}
		
	}

	private static void incrementParagraphAndWordAndFinderIndex(){
		
		FrontPanel.memory[200].setText(instUIBuilder(LDR, 2, 0, 14, 0));//Load from memory to register the counter
		FrontPanel.memory[201].setText(instUIBuilder(AIR, 2, 0, 1, 0));// +1
		FrontPanel.memory[202].setText(instUIBuilder(STR, 2, 0, 14, 0));//Store to memory the counter
		FrontPanel.memory[203].setText(instUIBuilder(STX, 0, 1, 12, 0));//Bring index paragraph to memory
		FrontPanel.memory[204].setText(instUIBuilder(STX, 0, 2, 13, 0));//Bring index word to memory
		FrontPanel.memory[205].setText(instUIBuilder(LDR, 2, 0, 12, 0));//Load from memory to register the indexes
		FrontPanel.memory[206].setText(instUIBuilder(LDR, 3, 0, 13, 0));//Load from memory to register the indexes
		FrontPanel.memory[207].setText(instUIBuilder(AIR, 2, 0, 1, 0));// +1
		FrontPanel.memory[208].setText(instUIBuilder(AIR, 3, 0, 1, 0));// +1
		FrontPanel.memory[209].setText(instUIBuilder(STR, 2, 0, 12, 0));//Store to memory
		FrontPanel.memory[210].setText(instUIBuilder(STR, 3, 0, 13, 0));//Store to memory
		FrontPanel.memory[211].setText(instUIBuilder(LDX, 0, 1, 12, 0));//Store to index
		FrontPanel.memory[212].setText(instUIBuilder(LDX, 0, 2, 13, 0));//Store to index
		FrontPanel.memory[213].setText(instUIBuilder(JMA, 0, 0, 21, 1));//Jump to 1st continue
		
	}
	
	private static void isWordFound(){
		//isWordFound()
		FrontPanel.memory[300].setText(instUIBuilder(LDR,3, 0, 14, 0));//Load from memory to register the counter
		FrontPanel.memory[301].setText(instUIBuilder(LDR, 1, 0, 8, 0));//Load from memory to the word number
		FrontPanel.memory[302].setText(instUIBuilder(TRR, 1, 3, 0, 0)); //Compare them
		FrontPanel.memory[303].setText(instUIBuilder(JCC, 3, 0, 16, 0));//If equal jump then
		FrontPanel.setMemory(16, 0);//Stop in 16 POS <- mean success!
		//Else
		FrontPanel.memory[304].setText(instUIBuilder(JMA, 0, 0, 31, 0));//Stop in 31 POS <- mean finish without finding word!
	}
	
	private static void isWordFoundSpaceReturn(){
		//isWordFound()
		FrontPanel.memory[400].setText(instUIBuilder(LDR, 3, 0, 14, 0));//Load from memory to register the counter
		FrontPanel.memory[401].setText(instUIBuilder(LDR, 1, 0, 8, 0));//Load from memory to the word number
		FrontPanel.memory[402].setText(instUIBuilder(TRR, 1, 3, 0, 0)); //Compare them
		FrontPanel.memory[403].setText(instUIBuilder(JCC, 3, 0, 16, 0));//If equal jump then
		FrontPanel.setMemory(16, 0);//Stop in 16 POS <- mean success!
		//Else
		FrontPanel.memory[404].setText(instUIBuilder(LDR, 1, 0, 17, 0)); //Load word counter
		FrontPanel.memory[405].setText(instUIBuilder(AIR, 1, 0, 1, 0));// +1
		FrontPanel.memory[406].setText(instUIBuilder(STR, 1, 0, 17, 0)); //Store word counter
		FrontPanel.memory[407].setText(instUIBuilder(LDR, 1, 0, 19, 0));//Initialize letter counter to zero
		FrontPanel.memory[408].setText(instUIBuilder(STR, 1, 0, 14, 0));//Initialize letter counter to zero
		FrontPanel.memory[409].setText(instUIBuilder(LDR, 1, 0, 26, 0));//Initialize letter index to 2000
		FrontPanel.setMemory(26, 2000);
		FrontPanel.memory[410].setText(instUIBuilder(STR, 1, 0, 13, 0));//Initialize letter index to 2000
		FrontPanel.memory[411].setText(instUIBuilder(LDX, 0, 2, 13, 0));//Initialize index index to 2000		
		//Paragraph index++
		FrontPanel.memory[412].setText(instUIBuilder(STX, 0, 1, 12, 0));//Bring index paragraph to memory
		FrontPanel.memory[413].setText(instUIBuilder(LDR, 1, 0, 12, 0));//Load from memory to register the indexes
		FrontPanel.memory[414].setText(instUIBuilder(AIR, 1, 0, 1, 0));// +1
		FrontPanel.memory[415].setText(instUIBuilder(STR, 1, 0, 12, 0));//Store to memory
		FrontPanel.memory[416].setText(instUIBuilder(LDX, 0, 1, 12, 0));//Store to index
		
		FrontPanel.memory[417].setText(instUIBuilder(JMA, 0, 0, 30, 1));//Jump to POS 51
	}
	
	private static void isWordFoundDotReturn(){
		//isWordFound()
		FrontPanel.memory[500].setText(instUIBuilder(LDR, 3, 0, 14, 0));//Load from memory to register the counter
		FrontPanel.memory[501].setText(instUIBuilder(LDR, 1, 0, 8, 0));//Load from memory to the word number
		FrontPanel.memory[502].setText(instUIBuilder(TRR, 1, 3, 0, 0)); //Compare them
		FrontPanel.memory[503].setText(instUIBuilder(JCC, 3, 0, 16, 0));//If equal jump then
		FrontPanel.setMemory(16, 0);//Stop in 16 POS <- mean success!
		//Else
		FrontPanel.memory[504].setText(instUIBuilder(LDR, 1, 0, 18, 0)); //Load sentence counter
		FrontPanel.memory[505].setText(instUIBuilder(AIR, 1, 0, 1, 0));// +1
		FrontPanel.memory[506].setText(instUIBuilder(STR, 1, 0, 18, 0)); //Store sentence counter
		
		FrontPanel.memory[507].setText(instUIBuilder(LDR, 1, 0, 19, 0));//Initialize letter counter to zero
		FrontPanel.memory[508].setText(instUIBuilder(STR, 1, 0, 14, 0));//Initialize letter counter to zero
		FrontPanel.memory[509].setText(instUIBuilder(LDR, 1, 0, 26, 0));//Initialize letter index to 2000
		FrontPanel.setMemory(26, 2000);
		FrontPanel.memory[510].setText(instUIBuilder(STR, 1, 0, 13, 0));//Initialize letter index to 2000
		FrontPanel.memory[511].setText(instUIBuilder(LDX, 0, 2, 13, 0));//Initialize index index to 2000		
		//Paragraph index++
		FrontPanel.memory[512].setText(instUIBuilder(STX, 0, 1, 12, 0));//Bring index paragraph to memory
		FrontPanel.memory[513].setText(instUIBuilder(LDR, 1, 0, 12, 0));//Load from memory to register the indexes
		FrontPanel.memory[514].setText(instUIBuilder(AIR, 1, 0, 1, 0));// +1
		FrontPanel.memory[515].setText(instUIBuilder(STR, 1, 0, 12, 0));//Store to memory
		FrontPanel.memory[516].setText(instUIBuilder(LDX, 0, 1, 12, 0));//Store to index
		//Initialize word counter to (1)
		FrontPanel.memory[517].setText(instUIBuilder(LDR, 1, 0, 20, 0));//Initialize register to one
		FrontPanel.memory[518].setText(instUIBuilder(STR, 1, 0, 17, 0));//Initialize word counter to one
		
		FrontPanel.memory[519].setText(instUIBuilder(JMA, 0, 0, 30, 1));//Jump to POS 51
	}

	
	private static void loadAMR() {
		FrontPanel.txtPc.setText("0000000000000110");
		FrontPanel.setRegister(0, "0000000000000010");
		FrontPanel.memory[6].setText("0001000000000111");
		FrontPanel.memory[7].setText("0000000000000001");
	}
	private static void loadSMR() {
		FrontPanel.txtPc.setText("0000000000000110");
		FrontPanel.setRegister(0, "0000000000000010");
		FrontPanel.memory[6].setText("0001010000000111");
		FrontPanel.memory[7].setText("0000000000000001");
	}
	private static void loadAIR() {
		FrontPanel.txtPc.setText("0000000000000110");
		FrontPanel.setRegister(0, "0000000000000010");
		FrontPanel.memory[6].setText("0001100000000111");
		FrontPanel.memory[7].setText("0000000000000001");
	}
	private static void loadSIR() {
		FrontPanel.txtPc.setText("0000000000000110");
		FrontPanel.setRegister(0, "0000000000000010");
		FrontPanel.memory[6].setText("0001110000000111");
		FrontPanel.memory[7].setText("0000000000000001");
	}
	private static void loadMLT() {
		FrontPanel.txtPc.setText("0000000000000110");
		FrontPanel.setRegister(0, "0000000000000100");
		FrontPanel.setRegister(2, "0000000000000010");
		FrontPanel.memory[6].setText("0100000010000000");
		//FrontPanel.memory[7].setText("0000000000000001");
	}
	private static void loadDVD() {
		FrontPanel.txtPc.setText("0000000000000110");
		FrontPanel.setRegister(0, "0000000000000100");
		FrontPanel.setRegister(2, "0000000000000010");
		FrontPanel.memory[6].setText("0100010010000000");
		FrontPanel.memory[7].setText("0000000000000001");
	}
	private static void loadTRR() {
		FrontPanel.setPc(6);
		FrontPanel.setRegister(0, "0000000000000010");
		FrontPanel.setRegister(2, "0000000000000010");
		FrontPanel.memory[6].setText(instUIBuilder(TRR, 0, 2, 0, 0));
	}
	private static void loadAND() {
		FrontPanel.txtPc.setText("0000000000000110");
		FrontPanel.setRegister(0, "0000000000000011");
		FrontPanel.setRegister(2, "0000000000000010");
		FrontPanel.memory[6].setText("0100110000000111");
		FrontPanel.memory[7].setText("0000000000000001");
	}
	private static void loadORR() {
		FrontPanel.txtPc.setText("0000000000000110");
		FrontPanel.setRegister(0, "0000000000000011");
		FrontPanel.setRegister(2, "0000000000000010");
		FrontPanel.memory[6].setText("0101000000000111");
		FrontPanel.memory[7].setText("0000000000000001");
	}
	private static void loadNOT() {
		FrontPanel.txtPc.setText("0000000000000110");
		FrontPanel.setRegister(0, "0000000000000001");
		FrontPanel.memory[6].setText("0101010000000111");
		FrontPanel.memory[7].setText("0000000000000001");
	}
	
	private static void loadJZ() {
		FrontPanel.txtPc.setText("0000000000000110");
		FrontPanel.setRegister(0, "0000000000000010");
		FrontPanel.memory[6].setText("0010000000000111");
		FrontPanel.memory[7].setText("0000000000000001");
	}
	private static void loadJNE() {
		FrontPanel.txtPc.setText("0000000000000110");
		FrontPanel.setRegister(0, "0000000000000010");
		FrontPanel.memory[6].setText("0010010000000111");
		FrontPanel.memory[7].setText("0000000000000001");
	}
	private static void loadJCC() {
		FrontPanel.setPc(6);
		FrontPanel.memory[6].setText(instUIBuilder(JCC, 1, 0, 8, 1));
		FrontPanel.setMemory(8, 130);
		FrontPanel.txtCc.setText("0100");
	}
	private static void loadJMA() {
		FrontPanel.txtPc.setText("0000000000000110");
		FrontPanel.setRegister(0, "0000000000000010");
		FrontPanel.memory[6].setText(instUIBuilder(JMA, 1, 0, 7, 0));
		FrontPanel.memory[7].setText("0000000000000001");
	}
	private static void loadJSR() {
		FrontPanel.txtPc.setText("0000000000000110");
		FrontPanel.setRegister(0, "0000000000000010");
		FrontPanel.memory[6].setText(instUIBuilder(JSR, 0, 0, 7, 0));
		FrontPanel.memory[7].setText("0000000000000001");
	}
	private static void loadRFS() {
		FrontPanel.txtPc.setText("0000000000000110");
		FrontPanel.setRegister(0, "0000000000000100");
		FrontPanel.memory[6].setText(instUIBuilder(RFS, 0, 0, 7, 0));
		FrontPanel.memory[7].setText("0000000000000001");
	}
	private static void loadSOB() {
		FrontPanel.txtPc.setText("0000000000000110");
		FrontPanel.setRegister(0, "0000000000000010");
		FrontPanel.memory[6].setText(instUIBuilder(SOB, 0, 0, 7, 0));
		FrontPanel.memory[7].setText("0000000000000001");
	}
	private static void loadJGE() {
		FrontPanel.txtPc.setText("0000000000000110");
		FrontPanel.setRegister(0, "0000000000000011");
		FrontPanel.memory[6].setText(instUIBuilder(JGE, 0, 0, 7, 0));
		FrontPanel.memory[7].setText("0000000000000001");
	}
	private static void loadSRC() {
		FrontPanel.txtPc.setText("0000000000000110");
		FrontPanel.setRegister(0, "0000000000000110");
		FrontPanel.memory[6].setText("0110010000000111");
		FrontPanel.memory[7].setText("0000000000000001");
	}
	private static void loadRRC() {
		FrontPanel.txtPc.setText("0000000000000110");
		FrontPanel.setRegister(0, "0000000000000011");
		FrontPanel.memory[6].setText("0110100000000111");
		FrontPanel.memory[7].setText("0000000000000001");
	}
	private static void loadCHK() {
		FrontPanel.txtPc.setText("0000000000000110");
		FrontPanel.setRegister(0, "0000000000000011");
		FrontPanel.memory[6].setText("1100110000000111");
		FrontPanel.memory[7].setText("0000000000000001");
		FrontPanel.txtInput.setText("3");
	}
        
        	private static void loadFADD() {
		FrontPanel.txtPc.setText("0000000000000110");
		FrontPanel.memory[6].setText(instUIBuilder(FADD, 0, 0, 7, 0));
		FrontPanel.setMemory(7, 13); // 13
		FrontPanel.txtFR0.setText("0000000111100000"); // 7.5f
		//Result = 0000001101001000 20.5f
	}
                
	private static void loadFSUB() {
		FrontPanel.txtPc.setText("0000000000000110");
		FrontPanel.memory[6].setText(instUIBuilder(FSUB, 0, 0, 7, 0));
		FrontPanel.setMemory(7, 4); // 4
		FrontPanel.txtFR0.setText("0000000111100000"); // 7.5f
		//Result = 0000000011000000 3.5f
	}
        
        private static void loadCNVRT() {
		FrontPanel.txtPc.setText("0000000000000110");
		FrontPanel.memory[6].setText(instUIBuilder(CNVRT, 1, 0, 7, 0));
		FrontPanel.setMemory(7, 17); //Convert the number 17 
		FrontPanel.setRegister(0, 0); //Convert from Integer to Float
		//Result 0000001100010000 17f
	}

	private static void loadVSUB() {
		FrontPanel.txtPc.setText("0000000000000110");
		FrontPanel.memory[6].setText(instUIBuilder(VSUB, 0, 0, 7, 0));
		FrontPanel.txtFR0.setText("0000000010000000"); // 3f
		FrontPanel.setMemory(7, 10);
		FrontPanel.setMemory(8, 15);
		
		FrontPanel.setMemory(10, 4);
		FrontPanel.setMemory(11, 2);
		FrontPanel.setMemory(12, 2);
		
		FrontPanel.setMemory(15, 1);
		FrontPanel.setMemory(16, 2);
		FrontPanel.setMemory(17, 1);    
		//Result, vector with = 3, 0, 1 in pos 10, 11, 12
	}

	private static void loadVADD() {
		FrontPanel.txtPc.setText("0000000000000110");
		FrontPanel.memory[6].setText(instUIBuilder(VADD, 0, 0, 7, 0));
		FrontPanel.txtFR0.setText("0000000010000000"); // 3f
		FrontPanel.setMemory(7, 10);
		FrontPanel.setMemory(8, 15);
		
		FrontPanel.setMemory(10, 1);
		FrontPanel.setMemory(11, 1);
		FrontPanel.setMemory(12, 2);
		
		FrontPanel.setMemory(15, 1);
		FrontPanel.setMemory(16, 2);
		FrontPanel.setMemory(17, 1);
		
		//Result, vector with = 2, 3, 3 in pos 10, 11, 12
	}
        
        private static void loadSTFR() {
		FrontPanel.txtPc.setText("0000000000000110");
		FrontPanel.memory[6].setText(instUIBuilder(STFR, 0, 0, 7, 0));
		FrontPanel.memory[7].setText("0000000000000000"); // 0f
		FrontPanel.txtFR0.setText("0100000000000000"); // 1f
                FrontPanel.txtFR1.setText("1110000000000000");
		//Result = 0100000000000000 1f
	}

	private static void loadLDFR() {
		FrontPanel.txtPc.setText("0000000000000110");
		FrontPanel.memory[6].setText(instUIBuilder(LDFR, 0, 0, 7, 0));
		FrontPanel.memory[7].setText("0100000000000000"); // 1f
                FrontPanel.memory[8].setText("1110000000000000");
		FrontPanel.txtFR0.setText(""); // 1f
                FrontPanel.txtFR1.setText("");
		//Result = 0100000000000000 1f
	}
        
	/**
	 Function to build the instructions to UI
	 receiving the opCode with the instruction name and the
	 other parameter as decimal numbers.
	 @return 16 bits long binary instruction
	 */
	public static String instUIBuilder(InstructionEnum opCodeEnum,
												 Integer r, Integer ix,
												 Integer address, Integer i){
          
        
		String opCode = InstructionEnum.getValue(opCodeEnum);
                
		String rS = BinaryUtil.fillBinaryStringParam(Integer.toBinaryString(r), 2);
		String ixS = BinaryUtil.fillBinaryStringParam(Integer.toBinaryString(ix), 2);
                
		String iS = Integer.toBinaryString(i);
		String addressS = BinaryUtil.fillBinaryStringParam(Integer.toBinaryString(address), 5);
               
		return opCode + rS + ixS + iS + addressS; 
	}

}
 