package com.example.kolejneformularze;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
        loadQuestions();

        if (!pytania.isEmpty()) {
            displayQuestion();
        }

        nextButton.setOnClickListener(v -> handleNextQuestion());
    }

    private void initializeViews(){

    }
    private void loadQuestions(){

    }
    private void displayQuestion(){

    }
    private void handleNextQuestion(){

    }
}