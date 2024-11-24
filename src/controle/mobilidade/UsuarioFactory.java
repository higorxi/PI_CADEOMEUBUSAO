package controle.mobilidade;

public class UsuarioFactory {
    public static Usuario criarUsuario(String tipo, String nome, String email, String senha, String telefone, String bairro) {
        if ("passageiro".equalsIgnoreCase(tipo)) {
            return new UsuarioPassageiro(nome, email, senha, telefone, bairro);
        }
        throw new IllegalArgumentException("Tipo de usuário desconhecido: " + tipo);
    }
}
