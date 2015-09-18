package com.qizhu.util;

import java.util.ArrayList;
import java.util.List;

public class ArryUtil {

    public static void main(String[] args) {
        String[] str = new String[]{"乳白","雪白","本白","银白"};
        getArray(str);
//        ArrayList<String> allResult = new ArrayList<String>();
//        for(String s:str){
//            
//            for(String p:str){
//                if(p.equals(s)){
//                    continue;
//                }
//                
//                allResult.add(s+","+p);
//            }
//        }
//        System.out.println(allResult);
    }
    
    
    public static List<String> getArray(String str[]){
//    	  String[] str = new String[]{"乳白","雪白","本白","银白"};
          ArrayList<String> allResult = new ArrayList<String>();
          for(String s:str){
              
              allResult.add(s);
          }
          System.out.println(allResult);
          return allResult;
    }
//    public static List<String> getArray(String str[]){
////    	  String[] str = new String[]{"乳白","雪白","本白","银白"};
//    	ArrayList<String> allResult = new ArrayList<String>();
//    	for(String s:str){
//    		
//    		for(String p:str){
//    			if(p.equals(s)){
//    				continue;
//    			}
//    			
//    			allResult.add(s+","+p);
//    		}
//    	}
//    	System.out.println(allResult);
//    	return allResult;
//    }
    
}