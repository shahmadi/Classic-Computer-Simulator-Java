
package frontpanel;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.lang.Math;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;


import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Toolkit;
import javax.swing.ImageIcon;



public class FrontPanel {

	private JFrame frmFontPanelGui;
	private JSplitPane splitPanel;
	
	private JTextField txtOpCode;
	private JTextField txtR;
	private JTextField txtIX;
	private JTextField txtI;
	private JTextField txtAddress;
        private JTextField txtMemLoc;
	static JTextField txtMsr;

	//Registers
	static JTextPane txtR0;// TextInput for R0
	static JTextPane txtR1;// TextInput for R1
	static JTextPane txtR2;// TextInput for R2
	static JTextPane txtR3;// TextInput for R3
	
	//Indexes
	static JTextPane txtX1;// TextInput for X1
	static JTextPane txtX2;// TextInput for X2
	static JTextPane txtX3;// TextInput for X3
	
	static JTextPane txtPc; //PC
	static JTextPane txtMar; //MAR
	static JTextPane txtMbr; //MBR
	static JTextPane txtIr;  //IR
	static JTextField txtMfr;  //MFR
        static JTextField txtFR0;  //FR0
	static JTextField txtFR1;  //FR1
	
	static JTextPane txtEc; //EC
	static JTextField txtCc; //CC
	static JTextPane txtOutput; //Output
	static JTextPane txtInput;
	
	/*
	 Creating the application.
	 */
	public FrontPanel() {
		initialize();
	}

	static public JTextPane[] memory; //All memory entries
	private JPanel panel_1;
	
	/*
	 Launching the application.
	 */
	public static void main(String[] args) {
		
               // FileReaderUtil.ReadFile("out.txt");
                
              /*  try{
                    FileReaderUtil.writeFile2();
                }
                catch(Exception e){
                    System.out.println("kadsh");
                }*/
              
               FrontPanel window = new FrontPanel();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
                                    
					window.frmFontPanelGui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
             
                
                //HardCodeBuilder.loadProgram2();
               /* 
                //0000001100010000
                String s = "0";
		String exp = "0000011";
		String mantissa = "00010000";
		FloatRepresentation f = new FloatRepresentation(s+exp+mantissa);
		System.out.println(f.calculateDecimalNumber());
		//FloatRepresentation f2 = new FloatRepresentation(2f);*/
		//System.out.println(f2.toString());
	}

	/**
	 * Creation of the components and basic initialization of 
	 * the contents of the application
	 */
        //done
	private void initialize() {
		
		//Main window
		frmFontPanelGui = new JFrame(); // create and make a window
		
		frmFontPanelGui.setTitle("User Interface");
		frmFontPanelGui.setBounds(100, 100, 1176, 618);
		frmFontPanelGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFontPanelGui.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		//Split Panel (main panel)
		splitPanel = new JSplitPane();
		splitPanel.setDividerLocation(900);
		frmFontPanelGui.getContentPane().add(splitPanel);
		
		//Memory Panel (right part of the app)  
		JScrollPane memoryPanel = new JScrollPane();// arrange a scrollpane for memoryPanel.
		memoryPanel.setViewportBorder(new CompoundBorder());//add a new border for memoryPanel
		memoryPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                
		//Initialzing memory
		memory = new JTextPane[2048];// arrange 2048 bits space for memory store it here as array.
		splitPanel.setRightComponent(new MemoryPanel(2048, memory).getSplitPane());// build rightComponent and at the same time split border for panel
		                                                                        
		//Left Panel (left part of the part - all that isn't memory)
		panel_1 = new JPanel(); // Creating a panel in left side.
		panel_1.setBackground(new Color(29, 150, 210));
		splitPanel.setLeftComponent(panel_1);
		initLeftPanelComponents(panel_1);
		txtInput = new JTextPane();
		txtInput.setBounds(109, 376, 288, 59);
		panel_1.add(txtInput);
		
                //creating address and output text fields
		JLabel lblNewLabel = new JLabel("Address");
		lblNewLabel.setBounds(435, 96, 72, 16);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("OUTPUT");
		lblNewLabel_1.setBounds(45, 262, 61, 16);
		panel_1.add(lblNewLabel_1);
		
		
	}
        
