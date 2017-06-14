package com.java8.test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ReadFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File folder = new File("D:\\Solr\\fusionPOC\\");
		File[] listOfFiles = folder.listFiles();
		try {
			ReadFile.printFileName(listOfFiles);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void printFileName(File[] listOfFiles) throws Exception{
		List<String> list = new ArrayList<>();
		for (File file : listOfFiles) {			
		    if (file.isFile()) {
		        System.out.println(file.getName());	       
				
				try (Stream<String> stream = Files.lines(Paths.get(file.toURI()))) {

					//1. filter line 3
					//2. convert all content to upper case
					//3. convert it into a List
					list = stream
							.filter(line -> line.contains("spring"))
							.map(String::toUpperCase)
							.collect(Collectors.toList());

				} catch (Exception e) {
					e.printStackTrace();
				}
				String sb=new String();
				for(String str:list){
					sb=sb+str;
				}
				System.out.println(sb);
				Files.write(Paths.get("D:\\output.txt"),sb.getBytes());
			
		    }else if (file.isDirectory()){
		    	printFileName(file.listFiles());
		    }
		}
	}

}
