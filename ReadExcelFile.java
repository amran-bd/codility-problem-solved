/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.read.excel.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 *
 * @author amran
 */
public class ReadExcelFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Map<String, String> map = new HashMap();

        map.put("SCBL", "STANDARD CHARTERED BANK");
        map.put("NCC", "NATIONAL CREDIT & COMMERCE BANK LTD.");
        map.put("UTBL", "UTTARA BANK LTD.");
        map.put("NBP", "NATIONAL BANK OF PAKISTAN");
        map.put("BCBL", "BANGLADESH COMMERCE BANK LTD.");
        map.put("DHBL", "DHAKA BANK LTD.");
        map.put("DBBL", "DUTCH-BANGLA BANK LTD");
        map.put("BRKBL", "BRAC BANK LTD.");
        map.put("BDDB", "BANGLADESH DEVELOPMENT BANK LTD.");
        map.put("MTB", "MUTUAL TRUST BANK LTD.");
        map.put("NRB", "NRB BANK LIMITED");
        map.put("UBL", "UNION BANK LTD.");
        map.put("NGBL", "NRB GLOBAL BANK LIMITED");
        map.put("ALAR", "AL-ARAFAH ISLAMI BANK LTD.");
        map.put("SONALI", "SONALI BANK LTD.");
        map.put("SJBL", "SHAHJALAL ISLAMI BANK LTD.");
        map.put("RKUB", "RAJSHAHI KRISHI UNNAYAN BANK");
        map.put("BSBBL", "BANGLADESH SAMABAYA BANK LTD.");
        map.put("BB", "BANGLADESH BANK");
        map.put("MGBL", "MEGHNA BANK LIMITED");
        map.put("ALFH", "BANK AL-FALAH LTD");
        map.put("UCBL", "UNITED COMMERCIAL BANK LTD.");
        map.put("FSIB", "FIRST SECURITY ISLAMI BANK LTD.");
        map.put("ONEB", "ONE BANK LTD.");
        map.put("TRUSTBANK", "TRUST BANK LTD.");
        map.put("PUBALIBANK", "PUBALI BANK LTD.");
        map.put("JBL", "JAMUNA BANK LTD.");
        map.put("HBL", "HABIB BANK LTD.");
        map.put("ICBIBANK", "ICB ISLAMIC BANK LTD");
        map.put("SBAC", "SBAC BANK LIMITED");
        map.put("SDBL", "STANDARD BANK LTD.");
        map.put("SBIN", "STATE BANK OF INDIA");
        map.put("MBL", "MERCANTILE BANK LTD.");
        map.put("SEB", "SOUTHEAST BANK LTD.");
        map.put("SHIMANTO", "SHIMANTO BANK LIMITED");
        map.put("EXIMBANK", "EXIM BANK LTD.");
        map.put("WOORI", "WOORI BANK");
        map.put("SIBL", "SOCIAL ISLAMI BANK LTD");
        map.put("AGB", "AGRANI BANK LTD.");
        map.put("BANKASIA", "BANK ASIA LTD.");
        map.put("CITYBANK", "THE CITY BANK LTD.");
        map.put("HSBC", "HONGKONG & SHANGHAI BANKING CORP.");
        map.put("BKBA", "BANGLADESH KRISHI BANK");
        map.put("NBL", "NATIONAL BANK LTD.");
        map.put("NRBC", "NRB COMMERCIAL BANK LTD.");
        map.put("CCEY", "COMMERCIAL BANK OF CYLON");
        map.put("PRBL", "PRIME BANK LTD.");
        map.put("EBL", "EASTERN BANK LTD.");
        map.put("PRMR", "THE PREMIER BANK LTD.");
        map.put("MDBL", "MIDLAND BANK LIMITED");
        map.put("TFBL", "THE FARMERS BANK LIMITED");
        map.put("IBBL", "ISLAMI BANK BANGLDESH LTD.");
        map.put("JB", "JANATA BANK LTD.");
        map.put("IFIC", "IFIC BANK LTD.");
        map.put("BKSI", "BASIC BANK LTD.");
        map.put("MODH", "MODHUMOTI BANK LIMITED");
        map.put("RUPB", "RUPALI BANK LTD.");
        map.put("ABBL", "AB BANK LTD.");
        map.put("CITI", "CITI BANK N A");
        map.put("COMBL", "COMMUNITY BANK BANGLADESH LTD.");

        Map<String, String> swapMapp = map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

        try {
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("/home/amran/Downloads/ROUTING_NUMBER_LIST.xls"));
            PrintWriter out = new PrintWriter("/home/amran/Downloads/BEFTN_SCRIPT.sql"); // Step 2
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            HSSFRow row;
            //HSSFCell cell;
            int count2 = 0;

            int rows; // No of rows
            rows = sheet.getPhysicalNumberOfRows();

            int cols = 0; // No of columns
            int tmp = 0;

            // This trick ensures that we get the data properly even if it doesn't start from first few rows
            for (int i = 0; i < 10 || i < rows; i++) {
                row = sheet.getRow(i);
                if (row != null) {
                    tmp = sheet.getRow(i).getPhysicalNumberOfCells();
                    if (tmp > cols) {
                        cols = tmp;
                    }
                }
            }

            /**
             * For Current List
             */
            POIFSFileSystem fs2 = new POIFSFileSystem(new FileInputStream("/home/amran/current_bank2.xls"));
            HSSFWorkbook wb2 = new HSSFWorkbook(fs2);
            HSSFSheet sheet2 = wb2.getSheetAt(0);
            HSSFRow row2 = null;

            int rows2; // No of rows
            rows2 = sheet2.getPhysicalNumberOfRows();

            int cols2 = 0; // No of columns
            int tmp2 = 0;

            // This trick ensures that we get the data properly even if it doesn't start from first few rows
            for (int i = 0; i < 10 || i < rows2; i++) {
                row2 = sheet2.getRow(i);
                if (row2 != null) {
                    tmp2 = sheet2.getRow(i).getPhysicalNumberOfCells();
                    if (tmp2 > cols2) {
                        cols2 = tmp2;
                    }
                }
            }