	//done
	private void initLeftPanelComponents(JPanel panel){
		initTitle(panel);
		initInstructionInput(panel);
		//Initialzing PC, IR, MBR, IR, IAR, MBR and MAR
		initPCandOtherFields(panel);
		initRegisters(panel);
		initIndexes(panel);
		initButtons(panel);
                initBtnResetCache(panel);
		//Init CC, Output, Input, CC and MSR
		initInputsAndOutputs(panel);
            
		
	}
	//to set values of general register
	public static void setRegister(int registerNum, String content){
		if(registerNum == 0){
			txtR0.setText(content);
		} else if(registerNum == 1){
			txtR1.setText(content);
		} else  if(registerNum == 2){
			txtR2.setText(content);
		} else if(registerNum == 3){
			txtR3.setText(content);
		} else {
			//Exception
		}
	}
	//getting values of register
	public static String getRegister(int registerNum){ //
		if(registerNum == 0){
			return txtR0.getText();
		} else if(registerNum == 1){
			return txtR1.getText();
		} else  if(registerNum == 2){
			return txtR2.getText();
		} else if(registerNum == 3){
			return txtR3.getText();
		} else {
			//Exception
		}
		return "";
	}
	//setting index register
	public static void setIndex(int indexNum, String content){
		if(indexNum == 1){
			txtX1.setText(content);
		} else  if(indexNum == 2){
			txtX2.setText(content);
		} else if(indexNum == 3){
			txtX3.setText(content);
		} else {
			//Exception
		}
	}
	//getting index register
	public static String getIndex(int indexNum){
		if(indexNum == 1){
			return txtX1.getText();
		} else  if(indexNum == 2){
			return txtX2.getText();
		} else if(indexNum == 3){
			return txtX3.getText();
		} else {
			//Exception
		}
		return "";
	}
	//setting CC field
	public void setCC(int CCNum, String content){
		if(CCNum == 1){
			txtCc.setText(content);
		} else  if(CCNum == 2){
			txtCc.setText(content);
		} else if(CCNum == 3){
			txtCc.setText(content);
		} else if(CCNum == 4){
			txtCc.setText(content);
		} else {
			//Exception
		}
	}
	//getting CC
	public static String getCC(int CCNum){
		if(CCNum == 1){
			return txtCc.getText();
		} else  if(CCNum == 2){
			return txtCc.getText();
		} else if(CCNum == 3){
			return txtCc.getText();
		} else if(CCNum == 4){
			return txtCc.getText();
		} else {
			//Exception
		}
		return "";
	}
        //getting input
	public JTextPane getDirectInput() {
		return txtInput;
	}
        
        //setting input
	public void setDirectInput(JTextPane directInput) {
		txtInput = directInput;
	}
	//done

	
	
