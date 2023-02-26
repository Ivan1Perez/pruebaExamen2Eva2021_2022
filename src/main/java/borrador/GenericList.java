package borrador;

import java.io.*;

public class GenericList<T> {

    /*
    Crea una lista genérica con los siguientes métodos:

     */

    private int size;
    private Node<T> head;
    private Node<T> tail;

    public GenericList(){

    }

//    a. addHead(E e) que añade elementos al principio de la colección

    public void addHead(T info){
        Node<T> node = new Node<>(info);

        if(head==null){
            head = node;
            tail = node;
        }else{
            node.setNext(head);
            head = node;
        }
        size++;
    }

//            b. addTail(E e) que añade elementos al final de la colección.

    public void addTail(T info){
        Node<T> node = new Node<>(info);

        if(head==null){
            head = node;
            tail = node;
        }else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

//            c. find(E e) que busca un elemento en la colección y devuelve su posición (-1 si no está).

    public int find(T e){
        int posicion = 0;
        boolean encontrado = false;
        Node<T> node = head;

        while(node!=null && !encontrado){
            if(node.getInfo().equals(e)){
                encontrado = true;
            }
            node = node.getNext();
        }

        if(!encontrado)
            posicion = -1;

        return posicion;
    }

//    d. remove(int index) que deberá eliminar el objeto en la posición index, devolviendo este.
//    Si no existe, deberá devolver null.

    public T remove(int index){
        GenericList<T> aux = new GenericList<>();
        Node<T> node = head;
        T data = null;

        if(index >= size || index < 0)
            return null;

        for(int i = 0 ; i < size ; i++){
            if(i!=index){
                aux.addHead(node.getInfo());
            }else {
                data = node.getInfo();
            }
            node = node.getNext();
        }
        size--;
        head = aux.head;

        return data;
    }

//    e. size() que devuelva el tamaño de la lista
    public int size(){
        return size;
    }

//            f. save(String file) que guarde la colección en un fichero

    public void save(String file){

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(file)))){
            oos.writeObject(this);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

//        g. load(String file) que cargue los datos desde un fichero.

    public void load(String file){

        try(ObjectInputStream ios = new ObjectInputStream(new FileInputStream(new File(file)))){
            ios.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        String output = "Total: " + size + "\n";
        Node<T> node = head;

        while(node!=null){
            output += node.getInfo() + "\n";
            node = node.getNext();
        }

        return output;
    }

    static class Node<T> {

        private T info;
        private Node<T> next;

        public Node(T info){
            this.info = info;
        }

        public T getInfo() {
            return info;
        }

        public void setInfo(T info) {
            this.info = info;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        @Override
        public boolean equals(Object obj){
            if(obj instanceof Node<?> node){
                return node.info.equals(info);
            }

            return false;
        }

        @Override
        public String toString(){
            return info.toString();
        }
    }

}
