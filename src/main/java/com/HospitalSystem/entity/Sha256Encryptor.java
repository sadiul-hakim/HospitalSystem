package com.HospitalSystem.entity;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hakim
 */
public class Sha256Encryptor implements PasswordEncryption{

    @Override
    public String encrypt(String password) {
        String encryption=null;
        try {
            MessageDigest digest=MessageDigest.getInstance("sha-256");
            var bytes=digest.digest(password.getBytes(StandardCharsets.UTF_8));
            
            encryption= convertToHex(bytes);
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Sha256Encryptor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return encryption;
    }
    
    private String convertToHex(byte[] hash){
        StringBuilder builder=new StringBuilder();
        
        for(byte b:hash){
            String hex=Integer.toHexString(0xff & b);
            if(hex.length()==1){
                builder.append('0');
            }
            builder.append(hex);
        }
        
        return builder.toString();
    }
}
