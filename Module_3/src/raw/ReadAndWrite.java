package raw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadAndWrite {
	
	private String text;
	private FileWriter fwriter;
	private File file;
	private FileReader frider;
	
	public void createFile(String fileURL) throws TheException 
	{
		
		file = new File(fileURL+".txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			
			throw new TheException("Ошибка при создании файла");
		}
		
		
	}
	
	public void write() throws TheException
	{
		try {
			
            fwriter = new FileWriter(file, true);
            BufferedWriter bfw = new BufferedWriter(fwriter);
            setText();
            bfw.write(text+"\n");
            bfw.close();
            
        } catch (IOException e) {
            throw new TheException("Ошибка записи");
        }
	}
	
	
	
	public void read(String fileURL) throws TheException
	{
		try {
			frider = new FileReader(fileURL+".txt");
			BufferedReader bfr = new BufferedReader(frider);
			String s;
		    while((s=bfr.readLine())!=null){
		                 
		        System.out.println(s);
		        }
		        
		} catch (FileNotFoundException e) {
			throw new TheException ("Файл не найден");
		}
		catch(IOException ioe)
		{
			throw new TheException ("Ошибка чтения");
		}
	}
	
	
	
	public void setText()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите текст");
		
		text = scanner.nextLine();
		scanner.close();
	}
	
	
	
	
	

}
