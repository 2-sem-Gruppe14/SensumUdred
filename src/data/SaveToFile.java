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

/**
 *
 * @author geniu
 */
public class SaveToFile implements IData {

    File logFile;
    
    public SaveToFile(){
    
    }
    
    private void writeToLog(int caseID, int workerID, String logType, Timestamp Timestamp) throws FileNotFoundException {
        
        try(PrintStream out = new PrintStream("Log.txt")){

            out.println(caseID);
            out.println(workerID);
            out.println(logType);
            out.println(Timestamp);

        }
    }
    
    private void getLog() throws FileNotFoundException, IOException {
        
        try(BufferedReader br = new BufferedReader(new FileReader("Log.txt"))){
        
            String dataLine = null;
            
            while((dataLine = br.readLine()) != null){
                System.out.println(dataLine);
            }
            
        }
        
    }
    
    private void writeToCase(int caseID, String caseInformation, Timestamp Timestamp) throws FileNotFoundException{
        
        try(PrintStream out = new PrintStream("Case.txt")){

            out.println(caseID);
            out.println(caseInformation);
            out.println(Timestamp);

        }
    }
    
    private void getCase() throws FileNotFoundException, IOException {
        
    }
}
