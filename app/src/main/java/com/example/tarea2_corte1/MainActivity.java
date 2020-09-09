package com.example.tarea2_corte1;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.*;
import android.os.*;
import android.text.*;
import android.view.*;
import android.widget.*;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    EditText x1, x2, y1, y2;
    Button boton1, boton2, boton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        x1=findViewById(R.id.txtn1);
        y1=findViewById(R.id.txtn2);
        x2=findViewById(R.id.txtn3);
        y2=findViewById(R.id.txtn4);

        boton1=findViewById(R.id.btn1);
        boton2=findViewById(R.id.btn2);
        boton3=findViewById(R.id.btn3);



    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.btn1:
                double array[]=this.puntoMedio(Double.parseDouble(this.x1.getText().toString()), Double.parseDouble(this.y1.getText().toString()), Double.parseDouble(this.x2.getText().toString()), Double.parseDouble(this.y2.getText().toString()));
                Toast.makeText(getApplicationContext(),"Punto medio: ("+array[0]+","+array[1]+")", Toast.LENGTH_LONG).show();
                break;
            case R.id.btn2:
                double pendiente=this.pendiente(Double.parseDouble(this.x1.getText().toString()), Double.parseDouble(this.y1.getText().toString()), Double.parseDouble(this.x2.getText().toString()), Double.parseDouble(this.y2.getText().toString()));
                Toast.makeText(getApplicationContext(),"Pendiente: "+pendiente, Toast.LENGTH_LONG).show();
                break;
            case R.id.btn3:
                String cuadrante=this.cuadrante(Double.parseDouble(this.x1.getText().toString()), Double.parseDouble(this.y1.getText().toString()), Double.parseDouble(this.x2.getText().toString()), Double.parseDouble(this.y2.getText().toString()));
                Toast.makeText(getApplicationContext(),"Cuadrante: "+cuadrante, Toast.LENGTH_LONG).show();
                break;
        }
    }

    public double[] puntoMedio(double x1, double y1, double x2, double y2){
        double array[];
        array=new double[2];

        double x; double y;

        x=(x1+x2)/2;
        y=(y1+y2)/2;

        array[0]=x;
        array[1]=y;

        return array;
    }

    public double pendiente(double x1, double y1, double x2, double y2){
        double pend;

        pend=(y2-y1)/(x2-x1);

        return pend;
    }

    public String cuadrante(double x1, double y1, double x2, double y2){
        String cuadro="";

        if (x1>=0){
            if (y1>=0){
                cuadro="Primer cuadrante";
            }else{
                cuadro="Cuarto cuadrante";
            }
        }else{
            if (y1>=0){
                cuadro="Segundo cuadrante";
            }else{
                cuadro="Tercer cuadrante";
            }
        }

        return cuadro;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.aleatorio:
                x1.setText(String.valueOf(generaAleatorio()));
                y1.setText(String.valueOf(generaAleatorio()));
                x2.setText(String.valueOf(generaAleatorio()));
                y2.setText(String.valueOf(generaAleatorio()));
                break;
            case R.id.distancia:
                double parseX1 = Double.valueOf(x1.getText().toString());
                double parseY1 = Double.valueOf(y1.getText().toString());
                double parseX2 = Double.valueOf(x2.getText().toString());
                double parseY2 = Double.valueOf(y2.getText().toString());

                double result = Math.sqrt(Math.pow((parseX2 - parseX1), 2) + Math.pow((parseY2 - parseY1), 2));

                Toast.makeText(this, String.valueOf(result), Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public double generaAleatorio() {
        Random r = new Random();
        int randomNumber = r.nextInt(20 - (-20)) + (-20);
        return Double.valueOf(randomNumber);
    }

}