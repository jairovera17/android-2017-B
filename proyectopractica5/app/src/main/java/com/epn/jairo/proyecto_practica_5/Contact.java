package com.epn.jairo.proyecto_practica_5;

/**
 * Created by Jairo on 14/12/2017.
 */

public class Contact {

    int _id;
    String _name;
    String _phone_number;

    public Contact(){}

    public Contact(int id, String name, String _phone_number){
        this._id=id;
        this._name=name;
        this._phone_number=_phone_number;
    }

    public Contact(String name, String _phone_number){
        this._name=name;
        this._phone_number=_phone_number;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public String getPhoneNumber() {
        return _phone_number;
    }

    public void setPhoneNumber(String _phone_number) {
        this._phone_number = _phone_number;
    }

    public int getID() {
        return _id;
    }

    public void setID(int _id) {
        this._id = _id;
    }
}