	//for reseting all the values in interface
	private void resetInterface(){
		setIndex(1, null);
		setIndex(2, null);
		setIndex(3, null);
		setRegister(0, null);
		setRegister(1, null);
		setRegister(2, null);
		setRegister(3, null);
		txtCc.setText("");
		//txtMsr.setText("MSR");
		
		txtMar.setText(null);
		txtMbr.setText(null);
		txtIr.setText(null);
		txtInput.setText(null);
		txtOutput.setText("Output");
	}
        private void initBtnResetCache(JPanel panel){
		JButton btnEmptyCache = new JButton("Reset Cache");
		GridBagConstraints gbc_btnEmptyCache = new GridBagConstraints();
		gbc_btnEmptyCache.insets = new Insets(0, 0, 5, 5);
		gbc_btnEmptyCache.anchor = GridBagConstraints.NORTH;
		gbc_btnEmptyCache.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEmptyCache.gridx = 8;
		gbc_btnEmptyCache.gridy = 11;
		panel_1.add(btnEmptyCache, gbc_btnEmptyCache);
		
		btnEmptyCache.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e){
			  Cache.getInstance().resetCache();
		  }
		});
	}
	//for reseting all the values in memory
	private void resetMemory(){
		for(int i = 0; i < 2048; i++){
			setMemory(i, 0);
		}
	}
	//User interface
	private void initTitle(JPanel panel){
		panel_1.setLayout(null);
		JLabel lblCiscSimulator = new JLabel("UI");
		lblCiscSimulator.setBounds(292, 23, 323, 36);
		lblCiscSimulator.setForeground(Color.BLACK);
		lblCiscSimulator.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(lblCiscSimulator);
	}
	//creating OpCode instruction text fields
	private void initInstructionInput(JPanel panel){
		
		//OpCode
		JLabel lblOpcode = new JLabel("OpCode");
		lblOpcode.setBounds(73, 96, 50, 16);
		panel.add(lblOpcode);
		
		txtOpCode = new JTextField();
		txtOpCode.setBounds(31, 117, 128, 26);
		panel.add(txtOpCode);
		txtOpCode.setColumns(10);
		
		//R
		JLabel lblR = new JLabel("R");
		lblR.setBounds(181, 96, 8, 16);
		panel.add(lblR);
		
		txtR = new JTextField();
		txtR.setBounds(164, 117, 63, 26);
		panel.add(txtR);
		txtR.setColumns(10);
		
		//IX
		JLabel lblIx = new JLabel("IX");
		lblIx.setBounds(282, 96, 12, 16);
		panel.add(lblIx);
		
		txtIX = new JTextField();
		txtIX.setBounds(229, 117, 111, 26);
		panel.add(txtIX);
		txtIX.setColumns(10);
		
		//I
		JLabel lblI = new JLabel("I");
		lblI.setBounds(360, 96, 23, 16);
		panel.add(lblI);
		txtI = new JTextField();
		txtI.setBounds(341, 117, 46, 26);
		panel.add(txtI);
		txtI.setColumns(10);
		
		//Address
		txtAddress = new JTextField();
		txtAddress.setBounds(385, 117, 130, 26);
		txtAddress.setText("");
		panel.add(txtAddress);
		txtAddress.setColumns(10);
                
                JLabel mmlc = new JLabel("Mem-Loc");
		mmlc.setBounds(532, 96, 90, 16);
		panel.add(mmlc);
		txtMemLoc = new JTextField();
		txtMemLoc.setBounds(530, 117, 46, 26);
		panel.add(txtMemLoc);
		txtMemLoc.setColumns(10);
                
                
                
	}
        
	//creating various register text field
	private void initPCandOtherFields(JPanel panel) {
		//Init PC
		JLabel lblPc = new JLabel("PC");
		lblPc.setBounds(656, 127, 16, 16);
		panel.add(lblPc);
		
		txtPc = new JTextPane();
		txtPc.setBounds(691, 127, 128, 16);
		txtPc.setText("");
		panel.add(txtPc);
		
		//Init MAR
		JLabel lblMar = new JLabel("MAR");
		lblMar.setBounds(650, 148, 28, 16);
		panel.add(lblMar);
		
		txtMar = new JTextPane();
		txtMar.setBounds(691, 148, 128, 16);
		txtMar.setText("");
		panel.add(txtMar);
		
		//Init MBR
		JLabel lblMbr = new JLabel("MBR");
		lblMbr.setBounds(651, 169, 26, 16);
		panel.add(lblMbr);
		
		txtMbr = new JTextPane();
		txtMbr.setBounds(691, 169, 128, 16);
		txtMbr.setText("");
		panel.add(txtMbr);
		
		//Init IR
		JLabel lblIr = new JLabel("IR");
		lblIr.setBounds(658, 190, 12, 16);
		panel.add(lblIr);
		
		txtIr = new JTextPane();
		txtIr.setBounds(691, 190, 128, 16);
		txtIr.setText("");
		panel.add(txtIr);
		
		//Init IAR
	
	}
	////creating general register text field
	private void initRegisters(JPanel panel){
		//Init Registers Title
		JLabel lblRegisters = new JLabel("Registers");
		lblRegisters.setBounds(715, 296, 72, 19);
		lblRegisters.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblRegisters);
		
		//Init Register 0
		JLabel lblR0 = new JLabel("R0");
		lblR0.setBounds(656, 320, 16, 16);
		panel.add(lblR0);
		
		txtR0 = new JTextPane();
		txtR0.setBounds(691, 320, 128, 16);
		txtR0.setText("");
		panel.add(txtR0);
		
		//Init Register 1
		JLabel lblR1 = new JLabel("R1");
		lblR1.setBounds(656, 348, 16, 16);
		panel.add(lblR1);
		
		txtR1 = new JTextPane();
		txtR1.setBounds(691, 348, 128, 16);
		txtR1.setText("");
		panel.add(txtR1);
		
		//Init Register 2
		JLabel lblR2 = new JLabel("R2");
		lblR2.setBounds(656, 376, 16, 16);
		panel.add(lblR2);
		
		txtR2 = new JTextPane();
		txtR2.setBounds(691, 376, 128, 16);
		txtR2.setText("");
		panel.add(txtR2);
		
		//Init Register 3
		JLabel lblR3 = new JLabel("R3");
		lblR3.setBounds(656, 404, 16, 16);
		panel.add(lblR3);
		
		txtR3 = new JTextPane();
		txtR3.setBounds(691, 404, 128, 16);
		txtR3.setText("");
		panel.add(txtR3);
	}
	//creating index register text field
	private void initIndexes(JPanel panel){
		
		//Init Index 1
		JLabel lblX1 = new JLabel("X1");
		lblX1.setBounds(656, 443, 16, 16);
		panel.add(lblX1);
		
		txtX1 = new JTextPane();
		txtX1.setBounds(691, 443, 128, 16);
		txtX1.setText("");
		panel.add(txtX1);

		//Init Index 2
		JLabel lblX2 = new JLabel("X2");
		lblX2.setBounds(656, 471, 16, 16);
		panel.add(lblX2);
		
		txtX2 = new JTextPane();
		txtX2.setBounds(691, 471, 128, 16);
		txtX2.setText("");
		panel.add(txtX2);
		
		
		//Init Index 3
		JLabel lblX3 = new JLabel("X3");
		lblX3.setBounds(656, 499, 16, 16);
		panel.add(lblX3);
		
		txtX3 = new JTextPane();
		txtX3.setBounds(691, 499, 128, 16);
		txtX3.setText("");
		panel.add(txtX3);
	}
	
	/*creating One instructiob button and after pressing that button read
        the content of instruction and break it down and execute it according 
        to type of instruction
        */
        
	private void initBtnSingleInstruction(JPanel panel){
		JButton btnSingle = new JButton("One Instruction");
		btnSingle.setFont(new Font("Lantinghei SC", Font.BOLD, 14));
		btnSingle.setBounds(452, 293, 155, 50);
		panel.add(btnSingle);
		
		btnSingle.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  //Get MSR
			  String MSR = txtMsr.getText();
			  //Get MFR
			  String MFR = txtMfr.getText();
                         // System.out.println("ASD");
		
			  //Get PC counter
			  String pc = txtPc.getText();
			  //Convert PC from binary to decimal 
			  Integer pcDecimal = Integer.parseInt(txtPc.getText(), 2);
			  //Get Instruction from memory space
                          
                           String FR0 = txtFR0.getText();
			  //Get FR1
			  String FR1 = txtFR1.getText();
                          
			  
			  try
			  {
				  String plainInstruction = Cache.getInstance().checkCache(pcDecimal);
				  //String plainInstruction = memory[pcDecimal].getText();
				  Instruction instruction;
				  instruction = new Instruction(plainInstruction);
				  //Change MAR
				  txtMar.setText(pc);
				  //Change MBR
				  txtMbr.setText(plainInstruction);
				  //Change IR
				  txtIr.setText(plainInstruction);
				  //Evaluate instruction
				  InstructionEnum iCode = instruction.getIntructionCode();
                                  //
			
				  switch(iCode){
                                                case LDX:
                                                    LoadStore.instructionLDX(instruction);
                                                    break;
                                                    case STX:
                                                    LoadStore.instructionSTX(instruction);
                                                    break;
                                                case LDA:
                                                        LoadStore.instructionLDA(instruction);
                                                        break;
		  		  		case LDR:
		  		  			LoadStore.instructionLDR(instruction);
                                                        //System.out.println("HELLO");
                                                              
		  		  			break;
		  		  		case STR:
                                                        //System.out.println(instruction);
		  		  			LoadStore.instructionSTR(instruction);
                                                        
	  		  				break;
		  		  		case AMR:
		  		  			ArithmeticLogicalOps.instructionAMR(instruction);
	  		  				break;
		  		  		case SMR:
		  		  			ArithmeticLogicalOps.instructionSMR(instruction);
	  		  				break;
		  		  		case AIR:
		  		  			ArithmeticLogicalOps.instructionAIR(instruction);
	  		  				break;
		  		  		case SIR:
		  		  			ArithmeticLogicalOps.instructionSIR(instruction);
	  		  				break;
		  		  		case MLT:
		  		  			ArithmeticLogicalOps.instructionMLT(instruction);
	  		  				break; 
		  		  		case DVD:
		  		  			ArithmeticLogicalOps.instructionDVD(instruction);
	  		  				break;
		  		  		case TRR:
		  		  			ArithmeticLogicalOps.instructionTRR(instruction);
	  		  				break;
		  		  		case AND:
		  		  			ArithmeticLogicalOps.instructionAND(instruction);
	  		  				break;
		  		  		case ORR:
		  		  			ArithmeticLogicalOps.instructionORR(instruction);
	  		  				break;
		  		  		case NOT:
		  		  			ArithmeticLogicalOps.instructionNOT(instruction);
	  		  				break;
		  		  		case JZ:
		  		  			Transfer.instructionJZ(instruction);
		  		  			break;
			  		  	case JNE:
		  		  			Transfer.instructionJNE(instruction);
		  		  			break;	
				  		case JCC:
				  			Transfer.instructionJCC(instruction);
			  		  		break;	
				  		case JMA:
		  		  			Transfer.instructionJMA(instruction);
		  		  			break;	
				  		case JSR:
		  		  			Transfer.instructionJSR(instruction);
		  		  			break;	
                                                        
				  		case RFS:
		  		  			Transfer.instructionRFS(instruction);
		  		  			break;	
				  		case SOB:
		  		  			Transfer.instructionSOB(instruction);
		  		  			break;	
				  		case JGE:
		  		  			Transfer.instructionJGE(instruction);
		  		  			break;
				  		case IN:
		  		  			IOOps.instructionIN(instruction);
		  		  			break;
				  		case OUT:
		  		  			IOOps.instructionOUT(instruction);
		  		  			break;
				  		case CHK:
		  		  			IOOps.instructionCHK(instruction);
		  		  			break;
		  		  		case SRC:
		  		  			ArithmeticLogicalOps.instructionSRC(instruction);
	  		  				break;
		  		  		case RRC:
		  		  			ArithmeticLogicalOps.instructionRRC(instruction);
		  		  			break;
		  		  		
                                                case FADD:
		  		  			FloatingPointVectorOps.instructionFADD(instruction);
	  		  				break;
                                                        
		  		  		case FSUB:
		  		  			FloatingPointVectorOps.instructionFSUB(instruction);
	  		  				break;
		  		  		case LDFR:
		  		  			FloatingPointVectorOps.instructionLDFR(instruction);
	  		  				break;
		  		  		case STFR:
		  		  			FloatingPointVectorOps.instructionSTFR(instruction);
	  		  				break;
		  		  		case VADD:
		  		  			FloatingPointVectorOps.instructionVADD(instruction);
	  		  				break;
		  		  		case VSUB:
		  		  			FloatingPointVectorOps.instructionVSUB(instruction);
	  		  				break;
		  		  		case CNVRT:
		  		  			FloatingPointVectorOps.instructionCNVRT(instruction);
	  		  				break;
		  		  		case HALT:
		  		  			txtOutput.setText("HALT");
			  				break;
		  		  		case FAULT:
                                                   // System.out.println("AKHGSDKJASD");
		  		  			txtOutput.setText("FAULT");
			  		  		/* Machine Fault
			  		  		 * Illegal Operation Code */
			  		  			pc = txtPc.getText();
			  		  			String msr = txtMsr.getText();
			  		  			memory[1].setText(msr);
			  		  			memory[4].setText(pc);
			  		  			txtMfr.setText("2");
                                                                
		  		  			break;
				  }
				  //Increment PC counter
				  if((iCode != InstructionEnum.HALT) && (iCode != InstructionEnum.JZ)
					  && (iCode != InstructionEnum.JCC) && (iCode != InstructionEnum.JNE) 
					  && (iCode != InstructionEnum.JMA)){
					  pcDecimal++;
					  txtPc.setText(BinaryUtil.fillBinaryString(Integer.toBinaryString(pcDecimal)));
				  }
			  } catch(IndexOutOfBoundsException m){
						pc = txtPc.getText();
			  			String msr = txtMsr.getText();
			  			memory[1].setText(msr);
			  			memory[4].setText(pc);
			  			txtMfr.setText("3"); 	
			  			}
		  	 catch (Throwable t){
		  		txtOutput.setText("FAULT");
		  		
		  	}
		  }
		});
	}

