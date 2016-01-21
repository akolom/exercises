package edu.mum.cs.cs525.labs.exercises.lab04;
// Example from: Java Design Patterns;  James Cooper

class Namer{
    private String last,first;
    
    public void processName(String str){
        int i = str.indexOf(",");
        if (i>0){
            last=str.substring(0,i).trim();
            first=str.substring(i+1).trim();
        }
        else{
            i = str.indexOf(" ");
            if (i>0){
                first=str.substring(0,i).trim();
                last=str.substring(i+1).trim();
            }
            else{
                first = "";
                last= str;
            }
        }
    }
    
    public String getFirst(){
        return first;
    }
    public String getLast(){
        return last;
    }
}    
    