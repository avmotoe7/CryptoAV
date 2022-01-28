/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;

import java.security.SecureRandomSpi;

/**
 *
 * @author vidak
 */
public class CaesarSecureRandomSpi extends SecureRandomSpi {

    private byte[] curentSeed;
    private int counter=0;

    @Override
    protected void engineSetSeed(byte[] seed) {
        //throw new UnsupportedOperationException("Not supported yet."); 
        byte[] curentSeed = new byte[seed.length];
        System.arraycopy(seed, 0, curentSeed, 0, seed.length);
        counter=0;
    }

    @Override
    protected void engineNextBytes(byte[] bytes) {
        //throw new UnsupportedOperationException("Not supported yet."); 
        
        // genereise prirodne brojeve po redu do 255
        for (int i = 0; i < bytes.length; i++) {
            counter++;
            bytes[i]=(byte) (counter%255);
        }
    }

    @Override
    protected byte[] engineGenerateSeed(int numBytes) {
        //throw new UnsupportedOperationException("Not supported yet."); 
        byte[] seed = new byte[numBytes];
        for (int i = 0; i < seed.length; i++) {
            seed[i] = (byte) i;
        }
        return seed;
    }

}
