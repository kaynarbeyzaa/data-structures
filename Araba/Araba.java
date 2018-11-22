
/************* LAB-1 ****************/

package araba;

public class Araba implements Comparable <Araba>{
   
    private int modelYili;
    private String plaka;
    private String marka;
    private double motorHacmi;
    
    public Araba(String marka, int modelYili,double motorHacmi, String plaka){
       
        this.marka= marka;
        this.modelYili= modelYili;
        this.motorHacmi=motorHacmi;
        this.plaka=plaka;
        
    }
    public int compareTo (Araba a){
        return modelYili - a.modelYili;
    }
}
