package com.maxGroup;


public class Account {
    private String numberAccount;
    private int balans;
    private int pass;

    public Account(){
        numberAccount = "0000000000";
        balans = 0;
        pass=11111111;
    }
    public Account(String numberAccount, int balans, int pass){
        this.numberAccount=numberAccount;
        this.balans=balans;
        this.pass=pass;
    }

    public void fillBalans(int count){
        balans+=count;
    }
    public Boolean GetMany(int count, int pass){
        if(pass==this.pass && count <=this.balans)
        {
            balans-=count;
            return true;
        }
        return false;
    }
    public String getNumberClient() {
        return numberAccount;
    }

    public void setNumberClient(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    public int getBalans() {
        return balans;
    }

    public void setBalans(int balans) {
        this.balans = balans;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }
}
