

class MultiThreadHandle {
    static int var = 5;
    public synchronized void test1() {
        var++;
        System.out.println("Inside Test1 Method : " + var);
        while (true) {
            try {
                Thread.sleep(Long.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static synchronized void test2() {
        var++;
        System.out.println("Inside Test2 Method : " + var);
        while (true) {
            try {
                Thread.sleep(Long.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

