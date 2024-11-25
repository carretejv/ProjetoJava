package model;

public class GerenteDesenvolvedor extends Funcionario implements Gerencia, Desenvolve {
	private static final long serialVersionUID = 1L;
	
    public GerenteDesenvolvedor(int id, String nome, double salario) {
        super(id, nome, salario);
    }

    @Override
    public void codar() {
        System.out.println(getNome() + " está codando e gerenciando.");
    }

    @Override
    public void resolverProblemas() {
        System.out.println(getNome() + " está resolvendo problemas técnicos e organizando a equipe.");
    }

    @Override
    public void organizarEquipe() {
        System.out.println(getNome() + " está organizando a equipe como Gerente Desenvolvedor.");
    }

    @Override
    public void conduzirReunioes() {
        System.out.println(getNome() + " está conduzindo reuniões.");
    }

    @Override
    public String mostrarDetalhes() {
        return "Gerente Desenvolvedor: " + getNome() + ", Salário: " + getSalario();
    }
}
