
/*************** LAB-2 ******************/

package islemler;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Islemler {
    /**
     * Yığıtın elemnlarının sırasını tersine çevirir
     * @param s Tersine çevrilecek yığıt
     * @return Tersine çevirlmiş yığıtı döndürür
     */
    public static <T> Stack<T> tersCevir(Stack<T> s){
        Stack <T> s2 = (Stack <T>)s.clone();
        Stack <T> s3 = new Stack<>();
        
        while (!s2.isEmpty()){
           s3.push(s2.pop());
        }
        //Metodun gövdesini yazınız
        return s3;
    }

    /**
     * İki yığıtın eşit olup olmadığını kontrol eder
     * @param s1 Birinci yığıt
     * @param s2 İkinci yığıt
     * @return İki yığıtın eşit olma durumunu döndürür
     */
    public static <T> boolean esit(Stack<T> s1, Stack<T> s3)
    {
        Stack <T> s4 = (Stack <T>)s1.clone();
        Stack <T> s5 = (Stack <T>)s3.clone();
        
        while(!s4.isEmpty())
            if(s4.pop()!=s5.pop()){
                return false;
            }
            
        while(!s5.isEmpty()){
            return false;
        }
                return true;
        //Metodun gövdesini yazınız
    }

    /**
     * Postfix ifadeyi değerlendirir. İşlemler tamsayılar üzerinde gerçekleşir. "7 5 /" işleminin sonucu 1'dir.
     * @param girdi Girdi ifadesi
     * @return İfadenin sonucu
     */
    public static int postfixDegerlendir(String girdi) {
       
        Stack<Integer> ostack = new Stack<>();
        String [] gm = girdi.split(" ");
        
        for (String s : gm){
            if (Character.isDigit(s.charAt(0)))
                ostack.push(Integer.parseInt(s));
            else {
                int d1 = ostack.pop();
                int d2 = ostack.pop();
                int sonuc = 0;
                 
                switch(s){
                    case "+":{
                         sonuc = d1+d2;
                         break;
                    }
                    case "-":{
                         sonuc = d2-d1;
                         break;
                    }
                    case "*":{
                         sonuc = d2*d1;
                         break;
                    }
                    case "/":{
                         sonuc = d2/d1;
                         break;
                    }
                }
                ostack.push(sonuc);
            }
        }
        //Metodun gövdesini yazınız
        return ostack.pop();
    }

    /**
     * Infix ifadeyi postfix'e dönüştürür.
     * @param girdi Infix girdi metni
     * @return Dönüştürülmüş postfix ifade
     */
    
    
    
    
    /*public static String infixToPostfix(String girdi){
        
      
        //Metodun gövdesini yazınız
      
    }*/
    
    /**********INFIX TO POSTFİX METODUNU YAZAMADIM************/
    
    
    public boolean oncelik(String x,String y ){
        if (x.equals('*') || x.equals('/') )
            return true;
        else if (y.equals('+') || y.equals('-'))
            return true;
        
        return false;
    }
    /**
     * Infix ifadeyi sembollerine ayıran metod
     * @param girdi Infix ifade
     * @return Sembol dizisi
     */
    private static String[] splitToTokens(String girdi)
    {
        StringTokenizer t=new StringTokenizer(girdi, "+-*/^() ",true);
        List<String> tokenList=new ArrayList<>();
        while (t.hasMoreTokens()){
            String s=t.nextToken().trim();
            if(!s.equals(""))
                tokenList.add(s);
        }
        String [] tl=new String[tokenList.size()];
        tokenList.toArray(tl);
        return tl;
    }
}









