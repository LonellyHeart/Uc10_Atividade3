/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.uc10_atividade3.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

/**
 *
 * @author MATRIZ
 */
public class PodcastDao {
     public void cadastrar(Podcast p){
          EntityManager em = JPAUtil.getEntityManager();
          try {
              em.getTransaction().begin();
              em.persist(p);
              em.getTransaction().commit();
          }catch(Exception e){
              em.getTransaction().rollback();
              throw e;
          }
          finally{
              JPAUtil.closeEntityManager();
          }
    }
     
    public List<Podcast> listar(String idPodcast, String produtorPodcast, String nomePodcast, String numPodcast, String duracaoPodcast, String urlPodcast) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Podcast> podcast = null;

        try {
            String textoQuery = "SELECT p FROM Podcast p WHERE "
                    + "(:id IS NULL OR p.id = :id) "
                    + "AND (:produtor IS NULL OR p.produtor LIKE :produtor) "
                    + "AND (:nomePod IS NULL OR p.nomePod LIKE :nomePod) "
                    + "AND (:numPod IS NULL OR p.numPod = :numPod) "
                    + "AND (:duracao IS NULL OR p.duracao LIKE :duracao) "
                    + "AND (:url IS NULL OR p.url LIKE :url)";

            Query consulta = em.createQuery(textoQuery);

            consulta.setParameter("id", idPodcast.isEmpty() ? null : Integer.parseInt(idPodcast));
            consulta.setParameter("produtor", produtorPodcast.isEmpty() ? null : "%" + produtorPodcast + "%");
            consulta.setParameter("nomePod", nomePodcast.isEmpty() ? null : "%" + nomePodcast + "%");
            consulta.setParameter("numPod", numPodcast.isEmpty() ? null : Integer.parseInt(numPodcast));
            consulta.setParameter("duracao", duracaoPodcast.isEmpty() ? null : "%" + duracaoPodcast + "%");
            consulta.setParameter("url", urlPodcast.isEmpty() ? null : "%" + urlPodcast + "%");

            podcast = consulta.getResultList();
        } finally {
            JPAUtil.closeEntityManager();
        }

        return podcast;
}
     
  }

