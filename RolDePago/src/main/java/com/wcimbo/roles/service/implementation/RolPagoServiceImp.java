
package com.wcimbo.roles.service.implementation;

import com.wcimbo.roles.entity.RolPago;
import com.wcimbo.roles.repository.RolPagoRepository;
import com.wcimbo.roles.service.RolPagoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolPagoServiceImp implements RolPagoService {
    @Autowired
    RolPagoRepository rolPago;
    
    /** Funcion que lista la informacion de rol de pagos
     * @return RolPago[]
     * @version 1.0
     * @author Javier<javierchimbo95@gmail.com>
    */
    @Override
    public List<RolPago> GetAll() {
        return rolPago.findAll();
    }

    /** Funcion que muestra informacion de rol de pagos de acuerdo al id
     * @param id
     * @return rolPago
     * @version 1.0
     * @author Javier<javierchimbo95@gmail.com>
    */
    @Override
    public RolPago GetById(long id) {
        return rolPago.findById(id).get();
    }

    /** Metodo que guarda la informacion de un rol de pago
     * @param  request
     * @version 1.0
     * @author Javier<javierchimbo95@gmail.com>
    */
    @Override
    public void Post(RolPago request) {
        rolPago.saveAndFlush(request);
    }

    /** Metodo que actualiza la informacion del rol de pagos de acuerdo al id
     * @param requests 
     * @param id
     * @version 1.0
     * @author Javier<javierchimbo95@gmail.com>
    */
    @Override
    public void Put(RolPago requests, long id) {
        requests.setId(id);
        rolPago.saveAndFlush(requests);
    }

    /** Metodo que elimina la informacion del rol de pagos de acuerdo al id
     * @param id
     * @version 1.0
     * @author Javier<javierchimbo95@gmail.com>
    */
    @Override
    public void Delete(long id) {
        rolPago.deleteById(id);
    }
    
    
    
}
