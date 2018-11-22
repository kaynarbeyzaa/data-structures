
package seperatedchainhash;

import java.util.LinkedList;

public class SeperatedChainHash {
    public LinkedList<Integer>[] dizi;

    public SeperatedChainHash() {
        //içerği değiştirmeyin
        dizi=new LinkedList[23];
    }
    public SeperatedChainHash(int boyut) {
        //içerği değiştirmeyin
        dizi=new LinkedList[boyut];
    }
    public int hash(int deger){
        //içerği değiştirmeyin
        return deger%dizi.length;
    }
    public void ekle(int deger){
        //ekle metodunu yazınız
        
        int konum = hash(deger);
        
        if(dizi[konum]!=null){
            dizi[konum].add(deger);
        }
        else{
            dizi[konum]= new LinkedList();
            dizi[konum].add(deger);
        }
        
    }
    public boolean sil(int deger){
        //sil metodunu yazınız
        
        int konum = hash(deger);
        
        if(dizi[konum]!=null){
            int llindex = dizi[konum].indexOf(deger);
            dizi[konum].remove(llindex);
            return true;
        }
        return false;
    }
    
    public LinkedList<Integer>[] yenihashBul() {
        int yeniUzunluk = dizi.length*2;
        for(int i=2; i<=yeniUzunluk/2; i++){
            if(yeniUzunluk%i==0)
                yeniUzunluk++;
            else
                return new LinkedList[yeniUzunluk];
        }
        
        return null;
    }
    
    public void yenidenOzetle() {
        LinkedList<Integer>[] eskiDizi = dizi;
        
        dizi = yenihashBul();
        
        for(LinkedList<Integer> okunanListe : eskiDizi) {
            if(okunanListe!=null)
                for( int deger : okunanListe){
                    ekle(deger);
                }
        }
    }
}

