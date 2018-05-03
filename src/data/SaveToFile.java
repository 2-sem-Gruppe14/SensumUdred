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
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author geniu
 */
public class SaveToFile implements IData, Serializable {

    Timestamp Timestamp;
    PreparedStatement ps = null;
    Connection connection = null;
    ResultSet rs = null;
    File logFile;
    public SaveToFile(){
    
    }
    
    private void writeToLog(int caseID, int workerID, String logType) throws SQLException, FileNotFoundException {
        
        

        }
    }

}
