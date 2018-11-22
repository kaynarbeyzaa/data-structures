
package odev1;

/* Beyza Kaynar
   17253022    */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Odev1 {
    /**
     * Postfix biçiminde verilen metni ExpressionTree sınıfına dönüştürür
     * @param girdi postfix girdi metni
     * @return Oluşturulan ifade ağacı
     */
    
    public static ExpressionTree postfixToExpressionTree(String girdi){
        
        BTNode node; 
        BTNode node1; 
        BTNode node2;
        
        Stack<BTNode> stack = new Stack<BTNode>();
        
        if(girdi != null){
        
            String[] gm = girdi.split(" ");
            for (String s: gm) {
                if (Character.isDigit(s.charAt(0))){
                    node = new BTNode(s,null,null);
                    stack.push(node);
                }
                else{
                    node = new BTNode(s,null,null);

                    node1 = stack.pop();
                    node2 = stack.pop();

                    node.right = node1;
                    node.left = node2;

                    stack.push(node);
                }
            }
        }
        return new ExpressionTree(stack.pop());
    }
    /**
     * Parametre olarak verilen ifade ağacını değerlendirir(sonucunu hesaplar).
     * @param agac İfade ağacı
     * @return İfade ağacının sonucu
     */
    public static int evaluateExpressionTree(ExpressionTree agac){
        
        BTNode root = agac.getRoot();
        List<String> list = new ArrayList<String>();
        Stack<BTNode> stack = new Stack<BTNode>();
        
        stack.push(root);

        while(!stack.isEmpty()) {
            
            BTNode node = stack.peek();
            if(node.left==null && node.right==null) {
                BTNode pop = stack.pop();
                list.add((String) pop.value);
            }
           
            else {
                if(node.right!=null) {
                    stack.push(node.right);
                    node.right = null;
                }

                if(node.left!=null) {
                    stack.push(node.left);
                    node.left = null;
                }
            }
        }
        
        String result = "";
        for (String ifade : list){
            result+=ifade + ' ';  
        }
       
        return postfixDegerlendir(result);
    }
    
    public static int postfixDegerlendir(String girdi) {
        
        Stack<Integer> ostack=new Stack<Integer>();
        
        String[] gm=girdi.split(" ");
        for (String s: gm) {
            if (Character.isDigit(s.charAt(0)))
                ostack.push(Integer.parseInt(s));
            
            else{
                int d1=ostack.pop();
                int d2=ostack.pop();
                int sonuc=0;
                switch (s) {
                    case "+":
                        sonuc=d1+d2;
                        break;
                    case "-":
                        sonuc=d2-d1;
                        break;
                    case "*":
                        sonuc=d1*d2;
                        break;
                    case "/":
                        if(d1 == 0 ){
                            sonuc = 1;
                        }
                        else{
                        sonuc=d2/d1;
                        }
                        break;
                    default:
                        throw new UnsupportedOperationException("Desteklenmeyen işlem");
                }
                ostack.push(sonuc);
            }
        }
        return ostack.pop();
    }
}