package com.example.jesus.poligono_irregular;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.javier.poligono_irregular.R;

public class Main2Activity extends AppCompatActivity {

    TextView perimetro,areas;
    Button regreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        perimetro=(TextView)findViewById(R.id.perimetro);
        areas = (TextView) findViewById(R.id.area);
        regreso=(Button)findViewById(R.id.bt1);


        recibir();
        regreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                volver();
            }
        });
    }


    private void recibir(){

        Bundle a = getIntent().getExtras();
        String b = a.getString("perimetro");
        String area = a.getString("area");

        perimetro.setText(" "+b);
        areas.setText(" "+ area);


    }

    private void volver(){
        Intent q = new Intent(Main2Activity.this,MainActivity.class);
        startActivity(q);

    }
}
