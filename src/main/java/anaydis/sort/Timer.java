package anaydis.sort;

/**
 * User: nschejtman
 * Date: 27/08/13
 * Time: 11:51
 */
public class Timer {
    private long start;
    private long end;

    public void start(){
        start = System.currentTimeMillis();
    }

    public void end(){
        end = System.currentTimeMillis();
    }

    public long time(){
        return end - start;
    }

    public void reset(){
        start = end = 0;
    }
}
