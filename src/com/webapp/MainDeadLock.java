package com.webapp;

public class MainDeadLock {

    public static void main(String[] args) {
        final int lock1 = 1;
        final int lock2 = 2;
        deadLock(lock1, lock2);
        deadLock(lock2, lock1);
    }

    private static void deadLock(Object lock1, Object lock2) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " trying to handle object № " + lock1);
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + " handles object № " + lock1);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " trying to handle object № " + lock2);
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + " handles object № " + lock2);
                }
            }
        }).start();
    }
}
