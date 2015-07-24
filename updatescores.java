/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import java.io.*;


/**
 *
 * @author test
 */
public class updatescores {

    /**
     * @param args the command line arguments
     */
    static int[] scores={1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
    
    public static void main(String[] args) {
        
        System.out.println(update_score("abc","aeb"));
           
         
                
                
                
     }              
       
    public static int cal_score(String s)

    {
        int score =0;
        for(int i=0;i<s.length();i++)
        {
            score = score + scores[s.charAt(i)-'a'];
        } 
        return score;
    }
    
    public static int update_score(String s1,String s2) // s1 is rack s2 is word
    {   
        int score=0;
        
        for(int i=0;i<s1.length();i++)
        {
            if(s2.indexOf(s1.charAt(i))>-1)
            {
                score = score + scores[s1.charAt(i)-'a']; 
            }
        
        }

         return score;
    }
    
}
