/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensumudred.benjamin_additions.classes;

import sensumudred.benjamin_additions.interfaces.*;

/**
 *
 * @author BenPaxIndustries
 */
public class TransactionManager implements ITransactionManager {
    // modules to transmit to
    ILoggingAndRecoveryModule loggingAndRecoveryModule;
    IConcurrencyControlModule concurrencyControlModule;
}
