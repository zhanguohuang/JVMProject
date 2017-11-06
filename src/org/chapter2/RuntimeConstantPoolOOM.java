package org.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * Java HotSpot(TM) 64-Bit Server VM warning: ignoring option PermSize=10M; support was removed in 8.0
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        //使用List保持着常量池引用，避免Full GC回收常量池行为
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i).intern());
        }
    }
}