//            for (int r = 1; r < rows2; r++) {
//                row2 = sheet2.getRow(r);
//                if (row2 != null) {
//                    count2++;
//                    String s = row2.getCell(7).toString();
//                    System.out.println("Current Routing Number:: " + row2.getCell(7).toString());
//                }
//            }
            boolean found = false;
            int routingID = rows2;
            int count4 = 0;
            out.println("--BEFTN Postgresql Script--\n\n\n");
            for (int r = 1; r < rows; r++) {
                row = sheet.getRow(r);
                if (row != null) {
                    count2++;
                    for (int r2 = 1; r2 < rows2; r2++) {
                        row2 = sheet2.getRow(r2);
                        if (row2 != null) {
                            if (row2.getCell(7).toString().equals(row.getCell(6).toString())) {
                                found = true;
                                break;
                            }
                        }
                    }
                    if (!found) {
                        count4++;
                        routingID++;
                        int tempID = routingID -1 ;
                        out.append("INSERT INTO public.beftn_route(\n"
                                + "	id, dist_code, dist_name, bank_code, bank_name, branch_name, branch_code, routing_number,created_at,updated_at, bank_alias)\n"
                                + "	VALUES ("
                                + tempID + ",'"
                                + row.getCell(2).toString() + "', '"
                                + row.getCell(3).toString() + "', '"
                                + row.getCell(0).toString() + "', '"
                                + row.getCell(1).toString() + "', '"
                                + row.getCell(5).toString() + "', '"
                                + row.getCell(4).toString() + "', '"
                                + row.getCell(6).toString() + "', '"
                                + LocalDateTime.now() + "', '"
                                + LocalDateTime.now() + "', '"
                                + swapMapp.get(row.getCell(1).toString()) + "');\n");
                    }
                    found = false;
                }
            }
            out.close();  // Step 4
            System.out.println("Total Row Count " + count2);
            System.out.println("Total Row Adjusted " + count4);
        } catch (IOException ioe) {
            System.out.println("Exception is:" + ioe.getMessage());
        }
    }

}
