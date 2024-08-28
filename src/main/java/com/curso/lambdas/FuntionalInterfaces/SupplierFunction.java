package com.curso.lambdas.FuntionalInterfaces;

import lombok.ToString;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierFunction {
    static Supplier<Integer> randomNumber = () -> new Random().nextInt(100);
    static Supplier<MyProduct> product = () -> new MyProduct(100,"galletas");
    public static void main(String[] args) {
        System.out.println(randomNumber.get());
        System.out.println(product.get());
    }
}

@ToString
class MyProduct{
    private int idPro;
    private String nom;

    public MyProduct(int idPro, String nom){
        this.idPro = idPro;
        this.nom = nom;
    }

    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
