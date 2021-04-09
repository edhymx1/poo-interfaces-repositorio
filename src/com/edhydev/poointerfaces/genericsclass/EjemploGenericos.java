package com.edhydev.poointerfaces.genericsclass;

public class EjemploGenericos {

    public static <T> void imprimirCamion(Camion<T> camion) {
        for(T a : camion) {
            if(a instanceof Animal) {
                System.out.println(((Animal)a).toString());
            }
            else if(a  instanceof Maquinaria) {
                System.out.println(((Maquinaria)a).toString());
            }
            else  if(a instanceof Automovil) {
                System.out.println(((Automovil)a).toString());
            }
        }
    }

    public static void main(String[] args) {

        Camion<Animal> transporteCaballos = new Camion<>(5);
        transporteCaballos.add(new Animal("Peregrino", "Caballo"));
        transporteCaballos.add(new Animal("Peter", "Caballo"));
        transporteCaballos.add(new Animal("Grillo", "Caballo"));
        transporteCaballos.add(new Animal("Mister", "Caballo"));
        transporteCaballos.add(new Animal("Bruno", "Caballo"));

        imprimirCamion(transporteCaballos);

        Camion<Maquinaria> transMaquinas = new Camion<>(3);
        transMaquinas.add(new Maquinaria("Bulldozer"));
        transMaquinas.add(new Maquinaria("Grúa Horquilla"));
        transMaquinas.add(new Maquinaria("Perforadora"));

        imprimirCamion(transMaquinas);

        Camion<Automovil> transAuto = new Camion<>(3);
        transAuto.add(new Automovil("Nissan"));
        transAuto.add(new Automovil("Toyota"));
        transAuto.add(new Automovil("Chevrolet"));

        imprimirCamion(transAuto);
     }

}
