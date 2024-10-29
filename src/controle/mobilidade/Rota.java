package controle.mobilidade;

import java.time.LocalTime;

public class Rota {
    private String nome;
    private String bairro;
    private LocalTime horario;

    public Rota(String nome, String bairro, LocalTime horario) {
        this.nome = nome;
        this.bairro = bairro;
        this.horario = horario;
    }

    public String getNome() {
        return nome;
    }

    public String getBairro() {
        return bairro;
    }

    public LocalTime getHorario() {
        return horario;
    }
}
