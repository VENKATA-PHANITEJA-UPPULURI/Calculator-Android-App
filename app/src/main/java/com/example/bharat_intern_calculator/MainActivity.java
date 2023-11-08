package com.example.bharat_intern_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import java.util.*;




public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    MaterialButton Btnc,Btnbrack,Btnmod,Btndiv,Btn9,Btn8,Btn7,
            Btn6,Btn5,Btn4,Btn3,Btn2,Btn1,
            Btn0,Btnpoint,Btnequal,
            Btnadd,Btnsub,
            Btnmult,Btnempty;
    TextView Result,Calc;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Btn0=findViewById(R.id.btn0);
        Btn1=findViewById(R.id.btn1);
        Btn2=findViewById(R.id.btn2);
        Btn3=findViewById(R.id.btn3);
        Btn4=findViewById(R.id.btn4);
        Btn5=findViewById(R.id.btn5);
        Btn6=findViewById(R.id.btn6);
        Btn7=findViewById(R.id.btn7);
        Btn8=findViewById(R.id.btn8);
        Btn9=findViewById(R.id.btn9);
        Btnc=findViewById(R.id.btnc);
        Btnbrack=findViewById(R.id.btnbrack);
        Btnsub=findViewById(R.id.btnsub);
        Btnadd=findViewById(R.id.btnadd);
        Btnmod=findViewById(R.id.btnmod);
        Btndiv=findViewById(R.id.btndiv);
        Btnmult=findViewById(R.id.btnmult);
        Btnpoint=findViewById(R.id.btnpoint);
        Btnequal=findViewById(R.id.btnequal);
        Btnempty=findViewById(R.id.btnempty);
        Result=findViewById(R.id.result);
        Calc=findViewById(R.id.calc);

        Btn0.setOnClickListener(this);
        Btn1.setOnClickListener(this);
        Btn2.setOnClickListener(this);
        Btn3.setOnClickListener(this);
        Btn4.setOnClickListener(this);
        Btn5.setOnClickListener(this);
        Btn6.setOnClickListener(this);
        Btn7.setOnClickListener(this);
        Btn8.setOnClickListener(this);
        Btn9.setOnClickListener(this);
        Btnpoint.setOnClickListener(this);
        Btnadd.setOnClickListener(this);
        Btnequal.setOnClickListener(this);
        Btnsub.setOnClickListener(this);
        Btnbrack.setOnClickListener(this);
        Btnmod.setOnClickListener(this);
        Btndiv.setOnClickListener(this);
        Btnempty.setOnClickListener(this);
        Btnmult.setOnClickListener(this);
        Btnc.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        MaterialButton button=(MaterialButton) view;
        String buttontext=button.getText().toString();
        String datatocaclculate=Calc.getText().toString();
        datatocaclculate = datatocaclculate + buttontext;
        Calc.setText(datatocaclculate);
        if(buttontext.equals("C") || buttontext.equals("AC")){
            Calc.setText("");
            Result.setText("");
            return;
        }
        else if(buttontext.equals("=")){
            datatocaclculate=datatocaclculate.substring(0,datatocaclculate.length()-1);
            Context rhino=Context.enter();
            rhino.setOptimizationLevel(-1);
            String finalresult="";
            Scriptable scriptable=rhino.initStandardObjects();
            finalresult=rhino.evaluateString(scriptable,datatocaclculate,"Javascript",1,null).toString();
            Result.setText(finalresult);


        }

    }
    
}