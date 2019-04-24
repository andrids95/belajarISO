/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maven.iso8583.belajariso;

import java.io.IOException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;

/**
 *
 * @author Andri D Septian
 */
public class sendIso {

    public static void build() throws IOException, ISOException {
        GenericPackager packager = new GenericPackager("src/main/resources/basic_field.xml");

        Logger logger = Logger.getLogger("log");
        logger.setLevel(Level.INFO);

//        create iso message
        ISOMsg isoMsg = new ISOMsg();
        isoMsg.setPackager(packager);
        isoMsg.setMTI("0200");
        isoMsg.set(3, "201234");
        isoMsg.set(4, "10000");
        isoMsg.set(7, "110722180");
        isoMsg.set(11, "123456");
        isoMsg.set(44, "A5DFGR");
        isoMsg.set(104, "TESTISO");
        isoMsg.set(105, "ANDRITESTISO8583 1234567890");

        logISOMsg(isoMsg);
        
        byte[] data = isoMsg.pack();
        System.out.println("RESULT : " + new String(data));
        logger.info("RESULT : " + new String(data));
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
