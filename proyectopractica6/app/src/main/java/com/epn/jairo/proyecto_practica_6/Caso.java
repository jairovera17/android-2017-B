package com.epn.jairo.proyecto_practica_6;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Jairo on 17/12/2017.
 */

public class Caso {
    private int _id;
    private String _cliente;
    private String _fecha_inicio;
    private String _fecha_fin;
    private String _estado;

    public Caso(){}

    public Caso(int _id, String _cliente
            , String _fecha_inicio
            , String _fecha_fin
            , String _estado) {
        this._id = _id;
        this._cliente = _cliente;
        this._fecha_inicio = _fecha_inicio;
        this._fecha_fin = _fecha_fin;
        this._estado = _estado;
    }

    public Caso(String _cliente
            , String _fecha_inicio
            , String _fecha_fin
            , String _estado) {
        this._cliente = _cliente;
        this._fecha_inicio = _fecha_inicio;
        this._fecha_fin = _fecha_fin;
        this._estado = _estado;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_cliente() {
        return _cliente;
    }

    public void set_cliente(String _cliente) {
        this._cliente = _cliente;
    }

    public String get_fecha_inicio() {
        return _fecha_inicio;
    }

    public void set_fecha_inicio(String _fecha_inicio) {
        this._fecha_inicio = _fecha_inicio;
    }

    public String get_fecha_fin() {
        return _fecha_fin;
    }

    public void set_fecha_fin(String _fecha_fin) {
        this._fecha_fin = _fecha_fin;
    }

    public String get_estado() {
        return _estado;
    }

    public void set_estado(String _estado) {
        this._estado = _estado;
    }


}
