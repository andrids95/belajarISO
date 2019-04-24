/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.iso8583.belajariso;

import java.io.IOException;
import java.util.Scanner;
import org.jpos.iso.ISOException;

/**
 *
 * @author Andri D Septian
 */
public class mainApp {
    public static void main(String[] args) throws IOException, ISOException{
        
        System.out.print("1. SEND  | 2. RECEIVE  : ");
        Scanner a = new Scanner(System.in);
        int input = a.nextInt();
        
        if(input == 1){
            System.out.println("");
            sendIso.build();
        }
        else if(input == 2){
            System.out.println("");
            recIsoData.receive();
        }
        else {
            System.out.println("input salah");
        }
    }
}