//executing the program using button execute
        
   
	private void initBtnLoad(JPanel panel) {
		JToggleButton btnExecute = new JToggleButton("Execute");
		btnExecute.setBounds(250, 486, 93, 29);
		panel.add(btnExecute);
                int cnt=100;
                 btnExecute.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
                      setPc(50);
                    FrontPanel.setIndex(1, 1000);
                    FrontPanel.setIndex(2, 2000);
                    FrontPanel.setPc(50);
                     String word=HardCodeBuilder.initProgram2();
                     HardCodeBuilder.startAutoProgram(word);
                  }
                });
	}
        
        private void initBtnLoaad(JPanel panel) {
		JToggleButton btnExecute = new JToggleButton("Load");
		btnExecute.setBounds(350, 486, 93, 29);
		panel.add(btnExecute);
                int cnt=100;
                 btnExecute.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
                     FileReaderUtil.ReadFile("out.txt");
                     
                  }
                });
	}
        	
//creating and implementing pre load button to load program1
	private void initBtnExecute(JPanel panel) {
		JToggleButton btnLoad = new JToggleButton("Load & Execute");
		btnLoad.setBounds(90, 486, 140, 35);
		panel.add(btnLoad);
                btnLoad.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
                     System.out.println("HI");
                      HardCodeBuilder.loadProgram2();
                      
                  }
                });
                //btnLoad.doClick();
	}
