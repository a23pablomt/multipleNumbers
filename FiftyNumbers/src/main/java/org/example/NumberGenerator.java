package org.example;

import java.util.concurrent.Callable;

public class NumberGenerator implements Callable<String> {

    @Override
    public String call() throws Exception {
        String val = "" + (int) ((Math.random() * 9) + 1);
        for(int i = (int) ((Math.random()*29)+19); i > 0; i--) val = val +((int) (Math.random() * 10));
        return val;
    }
}
