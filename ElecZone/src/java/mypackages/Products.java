
package Mypackages;

/**
 *
 * @author Mr.Kshan
 */
public class Products {

    private int id;
    private String name;
    private String catagory;
    private String image;
   
    private String price;
    private String des;
    
     public Products(int id ,String name,String catagory,String image,String price, String des){
         this.name=name;
         this.id=id;
         this.image=image;
         this.catagory=catagory;
         
         this.price=price;
         this.des=des;
     }
      public Products(String name , String price, String des,String catagory,String image ){
        this.name=name;
        this.price=price;
        this.des=des;
        this.image=image;
        this.catagory=catagory;
        
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getPrice(){
        return price;
    }
    public void setPrice(String price){
        this.price=price;
    }
      public String getDescription(){
        return des;
    }
    public void setDecription(String des){
        this.des=des;
    
}   
     public String getImage(){
        return image;
    }
    public void setImage(String image){
        this.image=image;
    
}   
      public String getCatagory(){
        return catagory;
    }
    public void setCatagory(String catagory){
        this.catagory=catagory;
    
}   
  
      
    
    


}
