package ab_no_informada;

import java.util.ArrayList;
import java.util.Arrays;

public class BusquedaAmplitud {
    //public int[] mejor_solucion = {};
    ArrayList<Nodo> mejor_solucion = new ArrayList<Nodo>();
    public Nodo AlIterativo(int[] estado_inicial, int[] solucion) {
        boolean solucionado=false;
        ArrayList<Nodo> nodos_no_expandidos = new ArrayList<Nodo>();
        Nodo nodoInicial=new Nodo(); //creamos el objeto nodo inicial
        nodoInicial.setDatos(estado_inicial); //Ponemos el array al nodo inicial
        nodos_no_expandidos.add(nodoInicial); //POner el nodo inicial a la PILA

        while(!solucionado){
            Nodo nodo=nodos_no_expandidos.get(0);
            nodos_no_expandidos.remove(0);

            if(Arrays.equals(nodo.getDatos(), solucion)){
                solucionado=true;
                return nodo;
            }else{
                int data[]=nodo.getDatos(); //Sacando el contenido del nodo
                int datoi[]={data[1],data[0],data[2],data[3]}; //Intermcabio Izquierda
                int datoc[]={data[0],data[2],data[1],data[3]}; //Intercambio al centro
                int datod[]={data[0],data[1],data[3],data[2]}; //Intercambio a la derecha

                Nodo hijoIzquierdo=new Nodo(); //Creando los objetos nodos
                Nodo hijoCentral=new Nodo();
                Nodo hijoDerecho=new Nodo();

                hijoIzquierdo.setDatos(datoi); //ponemos los arrays a los nodos
                hijoCentral.setDatos(datoc);
                hijoDerecho.setDatos(datod);

                nodos_no_expandidos.add(hijoIzquierdo); //ponemos los nodos a la pila
                nodos_no_expandidos.add(hijoCentral);
                nodos_no_expandidos.add(hijoDerecho);

                ArrayList<Nodo> nhijos = new ArrayList<Nodo>();

                nhijos.add(hijoIzquierdo);
                nhijos.add(hijoCentral);
                nhijos.add(hijoDerecho);
                nodo.setHijos(nhijos);

            }
        }
        return null;
    }

