package controle.mobilidade;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
    protected String nome;
    protected String email;
    protected String senha;
    protected String telefone;
    protected String bairro;
    protected double saldoCarteira;

    public Usuario(String nome, String email, String senha, String telefone, String bairro) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.bairro = bairro;
        this.saldoCarteira = 0.0;
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Telefone: " + telefone);
        System.out.println("Bairro: " + bairro);
        System.out.println("Saldo da Carteira: R$ " + saldoCarteira);
    }

    public boolean autenticar(String email, String senha) {
        return this.email.equals(email) && this.senha.equals(senha);
    }

    public void adicionarSaldo(double valor) {
        if (valor > 0) {
            saldoCarteira += valor;
            System.out.println("R$ " + valor + " adicionados à carteira.");
        } else {
            System.out.println("Valor inválido para adicionar saldo.");
        }
    }

    public void removerSaldo(double valor) {
        if (valor > 0 && valor <= saldoCarteira) {
            saldoCarteira -= valor;
            System.out.println("R$ " + valor + " removidos da carteira.");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }

    public void atualizarDados(String novoNome, String novoEmail, String novoTelefone, String novoBairro) {
        this.nome = novoNome;
        this.email = novoEmail;
        this.telefone = novoTelefone;
        this.bairro = novoBairro;
        System.out.println("Dados atualizados com sucesso.");
    }

    public void listarRotasDisponiveis(String bairro, LocalTime horario) {
        List<Rota> rotasDisponiveis = new ArrayList<>();
        
        rotasDisponiveis.add(new Rota("Rota 1", "Centro", LocalTime.of(10, 0)));
        rotasDisponiveis.add(new Rota("Rota 2", "Jundiaí", LocalTime.of(10, 30)));
        rotasDisponiveis.add(new Rota("Rota 3", "Centro", LocalTime.of(11, 0)));
        rotasDisponiveis.add(new Rota("Rota 4", "Jundiaí", LocalTime.of(11, 30)));

        Rota rotaProxima = null;

        for (Rota rota : rotasDisponiveis) {
            if (rota.getBairro().equalsIgnoreCase(bairro)) {
                if (rotaProxima == null || Math.abs(rota.getHorario().toSecondOfDay() - horario.toSecondOfDay()) <
                        Math.abs(rotaProxima.getHorario().toSecondOfDay() - horario.toSecondOfDay())) {
                    rotaProxima = rota;
                }
            }
        }

        if (rotaProxima != null) {
            System.out.println("Rota mais próxima para o bairro " + bairro + ": " + rotaProxima.getNome() +
                               " às " + rotaProxima.getHorario());
        } else {
            System.out.println("Nenhuma rota disponível para o bairro " + bairro + " no horário especificado.");
        }
    }
}
