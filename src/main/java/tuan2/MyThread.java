/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan2;
// tạo và quản lý luồng
public class MyThread extends Thread {
    // tạo luồn
    @Override
    public void run() {
        System.out.println("Luong dang chay");
    }
    public static void main(String[] args) {
        MyThread th=new MyThread();
        th.start();
    }   
    
}
