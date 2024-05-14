public class GradeDetails {
    String subjectName;
    int grade;
    int level;

    int bonus;
    public GradeDetails(String subjectName, int grade, int level) {
        this.subjectName = subjectName;
        this.grade = grade;
        this.level = level;
        this.bonus = calcBonus();
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getGrade() {
        return grade;
    }

    public int getLevel() {
        return level;
    }

    public int getBonus() {
        return bonus;
    }

    public int calcBonus(){
        if(this.level>=4){
            if(this.subjectName=="math" || this.subjectName=="english"){
                if(this.level==5){
                    return 30;
                }else{
                    return 15;
                }
            }else{
                if(this.level==5){
                    return 20;
                }else{
                    return 10;
                }
            }
        }
        return 0;
    }

    public int calcTotalGrade(){
        return this.grade+this.bonus;
    }

    public int calcGradeByLevel(){
        return calcTotalGrade()*this.level;
    }
}