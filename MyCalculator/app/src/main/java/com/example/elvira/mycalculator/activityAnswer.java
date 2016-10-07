package com.example.elvira.mycalculator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



public class activityAnswer extends Activity implements OnClickListener{

Button btOne;
    Button btTwo;
    Button btThree;
    Button btFour;
    Button btFive;
    Button btSix;
    Button btSeven;
    Button btEight;
    Button btNine;
    Button btZero;
    Button btPlus;
    Button btMinus;
    Button btMulti;
    Button btDiv;
    Button btEqual;
    Button btClear;
    Button btPoint;
    Button btSquare;
    Button btRadical;
    Button btBack;

    TextView text1;
    TextView text2;

    double opr1;
    double opr2;

    int flagAction;

    double result;
    String operation = "";

    int degree_before;
    int degree_after;
    int length;

    int[] bt_id;
    Button[] bt_array;

    Boolean plPoint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_answer);


        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);



        bt_id = new int[]{R.id.btOne, R.id.btTwo, R.id.btThree, R.id.btFour, R.id.btFive, R.id.btSix, R.id.btSeven, R.id.btEight, R.id.btNine, R.id.btZero, R.id.btPlus, R.id.btMinus, R.id.btMulti, R.id.btDiv, R.id.btEqual, R.id.btClear, R.id.btPoint, R.id.btSquare, R.id.btRadical, R.id.btBack};
        bt_array = new Button[]{btOne, btTwo, btThree, btFour, btFive, btSix, btSeven, btEight, btNine,btZero, btPlus, btMinus, btMulti, btDiv, btEqual, btClear, btPoint, btSquare, btRadical, btBack};
        length = bt_array.length;
        for(int i = 0; i < length; i++){
            bt_array[i] = (Button) findViewById(bt_id[i]);
            bt_array[i].setOnClickListener(this);
        }

        cleanOpr();
        showNumber(opr1);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.btOne:
                ClickNumber(1);
                break;

            case R.id.btTwo:
                ClickNumber(2);
                break;

            case R.id.btThree:
                ClickNumber(3);
                break;

            case R.id.btFour:
                ClickNumber(4);
                break;

            case R.id.btFive:
                ClickNumber(5);
                break;

            case R.id.btSix:
                ClickNumber(6);
                break;

            case R.id.btSeven:
                ClickNumber(7);
                break;

            case R.id.btEight:
                ClickNumber(8);
                break;

            case R.id.btNine:
                ClickNumber(9);
                break;

            case R.id.btZero:
                ClickNumber(0);
                break;

            case R.id.btPlus:
                operation ="+";
                if(flagAction == 0){
                    flagAction = 1;
                    cleanDegree();
                }
                break;

            case R.id.btMinus:
                operation ="-";
                if(flagAction == 0){
                    flagAction = 2;

                    cleanDegree();
                }
                break;

            case R.id.btMulti:
                operation ="*";
                if(flagAction == 0){
                    flagAction = 3;
                     cleanDegree();
                }
                break;

            case R.id.btDiv:
                operation ="/";
                if(flagAction == 0){
                    flagAction = 4;
                    cleanDegree();
                }
                break;

            case R.id.btPoint:
                plPoint = true;
                break;

            case R.id.btSquare:
                if(flagAction == 0){
                    result = Math.pow(opr1, 2);

                    if(result%1 != 0)degree_after = 2;
                    showNumber(result);

                    cleanOpr();
                }
                else Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();

                break;

            case R.id.btRadical:
                if(flagAction == 0){
                    result = Math.sqrt(opr1);

                    if(result%1 != 0)degree_after = 2;

                    showNumber(result);
                    cleanOpr();
                }
                else Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
                break;

            case R.id.btBack:
                String Temp;
                if(flagAction == 0){
                    if(opr1 %1 == 0 & degree_after == 0)
                        Temp = Integer.toString((int) opr1);
                    else
                        Temp = Double.toString(opr1);

                    Temp = Temp.substring(0, Temp.length()-1);

                    if(Temp.length() > 0)
                        opr1 = Double.parseDouble(Temp);
                    else{
                        opr1 = 0;}
                        showNumber(opr1);
                }
                else{
                    if(opr2 %1 == 0 & degree_after == 0) Temp = Integer.toString((int) opr2);

                    else Temp = Double.toString(opr2);

                    Temp = Temp.substring(0, Temp.length()-1);

                    if(Temp.length() > 0) opr2 = Double.parseDouble(Temp);

                    else opr2 = 0;
                    showNumber(opr2);

                }
                if(degree_after > 0) degree_after--;
                else plPoint = false;

                break;

            case R.id.btEqual:
                operation = "=";

                switch(flagAction){

                    case 1:
                        result = opr1 + opr2;
                        break;

                    case 2:
                        result = opr1 - opr2;
                        break;

                    case 3:
                        result = opr1 * opr2;
                        break;

                    case 4:
                        result = opr1 / opr2;
                        break;

                    default:
                        Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();

                }

                if(result%1 != 0)degree_after = 2;
                if(flagAction != 0){

                    showNumber(result);
                    cleanOpr();

                }
                break;

            case R.id.btClear:

                cleanOpr();
                showNumber(opr1);

                break;

        }
    text2.setText(operation);
    }



    private void ClickNumber(int num){

        if(flagAction == 0) {
            if (plPoint) {
                degree_after++;
                if (degree_after <= 2) {
                    opr1 += num / Math.pow(10, degree_after);
                } else {

                    degree_after = 2;
                    Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
                }
            } else {
                degree_before++;
                if (degree_before <= 8) {
                    opr1 = opr1 * 10 + num;
                } else {
                    degree_before = 8;
                    Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
                }

            }

            showNumber(opr1);
        }
        else{
            if(plPoint){
                 degree_after++;
                if(degree_after <= 2) opr2 += num / Math.pow(10, degree_after);
                else{
                    degree_after = 2;
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
            else{
                degree_before++;
                if(degree_before <= 8){
                    opr2 = opr2 *10 + num;
                }
                else{
                    degree_before = 8;
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                }

            }

            showNumber(opr2);

        }

    }



    private void showNumber(double num){
        String corr = "";
        if(num > Integer.MAX_VALUE){
            text1.setText("ERROR");
            Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
        }
        else{
            if(num%1 == 0 & degree_after == 0){
                text1.setText(Integer.toString((int) num));
            }
            else{
                int part_int = (int) num;
                int part_frac = (int) Math.round(num%1 * Math.pow(10, degree_after));
                if(degree_after == 2 & part_frac < 10) corr = "0";

                text1.setText(part_int + "," + corr + part_frac);
            }
        }
    }
    private void cleanOpr(){
        opr1 = 0;
        opr2 = 0;
        result = 0;
        flagAction = 0;
        cleanDegree();

    }


    private void cleanDegree(){
        degree_before = 0;
        degree_after = 0;
        plPoint = false;

    }


}