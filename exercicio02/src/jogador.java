public class jogador {
    private String nome;
    private String sobrenome;
    private String posicao;
    private int idade;
    private String clube;

    public jogador(String nome, String sobrenome, String posicao, int idade, String clube){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.posicao = posicao;
        this.idade = idade;
        this.clube = clube;
    }
    public String getNome() {
        return nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public String getPosicao() {
        return posicao;
    }
    public int getIdade() {
        return idade;
    }
    public String getClube() {
        return clube;
    }
    public String getDescricao() {
        return (nome +' ' + sobrenome +" é um futebolista brasileiro de " + idade + " anos que atua como " + posicao + ". Atualmente defende o " + clube + '.');
    }
}
