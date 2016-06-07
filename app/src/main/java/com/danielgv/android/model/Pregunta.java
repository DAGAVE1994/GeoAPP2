package com.danielgv.android.model;

public class Pregunta {
    private Integer mlResTexto;
    private boolean mRespuesta;

    public Pregunta(Integer mlResTexto,boolean mRespuesta) {
        this.mlResTexto = mlResTexto;
        this.mRespuesta = mRespuesta;
    }

    public Integer getMlResTexto() {
        return mlResTexto;
    }

    public void setMlResTexto(Integer mlResTexto) {
        this.mlResTexto = mlResTexto;
    }

    public void setmRespuesta(boolean mRespuesta) {
        this.mRespuesta = mRespuesta;
    }

    public boolean ismRespuesta() {
        return mRespuesta;
}


    }


