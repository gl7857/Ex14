package com.example.ex14;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class second_activity extends AppCompatActivity {
    TextView agbara1, agbara2, agbara3, level1, level2, level3;
    RadioGroup radioGroup;
    RadioButton option1, option2, option3;
    EditText agbaraGrade1, agbaraGrade2, agbaraGrade3, edtMathGrade, edtEnglishGrade, edtEnglishLevel,
            edtMathLevel;
    Intent intentToResult, intentBack;
    int mathGrade=-1, mathLevel, englishGrade, englishLevel, grade1, grade2, grade3, selectedOption=0;
    String mathGradeStr, mathLevelStr, englishGradeStr, englishLevelStr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        intentToResult = new Intent(second_activity.this, result.class);
        initViews();
        intentBack = getIntent();
        setScreenParams();
    }

    public void setScreenParams(){
        mathGrade = intentBack.getIntExtra("mathGrade", -1);
        if(mathGrade>-1) {
            edtMathGrade.setText(String.valueOf(mathGrade));
        }
        mathLevel = intentBack.getIntExtra("mathLevel", -1);
        if(mathLevel>-1){
            edtMathLevel.setText(String.valueOf(mathLevel));
        }
        englishGrade = intentBack.getIntExtra("englishGrade", -1);
        if(englishGrade>-1) {
            edtEnglishGrade.setText(String.valueOf(englishGrade));
        }
        englishLevel = intentBack.getIntExtra("englishLevel", -1);
        if(englishLevel>-1){
            edtEnglishLevel.setText(String.valueOf(englishLevel));
        }
        selectedOption = intentBack.getIntExtra("selectedOption", 0);
        if(selectedOption>0){
            if(selectedOption==1){
                option1.setChecked(true);
                clickedOption1(null);
                String agbara1Name = intentBack.getStringExtra("agbara1");
                String agbara2Name = intentBack.getStringExtra("agbara2");
                grade1 = intentBack.getIntExtra("grade1", -1);
                grade2 = intentBack.getIntExtra("grade2", -1);
                if(!agbara1Name.isEmpty()){
                    agbara1.setText(agbara1Name);
                }
                if(!agbara2Name.isEmpty()){
                    agbara2.setText(agbara2Name);
                }
                level1.setText("1");
                level2.setText("5");
                if(grade1>-1){
                    agbaraGrade1.setText(String.valueOf(grade1));
                }
                if(grade2>-1){
                    agbaraGrade2.setText(String.valueOf(grade2));
                }
            }
            if(selectedOption==2){
                option2.setChecked(true);
                clickedOption2(null);
                String agbara1Name = intentBack.getStringExtra("agbara1");
                String agbara2Name = intentBack.getStringExtra("agbara2");
                grade1 = intentBack.getIntExtra("grade1", -1);
                grade2 = intentBack.getIntExtra("grade2", -1);
                if(!agbara1Name.isEmpty()){
                    agbara1.setText(agbara1Name);
                }
                if(!agbara2Name.isEmpty()){
                    agbara2.setText(agbara2Name);
                }
                level1.setText("5");
                level2.setText("5");
                if(grade1>-1){
                    agbaraGrade1.setText(String.valueOf(grade1));
                }
                if(grade2>-1){
                    agbaraGrade2.setText(String.valueOf(grade2));
                }
            }
            if(selectedOption==3){
                option3.setChecked(true);
                clickedOption3(null);
                String agbara1Name = intentBack.getStringExtra("agbara1");
                String agbara2Name = intentBack.getStringExtra("agbara2");
                String agbara3Name = intentBack.getStringExtra("agbara3");
                grade1 = intentBack.getIntExtra("grade1", -1);
                grade2 = intentBack.getIntExtra("grade2", -1);
                grade3 = intentBack.getIntExtra("grade3", -1);
                if(!agbara1Name.isEmpty()){
                    agbara1.setText(agbara1Name);
                }
                if(!agbara2Name.isEmpty()){
                    agbara2.setText(agbara2Name);
                }
                if(!agbara3Name.isEmpty()){
                    agbara3.setText(agbara3Name);
                }

                level1.setText("5");
                level2.setText("5");
                level3.setText("5");

                if(grade1>-1){
                    agbaraGrade1.setText(String.valueOf(grade1));
                }
                if(grade2>-1){
                    agbaraGrade2.setText(String.valueOf(grade2));
                }
                if(grade3>-1){
                    agbaraGrade3.setText(String.valueOf(grade3));
                }
            }
        }

    }
    public void clearSelection(){
        agbara1.setVisibility(View.INVISIBLE);
        agbara2.setVisibility(View.INVISIBLE);
        agbara3.setVisibility(View.INVISIBLE);
        agbaraGrade1.setVisibility(View.INVISIBLE);
        agbaraGrade2.setVisibility(View.INVISIBLE);
        agbaraGrade3.setVisibility(View.INVISIBLE);
        level1.setVisibility(View.INVISIBLE);
        level2.setVisibility(View.INVISIBLE);
        level3.setVisibility(View.INVISIBLE);
        agbara1.setText("");
        agbara2.setText("");
        agbara3.setText("");
        level1.setText("");
        level2.setText("");
        level3.setText("");
        agbaraGrade1.setText("");
        agbaraGrade2.setText("");
        agbaraGrade3.setText("");

        grade1=0;
        grade2=0;
        grade3=0;
    }

    public void clickedOption1(View view) {
        clearSelection();
        selectedOption=1;
        agbara1.setVisibility(View.VISIBLE);
        agbara2.setVisibility(View.VISIBLE);
        agbaraGrade1.setVisibility(View.VISIBLE);
        agbaraGrade2.setVisibility(View.VISIBLE);
        level1.setVisibility(View.VISIBLE);
        level2.setVisibility(View.VISIBLE);
        agbara1.setText("Intro to Science");
        agbara2.setText(agbara2.getText().toString());
        level1.setText("1");
        level2.setText("5");
    }

    public void clickedOption2(View view) {
        clearSelection();
        selectedOption = 2;
        agbara1.setVisibility(View.VISIBLE);
        agbara2.setVisibility(View.VISIBLE);
        agbaraGrade1.setVisibility(View.VISIBLE);
        agbaraGrade2.setVisibility(View.VISIBLE);
        level1.setVisibility(View.VISIBLE);
        level2.setVisibility(View.VISIBLE);
        agbara1.setText(agbara1.getText().toString());
        agbara2.setText(agbara2.getText().toString());
        level1.setText("5");
        level2.setText("5");
    }


    public void clickedOption3(View view) {
        clearSelection();
        selectedOption=3;
        agbara1.setVisibility(View.VISIBLE);
        agbara2.setVisibility(View.VISIBLE);
        agbara3.setVisibility(View.VISIBLE);
        agbaraGrade1.setVisibility(View.VISIBLE);
        agbaraGrade2.setVisibility(View.VISIBLE);
        agbaraGrade3.setVisibility(View.VISIBLE);
        level1.setVisibility(View.VISIBLE);
        level2.setVisibility(View.VISIBLE);
        level3.setVisibility(View.VISIBLE);
        agbara1.setText(agbara1.getText().toString());
        agbara2.setText(agbara2.getText().toString());
        agbara3.setText(agbara3.getText().toString());
        level1.setText("5");
        level2.setText("5");
        level3.setText("5");
    }

    private void initViews() {
        radioGroup = findViewById(R.id.radioGroup);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        agbara1 = findViewById(R.id.agbara1);
        agbara2 = findViewById(R.id.agbara2);
        agbara3 = findViewById(R.id.agbara3);
        level1 = findViewById(R.id.level1);
        level2 = findViewById(R.id.level2);
        level3 = findViewById(R.id.level3);
        agbaraGrade1 = findViewById(R.id.agbaraGrade1);
        agbaraGrade2 = findViewById(R.id.agbaraGrade2);
        agbaraGrade3 = findViewById(R.id.agbaraGrade3);
        edtMathGrade = findViewById(R.id.mathGrade);
        edtEnglishGrade = findViewById(R.id.englishGrade);
        edtEnglishLevel = findViewById(R.id.englishLevel);
        edtMathLevel = findViewById(R.id.mathLevel);
    }

    public boolean isValidGrade(String grade) {
        return !grade.isEmpty() && !(Integer.parseInt(grade) > 100);
    }


    public boolean isValidLevel(String level) {
        return !level.isEmpty() && !(Integer.parseInt(level) <3 && Integer.parseInt(level)>5);
    }

    public void setGrades() {
        int gradeLang = intentBack.getIntExtra("gradeLang",-1);
        int gradeLitr = intentBack.getIntExtra("gradeLitr",-1);
        int gradeHist = intentBack.getIntExtra("gradeHist",-1);
        int gradeCitz = intentBack.getIntExtra("gradeCitz",-1);
        int gradeBible = intentBack.getIntExtra("gradeBible",-1);
        intentToResult.putExtra("gradeLang", gradeLang);
        intentToResult.putExtra("gradeLitr", gradeLitr);
        intentToResult.putExtra("gradeHist", gradeHist);
        intentToResult.putExtra("gradeCitz", gradeCitz);
        intentToResult.putExtra("gradeBible", gradeBible);



        if (!isValidLevel(edtEnglishLevel.getText().toString()) ||
                !isValidLevel(edtMathLevel.getText().toString()) ||
                !isValidGrade(edtMathGrade.getText().toString()) ||
                !isValidGrade(edtEnglishGrade.getText().toString())) {
            Toast.makeText(this, "Wrong input", Toast.LENGTH_SHORT).show();
            mathGrade = 0;
            mathLevel = 0;
            englishGrade = 0;
            englishLevel = 0;
        } else {
            mathGradeStr = edtMathGrade.getText().toString();
            mathLevelStr = edtMathLevel.getText().toString();
            englishGradeStr = edtEnglishGrade.getText().toString();
            englishLevelStr = edtEnglishLevel.getText().toString();
            mathGrade = Integer.parseInt(mathGradeStr);
            mathLevel = Integer.parseInt(mathLevelStr);
            englishGrade = Integer.parseInt(englishGradeStr);
            englishLevel = Integer.parseInt(englishLevelStr);
            intentToResult.putExtra("mathGrade", mathGrade);
            intentToResult.putExtra("mathLevel", mathLevel);
            intentToResult.putExtra("englishGrade", englishGrade);
            intentToResult.putExtra("englishLevel", englishLevel);
            intentToResult.putExtra("selectedOption", selectedOption);
        }
        if(selectedOption==1){
            if (!isValidGrade(agbaraGrade1.getText().toString()) ||
                    !isValidGrade(agbaraGrade2.getText().toString())) {
                Toast.makeText(this, "Wrong input", Toast.LENGTH_SHORT).show();
                grade1= 0;
                grade2= 0;
            } else {
                String agbaraGrade1Str = agbaraGrade1.getText().toString();
                String agbaraGrade2Str = agbaraGrade2.getText().toString();
                grade1 = Integer.parseInt(agbaraGrade1Str);
                grade2 = Integer.parseInt(agbaraGrade2Str);
                intentToResult.putExtra("agbaraGrade1",grade1 );
                intentToResult.putExtra("agbaraGrade2", grade2);
                intentToResult.putExtra("level1", 1);
                intentToResult.putExtra("level2", 5);
                intentToResult.putExtra("agbaraName1", "Intro to Science");
                intentToResult.putExtra("agbaraName2", agbara2.getText().toString());
            }
        }else if (selectedOption==2){
            if (!isValidGrade(agbaraGrade1.getText().toString()) ||
                    !isValidGrade(agbaraGrade2.getText().toString())) {
                Toast.makeText(this, "Wrong input", Toast.LENGTH_SHORT).show();
                grade1= 0;
                grade2= 0;
            } else {
                String agbaraGrade1Str = agbaraGrade1.getText().toString();
                String agbaraGrade2Str = agbaraGrade2.getText().toString();
                grade1 = Integer.parseInt(agbaraGrade1Str);
                grade2 = Integer.parseInt(agbaraGrade2Str);
                intentToResult.putExtra("agbaraGrade1", grade1);
                intentToResult.putExtra("agbaraGrade2", grade2);
                intentToResult.putExtra("level1", 5);
                intentToResult.putExtra("level2", 5);
                intentToResult.putExtra("agbaraName1", agbara1.getText().toString());
                intentToResult.putExtra("agbaraName2", agbara2.getText().toString());

            }
        }else if (selectedOption==3){
            if (!isValidGrade(agbaraGrade1.getText().toString()) ||
                    !isValidGrade(agbaraGrade2.getText().toString())||
                    !isValidGrade(agbaraGrade3.getText().toString())) {
                Toast.makeText(this, "Wrong input", Toast.LENGTH_SHORT).show();
                grade1= 0;
                grade2= 0;
                grade3= 0;
            } else {
                String agbaraGrade1Str = agbaraGrade1.getText().toString();
                String agbaraGrade2Str = agbaraGrade2.getText().toString();
                String agbaraGrade3Str = agbaraGrade3.getText().toString();
                grade1 = Integer.parseInt(agbaraGrade1Str);
                grade2 = Integer.parseInt(agbaraGrade2Str);
                grade3 = Integer.parseInt(agbaraGrade3Str);
                intentToResult.putExtra("agbaraGrade1", grade1);
                intentToResult.putExtra("agbaraGrade2", grade2);
                intentToResult.putExtra("agbaraGrade3", grade3);
                intentToResult.putExtra("level1", 5);
                intentToResult.putExtra("level2", 5);
                intentToResult.putExtra("level3", 5);
                intentToResult.putExtra("agbaraName1", agbara1.getText().toString());
                intentToResult.putExtra("agbaraName2", agbara2.getText().toString());
                intentToResult.putExtra("agbaraName3", agbara3.getText().toString());

            }
        }
    }

    public void next(View view){
        setGrades();
        startActivity(intentToResult);
    }
    public void prev(View view){
        setGrades();
        setResult(RESULT_OK, intentToResult);
        finish();
    }
}