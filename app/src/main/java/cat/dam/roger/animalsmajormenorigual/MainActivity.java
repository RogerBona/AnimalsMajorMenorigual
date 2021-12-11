package cat.dam.roger.animalsmajormenorigual;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {


    static ImageView correct;
    static ImageView incorrect;
    static TextView Contador;
    static int resultat;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Imatge correct i incorrect
        correct = (ImageView)findViewById(R.id.correct);
        incorrect = (ImageView)findViewById(R.id.incorrect);

        //Creem l'arraylist
        ArrayList<ImageView> Elefants = new ArrayList<>();
        Elefants.add((ImageView) findViewById(R.id.elefant));
        Elefants.add((ImageView) findViewById(R.id.elefant2));
        Elefants.add((ImageView) findViewById(R.id.elefant3));
        Elefants.add((ImageView) findViewById(R.id.elefant4));
        Elefants.add((ImageView) findViewById(R.id.elefant5));
        Elefants.add((ImageView) findViewById(R.id.elefant6));

        ArrayList<ImageView> Lleons = new ArrayList<>();
        Lleons.add((ImageView) findViewById(R.id.lleo));
        Lleons.add((ImageView) findViewById(R.id.lleo2));
        Lleons.add((ImageView) findViewById(R.id.lleo3));
        Lleons.add((ImageView) findViewById(R.id.lleo4));
        Lleons.add((ImageView) findViewById(R.id.lleo5));
        Lleons.add((ImageView) findViewById(R.id.lleo6));

        Contador = (TextView)findViewById(R.id.Contador);
        //Aqui girem l'arraylist per fer invisibles primer els ultims animals
        Collections.reverse(Elefants);
        Collections.reverse(Lleons);


        final Handler handler = new Handler();
        final ImageButton IBmajor = (ImageButton)findViewById(R.id.IBmajor);
        final ImageButton IBmenor = (ImageButton)findViewById(R.id.IBmenor);
        final ImageButton IBigual = (ImageButton)findViewById(R.id.IBigual);
        final ImageView Centra = (ImageView)findViewById(R.id.centra);


        //Aqui es posa en una variable la funcio random
        final int[] elefants = {Relefants()};
        final int[] lleons = {Rlleons()};

        playgame(elefants[0], lleons[0], Elefants, Lleons, correct, incorrect, Centra);

        //Boto signe major
        IBmajor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Aquest objecte de tipus Drawable s'utilitza per carregar diferents imatges.
                Drawable imatge = null;
                imatge = getDrawable(R.drawable.major);
                // Actualitza l'ImageButton amb l'objecte drawable.
                Centra.setImageDrawable(imatge);

                //Si elefants es mes gran que lleo es mostrara imatge correcta sino es mostrara imatge incorrecta
                if(elefants[0] < lleons[0]){
                    System.out.println("Ha entrat correctament");
                    incorrect.setVisibility(View.GONE);
                    correct.setVisibility(View.VISIBLE);
                    resultat ++;
                    Contador.setText("PUNTUACIO: " + String.valueOf(resultat));

                }else{
                    correct.setVisibility(View.GONE);
                    incorrect.setVisibility(View.VISIBLE);
                    resultat --;
                    Contador.setText("PUNTUACIO: " + String.valueOf(resultat));
                }

                //Aqui esperara 1,5 segons per tornar a iniciar el programa
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        elefants[0] = Relefants();
                        lleons[0] = Rlleons();
                        playgame(elefants[0], lleons[0], Elefants, Lleons, correct, incorrect, Centra);
                    }
                }, 1500);
            }


        });

        //Boto signe menor
        IBmenor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Aquest objecte de tipus Drawable s'utilitza per carregar diferents imatges.
                Drawable imatge = null;
                imatge = getDrawable(R.drawable.menor);
                // Actualitza l'ImageButton amb l'objecte drawable.
                Centra.setImageDrawable(imatge);

                //Si elefants es mes petit que lleo es mostrara imatge correcta sino es mostrara imatge incorrecta
                if(elefants[0] > lleons[0]){
                    incorrect.setVisibility(View.GONE);
                    correct.setVisibility(View.VISIBLE);
                    resultat ++;
                    Contador.setText("PUNTUACIO: " + String.valueOf(resultat));

                }else{
                    correct.setVisibility(View.GONE);
                    incorrect.setVisibility(View.VISIBLE);
                    resultat --;
                    Contador.setText("PUNTUACIO: " + String.valueOf(resultat));
                }

                //Aqui esperara 1,5 segons per tornar a iniciar el programa
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        elefants[0] = Relefants();
                        lleons[0] = Rlleons();
                        playgame(elefants[0], lleons[0], Elefants, Lleons, correct, incorrect, Centra);
                    }
                }, 1500);

            }
        });

        //Boto signe igual
        IBigual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Aquest objecte de tipus Drawable s'utilitza per carregar diferents imatges.
                Drawable imatge = null;
                imatge = getDrawable(R.drawable.igual);
                // Actualitza l'ImageButton amb l'objecte drawable.
                Centra.setImageDrawable(imatge);

                //Si elefants es igual que lleo es mostrara imatge correcta sino es mostrara imatge incorrecta
                if(elefants[0] == lleons[0]){
                    incorrect.setVisibility(View.GONE);
                    correct.setVisibility(View.VISIBLE);
                    resultat ++;
                    Contador.setText("PUNTUACIO: " + String.valueOf(resultat));

                }else{
                    correct.setVisibility(View.GONE);
                    incorrect.setVisibility(View.VISIBLE);
                    resultat --;
                    Contador.setText("PUNTUACIO: " + String.valueOf(resultat));
                }

                //Aqui esperara 1,5 segons per tornar a iniciar el programa
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        elefants[0] = Relefants();
                        lleons[0] = Rlleons();
                        playgame(elefants[0], lleons[0], Elefants, Lleons, correct, incorrect, Centra);
                    }
                }, 1500);

            }

        });

    }

    @SuppressLint("WrongConstant")
    public int Relefants (){
        int elefants = (int) (Math.random()*5+1);
        return elefants;
    }
    public int Rlleons (){
        int lleons = (int) (Math.random()*5+1);
        return lleons;
    }

    @SuppressLint("WrongConstant")
    public void playgame(int elefants, int lleons, ArrayList<ImageView>Elefants, ArrayList<ImageView>Lleons, ImageView correct, ImageView incorrect, ImageView Centra){



        Drawable imatge = null;
        imatge = getDrawable(R.drawable.base);
        Centra.setImageDrawable(imatge);
        correct.setVisibility(View.GONE);
        incorrect.setVisibility(View.GONE);

        //Aqui mostrara el numero d'elefants i lleons que sortirant per pantalla

        for (int i=0;i<Elefants.size();i++) {

            Elefants.get(i).setVisibility(0);
        }

        for (int i=0;i<Lleons.size();i++) {

            Lleons.get(i).setVisibility(0);
        }

        //Aqui farem un for per posar els elefants en invisibles
        for (int i=0; i<elefants; i++) {
            Elefants.get(i).setVisibility(-1);
        }

        //Aqui farem un for per posar els lleons en invisibles
        for (int i=0; i<lleons; i++) {
            Lleons.get(i).setVisibility(-1);
        }


    }


}