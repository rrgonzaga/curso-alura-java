package java8;

public class Curso {
    private String nome;
    private int alunos;

    public Curso(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public int getAlunos() {
        return alunos;
    }
    
    @Override
    public String toString() {
    	return String.format("[Curso: %s, qtde alunos: %d]", nome, alunos);
    }
}
