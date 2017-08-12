package tw.brad.app.helloworld.mythread;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mesg;
    private UIHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new UIHandler();
        mesg = (TextView)findViewById(R.id.mesg);
    }
    public void test1(View view){
        MyThread01 mt1 = new MyThread01();
        MyThread01 mt2 = new MyThread01();
        mt1.start(); mt2.start();
    }
    public void test2(View view){

    }
    public void test3(View view){

    }

    private class MyThread01 extends Thread {
        @Override
        public void run() {
            for (int i=0; i<20; i++){
                Log.i("brad", " i = " + i);
                //mesg.setText(" i = " + i);
                handler.sendEmptyMessage(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    private class UIHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mesg.setText("i = " + msg.what);
        }
    }

}
