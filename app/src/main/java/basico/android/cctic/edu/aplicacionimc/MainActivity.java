package basico.android.cctic.edu.aplicacionimc;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.mipmap.ic_launcher);
        Log.d("MIAPP", "Estoy en onCreate");
        String valor = getResources().getString(R.string.saludo);
        Log.d("MIAPP", "Saludo =" + valor);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MIAPP", "Estoy en onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MIAPP", "Estoy en onStop");


    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MIAPP", "Estoy en onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MIAPP", "Estoy en OnDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MIAPP", "Estoy en onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MIAPP", "Estoy en onResume");
    }


    private static float calcularIMC (Float peso, Float altura)
    {
        float imc = 0;

        if (peso == 0 || altura==0){
            return  imc;
        }

        boolean ingles = false;

        if (ingles){
            imc = (703*peso)/(altura*altura);
        }else {
            imc = peso/(altura*altura);
        }

        return imc;

    }

    private String informarIMC (float imc) {
        ImageView imageView = findViewById(R.id.imageView);

        if (imc == 0){

            return "";
        }
        String valor = null;

        if (imc < 16) {
            imageView.setImageResource(R.drawable.desnutrido);
            valor = getResources().getString(R.string.desnutrido);
            return valor;
        } else if (imc < 18) {
            imageView.setImageResource(R.drawable.delgado);
            valor = getResources().getString(R.string.delgado);
            return valor;
        } else if (imc < 25) {
            imageView.setImageResource(R.drawable.ideal);
            valor = getResources().getString(R.string.ideal);
            return valor;
        } else if (imc < 31) {
            imageView.setImageResource(R.drawable.sobrepeso);
            valor = getResources().getString(R.string.sobrepeso);
            return valor;
        } else {
            imageView.setImageResource(R.drawable.obesidad);
            valor = getResources().getString(R.string.obesidad);
            return valor;
        }
    }


    public void calculoIMC (View view){

        //TODO GESTIONAR BOTON
        //RECOGER EL PESO INTRODUCIDO
        EditText editPeso = findViewById(R.id.editPeso);
        String peso = editPeso.getText().toString();

        //casting de String a float
        Log.d("MIAPP", "Texto intro =" + peso);
        if (peso.length() < 1 ){
            ImageView imageView = findViewById(R.id.imageView);
            imageView.setImageResource(R.mipmap.ic_launcher);
            TextView imcVuelta = findViewById(R.id.imcCalculado);
            imcVuelta.setText("");
            return;
        }
        Float pesoF = Float.parseFloat(peso);

        // Una forma mas compacta
        //Float pesoF =  peso.length()<1 ? 0 : Float.parseFloat(peso);

        Log.d("MIAPP", "peso =" + pesoF);

        //RECOGER estatura INTRODUCIDA
        EditText editEstatura = findViewById(R.id.editEstatura);
        String estatura = editEstatura.getText().toString();

        Log.d("MIAPP", "Texto intro =" + estatura);

        if (estatura.length() < 1 ){
            ImageView imageView = findViewById(R.id.imageView);
            imageView.setImageResource(R.mipmap.ic_launcher);
            TextView imcVuelta = findViewById(R.id.imcCalculado);
            imcVuelta.setText("");
            return;
        }
       Float estaturaF = Float.parseFloat(estatura);

        Log.d("MIAPP", "estatura =" + estaturaF);

        //Calcular IMC
        float imc = calcularIMC(pesoF,estaturaF);
        String imcMostrado= "";
        String valor = getResources().getString(R.string.app_name);

        imcMostrado = valor+" = "+ imc +"\n --> "+informarIMC(imc);


        //MOSTRARLO
        TextView imcVuelta = findViewById(R.id.imcCalculado);
        imcVuelta.setText(imcMostrado);


    }


}
