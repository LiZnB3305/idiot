package 排序;

import java.util.Comparator;

public class AComp implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}
