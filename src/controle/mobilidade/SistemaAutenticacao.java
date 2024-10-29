package controle.mobilidade;

public class SistemaAutenticacao {
    private static SistemaAutenticacao instance;

    private SistemaAutenticacao() { }

    public static SistemaAutenticacao getInstance() {
        if (instance == null) {
            instance = new SistemaAutenticacao();
        }
        return instance;
    }

    public boolean login(Usuario usuario, String email, String senha) {
        if (usuario.autenticar(email, senha)) {
            System.out.println("Login bem-sucedido!");
            return true;
        } else {
            System.out.println("Falha no login. Verifique o email e senha.");
            return false;
        }
    }
}
