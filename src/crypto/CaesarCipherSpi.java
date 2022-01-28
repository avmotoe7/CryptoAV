package crypto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;

/**
 *
 * @author vidak
 */
public class CaesarCipherSpi extends CipherSpi {

    private final int BLOCK_SIZE = 128;
    private byte shiftChar;

    @Override
    protected void engineSetMode(String string) throws NoSuchAlgorithmException {
        throw new UnsupportedOperationException("Not supported yet.");
        //
    }

    @Override
    protected void engineSetPadding(String string) throws NoSuchPaddingException {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected int engineGetBlockSize() {
        return BLOCK_SIZE;
    }

    @Override
    protected int engineGetOutputSize(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected byte[] engineGetIV() {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected AlgorithmParameters engineGetParameters() {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void engineInit(int i, Key key, SecureRandom sr) throws InvalidKeyException {
        //throw new UnsupportedOperationException("Not supported yet."); 

        shiftChar = key.getEncoded()[0];
        if (Cipher.DECRYPT_MODE == i ) shiftChar = (byte) -shiftChar;
    }

    @Override
    protected void engineInit(int i, Key key, AlgorithmParameterSpec aps, SecureRandom sr)
            throws InvalidKeyException, InvalidAlgorithmParameterException {
        //throw new UnsupportedOperationException("Not supported yet."); 
        //> 
    }

    @Override
    protected void engineInit(int i, Key key, AlgorithmParameters ap, SecureRandom sr)
            throws InvalidKeyException, InvalidAlgorithmParameterException {
        //throw new UnsupportedOperationException("Not supported yet."); 
        //>
    }

    @Override
    protected byte[] engineUpdate(byte[] bytes, int i, int i1) {
        //throw new UnsupportedOperationException("Not supported yet."); 

        byte[] text = new byte[i1];
        System.arraycopy(bytes, i, text, 0, i1);

        for (int j = 0; j < text.length; j++) {
            text[j] += shiftChar;
        }

        return text;
    }

    @Override
    protected int engineUpdate(byte[] bytes, int i, int i1, byte[] bytes1, int i2)
            throws ShortBufferException {
        //throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.

        //arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
        System.arraycopy(bytes, i, bytes1, i2, i1);
        return i1;
    }

    @Override
    protected byte[] engineDoFinal(byte[] bytes, int i, int i1) throws IllegalBlockSizeException, BadPaddingException {
        //throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.

        byte[] text = new byte[i1];
        System.arraycopy(bytes, i, text, 0, i1);

        for (int j = 0; j < text.length; j++) {
            text[j] += shiftChar;
        }

        return text;

    }

    @Override
    protected int engineDoFinal(byte[] bytes, int i, int i1, byte[] bytes1, int i2) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        //throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
        System.arraycopy(bytes, i, bytes1, i2, i1);
        return i1;
    }

}
