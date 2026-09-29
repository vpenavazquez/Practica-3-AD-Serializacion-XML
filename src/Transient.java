import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Transient implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;
    private transient int num1;
    private double num2;

    public Transient(){

    }

    public Transient (String nome, int num1, double num2){
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

        String rutaFicheiro = "serial";

        Transient p1 = new Transient("Espada luz de luna", 1, 20000);

        System.out.println("Objeto magico antes de guardarlo");
        System.out.println(p1);

        try (ObjectOutputStream wardar = new ObjectOutputStream(new FileOutputStream(rutaFicheiro))) {
            wardar.writeObject(p1);
            System.out.println("Objeto magico guardado en el inventartio" + rutaFicheiro);

        } catch (IOException e){
            e.getMessage();
        }

        Transient p2 = new Transient();

        try (ObjectInputStream sakar = new ObjectInputStream(new FileInputStream(rutaFicheiro))){
            p2 = (Transient) sakar.readObject();
            System.out.println("Objeto recuperado (deserializado) del inventario:");
            System.out.println(p2);


        } catch (IOException | ClassNotFoundException e) {
            e.getMessage();
        }


    }


}
