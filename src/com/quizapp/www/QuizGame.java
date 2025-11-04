package com.quizapp.www;
import java.util.Scanner;

class Question {
    String question;
    String[] options;
    int correctAnswer; // 1-based index for answer

    public Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}

public class QuizGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define questions
        Question[] questions = {
            new Question("Which language is used to develop Android Apps?",
                    new String[]{"A. Python", "B. Kotlin", "C. Swift", "D. Ruby"}, 2),

            new Question("Which company developed Java?",
                    new String[]{"A. Microsoft", "B. Apple", "C. Sun Microsystems", "D. Google"}, 3),

            new Question("What is the extension of Java bytecode files?",
                    new String[]{"A. .java", "B. .class", "C. .jar", "D. .exe"}, 2),

            new Question("Which keyword is used to inherit a class in Java?",
                    new String[]{"A. implement", "B. extends", "C. import", "D. inherit"}, 2),

            new Question("Which method is the entry point of any Java program?",
                    new String[]{"A. start()", "B. main()", "C. run()", "D. init()"}, 2)
        };

        int score = 0;
        System.out.println("==========  Welcome to the Java Quiz Game ==========");

        // Loop through questions
        for (int i = 0; i < questions.length; i++) {
            Question q = questions[i];
            System.out.println("\nQ" + (i + 1) + ". " + q.question);
            for (String opt : q.options) {
                System.out.println(opt);
            }

            System.out.print("Enter your answer (1-4): ");
            int answer = getValidInt(scanner);

            if (answer == q.correctAnswer) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println(" Wrong! The correct answer was " + q.options[q.correctAnswer - 1]);
            }
        }

        System.out.println("\n========== Quiz Over ==========");
        System.out.println("Your Score: " + score + " / " + questions.length);

        if (score == questions.length)
            System.out.println(" Excellent! You’re a Java Master!");
        else if (score >= 3)
            System.out.println(" Good Job! Keep Learning!");
        else
            System.out.println("Keep Practicing to Improve!");
        
        scanner.close();
    }

    private static int getValidInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number (1-4): ");
            scanner.next();
        }
        int num = scanner.nextInt();
        while (num < 1 || num > 4) {
            System.out.print("Enter a number between 1 and 4: ");
            num = scanner.nextInt();
        }
        return num;
    }
}
