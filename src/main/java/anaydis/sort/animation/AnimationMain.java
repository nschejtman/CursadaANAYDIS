package anaydis.sort.animation;

import anaydis.animation.sort.gui.Main;
import anaydis.sort.SorterProviderImpl;

/**
 * Created with IntelliJ IDEA.
 * User: nicolas
 * Date: 19/09/13
 * Time: 14:44
 * To change this template use File | Settings | File Templates.
 */
public class AnimationMain {
    public static void main(String[] args) {
        Main.animate(new SorterProviderImpl());

    }
}
