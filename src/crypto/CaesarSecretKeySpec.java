/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;

import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author vidak
 */
public class CaesarSecretKeySpec extends SecretKeySpec{

    public CaesarSecretKeySpec(byte[] key, String algorithm){
        super(key, algorithm);
    }
    public CaesarSecretKeySpec(byte[] key){
        super(key, "CAESAR");
    }
    
    public String getFormat(){
        return "RAW";
    }  
}
