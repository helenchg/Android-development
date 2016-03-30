package edu.rosehulman.chonge.scorecalculatorprep;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int cPoints = 0;
    int sPoints =0;
    int totalPoints = 0;
    int nearPoint =0;
    int farPoint = 0;
    int homePoint = 0;
    int dPoints =0;
    private EditText nearBall;
    private EditText farBall;
    private EditText robotHome;
    private TextView nearText;
    private TextView farText;
    private TextView homeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                /* Initilizing views */
        nearText = (TextView) findViewById(R.id.textView_point1);
        nearBall = (EditText) findViewById(R.id.editText1);
        farBall = (EditText) findViewById(R.id.editText2);
        farText = (TextView) findViewById(R.id.textView_point2);
        robotHome = (EditText) findViewById(R.id.editText3);
        homeText = (TextView) findViewById(R.id.textView_point3);

        /* Set Text Watcher Listener */
        nearBall.addTextChangedListener(nearWatcher);
        farBall.addTextChangedListener(farWatcher);
        robotHome.addTextChangedListener(robotHomeWatcher);

    }

    private final TextWatcher nearWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s.length() == 0) {
                nearText.setVisibility(View.VISIBLE);
                nearText.setText("0");
                nearPoint = 0;

            } else {
                int nearBallInt = Integer.parseInt(nearBall.getText().toString());
                if (nearBallInt > 45){
                    nearPoint =0;
                }
                else if (nearBallInt > 30 && nearBallInt <= 45){
                    nearPoint =10;
                }
                else if (nearBallInt > 20 && nearBallInt <= 30){
                    nearPoint =50;
                }
                else if (nearBallInt > 10 && nearBallInt <= 20){
                    nearPoint =80;
                }
                else if (nearBallInt > 5 && nearBallInt <= 10){
                    nearPoint =100;
                }
                else if (nearBallInt <= 5){
                    nearPoint =110;
                }
                nearText.setText(nearPoint + "");
            }
            updateTotal();
        }
    };
    private final TextWatcher farWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s.length() == 0) {
                farText.setVisibility(View.VISIBLE);
                farText.setText("0");
                farPoint = 0;

            } else {
                int farBallInt = Integer.parseInt(farBall.getText().toString());
                if (farBallInt > 45){
                    farPoint =0;
                }
                else if (farBallInt > 30 && farBallInt <= 45){
                    farPoint =20;
                }
                else if (farBallInt > 20 && farBallInt <= 30){
                    farPoint =100;
                }
                else if (farBallInt > 10 && farBallInt <= 20){
                    farPoint =160;
                }
                else if (farBallInt > 5 && farBallInt <= 10){
                    farPoint =200;
                }
                else if (farBallInt <= 5){
                    farPoint =220;
                }
                farText.setText(farPoint + "");
            }
            updateTotal();
        }
    };
    private final TextWatcher robotHomeWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s.length() == 0) {
                homeText.setVisibility(View.VISIBLE);
                homeText.setText("0");
                homePoint = 0;
            } else {
                int robotHomeInt = Integer.parseInt(robotHome.getText().toString());
                if (robotHomeInt > 45){
                    homePoint =0;
                }
                else if (robotHomeInt > 30 && robotHomeInt <= 45){
                    homePoint =10;
                }
                else if (robotHomeInt > 20 && robotHomeInt <= 30){
                    homePoint =50;
                }
                else if (robotHomeInt > 10 && robotHomeInt <= 20){
                    homePoint =80;
                }
                else if (robotHomeInt> 5 && robotHomeInt <= 10){
                    homePoint =100;
                }
                else if (robotHomeInt <= 5){
                    homePoint =110;
                }
                homeText.setText(homePoint +"");
            }
            updateTotal();
        }
    };

    public void onCheckboxClicked(View view){
//         Is the view now checked?
        boolean checked = ((CheckBox)view).isChecked();
        final TextView colorPoints = (TextView) findViewById(R.id.textView_colorPoints);
//        Check which checkbox was clicked
        switch (view.getId()){
            case R.id.checkbox_3fixes:
                if(checked){
                    colorPoints.setText(cPoints + " color points");
                    cPoints = 0;
                }
                else {
                    cPoints = 0;
                    colorPoints.setText(cPoints + " color points");
                }
                break;
            case R.id.checkbox_2fixes:
                if(checked){
                    cPoints = 25;
                    colorPoints.setText(cPoints + " color points");
                }
                else {
                    cPoints = 0;
                    colorPoints.setText(cPoints + " color points");
                }                break;
            case R.id.checkbox_1fix:
                if(checked){
                    cPoints = 75;
                    colorPoints.setText(cPoints + " color points");
                }
                else {
                    cPoints = 0;
                    colorPoints.setText(cPoints + " color points");
                }                break;
            case R.id.checkbox_0fixes:
                if(checked){
                    cPoints = 150;
                    colorPoints.setText(cPoints + " color points");
                }
                else {
                    cPoints = 0;
                    colorPoints.setText(cPoints + " color points");
                }                break;
        }
        updateTotal();
    }

    public void onSwitch(View view){
        final TextView wbPoints = (TextView) findViewById(R.id.textView_wbPoints);
        boolean checked = ((Switch)view).isChecked();
        Switch switched = (Switch) findViewById(R.id.switch1);
        if (checked){
            sPoints = 60;
            wbPoints.setText(sPoints + " wb points");
        }
        else{
            sPoints = 0;
            wbPoints.setText(sPoints + "  wb points");
        }
        updateTotal();
    }

    public void updateTotal(){
        TextView total = (TextView) findViewById(R.id.textView_points);
        dPoints = farPoint + nearPoint + homePoint;
        totalPoints = cPoints + sPoints + dPoints;
        total.setText(totalPoints + " points");
    }

    public void onClickedButton(View view){
        Intent i = new Intent(this, MainActivity.class); //change it to your main class
        //the following 2 tags are for clearing the backStack and start fresh
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        finish();
        startActivity(i);
    }
}
