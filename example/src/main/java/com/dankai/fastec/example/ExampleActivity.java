package com.dankai.fastec.example;

import com.dankai.latte.activities.ProxyActivity;
import com.dankai.latte.delegates.LatteDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new ExampleDelegate();
    }
}