package controle.mobilidade;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        // Criação de um usuário passageiro
        UsuarioPassageiro usuario1 = new UsuarioPassageiro("Fábio", "fabio@email.com", "1234", "11987654321", "Centro");
        
        // Exibir informações do usuário
        System.out.println("\nInformações do Usuário:");
        usuario1.exibirInformacoes();

        // Autenticação
        SistemaAutenticacao sistemaAuth = SistemaAutenticacao.getInstance();
        System.out.println("\nTentando Login...");
        boolean loginSucesso = sistemaAuth.login(usuario1, "fabio@email.com", "1234");

        // Adicionar saldo
        if (loginSucesso) {
            usuario1.adicionarSaldo(50.0);
            usuario1.exibirInformacoes();
        }

        // Atualizar dados do usuário
        usuario1.atualizarDados("Fábio Santos", "fabio.santos@email.com", "11987654321", "Jundiaí");
        usuario1.exibirInformacoes();

        // Listar rotas disponíveis no bairro "Centro" no horário atual
        System.out.println("\nListando rotas disponíveis:");
        usuario1.listarRotasDisponiveis("Centro", LocalTime.now());
    }
}
