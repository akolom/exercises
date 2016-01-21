package edu.mum.cs.cs525.labs.exercises.lab04.solution;
class FirstLast extends Namer{
    public FirstLast(String str){
        int i = str.indexOf(" ");
        if (i>0){
            last=str.substring(0,i).trim();
            first=str.substring(i+1).trim();
        }
        else{
            last=str;
            first="";
        }
    }
}
    