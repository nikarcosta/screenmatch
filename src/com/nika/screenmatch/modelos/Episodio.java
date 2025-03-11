package com.nika.screenmatch.modelos;

import com.nika.screenmatch.calculos.Classificavel;

public class Episodio  implements Classificavel {

    private int totalVisualizacoes;

    public int getClassificacao(){
        if(totalVisualizacoes > 100){
            return 4;
        } else {
            return 2;
        }
    }
}
