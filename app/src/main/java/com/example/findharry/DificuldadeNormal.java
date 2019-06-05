package com.example.findharry;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Arrays;
import java.util.Collections;

public class DificuldadeNormal extends AppCompatActivity {


    private SQLiteDatabase bancoDados;

    String jogador;

    TextView tv_p1, txtPontuacao;

    ImageView iv_11, iv_12, iv_13, iv_14, iv_21, iv_22, iv_23, iv_24, iv_31, iv_32, iv_33, iv_34, iv_41, iv_42, iv_43, iv_44;

    //Array das imagens
    Integer[] cartasArray = {101,102,103,104,105,106,107,108,201,202,203,204,205,206,207,208};

    //Imagens Atuais
    int image101, image102, image103, image104, image105, image106, image107, image108,
        image201, image202, image203, image204, image205, image206, image207, image208;

    int primeiraCarta, segundaCarta;
    int primeiroClique, segundoClique;
    int numeroCarta = 1;

    int turno = 1;
    int pontosJogador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_dificuldade_normal);

        //Banco dados
        bancoDados = openOrCreateDatabase("appclassificacao", MODE_PRIVATE, null);

        //tabela classificacao
        bancoDados.execSQL("CREATE TABLE IF NOT EXISTS classificacoes_normal (id INTEGER PRIMARY KEY AUTOINCREMENT, nickname VARCHAR, pontuacao VARCHAR) ");

        tv_p1 = (TextView) findViewById(R.id.edtPontuacao);
        txtPontuacao = (TextView) findViewById(R.id.txtPontuacao);

        iv_11 = (ImageView) findViewById(R.id.iv_11);
        iv_12 = (ImageView) findViewById(R.id.iv_12);
        iv_13 = (ImageView) findViewById(R.id.iv_13);
        iv_14 = (ImageView) findViewById(R.id.iv_14);
        iv_21 = (ImageView) findViewById(R.id.iv_21);
        iv_22 = (ImageView) findViewById(R.id.iv_22);
        iv_23 = (ImageView) findViewById(R.id.iv_23);
        iv_24 = (ImageView) findViewById(R.id.iv_24);
        iv_31 = (ImageView) findViewById(R.id.iv_31);
        iv_32 = (ImageView) findViewById(R.id.iv_32);
        iv_33 = (ImageView) findViewById(R.id.iv_33);
        iv_34 = (ImageView) findViewById(R.id.iv_34);
        iv_41 = (ImageView) findViewById(R.id.iv_41);
        iv_42 = (ImageView) findViewById(R.id.iv_42);
        iv_43 = (ImageView) findViewById(R.id.iv_43);
        iv_44 = (ImageView) findViewById(R.id.iv_44);

        iv_11.setTag("0");
        iv_12.setTag("1");
        iv_13.setTag("2");
        iv_14.setTag("3");
        iv_21.setTag("4");
        iv_22.setTag("5");
        iv_23.setTag("6");
        iv_24.setTag("7");
        iv_31.setTag("8");
        iv_32.setTag("9");
        iv_33.setTag("10");
        iv_34.setTag("11");
        iv_41.setTag("12");
        iv_42.setTag("13");
        iv_43.setTag("14");
        iv_44.setTag("15");

        // preciso de um Bundle para receber os dados da activity anterior
        Bundle extras = getIntent().getExtras();
        // Se há extras, usa o valor para preencher campo de edição
        if (extras != null) {
            txtPontuacao.setText(extras.getString("Nickname"));
        }

        jogador = txtPontuacao.toString();

        //Carregar imagens
        frontOfCardsResources();

        Collections.shuffle(Arrays.asList(cartasArray));

        iv_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Carta = Integer.parseInt((String) v.getTag());
                doStuff(iv_11, Carta);
            }
        });

        iv_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Carta = Integer.parseInt((String) v.getTag());
                doStuff(iv_12, Carta);
            }
        });

        iv_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Carta = Integer.parseInt((String) v.getTag());
                doStuff(iv_13, Carta);
            }
        });

        iv_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Carta = Integer.parseInt((String) v.getTag());
                doStuff(iv_14, Carta);
            }
        });

        iv_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Carta = Integer.parseInt((String) v.getTag());
                doStuff(iv_21, Carta);
            }
        });

        iv_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Carta = Integer.parseInt((String) v.getTag());
                doStuff(iv_22, Carta);
            }
        });

        iv_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Carta = Integer.parseInt((String) v.getTag());
                doStuff(iv_23, Carta);
            }
        });

        iv_24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Carta = Integer.parseInt((String) v.getTag());
                doStuff(iv_24, Carta);
            }
        });

        iv_31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Carta = Integer.parseInt((String) v.getTag());
                doStuff(iv_31, Carta);
            }
        });

        iv_32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Carta = Integer.parseInt((String) v.getTag());
                doStuff(iv_32, Carta);
            }
        });

        iv_33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Carta = Integer.parseInt((String) v.getTag());
                doStuff(iv_33, Carta);
            }
        });

        iv_34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Carta = Integer.parseInt((String) v.getTag());
                doStuff(iv_34, Carta);
            }
        });

        iv_41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Carta = Integer.parseInt((String) v.getTag());
                doStuff(iv_41, Carta);
            }
        });

        iv_42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Carta = Integer.parseInt((String) v.getTag());
                doStuff(iv_42, Carta);
            }
        });

        iv_43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Carta = Integer.parseInt((String) v.getTag());
                doStuff(iv_43, Carta);
            }
        });

        iv_44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Carta = Integer.parseInt((String) v.getTag());
                doStuff(iv_44, Carta);
            }
        });

    }

    private void doStuff(ImageView iv, int carta){
        // Setar a imagem correta para o imageview
        if(cartasArray[carta] == 101){
            iv.setImageResource(image101);
        }else if(cartasArray[carta] == 102){
            iv.setImageResource(image102);
        }else if(cartasArray[carta] == 103){
            iv.setImageResource(image103);
        }else if(cartasArray[carta] == 104){
            iv.setImageResource(image104);
        }else if(cartasArray[carta] == 105){
            iv.setImageResource(image105);
        }else if(cartasArray[carta] == 106){
            iv.setImageResource(image106);
        }else if(cartasArray[carta] == 107){
            iv.setImageResource(image107);
        }else if(cartasArray[carta] == 108){
            iv.setImageResource(image108);
        }else if(cartasArray[carta] == 201){
            iv.setImageResource(image201);
        }else if(cartasArray[carta] == 202){
            iv.setImageResource(image202);
        }else if(cartasArray[carta] == 203){
            iv.setImageResource(image203);
        }else if(cartasArray[carta] == 204){
            iv.setImageResource(image204);
        }else if(cartasArray[carta] == 205){
            iv.setImageResource(image205);
        }else if(cartasArray[carta] == 206) {
            iv.setImageResource(image206);
        }else if(cartasArray[carta] == 207){
            iv.setImageResource(image207);
        }else if(cartasArray[carta] == 208){
            iv.setImageResource(image208);
        }

        // Verifica qual imagem foi selecionada e salva em uma variável temporária
        if(numeroCarta == 1){
            primeiraCarta = cartasArray[carta];
            if(primeiraCarta> 200){
                primeiraCarta = primeiraCarta - 100;

            }
            numeroCarta = 2;
            primeiroClique = carta;

            iv.setEnabled(false);
        }else if(numeroCarta == 2){
            segundaCarta = cartasArray[carta];
            if(segundaCarta> 200){
                segundaCarta = segundaCarta - 100;
            }
            numeroCarta = 1;
            segundoClique = carta;

            iv_11.setEnabled(false);
            iv_12.setEnabled(false);
            iv_13.setEnabled(false);
            iv_14.setEnabled(false);
            iv_21.setEnabled(false);
            iv_22.setEnabled(false);
            iv_23.setEnabled(false);
            iv_24.setEnabled(false);
            iv_31.setEnabled(false);
            iv_32.setEnabled(false);
            iv_33.setEnabled(false);
            iv_34.setEnabled(false);
            iv_41.setEnabled(false);
            iv_42.setEnabled(false);
            iv_43.setEnabled(false);
            iv_44.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Verifica se as imagens selecionadas são iguais
                    calcutale();
                }
            },1000);
        }
    }

    private void calcutale(){
        // Se as imagens forem iguais adiciona um ponto e ficam visíveis
        if(primeiraCarta == segundaCarta) {
            if (primeiroClique == 0) {
                iv_11.setVisibility(View.INVISIBLE);
            } else if (primeiroClique == 1) {
                iv_12.setVisibility(View.INVISIBLE);
            } else if (primeiroClique == 2) {
                iv_13.setVisibility(View.INVISIBLE);
            } else if (primeiroClique == 3) {
                iv_14.setVisibility(View.INVISIBLE);
            } else if (primeiroClique == 4) {
                iv_21.setVisibility(View.INVISIBLE);
            } else if (primeiroClique == 5) {
                iv_22.setVisibility(View.INVISIBLE);
            } else if (primeiroClique == 6) {
                iv_23.setVisibility(View.INVISIBLE);
            } else if (primeiroClique == 7) {
                iv_24.setVisibility(View.INVISIBLE);
            } else if (primeiroClique == 8) {
                iv_31.setVisibility(View.INVISIBLE);
            } else if (primeiroClique == 9) {
                iv_32.setVisibility(View.INVISIBLE);
            } else if (primeiroClique == 10) {
                iv_33.setVisibility(View.INVISIBLE);
            } else if (primeiroClique == 11) {
                iv_34.setVisibility(View.INVISIBLE);
            } else if (primeiroClique == 12) {
                iv_41.setVisibility(View.INVISIBLE);
            } else if (primeiroClique == 13) {
                iv_42.setVisibility(View.INVISIBLE);
            } else if (primeiroClique == 14) {
                iv_43.setVisibility(View.INVISIBLE);
            } else if (primeiroClique == 15) {
                iv_44.setVisibility(View.INVISIBLE);
            }

            if (segundoClique == 0) {
                iv_11.setVisibility(View.INVISIBLE);
            } else if (segundoClique == 1) {
                iv_12.setVisibility(View.INVISIBLE);
            } else if (segundoClique == 2) {
                iv_13.setVisibility(View.INVISIBLE);
            } else if (segundoClique == 3) {
                iv_14.setVisibility(View.INVISIBLE);
            } else if (segundoClique == 4) {
                iv_21.setVisibility(View.INVISIBLE);
            } else if (segundoClique == 5) {
                iv_22.setVisibility(View.INVISIBLE);
            } else if (segundoClique == 6) {
                iv_23.setVisibility(View.INVISIBLE);
            } else if (segundoClique == 7) {
                iv_24.setVisibility(View.INVISIBLE);
            } else if (segundoClique == 8) {
                iv_31.setVisibility(View.INVISIBLE);
            } else if (segundoClique == 9) {
                iv_32.setVisibility(View.INVISIBLE);
            } else if (segundoClique == 10) {
                iv_33.setVisibility(View.INVISIBLE);
            } else if (segundoClique == 11) {
                iv_34.setVisibility(View.INVISIBLE);
            } else if (segundoClique == 12) {
                iv_41.setVisibility(View.INVISIBLE);
            } else if (segundoClique == 13) {
                iv_42.setVisibility(View.INVISIBLE);
            } else if (segundoClique == 14) {
                iv_43.setVisibility(View.INVISIBLE);
            } else if (segundoClique == 15) {
                iv_44.setVisibility(View.INVISIBLE);
            }

            //Adiciona pontos ao jogador correto
            if (turno == 1) {
                pontosJogador = pontosJogador + 100;
                tv_p1.setText("Pontuação: " + pontosJogador);
            }

        }else{
            iv_11.setImageResource(R.drawable.background);
            iv_12.setImageResource(R.drawable.background);
            iv_13.setImageResource(R.drawable.background);
            iv_14.setImageResource(R.drawable.background);
            iv_21.setImageResource(R.drawable.background);
            iv_22.setImageResource(R.drawable.background);
            iv_23.setImageResource(R.drawable.background);
            iv_24.setImageResource(R.drawable.background);
            iv_31.setImageResource(R.drawable.background);
            iv_32.setImageResource(R.drawable.background);
            iv_33.setImageResource(R.drawable.background);
            iv_34.setImageResource(R.drawable.background);
            iv_41.setImageResource(R.drawable.background);
            iv_42.setImageResource(R.drawable.background);
            iv_43.setImageResource(R.drawable.background);
            iv_44.setImageResource(R.drawable.background);

            pontosJogador = pontosJogador - 30;
            tv_p1.setText("Pontuação: " + pontosJogador);

        }

        iv_11.setEnabled(true);
        iv_12.setEnabled(true);
        iv_13.setEnabled(true);
        iv_14.setEnabled(true);
        iv_21.setEnabled(true);
        iv_22.setEnabled(true);
        iv_23.setEnabled(true);
        iv_24.setEnabled(true);
        iv_31.setEnabled(true);
        iv_32.setEnabled(true);
        iv_33.setEnabled(true);
        iv_34.setEnabled(true);
        iv_41.setEnabled(true);
        iv_42.setEnabled(true);
        iv_43.setEnabled(true);
        iv_44.setEnabled(true);

        verificaFim();

    }

    private void verificaFim(){
        if(iv_11.getVisibility() == View.INVISIBLE &&
                iv_12.getVisibility() == View.INVISIBLE &&
                iv_13.getVisibility() == View.INVISIBLE &&
                iv_14.getVisibility() == View.INVISIBLE &&
                iv_21.getVisibility() == View.INVISIBLE &&
                iv_22.getVisibility() == View.INVISIBLE &&
                iv_23.getVisibility() == View.INVISIBLE &&
                iv_24.getVisibility() == View.INVISIBLE &&
                iv_31.getVisibility() == View.INVISIBLE &&
                iv_32.getVisibility() == View.INVISIBLE &&
                iv_33.getVisibility() == View.INVISIBLE &&
                iv_34.getVisibility() == View.INVISIBLE &&
                iv_41.getVisibility() == View.INVISIBLE &&
                iv_42.getVisibility() == View.INVISIBLE &&
                iv_43.getVisibility() == View.INVISIBLE &&
                iv_44.getVisibility() == View.INVISIBLE){

            String jogador = txtPontuacao.getText().toString();
            String pontos_jogador = tv_p1.getText().toString();
            salvarClassificacao(jogador, pontos_jogador);

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(DificuldadeNormal.this);
            alertDialogBuilder
                    .setMessage("Fim de Jogo!\nVocê fez : " + pontosJogador + " pontos.")
                    .setCancelable(false)
                    .setPositiveButton("Voltar ao menu!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    });
        }
    }

    private void salvarClassificacao(String nome, String pontos){

        try{
            bancoDados.execSQL("INSERT INTO classificacoes_normal (nickname, pontuacao) VALUES ('"+nome+"','"+pontos+"')");
            //Toast.makeText(DificuldadeNormal.this, "Classificacao salva com sucesso!", Toast.LENGTH_SHORT).show();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void frontOfCardsResources(){
        image101  = R.drawable.carta_1;
        image102  = R.drawable.carta_2;
        image103  = R.drawable.carta_3;
        image104  = R.drawable.carta_4;
        image105  = R.drawable.carta_5;
        image106  = R.drawable.carta_6;
        image107  = R.drawable.carta_7;
        image108  = R.drawable.carta_8;
        image201 = R.drawable.carta_1p;
        image202 = R.drawable.carta_2p;
        image203 = R.drawable.carta_3p;
        image204 = R.drawable.carta_4p;
        image205 = R.drawable.carta_5p;
        image206 = R.drawable.carta_6p;
        image207 = R.drawable.carta_7p;
        image208 = R.drawable.carta_8p;

    }

}