package main.java.com.lab.examen.model;

/**
 * Created by ELMER on 21/05/2016.
 */
public class Phone {

    private int numero;
    private String PhoneOperator;

    public Phone(int numero, String PhoneOperator){
        this.numero=numero;
        this.PhoneOperator=PhoneOperator;
    }
    public Phone(){}

    public String getPhoneOperator() {return PhoneOperator;}

    public void setPhoneOperator(String phoneOperator) {PhoneOperator = phoneOperator;}

    public int getNumero() {return numero;}

    public void setNumero(int numero) {this.numero = numero;}

}
