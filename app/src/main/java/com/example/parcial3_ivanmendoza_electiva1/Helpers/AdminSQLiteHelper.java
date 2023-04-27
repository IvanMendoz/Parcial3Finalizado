package com.example.parcial3_ivanmendoza_electiva1.Helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteHelper extends SQLiteOpenHelper {

    public AdminSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE contactos ( " +
                "cod_contacto int PRIMARY KEY, " +
                "nombres text, " +
                "apellidos text, " +
                "telefono text, " +
                "correo_electronico text )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
