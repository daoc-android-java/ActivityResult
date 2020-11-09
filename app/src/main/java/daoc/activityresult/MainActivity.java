package daoc.activityresult;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pedirCalculo(View view) {
        EditText et = (EditText) findViewById(R.id.etNumero);
        String str = et.getText().toString();
        try {
            Integer num = Integer.parseInt(str);
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("numero", num);
            startActivityForResult(intent, 123);
        } catch(Exception e) {
            Toast.makeText(this, "Ingrese un entero por favor", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == Activity.RESULT_OK) {
            if(requestCode == 123) {
                int dosalan = data.getIntExtra("resultado", -1);
                TextView tv = (TextView) findViewById(R.id.tvResultado);
                tv.setText(String.valueOf(dosalan));
            }
        }
    }

}