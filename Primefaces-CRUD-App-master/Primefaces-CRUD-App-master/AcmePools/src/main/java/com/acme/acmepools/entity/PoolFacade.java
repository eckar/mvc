/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.acmepools.entity;

import com.acme.acmepools.session.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pp
 */
@Stateless
public class PoolFacade extends AbstractFacade<Pool> {
    @PersistenceContext(unitName = "com.acme_AcmePools_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PoolFacade() {
        super(Pool.class);
    }
    
}
