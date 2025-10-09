package br.com.fiap.security;

import org.springframework.security.crypto.bcrypt.BCrypt;

//Aplicar o algoritmo hash bcrypt
public class PasswordHash {
    public static String hashPassword(String senha){
        String salt = BCrypt.gensalt(10);
      //  System.out.println(salt);
        String senhaCriptografada = BCrypt.hashpw(senha, salt);
        return senhaCriptografada;
    }

    public static boolean verificarSenha(String senha, String hashPassword){
        return BCrypt.checkpw(senha, hashPassword);
    }

}
