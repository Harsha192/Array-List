package com.company;
/*
*  in Array class methods that are in ArrayList list as add(), get(), remove(), replace(), contain()
*  isEmpty(), size(), trimToSize() and clear() are implemented using dynamic arrays.
* */

import java.util.Arrays;


public class Array {
    private int arraySize; //arraysize to keep the initial array size and array size after get called any method

    public Array() {} //constructor with no parameter

    public Array(int lclarraySize) {
        this.arraySize = lclarraySize;
    } //constructor with user enterd value as initial dynamic array size


    //initial array with the size of user enater
    private int[] intArray = new int[this.arraySize];


    //add() method with int argument to store the input argument
    public void add(int d){
        this.arraySize++;
        try {
            int[] intArray3 = new int[this.arraySize];
            int i=0;
            for (int x:intArray){
                intArray3[i] = x;
                i++;
            }
            intArray3[this.arraySize-1] = d;
            intArray = intArray3;

        }catch (Exception exp){

        }
    }

    //add() method with index to be added and value
    public void add(int index, int d){
        if (index-1<this.arraySize){
            intArray[index-1] = d;
        }else if (index-1==this.arraySize){
            try {
                this.arraySize++;
                int[] intArray3 = new int[this.arraySize];
                int i=0;
                for (int x:intArray){
                    intArray3[i] = x;
                    i++;
                }
                intArray3[this.arraySize-1] = d;
                intArray = intArray3;
            }catch (Exception e){
                System.out.println("Cannot add element to this location.");
            }
        }else {
            System.out.println("Cannot add element to this location.");
        }

    }

    //replace() method to replace any value exist in a array
    public void replace(int index, int d){
        try {
            intArray[index-1] = d;
        }catch (Exception e){
            System.out.println("Cannot access the location.");
        }
    }

    //get() method to get any index that exist.
    public int get(int index){
        try {
            return intArray[index-1];
        }catch (Exception e){
            //if given index not exist error message will be print.
            System.out.println("Error: Index might not exist.");
            return 0;
        }
    }

    //remove() method to remove value in the any given existing index
    public void remove(int index){
        if (index<=this.arraySize) {
            int[] removArray = new int[this.arraySize - 1];
            for (int i = 0; i < removArray.length; i++) {
                if (i < index - 1) {
                    removArray[i] = intArray[i];
                } else if (i >= index - 1) {
                    removArray[i] = intArray[i + 1];
                }
            }
            this.arraySize--; //new size of array will be decrease by 1 after removing.
            intArray = removArray;
        }else {
            System.out.println("Wrong index");
        }

    }

    //isEmpty() method return true if array is empty else return false
    public boolean isEmpty(){
        boolean result = true;
        if (this.arraySize==0){
            result = true;
        }else if(this.arraySize!=0){
           for (int x:intArray){
               if (x!=0)
                   result = false;
           }
        }else {
            result = true;
        }
        return result;
    }

    //size() method return the number of elements
    public int size(){
        return this.arraySize;
    }


    // return true/false based on wether or not the element is found on the array
    public boolean contain(int d) {
        boolean boolResult = false;
        for (int i = 0; i < this.arraySize; i++) {
            if (intArray[i] == d)
                boolResult = true;
        }
        return boolResult;
    }

    //trim the array so that only first 'size' elemnts are available in the array
    public int[] trimToSize(int size){
        int[] trimArray = new int[size];
        int[] excepArray = new int[0];
        try {
            for (int i=0;i<size;i++){
                trimArray[i] = intArray[i];
            }
            return trimArray;
        }catch (Exception e){
            System.out.println("Wrong trim size.");
            return excepArray;
        }
    }
// testing
    //clear() method will remove all the element from the array
    public void clear(){
        intArray = null;
    }

    //return a string with the elements in the array
    @Override
    public String toString() {
        return "intArray = " + Arrays.toString(this.intArray);
    }

}
