/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementations;

import java.util.NoSuchElementException;
import utilities.Iterator;

/**
 *
 * @author kyled
 */



//WE DO NOT USE THIS IN OUR PROGRAM, IMPLEMENTATED A DIFFERENT METHOD
public class GenericIterator<E> implements Iterator<E> {
    public  E[] data;
    private int index = 0;

        public GenericIterator() {
        }

        public GenericIterator(E[] data) {
            this.data = data;
        }
        
       
        

        public void setData(E[] data) {
            this.data = data;
        }
        
        @Override
        public boolean hasNext() {
            return index < data.length;
        }

        @Override
        public E next()throws NoSuchElementException{

            if(index < data.length)
            {return data[index++];}

            throw new NoSuchElementException();

        }
    
    
    
    
    //end of class
    }


