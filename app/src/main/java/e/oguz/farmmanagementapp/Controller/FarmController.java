package e.oguz.farmmanagementapp.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import e.oguz.farmmanagementapp.Database.DatabaseHandler;
import e.oguz.farmmanagementapp.Models.FarmModel;

public class FarmController extends DatabaseHandler {

    public FarmController(Context context) {
        super(context);
    }



    public boolean create(FarmModel farmModel) {

        ContentValues values = new ContentValues();

        values.put("alan", farmModel.alan);
        values.put("farmName", farmModel.farmName);
        values.put("location", farmModel.location);

        SQLiteDatabase db = this.getWritableDatabase();

        boolean createSuccessful = db.insert("farms", null, values) > 0;
        db.close();

        return createSuccessful;
    }


    public ArrayList<FarmModel> read() {

        ArrayList<FarmModel> recordsList = new ArrayList<FarmModel>();

        String sql = "SELECT * FROM farms ORDER BY id DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {

                int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
                String farmName = cursor.getString(cursor.getColumnIndex("farmName"));
                int alan =  Integer.parseInt(cursor.getString(cursor.getColumnIndex("alan")));
                String location = cursor.getString(cursor.getColumnIndex("location"));

                FarmModel farmModel = new FarmModel();
                farmModel.farmName = farmName;
                farmModel.id = id;
                farmModel.alan = alan;
                farmModel.location = location;

                recordsList.add(farmModel);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return recordsList;
    }

    public boolean delete(int id) {
        boolean deleteSuccessful = false;

        SQLiteDatabase db = this.getWritableDatabase();
        deleteSuccessful = db.delete("farms", "id ='" + id + "'", null) > 0;
        db.close();

        return deleteSuccessful;

    }


    public int count() {

        SQLiteDatabase db = this.getWritableDatabase();

        String sql = "SELECT * FROM farms";
        int recordCount = db.rawQuery(sql, null).getCount();
        db.close();

        return recordCount;

    }

    public FarmModel readSingleRecord(int farmId) {

        FarmModel objectFarm = null;

        String sql = "SELECT * FROM farms WHERE id = " + farmId;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
            String farmName = cursor.getString(cursor.getColumnIndex("farmName"));
            int alan =  Integer.parseInt(cursor.getString(cursor.getColumnIndex("alan")));
            String location = cursor.getString(cursor.getColumnIndex("location"));

            objectFarm = new FarmModel();
            objectFarm.farmName = farmName;
            objectFarm.id = id;
            objectFarm.alan = alan;
            objectFarm.location = location;

        }

        cursor.close();
        db.close();

        return objectFarm;

    }


    public boolean update(FarmModel objectFarm) {

        ContentValues values = new ContentValues();

        values.put("farmName", objectFarm.farmName);
        values.put("alan", objectFarm.alan);
        values.put("location", objectFarm.location);

        String where = "id = ?";

        String[] whereArgs = { Integer.toString(objectFarm.id) };

        SQLiteDatabase db = this.getWritableDatabase();

        boolean updateSuccessful = db.update("farms", values, where, whereArgs) > 0;
        db.close();

        return updateSuccessful;

    }
}
