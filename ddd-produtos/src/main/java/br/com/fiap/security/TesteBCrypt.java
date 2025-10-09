package br.com.fiap.security;

public class TesteBCrypt {
    public static void main(String[] args) {
        String senha = "minhaSenha123";
        String senhaHash = PasswordHash.hashPassword(senha);
        System.out.println(senhaHash);
    }
}
