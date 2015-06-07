package by.epam.fedyuk.ftpdownload;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.SocketException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;


public class FTPController {
	public final static String SERVER="ftp.byfly.by";
	public final static String USER="anonymous";
	public final static String PASS="";
	public static FTPClient ftpClient;
	public static void showServerReply(FTPClient ftpClient){
		String[] replies = ftpClient.getReplyStrings();
		if(replies!=null && replies.length>0){
			for(String reply : replies)
				System.out.println("Server: " + reply);
		}
	}
	public static boolean connectToServer(){
		boolean isConnected = false;
		ftpClient = new FTPClient();
		try {
			ftpClient.connect(SERVER);
			ftpClient.enterLocalPassiveMode();
			showServerReply(ftpClient);
			ftpClient.login(USER, PASS);
			if(ftpClient.isConnected()){
				System.out.println("Client is connected");
				isConnected=true;
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isConnected;
		
	}
	public static void showListFiles(String path){
		
		 FTPFile[] listOfFiles;
		 try {
			listOfFiles=ftpClient.listFiles(path);
			for(int i = 0;i<listOfFiles.length;i++){
				 System.out.println(listOfFiles[i].getName());
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	public static void showListDirectories(String path){
		
		FTPFile [] listOfDirectories;
		try {
			listOfDirectories=ftpClient.listDirectories(path);
			for(int i=0; i<listOfDirectories.length;i++){
				System.out.println(listOfDirectories[i].getName());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static String inputDirectory(){
		String directory = null;
		
		while(true){
			System.out.println("Input destination to file:");
			String line = "([a-zA-Z]:)?(\\\\[a-zA-Z 0-9\\p{InCyrillic}_.-]+)+\\\\?";
			Pattern pattern = Pattern.compile(line);
			BufferedReader br;
			try {
				br = new BufferedReader(new InputStreamReader(System.in,"cp866"));
				directory = br.readLine();
				Matcher matcher = pattern.matcher(directory);
				if(matcher.matches()==true){
					System.out.println("Correct path,continue!");
					break;
				}
					
				else
					System.out.println("Incorrect path!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		return directory;
		
	}
	
	public static void downloadFiles(){
	
		String destination = inputDirectory();
		String source = null;
		System.out.println("Input source from server:");
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(System.in,"cp866"));
			source = br.readLine();
			
		} catch (IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String remoteFile = source;
		File downloadFile = new File(destination);
		boolean success;
		try {
			OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(downloadFile));
			success = ftpClient.retrieveFile(remoteFile, outputStream);
			if(success==true)
				System.out.println("Download success");
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	public static void changeFolder(){
	
		String newPath = inputDirectory();
		try {
			ftpClient.changeWorkingDirectory(newPath);
			showListFiles(newPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static boolean goToParentDirectory(){
		boolean success = false;
		try {
			if(success==ftpClient.changeToParentDirectory()){
				success=true;
			}
				
			else
				System.out.println("Unsuccessful parent file changing");
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean disconnect(){
		boolean isConnected=true;
		try {
			ftpClient.disconnect();
			ftpClient.logout();
			if(ftpClient.isConnected()){
				System.out.println("Cliend is disconnected");
				isConnected = false;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isConnected;
		
	}
	
	public static void choseComand(String choice){
		switch(choice){
		case "1":{
			connectToServer();
			break;
		}
		case "2":{
			String path =inputDirectory();
			showListFiles(path);
			break;
		}
		case "3":{
			downloadFiles();
			break;
		}
		case "4":{
			String path =inputDirectory();
			showListFiles(path);
			showListDirectories(path);
			break;
		}
		case "5":{
			goToParentDirectory();
			break;
		}
		case "6":{
			disconnect();
			break;
		}
		}
			
		
	}

 }
