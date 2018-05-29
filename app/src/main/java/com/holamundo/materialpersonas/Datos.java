package com.holamundo.materialpersonas;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by android on 30/04/2018.
 */

public class Datos {

    private static String db = "Computadores";
    private static DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private static ArrayList<Computador> computadores  = new ArrayList();

    //public static void guardar(Persona p){
    //    personas.add(p);
    //}


    public static void guardar(Computador c){
    databaseReference.child(db).child(c.getId()).setValue(c);
    }

    public static ArrayList<Computador> obtener(){
        return computadores;
    }

    public static int fotoAleatoria(ArrayList<Integer> fotos){
        int fotoSeleccionada;
        Random r = new Random();
        fotoSeleccionada = r.nextInt(fotos.size());
        return  fotos.get(fotoSeleccionada);
    }


    public static String getId (){
        return databaseReference.push().getKey();
    }


    public static void setComputadores(ArrayList<Computador> computadores){
        Datos.computadores = computadores;
    }

    public static void eliminarComputador(Computador c){
        databaseReference.child(db).child(c.getId()).removeValue();
    }
    public static void modificarComputador(Computador c){
        databaseReference.child(db).child(c.getId()).setValue(c);
    }
}
