package com.lab.restaurant.app;

import com.lab.restaurant.model.Alimento;
import com.lab.restaurant.model.Cliente;
import com.lab.restaurant.model.Mesa;
import com.lab.restaurant.model.Mesero;
import com.lab.restaurant.transactional.AppRestauranteController;

import java.util.Random;

/**
 * Created by Kei on 09/05/2016.
 */
public class AppRestaurant {

    public static void main (String[] args){

        for(int auxiliar=1;auxiliar<=10;auxiliar++){
            Random random = new Random();
            AppRestauranteController.listaMesas.add(new Mesa(auxiliar,auxiliar,random.nextInt(5)+1));
        }

        Mesero mesero1 = new Mesero(1,"45465424","Mario","Bros","Luigi",1);
        Mesero mesero2 = new Mesero(2,"65756745","Kei","Bros","Luigi",1);
        Mesero mesero3 = new Mesero(3,"54534555","Chuks","Bros","Luigi",1);
        Mesero mesero4 = new Mesero(4,"62666868","Braulio","Bros","Luigi",1);
        Mesero mesero5 = new Mesero(5,"54534435","Kevin","Bros","Luigi",1);

        AppRestauranteController.asignarMeseroMesa(mesero1,0);
        AppRestauranteController.asignarMeseroMesa(mesero1,1);
        AppRestauranteController.asignarMeseroMesa(mesero2,2);
        AppRestauranteController.asignarMeseroMesa(mesero2,3);
        AppRestauranteController.asignarMeseroMesa(mesero3,4);
        AppRestauranteController.asignarMeseroMesa(mesero3,5);
        AppRestauranteController.asignarMeseroMesa(mesero4,6);
        AppRestauranteController.asignarMeseroMesa(mesero4,7);
        AppRestauranteController.asignarMeseroMesa(mesero5,8);
        AppRestauranteController.asignarMeseroMesa(mesero5,9);

        Cliente cliente = new Cliente(1,"67545456","Toad","Bros","Peach",1,4);

        AppRestauranteController.asignarMesa(cliente);

        //Mesero mesero = new Mesero(1,"45465424","Mario","Bros","Luigi",1,mesaAuxiliar);

        /*Alimento alimento1 = new Alimento(1,10.5,"Envasado");
        Alimento alimento2 = new Alimento(2,11.5,"Congelado");
        Alimento alimento3 = new Alimento(3,14.5,"Envasado");
        Alimento alimento4 = new Alimento(4,15.5,"Congelado");
        Alimento alimento5 = new Alimento(5,13.5,"Envasado");*/

        /*System.out.println("El cliente "+cliente.getNombre()+" "+cliente.getApellidoPaterno()+" entrará a la mesa "+mesaAuxiliar.getNumMesa());
        System.out.println("El mesero "+mesero.getNombre()+" lo atenderá");*/

    }
}
