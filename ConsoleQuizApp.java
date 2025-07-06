import java.util.*;

class Question {
    private String question;
    private String[] options;
    private int correctAnswerIndex;

    public Question(String question, String[] options, int correctAnswerIndex) {
        this.question = question;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public void display() {
        System.out.println(question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    public boolean isCorrect(int userAnswer) {
        return userAnswer == (correctAnswerIndex + 1);
    }

    public String getCorrectOption() {
        return options[correctAnswerIndex];
    }
}

public class ConsoleQuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Question> questions = new ArrayList<>();

       
        questions.add(new Question("What is the capital of India?", new String[]{"Mumbai", "Chennai", "Delhi", "Kolkata"}, 2));
        questions.add(new Question("Which collection is used to store dynamic lists?", new String[]{"Array", "ArrayList", "HashMap", "LinkedList"}, 1));
        questions.add(new Question("Which keyword is used to create a class in Java?", new String[]{"def", "create", "new", "class"}, 3));
        questions.add(new Question("How do you take input from user in Java?", new String[]{"Scanner", "input()", "cin", "System.read()"}, 0));

        int score = 0;

       
        for (int i = 0; i < questions.size(); i++) {
            System.out.println("\nQuestion " + (i + 1));
            Question q = questions.get(i);
            q.display();

            System.out.print("Your answer (1-4): ");
            int userAnswer = scanner.nextInt();

            if (q.isCorrect(userAnswer)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong. Correct answer: " + q.getCorrectOption());
            }
        }

        System.out.println("\n🎉 Quiz Completed!");
        System.out.println("Your Score: " + score + " out of " + questions.size());
        scanner.close();
    }
}

