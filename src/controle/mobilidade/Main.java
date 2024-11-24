package controle.mobilidade;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Usuario usuario1 = UsuarioFactory.criarUsuario("passageiro",
                "Fábio",
                "fabio@email.com",
                "1234",
                "11987654321",
                "Centro");

        usuario1.exibirInformacoes();

        SistemaAutenticacao sistemaAuth = SistemaAutenticacao.getInstance();
        System.out.println("\nTentando Login...");
        boolean loginSucesso = sistemaAuth.login(usuario1, "fabio@email.com", "1234");

        if (loginSucesso) {
            usuario1.adicionarSaldo(50.0);
            usuario1.exibirSaldo();
        }

        System.out.println("\nAtualizando as informações do usuário");
        usuario1.atualizarDados("Fábio Santos", "fabio.santos@email.com", "11987654321", "Jundiaí");
        usuario1.exibirInformacoes();

        System.out.println("\nListando rotas disponíveis:");
        usuario1.listarRotasDisponiveis("Centro", LocalTime.now());
    }
}
