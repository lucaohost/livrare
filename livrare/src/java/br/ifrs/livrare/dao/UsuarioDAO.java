package br.ifrs.livrare.dao;

import br.ifrs.livrare.model.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class UsuarioDAO {
    
    private EntityManager em;
    
     public void salvar(Usuario aluno) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        this.em.getTransaction().begin();
        this.em.persist(aluno);
        this.em.getTransaction().commit();
        this.em.close();
    }
 
    public void atualizar(Usuario aluno) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        this.em.getTransaction().begin();
        this.em.merge(aluno);
        this.em.getTransaction().commit();
        this.em.close();
    }

    public void excluir(int id) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        this.em.getTransaction().begin();
        Usuario entity = this.em.find(Usuario.class, id);
        if (entity != null) {
            this.em.remove(entity);
        } 
        this.em.getTransaction().commit();
        this.em.close();
    }

    public Usuario obter(int id) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        Usuario aluno = this.em.find(Usuario.class, id);
        this.em.close();
        return aluno;
    }
    
    public List<Usuario> pesquisar() throws Exception {
        this.em = EntityManagerProvider.getInstance();
        TypedQuery<Usuario> query = this.em.createQuery("Select c from Usuario c order by c.nome", Usuario.class);
        List<Usuario> alunos = query.getResultList();
        this.em.close();
        return alunos;
    }
    
    public List<Usuario> pesquisar(String nome) throws Exception {
        this.em = EntityManagerProvider.getInstance();
        TypedQuery<Usuario> query = this.em.createQuery(" Select c from Usuario c where lower(c.nome) like :nome order by c.nome",Usuario.class);
        query.setParameter("nome", "%"+nome.toLowerCase()+"%");        
        List<Usuario> alunos = query.getResultList();
        this.em.close();
        return alunos;
    }
    
        public Usuario logar(String email, String senha) throws Exception {
        
        this.em = EntityManagerProvider.getInstance();

        
        TypedQuery<Usuario> query = em.createQuery("select u from Usuario u where lower(u.email) = :email and u.senha = :senha", Usuario.class);
        query.setParameter("email", email);
        query.setParameter("senha", senha);
        List<Usuario> usuarios = query.getResultList();
        this.em.close();
        if (usuarios.size() > 0) {
            return usuarios.get(0);
        } else {
            return null;
        }

    }
    
}
