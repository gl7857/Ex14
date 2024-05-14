package com.example.ex14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class result extends AppCompatActivity {
    Intent parentIntent;
    TextView allAverages1, maxAverage,summaryOfGrades;
    GradeDetails[] mandatoryGrades = new GradeDetails[7];
    GradeDetails[] extraGrades = new GradeDetails[3];

    int gradeLang = -1, gradeLitr = -1, gradeHist = -1, gradeCitz = -1, gradeBible = -1, mathGrade = -1, mathLevel = -1, englishGrade = -1, englishLevel = -1, grade1 = -1, grade2 = -1, grade3 = -1, selectedOption = -1;
    int extraSubjectCounter;
    String gradeOpt1Text, gradeOpt2Text, gradeOpt3Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        parentIntent = getIntent();
        allAverages1 = findViewById(R.id.allAverages);
        maxAverage = findViewById(R.id.maxAverage);
        summaryOfGrades = findViewById(R.id.summaryOfGrades);
        setMandatoryGrades();
        setExtraGrades();
        double[] summaryOfAllAverages = calcAllAverage();
        printAverages(summaryOfAllAverages);
        double max = 0;
        for (int i = 0; i < summaryOfAllAverages.length; i++) {
            if (summaryOfAllAverages[i] > max) {
                max = summaryOfAllAverages[i];
            }
        }
        String strMaxAverage = Double.toString(max);
        maxAverage.setText("\t" + "\t" + strMaxAverage);
        String str1= printMandatoryGradesDetails(mandatoryGrades);
        String str2= printMandatoryGradesDetails(extraGrades);
        String str3 = str1+str2;
        summaryOfGrades.setText(str3);
    }

    public void setMandatoryGrades() {
        gradeLang = parentIntent.getIntExtra("gradeLang", -1);
        mandatoryGrades[0] = new GradeDetails("Language", gradeLang, 2);
        gradeLitr = parentIntent.getIntExtra("gradeLitr", -1);
        mandatoryGrades[1] = new GradeDetails("Litrature", gradeLitr, 2);
        gradeHist = parentIntent.getIntExtra("gradeHist", -1);
        mandatoryGrades[2] = new GradeDetails("History", gradeHist, 2);
        gradeCitz = parentIntent.getIntExtra("gradeCitz", -1);
        mandatoryGrades[3] = new GradeDetails("Citizanship", gradeCitz, 2);
        gradeBible = parentIntent.getIntExtra("gradeBible", -1);
        mandatoryGrades[4] = new GradeDetails("Bible", gradeBible, 2);
        mathGrade = parentIntent.getIntExtra("mathGrade", -1);
        mathLevel = parentIntent.getIntExtra("mathLevel", -1);
        mandatoryGrades[5] = new GradeDetails("Math", mathGrade, mathLevel);
        englishGrade = parentIntent.getIntExtra("englishGrade", -1);
        englishLevel = parentIntent.getIntExtra("englishLevel", -1);
        mandatoryGrades[6] = new GradeDetails("English", englishGrade, englishLevel);

    }

    public void setExtraGrades() {
        grade1 = parentIntent.getIntExtra("agbaraGrade1", -1);
        int level1 = parentIntent.getIntExtra("level1", -1);
        gradeOpt1Text = parentIntent.getStringExtra("agbaraName1");
        extraGrades[0] = new GradeDetails(gradeOpt1Text, grade1, level1);

        grade2 = parentIntent.getIntExtra("agbaraGrade2", -1);
        int level2 = parentIntent.getIntExtra("level2", -1);
        gradeOpt2Text = parentIntent.getStringExtra("agbaraName2");
        extraGrades[1] = new GradeDetails(gradeOpt2Text, grade2, level2);
        extraSubjectCounter = 2;
        grade3 = parentIntent.getIntExtra("agbaraGrade3", -1);
        if (grade3 > -1) {
            extraSubjectCounter = 3;
            int level3 = parentIntent.getIntExtra("level3", -1);
            gradeOpt3Text = parentIntent.getStringExtra("agbaraName3");
            extraGrades[2] = new GradeDetails(gradeOpt3Text, grade3, level3);
        }
    }

    public double calcSingleAvr(int mandatoryGradesSum, int mandatoryLevelsCount, int[] extraGradeIndx) {
        int extraGradesSum = 0;
        int extraLevelsCount = 0;
        double average = -1.0;
        for (int i = 0; i < extraGradeIndx.length; i++) {
            extraGradesSum += extraGrades[extraGradeIndx[i]].calcGradeByLevel();
            extraLevelsCount += extraGrades[extraGradeIndx[i]].getLevel();
        }
        if (extraLevelsCount + mandatoryLevelsCount >= 21) {
            average = (mandatoryGradesSum + extraGradesSum) / (mandatoryLevelsCount + extraLevelsCount);
        }
        return average;
    }

    public double[] calcAllAverage() {
        int mandatoryGradesSum = 0;
        int mandatoryLevelsCount = 0;
        double[] allAverages;
        for (int i = 0; i < mandatoryGrades.length; i++) {
            mandatoryGradesSum += mandatoryGrades[i].calcGradeByLevel();
            mandatoryLevelsCount += mandatoryGrades[i].getLevel();
        }
        if (extraSubjectCounter == 2) {
            allAverages = new double[3];
            int[] gradeIndx = {1, 0};
            allAverages[0] = calcSingleAvr(mandatoryGradesSum, mandatoryLevelsCount, gradeIndx);
            int[] gradeIndx0 = {0};
            allAverages[1] = calcSingleAvr(mandatoryGradesSum, mandatoryLevelsCount, gradeIndx0);
            int[] gradeIndx1 = {1};
            allAverages[2] = calcSingleAvr(mandatoryGradesSum, mandatoryLevelsCount, gradeIndx1);
        } else {
            allAverages = new double[7];
            int[] gradeIndx210 = {2, 1, 0};
            allAverages[0] = calcSingleAvr(mandatoryGradesSum, mandatoryLevelsCount, gradeIndx210);
            int[] gradeIndx10 = {1, 0};
            allAverages[1] = calcSingleAvr(mandatoryGradesSum, mandatoryLevelsCount, gradeIndx10);
            int[] gradeIndx21 = {2, 1};
            allAverages[2] = calcSingleAvr(mandatoryGradesSum, mandatoryLevelsCount, gradeIndx21);
            int[] gradeIndx20 = {2, 0};
            allAverages[3] = calcSingleAvr(mandatoryGradesSum, mandatoryLevelsCount, gradeIndx20);
            int[] gradeIndx0 = {0};
            allAverages[4] = calcSingleAvr(mandatoryGradesSum, mandatoryLevelsCount, gradeIndx0);
            int[] gradeIndx1 = {1};
            allAverages[5] = calcSingleAvr(mandatoryGradesSum, mandatoryLevelsCount, gradeIndx1);
            int[] gradeIndx2 = {2};
            allAverages[6] = calcSingleAvr(mandatoryGradesSum, mandatoryLevelsCount, gradeIndx2);
        }

        return allAverages;
    }


    public void printAverages(double[] allAverages) {
        String strAverages = "";
        for (int i = 0; i < allAverages.length; i++) {
            String strAverage = Double.toString(allAverages[i]);
            strAverages = strAverages + strAverage + "\t"+"\t";
        }
        allAverages1.setText(strAverages);
    }


    public String printMandatoryGradesDetails(GradeDetails[] mandatoryGrades) {
        String summary = "";
        for (int i = 0; i < mandatoryGrades.length; i++) {
            GradeDetails grade = mandatoryGrades[i];
            if (grade != null) { // Check if the GradeDetails object is not null
                String gradeName;
                if (grade.getSubjectName() != null) {
                    gradeName = grade.getSubjectName();
                } else {
                    gradeName = "N/A";
                }
                String gradeValue = String.valueOf(grade.getGrade());
                String gradeLevel = String.valueOf(grade.getLevel());
                String gradeBonus = String.valueOf(grade.getBonus());
                summary += "subject: "+gradeName + "\t" +"grade: "+ gradeValue + "\t" +"units: "+ gradeLevel + "\t" +"bonus: "+ gradeBonus + "\n";
            } else {
                summary += "";
            }
        }
        return summary;
    }

    public void prev(View view){
        finish();
    }
}