package com.cts.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyFileReader {

	public static void main(String[] args) {
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader("src/readme.txt"));
			int ch = 0;
			char []cbuf = new char[150];
//			while(ch != -1){
//				ch = fileReader.read();
//			while(Stream<String> strStream: bufferedReader.lines())
				
				Stream<String> strStream =  bufferedReader.lines();
				
				String str = strStream.collect(Collectors.joining());;
//				String str = bufferedReader.readLine();
//				ch = bufferedReader.read(cbuf);
//				String str = new String(cbuf);
//				String str = cbuf.toString();
				System.out.println(str);
//			}
		
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
