/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.iso8583.belajariso;

import java.util.Scanner;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;

/**
 *
 * @author Andri D Septian
 */
public class recIsoData {

    public static void receive() throws ISOException {
        GenericPackager packager = new GenericPackager("src/main/resources/basic_field.xml");

        Logger logger = Logger.getLogger("log");
        logger.setLevel(Level.INFO);

        System.out.print("INSER INPUT ISO: ");
        Scanner a = new Scanner(System.in);

        String data = a.nextLine();
        System.out.println("");

        ISOMsg isoMsg = new ISOMsg();
        isoMsg.setPackager(packager);
        isoMsg.unpack(data.getBytes());
        
        logISOMsg(isoMsg);
        
        

    }

    private static void logISOMsg(ISOMsg msg) {
        System.out.println("=======ISO MESSAGE======");
        try {
            System.out.println(" MTI : " + msg.getMTI());
            for (int i = 1; i <= msg.getMaxField(); i++) {
                if (msg.hasField(i)) {
                    System.out.println("    Field-" + i + " : " + msg.getString(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
