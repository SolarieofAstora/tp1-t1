/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhow;

import java.util.ArrayList;

/**
 *
 * @author root
 */
public class Modelo {
    static int countId = 1;
    private int id;
    private ArrayList<Carro> carros;
    
    private Marca marca;
    private String nome;
    private String combustivel;
    private int n_portas;
    
    Modelo(Marca marca, String nome, String combustivel, int n_portas) {
        this.id = Modelo.countId;
        Modelo.countId++;
        this.carros = new ArrayList<>();
        
        this.nome = nome.toLowerCase();
        this.combustivel = combustivel.toLowerCase();
        this.n_portas = n_portas;        
        
        this.marca = marca;
        marca.adicionarModelo((this));
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public int getId() {
        return this.id;
    }
    
    public Marca getMarca() {
       return this.marca; 
    }

    public void modificarMarca(Marca marca) {
        this.marca = marca;
    }
    
    public void adicionarCarro(Carro carro) {
        for (Carro i : this.carros) {
            if(carro.getId() == i.getId()) {
                System.out.println("Carro ja esta no modelo!");
                return;
            }
        }
        this.carros.add(carro);
        carro.modificarModelo(this);
    }
    
    public void removerCarro(Carro carro) {
        boolean s;
        s = this.carros.remove(carro);
        if(s) {
            System.out.println("Modelo removido com sucesso");
        }
        else {
            System.out.println("Modelo nao encontrado");
        }
    }
}
