package com.example.boletos;

public class Boletos {
    //ATRIBUTOS
    private int numerodeBoleto;
    private String nombreCliente;
    private String destino;
    private int tipodeViaje;
    private float precio;
    private String fecha;

    //METODOS
    //Constructores
    //Constructor Vacio
    public Boletos(){
        this.numerodeBoleto=0;
        this.nombreCliente="";
        this.destino="";
        this.tipodeViaje=0;
        this.precio=0.0f;
        this.fecha="";
    }
    //CONSTRUCTOR DE PARAMETROS
    public Boletos(int numerodeBoleto, String nombreCliente, String destino,
                   int tipodeViaje, float precio, String fecha){
        this.numerodeBoleto=numerodeBoleto;
        this.nombreCliente=nombreCliente;
        this.destino=destino;
        this.tipodeViaje=tipodeViaje;
        this.precio=precio;
        this.fecha=fecha;
    }
    //CONSTRUCTOR DE COPIA
    public Boletos (Boletos boleto){
        this.numerodeBoleto=boleto.numerodeBoleto;
        this.nombreCliente=boleto.nombreCliente;
        this.destino=boleto.destino;
        this.tipodeViaje=boleto.tipodeViaje;
        this.precio=boleto.precio;
        this.fecha=boleto.fecha;
    }

    //Encapsulamiento


    public int getnumerodeBoleto() {
        return numerodeBoleto;
    }

    public void setnumerodeBoleto(int numerodeBoleto) {
        this.numerodeBoleto = numerodeBoleto;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setnombrecliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getdestino() { //Ultima correccion set de destino
        return destino;
    }

    public void setdestino(String destino) {
        this.destino = destino;
    }

    public int gettipodeviaje() {
        return tipodeViaje;
    }

    public void settipodeViaje(int tipodeViaje) {
        this.tipodeViaje = tipodeViaje;
    }

    public float getprecio() {
        return precio;
    }

    public void setprecio(float precio) {
        this.precio = precio;
    }

    public String getfecha() {
        return fecha;
    }

    public void setfecha(String fecha) {
        this.fecha = fecha;
    }

    //Se calcula el subtotal en base al tipo de viaje
    public float calcularSubtotal(){
        float subtotal;
        if (tipodeViaje==2){
            subtotal=precio*(1.80f);
        }
        else
        {
            subtotal=precio;
        }
        return subtotal;
    }

    //Se calcula el IVA en base al resultado del metodo calcularSubtotal
    public float calcularIVA(){
        float iva;
        iva = calcularSubtotal()*(.16f);
        return iva;
    }

    //Se realiza un descuento al precio si la edad es mayor a 60
    public float calcularDescuento(int edad){
        float descuento;
        if (edad>60){
            descuento=(calcularSubtotal()+ calcularIVA())/2;
        }
        else{
            descuento=0;
        }
        return descuento;
    }

    public float calcularTotal(int edad){
        float total;
        total = calcularSubtotal()+ calcularIVA()-calcularDescuento(edad);
        return total;
    }
}
