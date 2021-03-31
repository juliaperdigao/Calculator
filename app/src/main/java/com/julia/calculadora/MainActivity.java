package com.julia.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button numberZero,numberOne,numberTwo,numberThree,numberFour,numberFive,
    numberSix,numberSeven,numberEight,numberNine,point,sum,sub,mul,div,equ,clr;

    private TextView txtExpression,txtResult;
    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitComponents();
        getSupportActionBar().hide();

        numberZero.setOnClickListener(this);
        numberOne.setOnClickListener(this);
        numberTwo.setOnClickListener(this);
        numberThree.setOnClickListener(this);
        numberFour.setOnClickListener(this);
        numberFive.setOnClickListener(this);
        numberSix.setOnClickListener(this);
        numberSeven.setOnClickListener(this);
        numberEight.setOnClickListener(this);
        numberNine.setOnClickListener(this);
        point.setOnClickListener(this);
        sum.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);

        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtExpression.setText("");
                txtResult.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView expression = findViewById(R.id.txt_expression);
                String string = expression.getText().toString();

                if(!string.isEmpty()){

                    byte var0 = 0;
                    int var1 = string.length()-1;
                    String txtExpression = string.substring(var0,var1);
                    expression.setText(txtExpression);
                }
                txtResult.setText(" ");
            }
        });

        equ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    Expression expression = new ExpressionBuilder(txtExpression.getText().toString()).build();
                    double result = expression.evaluate();
                    long longResult = (long) result;

                    if(result == (double)longResult){
                        txtResult.setText((CharSequence) String.valueOf(longResult));
                    }else{
                        txtResult.setText((CharSequence) String.valueOf(result));
                    }
                }catch(Exception e){

                }

            }
        });

    }

    private void InitComponents(){
        numberZero = findViewById(R.id.number_0);
        numberOne = findViewById(R.id.number_1);
        numberTwo = findViewById(R.id.number_2);
        numberThree = findViewById(R.id.number_3);
        numberFour = findViewById(R.id.number_4);
        numberFive = findViewById(R.id.number_5);
        numberSix = findViewById(R.id.number_6);
        numberSeven = findViewById(R.id.number_7);
        numberEight = findViewById(R.id.number_8);
        numberNine = findViewById(R.id.number_9);
        point = findViewById(R.id.point);
        sum = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mult);
        div = findViewById(R.id.div);
        equ = findViewById(R.id.equal);
        clr = findViewById(R.id.clear);
        backspace = findViewById(R.id.backspace);
        txtExpression = findViewById(R.id.txt_expression);
        txtResult = findViewById(R.id.txt_result);
    }

    public void AddExpression(String string, boolean clear_data){

        boolean var = true;

        if(txtResult.getText().equals("")){
            txtExpression.setText(" ");
        }else{
            if(txtResult.getText().equals(" ")){
                var = false;
            }else{
                if(clear_data){
                    txtExpression.setText(" ");
                }else{
                    txtExpression.setText(txtResult.getText());
                    txtResult.setText(" ");
                    var = false;
                }
            }
        }

        if(clear_data){
            txtResult.setText(" ");
            txtExpression.append(string);
        }else{
            if(var){
                txtExpression.append(txtResult.getText());
            }
            txtExpression.append(string);
            txtResult.setText(" ");
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.number_0:
                AddExpression("0", true);
                break;
            case R.id.number_1:
                AddExpression("1", true);
                break;
            case R.id.number_2:
                AddExpression("2", true);
                break;
            case R.id.number_3:
                AddExpression("3", true);
                break;
            case R.id.number_4:
                AddExpression("4", true);
                break;
            case R.id.number_5:
                AddExpression("5", true);
                break;
            case R.id.number_6:
                AddExpression("6", true);
                break;
            case R.id.number_7:
                AddExpression("7", true);
                break;
            case R.id.number_8:
                AddExpression("8", true);
                break;
            case R.id.number_9:
                AddExpression("9", true);
                break;
            case R.id.point:
                AddExpression(".", true);
                break;
            case R.id.add:
                AddExpression("+", false);
                break;
            case R.id.sub:
                AddExpression("-", false);
                break;
            case R.id.mult:
                AddExpression("*", false);
                break;
            case R.id.div:
                AddExpression("/", false);
                break;

        }
    }
}