package app.hamilton;

public class Peek extends Thread {
    DFS dfs;

    public Peek(DFS dfs) {
        this.dfs = dfs;
    }

    @Override
    public void run() {
        while(true) {
            System.out.println(dfs.stack);
            try {
                sleep(1000l);
            } catch (InterruptedException e) {

            }
        }
    }
}
