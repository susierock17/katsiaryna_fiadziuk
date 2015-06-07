package by.epam.fedyuk.ftpdownload;

import java.util.Scanner;

public class FTPMain {

	public static void main(String[] args) {
		FTPView.view();
		Scanner scanner = new Scanner(System.in);
		String choice=scanner.nextLine();
		while(choice.equals(0)){
			FTPController.choseComand(choice);
			choice=scanner.nextLine();
		}
	
	}

}
