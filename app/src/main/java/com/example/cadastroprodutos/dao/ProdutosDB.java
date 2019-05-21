package com.example.cadastroprodutos.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.support.annotation.RequiresApi;

public class ProdutosDB extends SQLiteOpenHelper {

    private static final String DATABASE = "dbprodutos";
    private static final int VERSION = 1;

    @RequiresApi(api = Build.VERSION_CODES.P)
    public ProdutosDB(Context context){
        super(context, DATABASE, VERSION, null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
