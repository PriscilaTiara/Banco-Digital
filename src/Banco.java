import java.util.ArrayList;
import java.util.List;

public class Banco {

	private String nome;
	private List<Conta> contas;

	public Banco(String nome) {
		this.nome = nome;
		this.contas = new ArrayList<>();
	}

	public void adicionarConta(Conta conta) {
		this.contas.add(conta);
	}

	public List<Conta> getContas() {
		return contas;
	}
}