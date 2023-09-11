/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.util.Date;

/**
 *
 * @author miguelarcadioarangoluna
 */
public class eventothread1 extends Thread {

    @Override
    public void run() {
        while (true) {
            String consulta = "!!! hola este es un mensaje cada minuto...!!!!!";
            System.out.println(consulta);
            Date fecha = new Date();
            System.out.println(consulta+" - "+fecha);
            try {
//                Thread.sleep(86400000);//representacion de un día
                Thread.sleep(1000);//representacion de un día
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ha terminado");
        }
    }
}
