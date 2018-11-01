package com.cj.junit;

import org.apache.poi.hwpf.extractor.WordExtractor;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class WordTest {
    @Test
    public  void testTim3(){
        try {
            InputStream is = new FileInputStream(new File("D:\\2003.doc"));
            WordExtractor ex = new WordExtractor(is);
            String text2003 = ex.getText();
            System.out.println(text2003);

//            OPCPackage opcPackage = POIXMLDocument.openPackage("2007.docx");
//            POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
//            String text2007 = extractor.getText();
//            System.out.println(text2007);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
