package com.danielgv.android.geoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.danielgv.android.TrampaActivity;
import com.danielgv.android.model.Pregunta;

public class GeoActivity extends AppCompatActivity {

    public static final String KEY_PREGUNTA_ACTUAL = "PreguntaActual";
    private Button mBotonCierto;
    private Button mBotonFalso;
    private Button mBotonSiguiente;
    private TextView mTextoPregunta;
    private Pregunta mBancoDePreguntas [] = {

            new Pregunta(R.string.texto_pregunta_1, false),
            new Pregunta(R.string.texto_pregunta_2, true),
            new Pregunta(R.string.texto_pregunta_3, true),
            new Pregunta(R.string.texto_pregunta_4, true),
            new Pregunta(R.string.texto_pregunta_5, false),
    };
    private int mPreguntaActual = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo);

        mBotonCierto = (Button) findViewById(R.id.boton_cierto);
        mBotonFalso = (Button) findViewById(R.id.boton_falso);
        mBotonSiguiente = (Button) findViewById(R.id.boton_siguiente);
        mTextoPregunta = (TextView) findViewById(R.id.texto_pregunta_1);

        mBotonCierto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarRespuesta(true);
            }
        });
        mBotonFalso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarRespuesta(false);
            }
        });
        mBotonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPreguntaActual = mPreguntaActual + 1;
                if (mPreguntaActual == mBancoDePreguntas.length) {
                    mPreguntaActual = 0;
                }

                actualizarPregunta();

            }

        });

        if (savedInstanceState != null) {
            mPreguntaActual = savedInstanceState.getInt(KEY_PREGUNTA_ACTUAL, 0);
        }
        actualizarPregunta();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_PREGUNTA_ACTUAL, mPreguntaActual);
    }

    private void actualizarPregunta() {
        int preguntaActual = mBancoDePreguntas[mPreguntaActual].getMlResTexto();
        mTextoPregunta.setText(preguntaActual);}


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode ==0) {
            if (resultCode == RESULT_OK){
                TrampaActivity.getExtraForResult(data);
            }
        }
    }

    private void verificarRespuesta(boolean botonOprimido) {
                boolean respuestaEsVerdadera = mBancoDePreguntas[mPreguntaActual].ismRespuesta();
                if (botonOprimido == respuestaEsVerdadera) {
                    Toast.makeText(GeoActivity.this, R.string.texto_correcto, Toast.LENGTH_SHORT).show();
                }
        else {
                    Toast.makeText(GeoActivity.this, R.string.texto_incorrecto, Toast.LENGTH_SHORT).show();


    }

    }
}
