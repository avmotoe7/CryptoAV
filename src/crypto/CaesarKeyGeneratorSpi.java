/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;

import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.KeyGeneratorSpi;
import javax.crypto.SecretKey;

/**
 *
 * @author vidak
 */
public class CaesarKeyGeneratorSpi extends KeyGeneratorSpi {
    
    private SecureRandom random;
    
    @Override
    protected void engineInit(SecureRandom random) {
        // throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
        this.random = random;
    }

    @Override
    protected void engineInit(AlgorithmParameterSpec params, SecureRandom random)
            throws InvalidAlgorithmParameterException {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void engineInit(int keysize, SecureRandom random) {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected SecretKey engineGenerateKey() {
        //throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
        byte[] bytes = new byte[1];
        random.nextBytes(bytes);
        return new CaesarSecretKeySpec(bytes);
    }

}
