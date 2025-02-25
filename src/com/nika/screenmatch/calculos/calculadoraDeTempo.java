package com.nika.screenmatch.calculos;

import com.nika.screenmatch.modelos.Filme;
import com.nika.screenmatch.modelos.Serie;
import com.nika.screenmatch.modelos.Titulo;

public class calculadoraDeTempo {
    private int tempoTotal;

    public int getTempoTotal(){
        return tempoTotal;
    }

//    public void inclui(Filme f){
//        this.tempoTotal += f.getDuracaoEmMinutos();
//    }
//
//    public void inclui(Serie s){
//        this.tempoTotal += s.getDuracaoEmMinutos();
//    }

    public void inclui(Titulo titulo){
        this.tempoTotal += titulo.getDuracaoEmMinutos();
    }
}
