/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import acquintaince.IData;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author geniu
 */
public class SaveToFile {

    File logFile;
    File caseFile;
    File userFIle;

    public SaveToFile() {

    }

    public void writeToLog(int caseID, int workerID, String logType) throws FileNotFoundException {

        try (PrintStream out = new PrintStream("Log.txt")) {

            out.println(caseID);
            out.println(workerID);
            out.println(logType);
            Timestamp TS = Timestamp.valueOf(LocalDateTime.MIN);
            out.println(TS);

        }
    }

    public void getLog() throws FileNotFoundException, IOException {

        try (BufferedReader br = new BufferedReader(new FileReader("Log.txt"))) {

            String dataLine = null;

            while ((dataLine = br.readLine()) != null) {
                System.out.println(dataLine);
            }

        }

    }

    public void writeToCase(int caseID, int CPR, String caseContent) throws FileNotFoundException {

        try (PrintStream out = new PrintStream("Case.txt")) {

            out.println(caseID);
            out.println(CPR);
            out.println(caseContent);
            Timestamp TS = Timestamp.valueOf(LocalDateTime.MIN);
            out.println();
            System.out.println("Save to file");

        }
    }

    public void getCase() throws FileNotFoundException, IOException {

    }

    public void creatCaseWorker(String name, String username, String password) throws FileNotFoundException {

        try (PrintStream out = new PrintStream("user.txt")) {
            out.println(username);
            out.println(password);

        }
    }

    public String getCaseWorker() throws FileNotFoundException, IOException {

       
        try (BufferedReader br = new BufferedReader(new FileReader("user.txt"))) {

            String dataLine = null;

            while ((dataLine = br.readLine()) != null) {
               
            }

        }
        

    return "";}
}
