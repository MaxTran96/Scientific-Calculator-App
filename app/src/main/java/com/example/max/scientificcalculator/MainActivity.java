package com.example.max.scientificcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String ADDITION = "+";
    private static final String MULTIPLICATION = "*";
    private static final String DIVISION = "/";
    private static final String SUBTRACTION = "-";
    private static final String SINE = "Sin";
    private static final String COSINE = "Cos";
    private static final String TANGENT = "Tan";
    private static final String ASINE = "ASin";
    private static final String ACOSINE = "ACos";
    private static final String ATANGENT = "ATan";
    private static final String EXPONENTIAL = "exp";
    private static final String FACTORIAL = "factorial";
    private static final String NEXTPRIME = "nextPrime";
    private String CURRENT_ACTION;
    private Button btnSubtraction, btnMultiplication, btnAddition, btnDivision;
    private Button btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnZero;
    private Button btnDelete, btnDot, btnClear, btnNextPrime, btnFactorial, btnExp, btnEqual;
    private Button btnSin, btnCos, btnTan, btnASin, btnACos, btnATan, btnPi;

    private TextView result,op1,op2;
    private EditText digit;
    private double operand1 = Double.NaN;
    private double operand2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        op1 = (TextView) findViewById(R.id.op1);
        op2 = (TextView) findViewById(R.id.op2);
        btnSubtraction = (Button) findViewById(R.id.btnSubtract);
        btnMultiplication = (Button) findViewById(R.id.btnMultiply);
        btnAddition = (Button) findViewById(R.id.btnAdd);
        btnDivision = (Button) findViewById(R.id.btnDivide);
        btnSin = (Button) findViewById(R.id.btnSine);
        btnCos = (Button) findViewById(R.id.btnCosine);
        btnTan = (Button) findViewById(R.id.btnTangent);
        btnACos = (Button) findViewById(R.id.btnArcCosine);
        btnASin = (Button) findViewById(R.id.btnArcSine);
        btnATan = (Button) findViewById(R.id.btnArcTangent);
        btnExp = (Button) findViewById(R.id.btnExponential);
        btnNextPrime = (Button) findViewById(R.id.btnNextPrime);
        btnFactorial = (Button) findViewById(R.id.btnFactorization);
        btnOne = (Button) findViewById(R.id.btnOne);
        btnTwo = (Button) findViewById(R.id.btnTwo);
        btnThree = (Button) findViewById(R.id.btnThree);
        btnFour = (Button) findViewById(R.id.btnFour);
        btnFive = (Button) findViewById(R.id.btnFive);
        btnSix = (Button) findViewById(R.id.btnSix);
        btnSeven = (Button) findViewById(R.id.btnSeven);
        btnEight = (Button) findViewById(R.id.btnEight);
        btnNine = (Button) findViewById(R.id.btnNine);
        btnZero = (Button) findViewById(R.id.btnZero);
        btnDelete = (Button) findViewById(R.id.btnDel);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnEqual = (Button) findViewById(R.id.btnEqual);
        btnPi = (Button) findViewById(R.id.btnPi);
        digit = (EditText) findViewById(R.id.digit);
        result = (TextView) findViewById(R.id.resultText);
        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                digit.setText(digit.getText().toString()+"0");
                result.setText(result.getText().toString() + "0");
            }
        });
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                digit.setText(digit.getText().toString()+"1");
                result.setText(result.getText().toString() + "1");
            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                digit.setText(digit.getText().toString()+"2");
                result.setText(result.getText().toString() + "2");
            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                digit.setText(digit.getText().toString()+"3");
                result.setText(result.getText().toString() + "3");
            }
        });
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                digit.setText(digit.getText().toString()+"4");
                result.setText(result.getText().toString() + "4");
            }
        });
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                digit.setText(digit.getText().toString()+"5");
                result.setText(result.getText().toString() + "5");
            }
        });
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText().toString() + "6");
                digit.setText(digit.getText().toString()+"6");
            }
        });
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                digit.setText(digit.getText().toString()+"7");
                result.setText(result.getText().toString() + "7");
            }
        });
        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                digit.setText(digit.getText().toString()+"8");
                result.setText(result.getText().toString() + "8");
            }
        });
        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                digit.setText(digit.getText().toString()+"9");
                result.setText(result.getText().toString() + "9");

            }
        });
        btnPi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                digit.setText(digit.getText().toString()+"3.14159");
                result.setText(result.getText().toString() + "3.14159");

            }
        });

        btnAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                CURRENT_ACTION = ADDITION;
                digit.setText("");
                result.setText(operand1 + "+");
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                CURRENT_ACTION = DIVISION;
                result.setText(operand1 + "/");
                digit.setText("");

            }
        });
        btnMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                CURRENT_ACTION = MULTIPLICATION;
                result.setText(operand1 + "*");
                digit.setText("");

            }
        });
        btnSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                CURRENT_ACTION = SUBTRACTION;
                result.setText(operand1 + "-");
                digit.setText("");

            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                result.setText(operand1+"");
                operand1 = Double.NaN;
                CURRENT_ACTION = "0";
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(digit.getText().length() > 0) {
                    CharSequence currentDigitText = digit.getText();
                    digit.setText(currentDigitText.subSequence(0, currentDigitText.length() - 1));
                }
                if(result.getText().length() > 0) {
                    CharSequence currentText = result.getText();
                    result.setText(currentText.subSequence(0, currentText.length()-1));

                } else {
                    operand1 = Double.NaN;
                    operand2 = Double.NaN;
                    result.setText(null);
                    digit.setText(null);
                }
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operand1 = Double.NaN;
                operand2 = Double.NaN;


                result.setText(null);
                digit.setText(null);

            }
        });
        btnSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CURRENT_ACTION = SINE;
                compute();
                result.setText(operand1+"");
            }
        });
        btnCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CURRENT_ACTION = COSINE;
                compute();
                result.setText(operand1+"");
            }
        });
        btnTan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CURRENT_ACTION = TANGENT;
                compute();
                result.setText(operand1+"");
            }
        });
        btnACos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CURRENT_ACTION = ACOSINE;
                compute();
                result.setText(operand1+"");
            }
        });
        btnASin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CURRENT_ACTION = ASINE;
                compute();
                result.setText(operand1+"");
            }
        });
        btnATan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CURRENT_ACTION = ATANGENT;
                compute();
                result.setText(operand1+"");
            }
        });
        btnExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                CURRENT_ACTION = EXPONENTIAL;

                result.setText(operand1+"");
            }
        });
        btnFactorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CURRENT_ACTION = FACTORIAL;
                compute();
                result.setText(operand1+"");
            }
        });
        btnNextPrime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CURRENT_ACTION = NEXTPRIME;
                compute();
                result.setText(operand1+"");
            }
        });
    }

    private void compute() {
        if (!Double.isNaN(operand1)) {
            operand2 = Double.parseDouble(digit.getText().toString());
            if (CURRENT_ACTION == ADDITION) {
                operand1 = this.operand1 + operand2;
            } else if (CURRENT_ACTION == SUBTRACTION){
                operand1 = this.operand1 - operand2;
            } else if (CURRENT_ACTION == MULTIPLICATION){
                operand1 = this.operand1 * operand2;
            } else if(CURRENT_ACTION ==DIVISION) {
                operand1 = this.operand1 / operand2;
            } else if(CURRENT_ACTION == EXPONENTIAL){
                operand1 = Math.pow(operand1,operand2);
            }
        } else {
            try {
                operand1 = Double.parseDouble(result.getText().toString());
                if(CURRENT_ACTION==SINE) {
                    operand1 = Math.sin(operand1*Math.PI/180);
                } else if (CURRENT_ACTION == COSINE){
                    operand1 = Math.cos(operand1*Math.PI/180);
                } else if (CURRENT_ACTION == TANGENT){
                    operand1 = Math.tan(operand1*Math.PI/180);
                } else if(CURRENT_ACTION == ACOSINE){
                    operand1 = Math.acos(operand1)*180/Math.PI;
                } else if(CURRENT_ACTION == ASINE){
                    operand1 = Math.asin(operand1)*180/Math.PI;
                } else if(CURRENT_ACTION == ATANGENT){
                    operand1 = Math.atan(operand1)*180/Math.PI;
                } else if(CURRENT_ACTION == FACTORIAL) {
                    operand1 = factorial(operand1);
                }
            } catch (Exception e){}
        }
    }

    private double factorial(double b){
        if(b==0){
            return 1;
        } else {
            return b*factorial(b-1);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
