/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontpanel;

import java.io.*;
import java.util.Scanner;

public class FileReaderUtil {

	public static String getFile(String fileName) {

		StringBuilder result = new StringBuilder("");

		//Get file from resources folder
		File file = new File(fileName);

		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				result.append(line).append("\n");
			}

			scanner.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result.toString();

	}
  public static void writeFile2() throws IOException {
	File fout = new File("out.txt");
	FileOutputStream fos = new FileOutputStream(fout);
 
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
 
	 for(int i=0;i<2048;i++){
                    try{
                    bw.write(FrontPanel.memory[i].getText());
                    bw.newLine();
                    }
                    catch(Exception e){
                        System.out.println(e);
                }
                }
	bw.close();
}
  
	public static void ReadFile(String fileName) {

		StringBuilder result = new StringBuilder("");

		//Get file from resources folder
		File file = new File(fileName);

		try (Scanner scanner = new Scanner(file)) {
                        int i=0;
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
                                
				FrontPanel.memory[i].setText(line);
                                i++;
			}
			scanner.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}