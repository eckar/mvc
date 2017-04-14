/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans.sessions;

import entidades.PrestamoLibro;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Gangster
 */
@Stateless
public class PrestamoLibroFacade extends AbstractFacade<PrestamoLibro> {
    @PersistenceContext(unitName = "BibliotecaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrestamoLibroFacade() {
        super(PrestamoLibro.class);
    }
    
}
