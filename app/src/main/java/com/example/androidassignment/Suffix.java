package com.example.androidassignment;

public class Suffix {
    String s;
    int index;

    public Suffix(String s, int index) throws IllegalArgumentException{
        if(index > s.length()){
            throw new IllegalArgumentException("The index parameter has to be less than the length of the string.");
        }
        this.s = s;
        this.index = index;
    }

    public String suffix(){
        String suffix = "";
        if (this.s.length()>= this.index)
            suffix = this.s.substring(this.s.length()-this.index);

        return suffix;
    }

    public void setS(String s){
        this.s = s;
    }

    public void setIndex(int index){
        if (index < 0){
            throw new IllegalArgumentException("The index can't be smaller than 0");
        }
        if(index > this.s.length()){
            throw new IllegalArgumentException("The index parameter has to be less than the length of the string.");
        }
        this.index = index;
    }

    public String getS(){
        return this.s;
    }

    public int getIndex(){
        return this.index;
    }
}
