/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.uc10_atividade3.persistence;

import jakarta.persistence.Column;
  import jakarta.persistence.Entity;
  import jakarta.persistence.GeneratedValue;
  import jakarta.persistence.GenerationType;
  import jakarta.persistence.Id;

  
@Entity
public class Podcast {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String produtor;
    
    @Column(name = "nome_episodio")
    private String nomePod;
    
    @Column(name = "num_episodio")
    private int numPod;
    
    private String duracao;
    
    private String url;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProdutor() {
        return produtor;
    }

    public void setProdutor(String produtor) {
        this.produtor = produtor;
    }

    public String getNomePod() {
        return nomePod;
    }

    public void setNomePod(String nomePod) {
        this.nomePod = nomePod;
    }

    public int getNumPod() {
        return numPod;
    }

    public void setNumPod(int numPod) {
        this.numPod = numPod;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}

