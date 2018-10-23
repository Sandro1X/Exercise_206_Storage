package BL;

public class Article {
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
    
    public void buy(){
        amount ++;
    }
    
    public void sell(){
        amount --;
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
