import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;
    private int num1;
    private double num2;

    public Producto(){

    }

    public Producto(String nome, int num1, double num2){
        this.nome = nome;
        this.num1 = num1;
        this.num2 = num2;

    }

    public String getnome(){
        return nome;
    }

    public void setnome(String nome){
        this.nome = nome;
    }

    public int getNum1(){
        return num1;
    }

    public void setNum1(int num1){
        this.num1 = num1;
    }

    public double getNum2(){
        return num2;
    }

    public void setNum2 (double num2){
        this.num2 = num2;
    }

    public static void main(String[] args){
        Producto p1 = new Producto("Grimorio", 777, 599.99);

        try (ObjectOutputStream wardar = new ObjectOutputStream(new FileOutputStream("serial"))){
            wardar.writeObject(p1);
            System.out.println("Objeto magico guardado");
        } catch (IOException e){
            e.getMessage();
        }

        Producto p2 = new Producto();

        try (ObjectInputStream xakar = new ObjectInputStream(new FileInputStream("serial"))){
            p2 = (Producto) xakar.readObject();
            System.out.println("Objeto magico leido del inventario");
            System.out.println("Nombre: " + p2.getnome() + ", Num1: " + p2.getNum1() + ", Num2: " + p2.getNum2());
        } catch (IOException  | ClassNotFoundException e ) {
            e.getMessage();
        }
    }

}
