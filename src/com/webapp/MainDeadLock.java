package com.webapp;

public class MainDeadLock {

    public static void main(String[] args) {
        final int lock1 = 1;
        final int lock2 = 2;
        getDeadLock(lock1, lock2);
        getDeadLock(lock2, lock1);
    }

    private static void getDeadLock(Object lock1, Object lock2) {
        new Thread(() -> {
            System.out.println(getCurrentThreadName() + " is trying to handle object № " + lock1);
            synchronized (lock1) {
                System.out.println(getCurrentThreadName() + " handles object № " + lock1);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getCurrentThreadName() + " is trying to handle object № " + lock2);
                synchronized (lock2) {
                    System.out.println(getCurrentThreadName() + " handles object № " + lock2);
                }
            }
        }).start();
    }

    private static String getCurrentThreadName() {
        return Thread.currentThread().getName();
    }
}
