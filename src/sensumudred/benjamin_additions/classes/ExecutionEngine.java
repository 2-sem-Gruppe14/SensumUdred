/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensumudred.benjamin_additions.classes;

import java.util.Queue;
import sensumudred.benjamin_additions.interfaces.*;

/**
 *
 * @author BenPaxIndustries
 */
public class ExecutionEngine implements IExecutionEngine {
    // this probably needs Collection for declared type
    // to increase flexibility of variating data types
    Queue<String> queryCommands;
    
    // modules to transmit to
    IIndexManager indexManager;
    ILoggingAndRecoveryModule loggingAndRecoveryModule;
}
