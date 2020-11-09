package daoc.activityresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        int num = intent.getIntExtra("numero", -1);
        if(num < 0) {
            Toast.makeText(this, "No llegó un entero", Toast.LENGTH_LONG).show();
        } else {
            TextView tv = (TextView) findViewById(R.id.tvNumero);
            tv.setText(String.valueOf(num));
        }
    }

    public void devolverCalculo(View view) {
        TextView tv = (TextView) findViewById(R.id.tvNumero);
        String str = tv.getText().toString();
        try {
            int num = Integer.parseInt(str);
            num = (int) Math.pow(2, num);
            Intent intent = new Intent();
            intent.putExtra("resultado", num);
            setResult(Activity.RESULT_OK, intent);
            finish();
        } catch(Exception e) {
            Toast.makeText(this, "No llegó un entero", Toast.LENGTH_LONG).show();
        }
    }
}
