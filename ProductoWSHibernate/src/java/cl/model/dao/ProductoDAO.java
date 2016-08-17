/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.model.dao;
import cl.model.pojos.Producto;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import java.util.List;
/**
 *
 * @author Edgar Rodriguez Arias
 */
public class ProductoDAO {
    public void ingresarProducto(Producto p){
        SessionFactory sf = null;
        Session sesion = null;
        Transaction tx = null;
        
        try{
            sf = HibernateUtil.getSessionFactory();
            sesion = sf.openSession();
            tx = sesion.beginTransaction();
            sesion.save(p);
            tx.commit();
            sesion.close();
        }
        catch(Exception r){
            tx.rollback();
            throw new RuntimeException("No se pudo guardar el producto");
        }
            
    }
    
    public String consultarProducto(int codigo){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion  = sf.openSession();
        Producto p = (Producto) sesion.get(Producto.class, codigo);
        sesion.close();
        if(p!=null){
            return   "El producto es: "+p.getCodigo()+" con nombre:"+p.getNombre()+" y tiene un costo de"
                    +p.getPrecio()+", tiene un stock de:"+p.getStock()+". Teniendo una descripcion de:"+p.getDescripcion();
        }               
        else{
            return "El producto con codigo "+ codigo +" no existe";
        }
    }
}
