package practice.implementaions.TheLedgerCo;


import practice.implementaions.TheLedgerCo.service.BankFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        try {
            ArrayList<String> list = (ArrayList<String>) Files.readAllLines(new File(args[0]).toPath(), Charset.defaultCharset());
            if (!list.isEmpty()) BankFactory.processFileData(list);
        } catch (FileNotFoundException e) {
            System.err.println("File not Found : " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IO Exception : " + e.getMessage());
        }
    }
}
