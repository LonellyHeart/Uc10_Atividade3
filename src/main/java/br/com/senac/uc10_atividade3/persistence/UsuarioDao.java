/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.uc10_atividade3.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author MATRIZ
 */
public class UsuarioDao {
    
    public static Usuario ValidarLogin(Usuario usuario){
    
      EntityManager em = JPAUtil.getEntityManager();
      Usuario usuarioEncontrado= null;
      try{
          String textoQuery = "SELECT u FROM Usuario u "+
                  " WHERE (u.login = :login ) "+
                  " AND (u.senha = :senha ) ";
          
          Query consulta = em.createQuery(textoQuery);
          
          consulta.setParameter("login", usuario.getLogin());
          consulta.setParameter("senha", usuario.getSenha() );
          
          usuarioEncontrado = (Usuario) consulta.getSingleResult();
          
      }catch (NoResultException e) {
           usuarioEncontrado = null;
      }finally {
           JPAUtil.closeEntityManager();
      }
      return usuarioEncontrado;
    }
         
     public static String getMD5(String texto) {
         try {
       
                 MessageDigest md = MessageDigest.getInstance("MD5");
                             
                 byte[] messageDigest = md.digest(texto.getBytes());
                             
                 BigInteger no = new BigInteger(1, messageDigest);
                             
                 String hashtext = no.toString(16);
                 while (hashtext.length() < 32) {
                       hashtext = "0" + hashtext;
                 }
                return hashtext;
         }
                 catch (NoSuchAlgorithmException e) {
                         throw new RuntimeException(e);
                 }
     }
}
