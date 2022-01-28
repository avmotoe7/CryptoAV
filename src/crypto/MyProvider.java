package crypto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.security.Provider;

/**
 *
 * @author vidak
 */
public class MyProvider extends Provider {

    public MyProvider() {
        super("JDP", 1.0, "Caesar cipher");

        put("Cipher.CAESAR/ECB/NoPadding", "crypto.CaesarCipherSpi");
        put("KeyGenerator.CAESAR", "crypto.CaesarKeyGeneratorSpi");
        put("SecureRandom.CAESAR", "crypto.CaesarSecureRandomSpi");
    }
}
