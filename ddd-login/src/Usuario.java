import java.time.LocalDateTime;

public class Usuario {
    public String nome;
    public String senha;
    public int tentativasAcesso;
    public boolean primeiroAcesso;
    public StatusUsuarioEnum status;
    private LocalDateTime dataInativacao;

    /*1.6.	Criar um método com a seguinte assinatura: alterarSenha(senha: String): void,
    que ao alterar a senha verifica se o usuário está ATIVO e, caso verdadeiro,
    trocar a senha conforme parâmetro passado,
    além de alterar o primeiro acesso para false e zerar as tentativas de acesso.*/
    public void alterarSenha(String senha){
        if(status.equals(StatusUsuarioEnum.ATIVO)) {
            this.senha = senha;
            primeiroAcesso = false;
            tentativasAcesso = 0;
        }
    }
}
