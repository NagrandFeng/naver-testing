package ysf.program.problemtwwo;


public class Main {
    public static void main(String[] args) {
        ReadWriteLockDemo demo =new ReadWriteLockDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(demo.getFromCache("demoKey"));
                }
            }).start();
        }
    }

}
