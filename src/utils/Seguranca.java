package utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Seguranca {
    public static String gerarHashSHA256(String texto) {
        if (texto == null) {
            return null;
        }
        try {
            MessageDigest disgest = MessageDigest.getInstance("SHA-256");
            byte[] hash = disgest.digest(texto.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao criptografar", e);
        }
    }

}


