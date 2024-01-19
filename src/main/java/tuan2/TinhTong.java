/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan2;

import javax.crypto.AEADBadTagException;

/**
 *
 * @author Admin
 */
public class TinhTong {
    public static void main(String[] args) {
        // mang so nguyen
        int [] array = {1,2,3,4,5,6,7,8,9,10};
        
        //so luong luong
        int numThreads=2;
        //  khai bao mang luong
        Thread[] ths=new Thread[numThreads];
        // 2 luong tuong ung voi 2 runable
        SumCalculator[] cals = new SumCalculator[numThreads];
        // chay cac luong
        for(int i=0; i<numThreads;i++)
        {
            cals[i]=new SumCalculator(array, i, numThreads);
            ths[i] = new Thread(cals[i]);
            ths[i].start(); //bat dau luong
        }
        // doi cho tat ca cac luong hoan thanh
        for(int i=0;i<numThreads;i++)
        {
            try {
                ths[i].join(); //cho luong ket thuc
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // tinh tong ket qua cac luong
        int totalSum=0;
        for(SumCalculator c: cals)
        {
            totalSum += c.getTong1Phan();
        }
        //in ra
        System.out.println("Tong la: "+totalSum);
    }
}
class SumCalculator implements Runnable {
    private int[] array;
    private int startIndex;
    private int chia;
    private int tong1phan;

    public SumCalculator(int[] array, int startIndex, int chia) {
        this.array = array;
        this.startIndex = startIndex;
        this.chia = chia;
        this.tong1phan = 0;
    }
    
    @Override

        public void run() {
            //tinh tong cac phan tu 
            for(int i=startIndex;i<array.length;i+=chia)
            {
                tong1phan += array[i];
            }
            
        }
    public int getTong1Phan()
    {
        return tong1phan;
    }
    
    
}
