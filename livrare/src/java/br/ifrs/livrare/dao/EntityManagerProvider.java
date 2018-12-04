package br.ifrs.livrare.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProvider {
    
    private static EntityManagerFactory emf;
    
    public static EntityManager getInstance() {
        if(emf==null){
            emf =Persistence.createEntityManagerFactory("livrarePU");
        }
        return emf.createEntityManager();
    }
    
    public static void closeInstance() {
        emf.close();
    } 
}
