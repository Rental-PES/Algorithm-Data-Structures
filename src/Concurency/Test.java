//package Concurency;
//
//public class Test {
//    import java.util.concurrent.TimeUnit;
//
//    class MT extends Thread {
//        protected int delay = 1;
//        protected int itr = 10;
//        MT(){};
//        MT(int delay) {
//            this.delay = delay;
//        }
//        MT(int delay, int itr) {
//            this.delay = delay;
//            this.itr = itr;
//        }
//        public void run() {
//            System.out.println("thread run!!!");
//            for (int i = 0; i < itr; i++) {
//                try {
//                    TimeUnit.SECONDS.sleep(delay);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                System.out.println("thread " + delay +" - iteration " + i);
//                myLoopScript();
//            }
//        }
//        public void myLoopScript() {
//            System.out.println("loop");
//            return;
//        }
//    }
//
//    public class Main {
//        static int number = 0;
//        public static void main(String[] args) {
//
//            MT t1 = new MT(2){
//                @Override
//                public void myLoopScript() {
//                    number+=1;
//                    System.out.println("t1 : " + number);
//                }
//            };
//            MT t2 = new MT(3){
//                @Override
//                public void myLoopScript() {
//                    number+=1;
//                    System.out.println("t2 : " + number);
//                }
//            };
//            MT t3 = new MT(1){
//                @Override
//                public void myLoopScript() {
//                    number+=1;
//                    System.out.println("t3 : " + number);
//                }
//            };
//            t1.start();
//            t2.start();
//            t3.start();
//        }
//    }
//}
