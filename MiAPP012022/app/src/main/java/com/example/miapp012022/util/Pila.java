package com.example.miapp012022.util;

import java.util.ArrayList;
import java.util.List;

public class Pila<W> {

    private W obj;
    private List<W> lista=new ArrayList<W>();

    public  W getObj(){
        return obj;
    }

    public void guardar(W dato) {
        lista.add(dato);
    }
}
