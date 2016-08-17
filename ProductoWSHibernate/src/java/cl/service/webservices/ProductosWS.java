/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.service.webservices;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import cl.model.dao.ProductoDAO;
import cl.model.pojos.Producto;

/**
 *
 * @author Gangster
 */
@WebService(serviceName = "ProductosWS")
public class ProductosWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ingresarProducto")
    public String ingresarProducto(@WebParam(name = "codigo") int codigo, @WebParam(name = "nombre") String nombre, @WebParam(name = "precio") int precio, @WebParam(name = "stock") int stock, @WebParam(name = "descripcion") String descripcion) {
        //TODO write your implementation code here:
        Producto p = new Producto(nombre,precio,stock,descripcion);
        return null;
    }
}
