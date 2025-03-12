package com.nika.screenmatch.modelos;

import com.nika.screenmatch.calculos.Classificavel;

public class Episodio  implements Classificavel {

    private int totalVisualizacoes;
    private int numero;
    private String nome;
    private Serie serie;

    public int getTotalVisualizacoes() {
        return totalVisualizacoes;
    }

    public void setTotalVisualizacoes(int totalVisualizacoes) {
        this.totalVisualizacoes = totalVisualizacoes;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public int getClassificacao(){
        if(totalVisualizacoes > 100){
            return 4;
        } else {
            return 2;
        }
    }
}
