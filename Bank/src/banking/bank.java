package banking;
import java.io.*;

import java.sql.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class bank {

	public static void main(String[] args)throws Exception {
		boolean f=true;Scanner sc1=new Scanner(System.in);String name;int pass_code;
		BufferedReader sc = new BufferedReader(
	            new InputStreamReader(System.in));
		do {
			printMenu();
			int choice=sc1.nextInt();
			switch(choice) {
				case 3:
					 System.out.println("********Thank_YOU**********");f=false;break;
				default:
					System.out.println("INVALID INPUT PROVIDED");
					break;
				case 1:
					 System.out.print(
	                            "Enter Unique UserName:");
	                        name = sc.readLine();
	                        System.out.print(
	                            "Enter New Password:");
	                        pass_code = Integer.parseInt(
	                            sc.readLine());
                        
                    System.out.print("GIVE INTIAL DEPOSIT AMOUNT");
                        double r=sc1.nextDouble();
                        if (bankMangement.createAccount(name, pass_code,r)) {
                            System.out.println(
                                "MSG : Account Created Successfully!\n");
                        }
                        else {
                            System.out.println(
                                "ERR : Account Creation Failed!\n");
                        }
                        break;
				case 2:
					System.out.print(
                            "Enter UserName:");
                        name = sc.readLine();
                        System.out.print(
                            "Enter  Password:");
                        pass_code = Integer.parseInt(
                            sc.readLine());
                        if (bankMangement.loginAccount(name, pass_code)) {System.out.println("*******");
                        	
                        }else {
                        	System.out.println("INVALID USER NAME OR PASSWORD");
                        }
                        
					
			}
					
		}while(f);

	}
	public static void printMenu() {
		System.out.println(
                "\n ->||    Welcome to InBank    ||<- \n");
            System.out.println("1)Create Account");
            System.out.println("2)Login Account");
            System.out.println("3)EXIT");        
	}
	

}