//creating button Test-Inst to implement particular instruction
	private void initBtnSave(JPanel panel) {
		JButton btnSave = new JButton("Test-Inst");
		btnSave.setBounds(450, 486, 95, 29);
		panel.add(btnSave);
                 btnSave.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
                      String pr=txtInput.getText();
                      HardCodeBuilder.loadProgram(pr);
                  }
                });
	}
        //creating and implementing store button
        private void initBtnStore(JPanel panel) {
		JButton btnSave = new JButton("Store");
		btnSave.setBounds(480, 190, 95, 50);
		panel.add(btnSave);
                 btnSave.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
                      Integer s=Integer.parseInt(txtMemLoc.getText());
                      memory[s].setText(txtOpCode.getText()+txtR.getText()+txtIX.getText()+txtAddress.getText());   
                  }
                });
	}
        
         
	//initializing buttons
	private void initButtons(JPanel panel) {
		initBtnSingleInstruction(panel);
		initBtnSave(panel);
		initBtnExecute(panel);
		initBtnLoad(panel);
                initBtnStore(panel);
               initBtnLoaad(panel);
	}
	//creating various text fields
	private void initInputsAndOutputs(JPanel panel) {
		//Init area for general output
		txtOutput = new JTextPane();
		txtOutput.setBounds(109, 262, 288, 83);
		panel.add(txtOutput);

		//Init Input field
		JLabel lblInput = new JLabel("INPUT");
		lblInput.setBounds(45, 392, 38, 16);
		lblInput.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblInput);
		
		//Init output for the condition code (CC)
                JLabel mmlc = new JLabel("CC");
		mmlc.setBounds(635, 96, 90, 16);
		panel.add(mmlc);
		txtCc = new JTextField();
		txtCc.setBounds(664, 91, 155, 26);
		txtCc.setText("");
		panel.add(txtCc);
		txtCc.setColumns(10);
		
		//Msr Label
		JLabel lblMsr = new JLabel("MSR");
		lblMsr.setBounds(646, 262, 26, 16);
		panel.add(lblMsr);
		
		//Init MSR
		txtMsr = new JTextField();
		txtMsr.setBounds(684, 257, 140, 26);
		txtMsr.setText("");
		panel.add(txtMsr);
		txtMsr.setColumns(10);
		
		//Mfr Label
		JLabel lblMfr = new JLabel("MFR");
		lblMfr.setBounds(650, 239, 26, 16);
		panel.add(lblMfr);
		
		//Init MFR
		txtMfr = new JTextField();
		txtMfr.setBounds(685, 238, 134, 18);
		txtMfr.setText("");
		panel.add(txtMfr);
		txtMfr.setColumns(10);
                
                //FR0 Label
		JLabel lblFR0 = new JLabel("FR0");
		lblFR0.setBounds(415, 376, 23, 16);
		panel.add(lblFR0);
		
		//Init FR0
		txtFR0 = new JTextField();
		txtFR0.setBounds(452, 371, 155, 26);
		txtFR0.setText("");
		panel.add(txtFR0);
		txtFR0.setColumns(10);
		
		
		//FR1 Label
		JLabel lblFR1 = new JLabel("FR1");
		lblFR1.setBounds(415, 409, 23, 16);
		panel.add(lblFR1);
		
		//Init FR1
		txtFR1 = new JTextField();
		txtFR1.setBounds(452, 404, 155, 26);
		txtFR1.setText("");
		panel.add(txtFR1);
		txtFR1.setColumns(10);
		
	

	}
        //checking to verify the result of instruction
        private void initveri(){
           // System.out.println("HERE "+ Integer.parseInt(memory[200].getText(), 2)+ "THERE "+Integer.parseInt(memory[201].getText(), 2));
            Integer m = Math.abs(Integer.parseInt(memory[200].getText(), 2)-Integer.parseInt(memory[201].getText(), 2));
            Integer j=Integer.parseInt(memory[201].getText(), 2);
            for(int i=202;i<=220;i++){
               // System.out.println("HERE "+ Integer.parseInt(memory[200].getText(), 2)+ "THERE "+Integer.parseInt(memory[i].getText(), 2));
                if(m>Math.abs(Integer.parseInt(memory[200].getText(), 2)-Integer.parseInt(memory[i].getText(), 2))){
                    
                    m=Math.abs(Integer.parseInt(memory[200].getText(), 2)-Integer.parseInt(memory[i].getText(), 2));
                    j=Integer.parseInt(memory[i].getText(), 2);
                }
            }
                String currentText = FrontPanel.txtOutput.getText();
		FrontPanel.txtOutput.setText(currentText +" "+ j);
        }
	//setting PC
	public static void setPc(Integer pc){
		txtPc.setText(BinaryUtil.fillBinaryStringParam(Integer.toBinaryString(pc), 16));
	}
	//setting Memory
	public static void setMemory(Integer pos, Integer content){
		memory[pos].setText(BinaryUtil.fillBinaryStringParam(Integer.toBinaryString(content), 16));
	}
	//setting Register
	public static void setRegister(Integer registerNum, Integer content){
		if(registerNum == 0){
			txtR0.setText(BinaryUtil.fillBinaryStringParam(Integer.toBinaryString(content), 16));
		} else if(registerNum == 1){
			txtR1.setText(BinaryUtil.fillBinaryStringParam(Integer.toBinaryString(content), 16));
		} else  if(registerNum == 2){
			txtR2.setText(BinaryUtil.fillBinaryStringParam(Integer.toBinaryString(content), 16));
		} else if(registerNum == 3){
			txtR3.setText(BinaryUtil.fillBinaryStringParam(Integer.toBinaryString(content), 16));
		} else {
			//Exception
		}
	}
	//setting index
	public static void setIndex(Integer indexNum, Integer content){
		if(indexNum == 1){
			txtX1.setText(BinaryUtil.fillBinaryStringParam(Integer.toBinaryString(content), 16));
		} else  if(indexNum == 2){
			txtX2.setText(BinaryUtil.fillBinaryStringParam(Integer.toBinaryString(content), 16));
		} else if(indexNum == 3){
			txtX3.setText(BinaryUtil.fillBinaryStringParam(Integer.toBinaryString(content), 16));
		} else {
			//Exception
		}
	}
	//implementing single instruction
	public static void autoSingleStepClicker(){
		//Get PC counter
		String pc = txtPc.getText();
		//Convert PC from binary to decimal 
		Integer pcDecimal = Integer.parseInt(txtPc.getText(), 2);
		
		Instruction instruction;
		try
		{
			//Get Instruction from memory space
			String plainInstruction = Cache.getInstance().checkCache(pcDecimal);
			instruction = new Instruction(plainInstruction);
			//Change MAR
			txtMar.setText(pc);
			//Change MBR
			txtMbr.setText(plainInstruction);
			//Change IR
			txtIr.setText(plainInstruction);
                       // System.out.println("HELLPO");
			//Evaluate instruction
			InstructionEnum iCode = instruction.getIntructionCode();
			
			
			switch(iCode){
			case LDR:
				LoadStore.instructionLDR(instruction);
				break;
			case STR:
				LoadStore.instructionSTR(instruction);
				break;
			case AMR:
				ArithmeticLogicalOps.instructionAMR(instruction);
				break;
			case SMR:
				ArithmeticLogicalOps.instructionSMR(instruction);
				break;
			case AIR:
				ArithmeticLogicalOps.instructionAIR(instruction);
				break;
			case SIR:
				ArithmeticLogicalOps.instructionSIR(instruction);
				break;
			case MLT:
				ArithmeticLogicalOps.instructionMLT(instruction);
				break; 
			case DVD:
				ArithmeticLogicalOps.instructionDVD(instruction);
				break;
			case TRR:
				ArithmeticLogicalOps.instructionTRR(instruction);
				break;
			case AND:
				ArithmeticLogicalOps.instructionAND(instruction);
				break;
			case ORR:
				ArithmeticLogicalOps.instructionORR(instruction);
				break;
			case NOT:
				ArithmeticLogicalOps.instructionNOT(instruction);
				break;
			case JZ:
				Transfer.instructionJZ(instruction);
				break;
			case JNE:
				Transfer.instructionJNE(instruction);
				break;	
			case JCC:
				Transfer.instructionJCC(instruction);
				break;	
			case JMA:
				Transfer.instructionJMA(instruction);
				break;	
			case JSR:
				Transfer.instructionRFS(instruction);
				break;	
			case RFS:
				Transfer.instructionSOB(instruction);
				break;	
			case SOB:
				Transfer.instructionJGE(instruction);
				break;	
			case JGE:
				Transfer.instructionJZ(instruction);
				break;
			case IN:
				IOOps.instructionIN(instruction);
				break;
			case OUT:
				IOOps.instructionOUT(instruction);
				break;
			case LDA:
				LoadStore.instructionLDA(instruction);
				break;
			case STX:
				LoadStore.instructionSTX(instruction);
				break;
			case LDX:
				LoadStore.instructionLDX(instruction);
			case HALT:
				txtOutput.setText("HALT");
				break;
			case FAULT:
				txtOutput.setText("FAULT");
				break;
			}
			//Increment PC counter
			if((iCode != InstructionEnum.HALT) && (iCode != InstructionEnum.JZ)
					&& (iCode != InstructionEnum.JCC) && (iCode != InstructionEnum.JNE) 
					&& (iCode != InstructionEnum.JMA)){
				pcDecimal++;
				txtPc.setText(BinaryUtil.fillBinaryString(Integer.toBinaryString(pcDecimal)));
			}
		} catch (Throwable t){
			txtOutput.setText("FAULT");

		}
	}
	// checking 
	public static Boolean isPC(Integer x){
		Integer num = Integer.parseInt(txtPc.getText(), 2);
		return num == x;
	}
	
public static String getFRField(Integer num){
		if(num == 0){
			return txtFR0.getText();
		} else if (num == 1){
			return txtFR1.getText();
		} else {
			return null;
		}
	}
	
	public static void setFRField(int num, String content){
		if(num == 0){
			txtFR0.setText(content);
		} else if(num == 1){
			txtFR1.setText(content);
		} else {
			//Exception
		}
	}
	
}
