package anaydis.sort.practice;

import anaydis.animation.sort.gui.Main;
import anaydis.sort.provider.SorterProviderImpl;

/**
 * Created by isabel on 8/28/16.
 */
public class animMain {
    public static void main(String[] args) {
        SorterProviderImpl provider = new SorterProviderImpl();
        Main.animate(provider);
    }
}
