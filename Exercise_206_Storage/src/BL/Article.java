package BL;

import java.io.Serializable;

public class Article implements Serializable{
    private int id;
    private String desc;
    private int amount;
    private int place;

    public Article(int id, String desc, int amount, int place) {
        this.id = id;
        this.desc = desc;
        this.amount = amount;
        this.place = place;
    }
    
    public void buy() throws Exception{
        if(amount < 75){
            amount ++;
        }else{
            throw new Exception("You cannot have more than 75!");
        }
    }
    
    public void sell() throws Exception{
        if(amount > 0){
            amount --;
        }else{
            throw new Exception("You cannot have -1!");
        }
    }

    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public int getAmount() {
        return amount;
    }

    public int getPlace() {
        return place;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPlace(int place) {
        this.place = place;
    }
    
    
}
