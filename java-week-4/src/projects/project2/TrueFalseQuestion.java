package projects.project2;

class TrueFalseQuestion extends Question {
    private boolean correctAnswer;
    
    public TrueFalseQuestion(String text, boolean correctAnswer){
        super(text);
        this.correctAnswer = correctAnswer;

    }
    @Override 
    public void displayQuestion(){
        System.out.println(getQuestion());
        System.out.println("1. True");
        System.out.println("2. False");
    }
    @Override
    public boolean checkAnswer(String answer) {
        if(answer.equals("1") || answer.equalsIgnoreCase("True")) return correctAnswer;
        if (answer.equals("2") || answer.equalsIgnoreCase("False")) return !correctAnswer;

        return false;
    }
}