    public Nodo AlRecursivo(Nodo nodo_inicial, int[] solucion, ArrayList visitados) {

        visitados.add(nodo_inicial.getDatos());

        if(Arrays.equals(nodo_inicial.getDatos(), solucion)){
            return nodo_inicial;
        }else{
            int data[]=nodo_inicial.getDatos(); //Sacando el contenido del nodo
            int datoi[]={data[1],data[0],data[2],data[3]}; //Intermcabio Izquierda
            int datoc[]={data[0],data[2],data[1],data[3]}; //Intercambio al centro
            int datod[]={data[0],data[1],data[3],data[2]}; //Intercambio a la derecha

            Nodo hijoIzquierdo=new Nodo(); //Creando los objetos nodos
            Nodo hijoCentral=new Nodo();
            Nodo hijoDerecho=new Nodo();

            hijoIzquierdo.setDatos(datoi); //ponemos los arrays a los nodos
            hijoCentral.setDatos(datoc);
            hijoDerecho.setDatos(datod);

            ArrayList<Nodo> nhijos=new ArrayList<Nodo>();
            nhijos.add(hijoIzquierdo);
            nhijos.add(hijoCentral);
            nhijos.add(hijoDerecho);
            nodo_inicial.setHijos(nhijos);

            for(Nodo nodoHijo: nodo_inicial.getHijos()){
                if(!contiene(visitados,nodoHijo.getDatos())){
                    Nodo sol = AlRecursivo(nodoHijo,solucion,visitados);
                    if(sol!=null){
                        return sol;
                    }
                }
            }
            return null;
        }
    }
    public Nodo AlRecursivo_h(Nodo nodo_inicial, int[] solucion, ArrayList visitados) {

        visitados.add(nodo_inicial.getDatos());

        if(Arrays.equals(nodo_inicial.getDatos(), solucion)){
            return nodo_inicial;
        }else{
            int data[]=nodo_inicial.getDatos(); //Sacando el contenido del nodo
            int datoi[]={data[1],data[0],data[2],data[3]}; //Intermcabio Izquierda
            int datoc[]={data[0],data[2],data[1],data[3]}; //Intercambio al centro
            int datod[]={data[0],data[1],data[3],data[2]}; //Intercambio a la derecha

            Nodo hijoIzquierdo=new Nodo(); //Creando los objetos nodos
            Nodo hijoCentral=new Nodo();
            Nodo hijoDerecho=new Nodo();

            hijoIzquierdo.setDatos(datoi); //ponemos los arrays a los nodos
            hijoCentral.setDatos(datoc);
            hijoDerecho.setDatos(datod);

            ArrayList<Nodo> nhijos=new ArrayList<Nodo>();
            nhijos.add(hijoIzquierdo);
            nhijos.add(hijoCentral);
            nhijos.add(hijoDerecho);
            nodo_inicial.setHijos(nhijos);

            for(Nodo nodoHijo: nodo_inicial.getHijos()){
                if(!contiene(visitados,nodoHijo.getDatos()) && heuristica(nodo_inicial, nodoHijo)){
                    Nodo sol = AlRecursivo_h(nodoHijo,solucion,visitados);
                    if(sol!=null){
                        return sol;
                    }
                }
            }
            return null;
        }
    }
    public void AlRecursivo_h_m(Nodo nodo_inicial, int[] solucion, ArrayList visitados, int nivel) {

        visitados.add(nodo_inicial.getDatos());

        if(Arrays.equals(nodo_inicial.getDatos(), solucion)){
            //return nodo_inicial;
            if(!mejor_solucion.isEmpty()){
                mejor_solucion.add(nodo_inicial);
            }else{
                /*if(mejor_solucion.get(0)>nivel){
                    mejor_solucion.add(nivel);
                    mejor_solucion.add(nodo_inicial);
                }*/

            }
        }else{
            int data[]=nodo_inicial.getDatos(); //Sacando el contenido del nodo
            int datoi[]={data[1],data[0],data[2],data[3]}; //Intermcabio Izquierda
            int datoc[]={data[0],data[2],data[1],data[3]}; //Intercambio al centro
            int datod[]={data[0],data[1],data[3],data[2]}; //Intercambio a la derecha

            Nodo hijoIzquierdo=new Nodo(); //Creando los objetos nodos
            Nodo hijoCentral=new Nodo();
            Nodo hijoDerecho=new Nodo();

            hijoIzquierdo.setDatos(datoi); //ponemos los arrays a los nodos
            hijoCentral.setDatos(datoc);
            hijoDerecho.setDatos(datod);

            ArrayList<Nodo> nhijos=new ArrayList<Nodo>();
            nhijos.add(hijoIzquierdo);
            nhijos.add(hijoCentral);
            nhijos.add(hijoDerecho);
            nodo_inicial.setHijos(nhijos);

            for(Nodo nodoHijo: nodo_inicial.getHijos()){
                if(!contiene(visitados,nodoHijo.getDatos()) && heuristica(nodo_inicial, nodoHijo)){
                    AlRecursivo_h_m(nodoHijo,solucion,visitados, nivel+1);

                }
            }
        }
    }


    public boolean contiene(ArrayList<int []> lista, int[] buscado){
        for (int[] v: lista
             ) {
            if(Arrays.equals(v, buscado)){
                return true;
            }
        }
        return false;
    }

    public boolean heuristica(Nodo padre, Nodo hijo){
        int calidad_padre = 0;
        int calidad_hijo = 0;
        int[] dato_padre  = padre.getDatos();
        int[] dato_hijo = hijo.getDatos();
        //for (int i: dato_padre) {
        for(int i = 1; i < dato_padre.length; i++){
            if(dato_padre[i]>dato_padre[i-1]){
                calidad_padre = calidad_padre + 1;
            }
            if(dato_hijo[i]>dato_hijo[i-1]){
                calidad_hijo = calidad_hijo + 1;
            }
        }
        if(calidad_hijo>=calidad_padre){
            return true;
        }else{
            return false;
        }
    }
}
