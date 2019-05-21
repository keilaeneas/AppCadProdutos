package com.example.cadastroprodutos.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.cadastroprodutos.model.Produtos;

import java.util.ArrayList;

public class ProdutosDB extends SQLiteOpenHelper {

    private static final String DATABASE = "dbprodutos";
    private static final int VERSION = 1;

    @RequiresApi(api = Build.VERSION_CODES.P)
    public ProdutosDB(Context context){
        super(context, DATABASE, VERSION, null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String produto = "CREATE TABLE produtos(id INT PRIMARY KEY AUTOINCREMENT NOT NULL, nomeproduto VARCHAR(30) NOT NULL, descricao  TEXT NOT NULL, quantidade INT);";
        db.execSQL(produto);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String produto = "DROP TABLE IF EXISTS produtos;";
        db.execSQL(produto);
    }

    //Salva
    public void salvarProduto(Produtos produto){
        ContentValues values = new ContentValues();

        values.put("nomeproduto", produto.getNomeProduto());
        values.put("descricao", produto.getDescricao());
        values.put("quantidade", produto.getQuantidade());

        getWritableDatabase().insert("produtos", null, values);
    }

    //Lista
    public ArrayList<Produtos> getLista(){
        String [] columns = {"id", "nomeproduto", "descricao", "quantidade"};
        Cursor cursor = getWritableDatabase().query("produtos", columns, null, null, null, null, null, null);
        ArrayList<Produtos> produtos = new ArrayList<Produtos>();

        while (cursor.moveToNext()){
            Produtos produto = new Produtos();
            produto.setId(cursor.getInt(0));
            produto.setNomeProduto(cursor.getString(1));
            produto.setDescricao(cursor.getString(2));
            produto.setQuantidade(cursor.getInt(3));

            produtos.add(produto);
        }
        return produtos;
    }
}
