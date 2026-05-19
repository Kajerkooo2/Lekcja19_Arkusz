package com.example.kolejneformularze;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView questionImage;
    private TextView questionText;
    private RadioGroup radioGroup;
    private RadioButton radioButtonA;
    private RadioButton radioButtonB;
    private RadioButton radioButtonC;
    private Button nextButton;
    private TextView scoreText;

    private List<PytanieZamkniete> pytania;
    private int currentQuestionIndex = 0;
    private int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initializeViews();
        pytania = new ArrayList<>();

        pytania.add(new PytanieZamkniete(
                "Które to schronisko?",
                "zad1",
                "Na Rysiance.",
                "Na Wielkiej Raczy.",
                "Na Wielkiej Rycerzowej.",
                'B'
        ));

        pytania.add(new PytanieZamkniete(
                "Zwierzę na zdjęciu to",
                "zad2",
                "owczarek.",
                "wilk.",
                "kozica.",
                'A'
        ));

        pytania.add(new PytanieZamkniete(
                "W oddali są widoczne",
                "zad3",
                "Himalaje.",
                "Alpy.",
                "Tatry.",
                'C'
        ));

        if (!pytania.isEmpty()) {
            displayQuestion();
        }

        nextButton.setOnClickListener(v -> handleNextQuestion());
    }

    private void initializeViews(){
        questionImage = findViewById(R.id.questionImage);
        questionText = findViewById(R.id.questionText);
        radioGroup = findViewById(R.id.radioGroup);
        radioButtonA = findViewById(R.id.radioButtonA);
        radioButtonB = findViewById(R.id.radioButtonB);
        radioButtonC = findViewById(R.id.radioButtonC);
        nextButton = findViewById(R.id.nextButton);
        scoreText = findViewById(R.id.scoreText);
    }

    private void displayQuestion() {
        PytanieZamkniete currentQuestion = pytania.get(currentQuestionIndex);

        questionText.setText(currentQuestion.getTrescPytania());

        radioButtonA.setText(currentQuestion.getOdpowiedzA());
        radioButtonB.setText(currentQuestion.getOdpowiedzB());
        radioButtonC.setText(currentQuestion.getOdpowiedzC());

        String imageName = currentQuestion.getNazwaPliku();
        int drawableId = getResources().getIdentifier(imageName, "drawable", getPackageName());
        questionImage.setImageResource(drawableId);
    }

    private void handleNextQuestion() {
        int selectedId = radioGroup.getCheckedRadioButtonId();

        if (selectedId == -1) {
            return;
        }

        char selectedAnswer;
        if (selectedId == radioButtonA.getId()) {
            selectedAnswer = 'A';
        } else if (selectedId == radioButtonB.getId()) {
            selectedAnswer = 'B';
        } else {
            selectedAnswer = 'C';
        }

        PytanieZamkniete pytanie = pytania.get(currentQuestionIndex);

        if (pytanie.sprawdzOdpowiedz(selectedAnswer)) {
            score++;
        }

        scoreText.setText("Wynik: " + score);
        radioGroup.clearCheck();

        currentQuestionIndex++;

        if (currentQuestionIndex >= pytania.size()) {
            showEndTestAlert();
        } else {
            displayQuestion();
        }
    }

    private void showEndTestAlert() {
        new androidx.appcompat.app.AlertDialog.Builder(this)
                .setTitle("Koniec testu")
                .setMessage("Wynik: " + score + "/" + pytania.size())
                .setPositiveButton("OK", (dialog, which) -> {
                    currentQuestionIndex = 0;
                    score = 0;
                    scoreText.setText("Wynik: 0");
                    radioGroup.clearCheck();
                    displayQuestion();
                })
                .setCancelable(false)
                .show();
    }
}
