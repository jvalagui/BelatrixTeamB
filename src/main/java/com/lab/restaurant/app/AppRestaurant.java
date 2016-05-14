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



        //Mesero mesero = new Mesero(1,"45465424","Mario","Bros","Luigi",1,mesaAuxiliar);

        Cliente cliente = new Cliente(1,"67545456","Toad","Bros","Peach",1);

        Alimento alimento1 = new Alimento(1,10.5,"Envasado");
        Alimento alimento2 = new Alimento(2,11.5,"Congelado");
        Alimento alimento3 = new Alimento(3,14.5,"Envasado");
        Alimento alimento4 = new Alimento(4,15.5,"Congelado");
        Alimento alimento5 = new Alimento(5,13.5,"Envasado");

        /*System.out.println("El cliente "+cliente.getNombre()+" "+cliente.getApellidoPaterno()+" entrará a la mesa "+mesaAuxiliar.getNumMesa());
        System.out.println("El mesero "+mesero.getNombre()+" lo atenderá");*/

        for(int auxiliar=1;auxiliar<=10;auxiliar++){
            Mesa mesaAuxiliar = AppRestauranteController.listaMesas.get(auxiliar-1);
            System.out.println(""+mesaAuxiliar.getNumMesa()+" "+mesaAuxiliar.getCapacidad());
        }

    }
}
