package com.example.lab_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.content.Intent;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String[] countries = { "Швейцарія", "Ямайка", "Данія", "Італія", "Того"};
    ImageView imageView;
    TextView textView;
    Button button1;
    Button button2;
    Button button3;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);
        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getVisibility() == View.VISIBLE) {
                    textView.setVisibility(View.INVISIBLE);
                } else {
                    textView.setVisibility(View.VISIBLE);
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSendMessage(v);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSendMessage1(v);
            }
        });

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = countries[position];

                changeSpinner(item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);
    }

    public void onSendMessage(View view) {
        EditText messageView = (EditText)findViewById(R.id.editTextTextMultiLine);
        String messageText = messageView.getText().toString();
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra(MainActivity2.EXTRA_MESSAGE, messageText);
        startActivity(intent);
    }
    public void onSendMessage1(View view) {
        EditText messageView = (EditText)findViewById(R.id.editTextTextMultiLine);
        String messageText = messageView.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, messageText);
        startActivity(intent);
    }

    @SuppressLint("SetTextI18n")
    private void changeSpinner(String country) {
        View rootLayout = findViewById(android.R.id.content);
        int backgroundResource;

        switch (country) {
            case "Швейцарія":
                backgroundResource = R.drawable.switzerland;
                imageView.setImageResource(R.drawable.fl_switzerland);
                textView.setText("    Коли входиш туди у ранкову зорю,\n" +
                                 "    Я бачу тебе у морі променів,\n" +
                                 "    Тебе, о піднесений, чудовий!\n" +
                                 "    Коли червоніє Альпійський хребет,\n" +
                                 "    Моліться, вільні швейцарці, моліться!\n" +
                                 "    Ваша побожна душа відчуває\n" +
                                 "    Ваша побожна душа відчуває\n" +
                                 "    Бога у священній Батьківщині,\n" +
                                 "    Бога, Господа, у священній Батьківщині.");
                break;
            case "Ямайка":
                backgroundResource = R.drawable.jamaica;
                imageView.setImageResource(R.drawable.fl_jamaica);
                textView.setText("    Eternal Father bless our land\n" +
                                 "    Guard us with Thy mighty hand\n" +
                                 "    Keep us free from evil powers\n" +
                                 "    Be our light through countless hours\n" +
                                 "    To our leaders, Great Defender,\n" +
                                 "    Grant true wisdom from above\n" +
                                 "    Justice, truth be ours forever\n" +
                                 "    Jamaica, land we love\n" +
                                 "    Jamaica, Jamaica, Jamaica, land we love.");
                break;
            case "Данія":
                backgroundResource = R.drawable.denmark;
                imageView.setImageResource(R.drawable.fl_denmark);
                textView.setText("Є чудова земля,\n" +
                        "     Що вільно простягається буками\n" +
                        "     Уздовж солоного східного узбережжя,\n" +
                        "     Уздовж солоного східного узбережжя,\n" +
                        "\n" +
                        "     Переходячи в горбисту місцевість.\n" +
                        "     Її звуть стара Данія.\n" +
                        "     Так, це і є обитель Фрей,\n" +
                        "     Так, це і є обитель Фрей\n");
                break;
            case "Італія":
                backgroundResource = R.drawable.italy;
                imageView.setImageResource(R.drawable.fl_italy);
                textView.setText("Fratelli d’Italia, l’Italia s’è desta, dell’elmo\n" +
                        "di Scipio s’è cinta la testa. Dov’è la vittoria?\n" +
                        "Le porga la chioma, ché schiava di Roma Iddio\n" +
                        "la creò. Stringiamci a coorte, siam pronti\n" +
                        "alla morte. Siam pronti alla morte, l’Italia\n" +
                        "chiamò. Stringiamci a coorte, siam pronti\n" +
                        "alla morte. Siam pronti alla morte, \n" +
                        "l’Italia chiamò!");
                break;
            case "Того":
                backgroundResource = R.drawable.togo;
                imageView.setImageResource(R.drawable.fl_togo);
                textView.setText("    Salut à toi pays de nos aïeux,\n" +
                        "    Toi que les rendait forts,\n" +
                        "    Paisibles et joyeux,\n" +
                        "    Cultivant vertu, vaillance,\n" +
                        "    Pour la prospérité\n" +
                        "    Que viennent les tyrans,\n" +
                        "    Ton cœur soupire vers la liberté,\n" +
                        "    Togo debout, luttons sans défaillance,\n" +
                        "    Vainquons ou mourons, mais dans la dignité,");
                break;
            default:
                backgroundResource = R.drawable.not_found;
                break;
        }
        rootLayout.setBackgroundResource(backgroundResource);
    }
}
