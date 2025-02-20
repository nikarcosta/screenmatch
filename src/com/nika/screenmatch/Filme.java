public class Filme {
    private String nome;
    private int anoDeLancamento;
    private double duracaoEmMinutos;
    private boolean incluidoNoPlano;
    private int somaDasAvaliacoes;
    private int totalDeAvaliacoes;

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public double getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public boolean getIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setDuracaoEmMinutos(double duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    private void exibeFichaTecnica() {
        System.out.println("Nome do filme: " +nome);
        System.out.println("Ano de lançamento: "  + anoDeLancamento);
        System.out.println("Duração em minutos: " + duracaoEmMinutos);
        System.out.println("Incluído no plano: " + incluidoNoPlano);
    }

    private void avalia(int nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    private double pegaMedia(){
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }
}
