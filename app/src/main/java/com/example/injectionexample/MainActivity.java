package com.example.injectionexample;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.example.injectionexample.event.TestEvent;
import com.example.injectionexample.service.StringService;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.hello)
    TextView hello;

    @Inject
    StringService stringService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mEventBus.register(this);

        new Handler().postDelayed(() -> mEventBus.post(new TestEvent()), 2000);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(TestEvent event) {
        hello.setText(stringService.formatString("Test event arrived"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mEventBus.unregister(this);
    }
}
