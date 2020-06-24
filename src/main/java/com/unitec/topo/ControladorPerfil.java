
package com.unitec.topo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Representational State Transfer Controller
//Los estados mas comunes son: guardar, buscar, actualizar y borrar
@RestController 
//api son las siglas de Application Programming Interface
@RequestMapping("/api")
public class ControladorPerfil {
   
    
//En los servicios REST se tiene una urlBase  que consiste
//de la ip o host, seguida del puerto, despues /api/hola
//ES decir, para este caso mi api REST es:
//http://localhost:8080/api/hola    
  @GetMapping("/hola")
public Saludo saludar(){
    Saludo s=new Saludo();
    s.setNombre("Juan Carlos");
    s.setMensaje("MI primer mensaje en spring rest");
    return s;
}

//El siguiente metodo va a servir para guardar en un back-end nuestros datos
//del perfil
//Para guardar SIEMPRE debes usar el metodo POST
@PostMapping("/perfil")
public Estatus guardar(@RequestBody String json)throws Exception{
    //Paso 1 para recibir ese objeto json es leerlo y convertirlo
    //en objeto JAVA a esto se le llama des-serializacion
       ObjectMapper maper =new ObjectMapper();
       Perfil perfil= maper.readValue(json, Perfil.class);
       //Por experiencia  antes de guardar tenemos que checar que llego bien
       //todo e objeto y se leyo bien
       System.out.println("Pefil leido "+perfil);
               
       //Aqui este objeto perfil despues se guarda con una sola linea en mongodb
       //Aqui va ir la linea para guardar
       //Despues enviamos un mensaje de estatus al cliente para que se informe
       //si se guardo o no su perfil
       Estatus e=new Estatus();
       e.setSuccess(true);
       e.setMensaje("Perfil guardado con exito!!!"); 
       return e;
       
    
}



 
    
}
