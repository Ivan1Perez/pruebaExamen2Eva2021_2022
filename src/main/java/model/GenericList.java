package model;

import java.io.*;

public class GenericList<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    public GenericList(){

    }

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

    public int find(T e){
        int posicion = 0, contador = 0;
        boolean encontrado = false;
        Node<T> node = head;

        while(node!=null && !encontrado){
            if(node.getInfo().equals(e)){
                encontrado = true;
            }
            posicion = contador;
            node = node.getNext();
            contador++;
        }

        if(encontrado)
            return posicion;

        return -1;
    }

    public T remove(int index){
        GenericList<T> aux = new GenericList<>();
        Node<T> node = head;
        T data = null;

        if(index >= size || index < 0)
            return null;

        for(int i = 0 ; i < size ; i++){
            if(i!=index)
                aux.addHead(node.getInfo());
            else
                data = node.getInfo();
            node = node.getNext();
        }

        head = aux.head;

        return data;
    }

    public int getSize(){
        return size;
    }

    public void save(String file){

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(file)))){
            oos.writeObject(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void load(String file){

        ObjectInputStream ios = null;

        try{
            ios = new ObjectInputStream(new FileInputStream(new File(file)));
            ios.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if(ios!=null){
                try{
                    ios.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

    }

    static class Node<T>{

        private T info;
        private Node<T> next;

        public Node(T info){
            this.info = info;
            this.next = null;
        }

        public T getInfo(){
            return info;
        }

        public Node<T> getNext(){
            return next;
        }

        public void setNext(Node<T> next){
            this.next = next;
        }

        @Override
        public boolean equals(Object obj){
            if(obj instanceof Node<?>){
                Node<?> aux = (Node<?>) obj;
                return aux.info.equals(info);
            }

            return false;
        }

        @Override
        public String toString(){
            return info.toString();
        }
    }

}
