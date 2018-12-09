package com.example.jesus.poligono_irregular;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.javier.poligono_irregular.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RadioButton Rb1, Rb2;
    Button sig, calcular;
    EditText X1,X2,Y1,Y2;
    TextView lado;
    String vertice1, vertice2, vertice3 , vertice4, perimetro;
    Integer cont=0, au=1;
    ArrayList<Integer> x = new ArrayList<Integer>();
    ArrayList <Integer> y = new ArrayList<Integer>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Rb1=(RadioButton)findViewById(R.id.radioButtonSi);
        Rb2=(RadioButton)findViewById(R.id.radioButtonNo);
        sig=(Button)findViewById(R.id.buttonNext);
        calcular=(Button)findViewById(R.id.buttonCalc);
        X1=(EditText)findViewById(R.id.etx1);
        X2=(EditText)findViewById(R.id.etx2);
        Y1=(EditText)findViewById(R.id.ety1);
        Y2=(EditText)findViewById(R.id.ety2);
        lado=(TextView) findViewById(R.id.lado);

        lado.setText(""+au);

        Rb1.setEnabled(false);
        Rb2.setChecked(true);
        sig.setEnabled(true);





        Rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Rb1.isChecked()==true) {

                    Rb2.setChecked(false);
                    calcular.setEnabled(true);
                    sig.setEnabled(false);
                }

            }
        });

        Rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Rb2.isChecked()==true) {

                    Rb1.setChecked(false);
                    sig.setEnabled(true);
                    calcular.setEnabled(false);

                }

            }
        });

        sig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (X1.getText().toString().isEmpty()||X2.getText().toString().isEmpty()||
                        Y1.getText().toString().isEmpty()||Y2.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,
                            "Llene todos los campos",
                            Toast.LENGTH_SHORT).show();
                } else if (au<2){
                    ade();
                    au+=1;
                    calcular();
                    borrar();
                    Rb1.setEnabled(false);
                    Rb2.setChecked(true);
                    //au+=1;

                } else if(au>=2){
                    ade();
                    au+=1;
                    calcular();
                    borrar();
                    Rb1.setEnabled(true);
                    Rb1.setChecked(false);
                    Rb2.setChecked(true);
                }


            }
        });

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (X1.getText().toString().isEmpty()||X2.getText().toString().isEmpty()||
                        Y1.getText().toString().isEmpty()||Y2.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,
                            "Llene los campos",
                            Toast.LENGTH_SHORT).show();
                } else {

                    ade();

                    calcular();
                    perimetro = Integer.toString(cont);

                    Intent q = new Intent(MainActivity.this,Main2Activity.class);
                    q.putExtra("perimetro", perimetro);
                    q.putExtra("area",CalcularArea());
                    startActivity(q);

                }
            }
        });

    }

    public void calcular(){
        int c=0;
        vertice1 = X1.getText().toString();
        vertice2 = X2.getText().toString();
        vertice3 = Y1.getText().toString();
        vertice4 = Y2.getText().toString();

        int num1 = Integer.parseInt(vertice1);
        int num2 = Integer.parseInt(vertice2);
        int num3 = Integer.parseInt(vertice3);
        int num4 = Integer.parseInt(vertice4);

        int a = (int)Math.pow((num2-num1), 2);
        int b = (int)Math.pow((num4-num3), 2);
        c = (int)Math.sqrt(a+b);
        cont=cont+c;

        lado.setText(""+au);



    }

    public static int m (ArrayList<Integer> x,ArrayList<Integer> y){

        int suma1=0;
        int co = 0;
        int re = 0;
        try {

            //Lado x
            for(int c=0; c < x.size()+1; c++){
                co++;

                re += y.get(c) * x.get(co);
                suma1=re;

            }
        }

        catch (Exception e){

        }
        finally {

            return suma1;

        }
    }

    public static int mx (ArrayList<Integer> x,ArrayList<Integer> y){

        int suma1=0;
        int co = 0;
        int re = 0;
        try {

            //Lado y
            for(int c=0; c < y.size()+1; c++){
                co++;

                re += x.get(c) * y.get(co);
                suma1=re;

            }
        }

        catch (Exception e){

        }
        finally {

            return suma1;

        }
    }

    public String CalcularArea (){


        int valor1 = m(x,y);
        int valor2 =mx(x,y);
        int result = (Math.abs(valor1-valor2))/2;

        String resl = Integer.toString(result);

        return resl;

    }

    public void borrar() {
        X1.setText("");
        X2.setText("");
        Y1.setText("");
        Y2.setText("");
    }

    public void ade(){

        int x1 = Integer.parseInt(X1.getText().toString());
        int x2 = Integer.parseInt(X2.getText().toString());
        int y1 = Integer.parseInt(Y1.getText().toString());
        int y2 = Integer.parseInt(Y2.getText().toString());

        x.add(x1);
        y.add(y1);
        x.add(x2);
        y.add(y2);

    }


}
