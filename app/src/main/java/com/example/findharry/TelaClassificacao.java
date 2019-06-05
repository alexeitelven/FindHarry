package com.example.findharry;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class TelaClassificacao extends AppCompatActivity {

    private SQLiteDatabase bancoDados;

    private ArrayAdapter<String> classificacaoAdaptador_facil;
    private ArrayAdapter<String> classificacaoAdaptador_normal;
    private ArrayAdapter<String> classificacaoAdaptador_dificil;

    private EditText txtNickname;

    //Declaração de Variaveis
    private Spinner spMostraDificuldade;
    private String dificuldade[] = {"Fácil", "Normal", "Difícil"};
    ArrayAdapter<String> array_dificuldade;

    private ArrayList<String> classificacao_facil;
    private ArrayList<String> classificacao_normal;
    private ArrayList<String> classificacao_dificil;
    private ArrayList<Integer> ids;

    private int dificuldadeEscolhida = 1; // 1-easy 2-normal 3-hard

    private ListView listaClassificacao;

    private Button btnEscolheDificuldade;

    private Button btnClassificacaoVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_tela_classificacao);

        inicializa();

        interacoes();

        listaClassificacao = (ListView) findViewById(R.id.ltListaClassificacao);

        //Banco dados
        bancoDados = openOrCreateDatabase("appclassificacao", MODE_PRIVATE, null);

        //tabela tarefas
        bancoDados.execSQL("CREATE TABLE IF NOT EXISTS classificacoes_facil (id INTEGER PRIMARY KEY AUTOINCREMENT, nickname VARCHAR, pontuacao INTEGER, dificuldade VARCHAR) ");
        bancoDados.execSQL("CREATE TABLE IF NOT EXISTS classificacoes_normal (id INTEGER PRIMARY KEY AUTOINCREMENT, nickname VARCHAR, pontuacao INTEGER, dificuldade VARCHAR) ");
        bancoDados.execSQL("CREATE TABLE IF NOT EXISTS classificacoes_dificil (id INTEGER PRIMARY KEY AUTOINCREMENT, nickname VARCHAR, pontuacao INTEGER, dificuldade VARCHAR) ");

    }

    void interacoes(){

        spMostraDificuldade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                switch (spMostraDificuldade.getSelectedItemPosition()) {
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
        btnEscolheDificuldade.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch (dificuldadeEscolhida) {
                    case 1: //easy
                        carrega_classificacoes_facil();
                        break;
                    case 2: //normal
                        carrega_classificacoes_normal();
                        break;
                    case 3: //hard
                        carrega_classificacoes_dificil();
                        break;
                }
            }
        });

        btnClassificacaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    void inicializa() {

        //Spinner
        spMostraDificuldade = (Spinner) findViewById(R.id.spMostraDificuldade);

        //Botoes
        btnEscolheDificuldade = (Button) findViewById(R.id.btnEscolheDifuculdade);

        btnClassificacaoVoltar = (Button) findViewById(R.id.btnClassificacaoVoltar);

        // Forma 1: Fazendo aparecer a lista com strings
        array_dificuldade = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dificuldade);
        spMostraDificuldade.setAdapter(array_dificuldade);

        // preciso de um Bundle para receber os dados da activity anterior
        Bundle extras = getIntent().getExtras();
        // Se há extras, usa o valor para preencher campo de edição
        if (extras != null) {
            txtNickname.setText(extras.getString("Nickname"));
        }
    }

    private void carrega_classificacoes_facil(){
        try{

            //Recuperar as tarefas
            Cursor cursor = bancoDados.rawQuery("SELECT * FROM classificacoes_facil ORDER BY pontuacao DESC", null);

            //recuperar os ids das colunas
            int indiceColunaId = cursor.getColumnIndex("id");
            int indiceColunaNickname = cursor.getColumnIndex("nickname");
            int indiceColunaPontuacao = cursor.getColumnIndex("pontuacao");

            //Criar adaptador
            classificacao_facil = new ArrayList<String>();
            ids = new ArrayList<Integer>();
            classificacaoAdaptador_facil = new ArrayAdapter<String>(getApplicationContext(),
                    android.R.layout.simple_list_item_2,
                    android.R.id.text2,
                    classificacao_facil) {

                @Override
                public View getView(int position, View convertView, ViewGroup parent) {

                    View view = super.getView(position, convertView, parent);
                    TextView text = (TextView) view.findViewById(android.R.id.text2);
                    text.setTextColor(Color.BLACK);
                    return view;

                }
            };
            listaClassificacao.setAdapter( classificacaoAdaptador_facil );

            //listar as tarefas
            cursor.moveToFirst();
            while ( cursor != null ){

                Log.i("Classificacao - ", "Nome: " + cursor.getString( indiceColunaNickname ) + "Pontuacao: " + cursor.getString( indiceColunaPontuacao ));
                classificacao_facil.add((cursor.getPosition() + 1)+ " - "  + cursor.getString(indiceColunaNickname)+" - " + cursor.getString(indiceColunaPontuacao));
                ids.add( Integer.parseInt(cursor.getString(indiceColunaId)) );

                cursor.moveToNext();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void carrega_classificacoes_normal(){
        try{

            //Recuperar as tarefas
            Cursor cursor = bancoDados.rawQuery("SELECT * FROM classificacoes_normal ORDER BY pontuacao DESC", null);

            //recuperar os ids das colunas
            int indiceColunaId = cursor.getColumnIndex("id");
            int indiceColunaNickname = cursor.getColumnIndex("nickname");
            int indiceColunaPontuacao = cursor.getColumnIndex("pontuacao");

            //Criar adaptador
            classificacao_normal = new ArrayList<String>();
            ids = new ArrayList<Integer>();
            classificacaoAdaptador_normal = new ArrayAdapter<String>(getApplicationContext(),
                    android.R.layout.simple_list_item_2,
                    android.R.id.text2,
                    classificacao_normal) {

                @Override
                public View getView(int position, View convertView, ViewGroup parent) {

                    View view = super.getView(position, convertView, parent);
                    TextView text = (TextView) view.findViewById(android.R.id.text2);
                    text.setTextColor(Color.BLACK);
                    return view;

                }
            };
            listaClassificacao.setAdapter( classificacaoAdaptador_normal );

            //listar as tarefas
            cursor.moveToFirst();
            while ( cursor != null ){

                Log.i("Classificacao - ", "Nome: " + cursor.getString( indiceColunaNickname ) + "Pontuacao: " + cursor.getString( indiceColunaPontuacao ));
                classificacao_normal.add((cursor.getPosition() + 1)+ " - "  + cursor.getString(indiceColunaNickname)+" - " + cursor.getString(indiceColunaPontuacao));
                ids.add( Integer.parseInt(cursor.getString(indiceColunaId)) );

                cursor.moveToNext();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void carrega_classificacoes_dificil(){
        try{

            //Recuperar as tarefas
            Cursor cursor = bancoDados.rawQuery("SELECT * FROM classificacoes_dificil ORDER BY pontuacao DESC", null);

            //recuperar os ids das colunas
            int indiceColunaId = cursor.getColumnIndex("id");
            int indiceColunaNickname = cursor.getColumnIndex("nickname");
            int indiceColunaPontuacao = cursor.getColumnIndex("pontuacao");

            //Criar adaptador
            classificacao_dificil = new ArrayList<String>();
            ids = new ArrayList<Integer>();
            classificacaoAdaptador_dificil = new ArrayAdapter<String>(getApplicationContext(),
                    android.R.layout.simple_list_item_2,
                    android.R.id.text2,
                    classificacao_dificil) {

                @Override
                public View getView(int position, View convertView, ViewGroup parent) {

                    View view = super.getView(position, convertView, parent);
                    TextView text = (TextView) view.findViewById(android.R.id.text2);
                    text.setTextColor(Color.BLACK);
                    return view;

                }
            };
            listaClassificacao.setAdapter( classificacaoAdaptador_dificil );

            //listar as tarefas
            cursor.moveToFirst();
            while ( cursor != null ){

                Log.i("Classificacao - ", "Nome: " + cursor.getString( indiceColunaNickname ) + "Pontuacao: " + cursor.getString( indiceColunaPontuacao ));
                classificacao_dificil.add((cursor.getPosition() + 1)+ " - "  + cursor.getString(indiceColunaNickname)+" - " + cursor.getString(indiceColunaPontuacao));
                ids.add( Integer.parseInt(cursor.getString(indiceColunaId)) );

                cursor.moveToNext();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}