package com.example.findharry;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declaração de Variaveis
    private Spinner spDificuldade;
    private String dificuldade[] = {"Fácil", "Normal", "Difícil"};

    ArrayAdapter<String> array_dificuldade;

    private Button btnClassificacao, btnJogar;
    private EditText edtNickname;
    String nickname;

    private int dificuldadeEscolhida = 1; // 1-easy 2-normal 3-hard

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        //Inicializa funcionalidades
        inicializa();
        interacoes();

    }

    void interacoes() {

        spDificuldade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                switch (spDificuldade.getSelectedItemPosition()) {
                    case 0:
                        dificuldadeEscolhida = 1;
                        break;
                    case 1:
                        dificuldadeEscolhida = 2;
                        break;
                    case 2:
                        dificuldadeEscolhida = 3;
                        break;
                }
            }

            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        //Escolhe após escolher a dificuldade
        btnJogar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    if (edtNickname.getText().toString().equals("")) {
                        Toast.makeText(MainActivity.this, "Digite seu nome!", Toast.LENGTH_SHORT).show();
                    } else {
                        switch (dificuldadeEscolhida) {
                            case 1: //easy
                                //Chama Tela
                                Intent activityDificuldadeEasy = new Intent(MainActivity.this, DificuldadeEasy.class);
                                nickname = edtNickname.getText().toString().toUpperCase();
                                activityDificuldadeEasy.putExtra("Nickname", nickname);
                                startActivityForResult(activityDificuldadeEasy, 1);
                                break;
                            case 2: //normal
                                //Chama Tela
                                Intent activityDificuldadeNormal = new Intent(MainActivity.this, DificuldadeNormal.class);
                                nickname = edtNickname.getText().toString().toUpperCase();
                                activityDificuldadeNormal.putExtra("Nickname", nickname);
                                startActivityForResult(activityDificuldadeNormal, 1);
                                break;
                            case 3: //hard
                                //Chama Tela
                                Intent activityDificuldadeHard = new Intent(MainActivity.this, DificuldadeHard.class);
                                nickname = edtNickname.getText().toString().toUpperCase();
                                activityDificuldadeHard.putExtra("Nickname", nickname);
                                startActivityForResult(activityDificuldadeHard, 1);
                                break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        btnClassificacao.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activityClassificacao = new Intent(MainActivity.this, TelaClassificacao.class);
                startActivityForResult(activityClassificacao, 1);
            }
        });

    }

    void inicializa() {

        //Spinner
        spDificuldade = (Spinner) findViewById(R.id.spDificuldade);

        //Botoes
        btnClassificacao = (Button) findViewById(R.id.btnClassificacao);
        btnJogar = (Button) findViewById(R.id.btnJogar);

        //EditText
        edtNickname = (EditText) findViewById(R.id.edtNickname);

        // Forma 1: Fazendo aparecer a lista com strings
        array_dificuldade = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dificuldade);
        spDificuldade.setAdapter(array_dificuldade);

    }
}
