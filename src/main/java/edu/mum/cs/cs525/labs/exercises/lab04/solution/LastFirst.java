package edu.mum.cs.cs525.labs.exercises.lab04.solution;
class LastFirst extends Namer{
    public LastFirst(String str){
        int i = str.indexOf(",");
        if (i>0){
            first=str.substring(0,i).trim();
            last=str.substring(i+1).trim();
        }
        else{
            last=str;
            first="";
        }
    }
}