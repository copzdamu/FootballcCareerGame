package com.example.footballcareer;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity {
    TextView status;
    Button playMatchBtn, trainBtn;

    Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        status = findViewById(R.id.statusText);
        playMatchBtn = findViewById(R.id.playMatchBtn);
        trainBtn = findViewById(R.id.trainBtn);

        player = new Player("You", 17, 50, 50, 50);

        updateStatus();

        trainBtn.setOnClickListener(v -> {
            player.train();
            updateStatus();
        });

        playMatchBtn.setOnClickListener(v -> {
            player.playMatch();
            updateStatus();
        });
    }

    void updateStatus() {
        String info = "Name: " + player.name +
                "\nAge: " + player.age +
                "\nShooting: " + player.shooting +
                "\nPassing: " + player.passing +
                "\nStamina: " + player.stamina +
                "\nGoals: " + player.goals +
                "\nSeasons: " + player.seasons;
        status.setText(info);
    }

    class Player {
        String name;
        int age, shooting, passing, stamina;
        int goals = 0;
        int seasons = 1;

        Player(String name, int age, int shooting, int passing, int stamina) {
            this.name = name;
            this.age = age;
            this.shooting = shooting;
            this.passing = passing;
            this.stamina = stamina;
        }

        void train() {
            shooting += 1;
            passing += 1;
            stamina += 1;
        }

        void playMatch() {
            int goalChance = shooting + passing + (int)(Math.random() * stamina);
            if (goalChance > 150) {
                goals++;
            }
            stamina -= 5;
            if (stamina < 20) {
                seasons++;
                age++;
                stamina = 50;
            }
        }
    }
      }
