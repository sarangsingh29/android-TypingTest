package maverick.com.self_filewriter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;
import android.os.Handler;

public class MainActivity extends AppCompatActivity
{

    public void onCreate(Bundle b)
    {
        super.onCreate(b);
        this.setContentView(R.layout.content_main);
        initializer();

        listenersetup();
    }

    Button b1, b2;
    TextView tv1;
    EditText et1;

    private void initializer()
    {
        b1=(Button)findViewById(R.id.btn1);
        b2=(Button)findViewById(R.id.btn2);
        tv1=(TextView)findViewById(R.id.tview1);
        et1=(EditText)findViewById(R.id.etext1);
    }

    Timer tmr=new Timer();
    Runnable r=new Runnable(){
        public void run()
        {
            tv1.setText("");
        }
    };

    Handler h=new Handler();
    private void listenersetup()
    {
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText("");
            }
        });


       et1.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {
             //  tv1.setText(tv1.getText().toString()+"before ");
           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {

           }

           @Override
           public void afterTextChanged(Editable s) {

               tv1.setText("Typing..");
               tmr.cancel();
               tmr=new Timer();
               tmr.schedule(new TimerTask() {
                   @Override
                   public void run() {
                       h.post(r);
                   }
               },1000);

           }
       });
    }

}