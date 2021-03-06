package com.cmsegroup8.PlantATree.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import com.cmsegroup8.PlantATree.Model.Trees;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteAssetHelper {

    //sets final variables for the database's name and version, as they will never change
    private static final String DB_NAME = "trees.db";
    private static final int DB_VERSION = 1;


    public Database(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    //retrieves all trees from the database
    public List<Trees> getTrees() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"id", "name", "price", "desc", "colour", "size"};
        String tableName = "trees";

        qb.setTables(tableName);
        Cursor c = qb.query(db, sqlSelect, null, null, null, null, null);
        List<Trees> result = new ArrayList<>();
        if (c.moveToFirst()) {
            do {
                Trees trees = new Trees();
                trees.setId(c.getInt(c.getColumnIndex("id")));
                trees.setName(c.getString(c.getColumnIndex("name")));
                trees.setPrice(c.getString(c.getColumnIndex("price")));
                trees.setDesc(c.getString(c.getColumnIndex("desc")));
                trees.setColour(c.getString(c.getColumnIndex("colour")));
                trees.setTreeSize(c.getString(c.getColumnIndex("size")));

                result.add(trees);
            } while (c.moveToNext());
        }
        return result;
    }

    //retrieves the names from the database to use in the suggestion list
    public List<String> getNames() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"name"};
        String tableName = "trees";

        qb.setTables(tableName);
        Cursor c = qb.query(db, sqlSelect, null, null, null, null, null);
        List<String> result = new ArrayList<>();
        if (c.moveToFirst()) {
            do {
                result.add(c.getString(c.getColumnIndex("name")));
            } while (c.moveToNext());
        }
        return result;
    }

    //retrieves the names from the database to show in the search field based on what the user has typed
       public List<Trees> getTreesByName(String name) {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"id", "name"};
        String tableName = "trees";

        qb.setTables(tableName);
        Cursor c = qb.query(db, sqlSelect, "name LIKE ?", new String[]{"%" + name + "%"}, null, null, null);
        List<Trees> result = new ArrayList<>();
        if (c.moveToFirst()) {
            do {
                Trees trees = new Trees();
                trees.setId(c.getInt(c.getColumnIndex("id")));
                trees.setName(c.getString(c.getColumnIndex("name")));

                result.add(trees);
            } while (c.moveToNext());
        }
        return result;
    }

}


