package com.danielgv.android;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.danielgv.android.geoapp.R;

public class TrampaActivity extends AppCompatActivity {
    private static final String EXTRA_RESPUESTA_ES_CIERTA = com.danielgv.android.
    private static final String EXTRA_SE_MOSTRO_RESPUESTA =
    private boolean mRespuestaEsCierta;
    private TextView mTextoRespuesta;
    private Button mBotonConfirmarTrampa;
    private boolean mSeMostroRespuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trampa);


        mTextoRespuesta = (TextView) this.findViewById(R.id.texto_respuesta_trampa);
        boton_confirmar_trampa = (Button) this.findViewById(R.id.boton_confirmar_trampa);
        mRespuestaEsCierta = getIntent().getBooleanExtra(EXTRA_RESPUESTA_ES_CIERTA, false);

        mBotonConfirmarTrampa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRespuestaEsCierta) {
                    mTextoRespuesta.setText(R.string.texto_incorrecto);
                }
                else {
                    mTextoRespuesta.setText("Falso");
                }
                mSeMostroRespuesta = true;
                Intent i = new Intent();
                i.putExtra()
            }
        });
        mSeMostroRespuesta = false;
    }

    public static Intent newIntent (Context contextoDelPaquete, boolean respuestaEsCierto) {
        Intent i = new Intent(contextoDelPaquete, TrampaActivity.class);
        i.putExtra(EXTRA_RESPUESTA_ES_CIERTA, respuestaEsCierto );
        return i;
    }
    public static boolean getExtraForResult(Intent i) {
        boolean seMostroRespuesta = i.getBooleanExtra(EXTRA_SE_MOSTRO_RESPUESTA, false);
        return seMostroRespuesta;
    }
}
