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
public class BufferManager implements IBufferManager {
    // modules to transmit to
    IIndexManager indexManager;
    IBuffer buffer;
    IStorageManager storageManager;
}
