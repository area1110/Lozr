/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.module;


/**
 *
 * @author Khanh
 */
public class PagingModule {
    
    public static int PAGE_SIZE = 5;
 
    public static int[] calcFromToRecord(int pageIndex){
        int[] fromTo = new int[2];
        fromTo[0] = (pageIndex - 1) * PAGE_SIZE + 1;
        fromTo[1] = pageIndex*PAGE_SIZE;
        return fromTo;
    }
    
    public static int calcTotalPage(int totalRecord){
        if(totalRecord%PAGE_SIZE==0){
            return totalRecord / PAGE_SIZE;
        } else {
            return totalRecord/PAGE_SIZE + 1;
        }
    }
}
