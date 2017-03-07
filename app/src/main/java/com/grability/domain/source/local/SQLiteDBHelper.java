package com.grability.domain.source.local;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.github.rpsqlparser.AssetsSQL;
import com.github.rpsqlparser.ParserSQL;
import com.grability.ui.activity.theme.ThemeContract;
import com.grability.util.Constants;

import java.io.IOException;

/**
 * Created by rogerp91 on 19/01/17.
 */

public class SQLiteDBHelper extends SQLiteOpenHelper {

    private String TAG = SQLiteDBHelper.class.getSimpleName();

    private Context context = null;

    SQLiteDBHelper(Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
        this.context = context;
    }

    public String getDatabaseName() {
        return Constants.DATABASE_NAME;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            execSqlFile(Constants.CREATEFILE, db);
        } catch (Exception e) {
            throw new RuntimeException("Database creation failed", e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            for (String sqlFile : AssetsSQL.list(Constants.SQL_DIR, context.getAssets())) {
                if (sqlFile.startsWith(Constants.UPGRADEFILE_PREFIX)) {
                    int fileVersion = Integer.parseInt(sqlFile.substring(Constants.UPGRADEFILE_PREFIX.length(), sqlFile.length() - Constants.UPGRADEFILE_SUFFIX.length()));
                    if (fileVersion > oldVersion && fileVersion <= newVersion) {
                        execSqlFile(sqlFile, db);
                        //Log.d("sqlFile", sqlFile);
                    }
                }
            }
        } catch (IOException exception) {
            throw new RuntimeException("Database upgrade failed", exception);
        }
    }

    private void execSqlFile(String createfile, SQLiteDatabase db) throws SQLException, IOException {
        try {
            for (String sqlInstruction : ParserSQL.parseSqlFile(Constants.SQL_DIR + "/" + createfile, context.getAssets())) {
//                Log.d(TAG, "SQL: " + sqlInstruction);
                db.execSQL(sqlInstruction);
            }
        } catch (SQLException | IOException e) {
            Log.d(TAG, "Error executing command: ", e);
        }
    }

    public void onDelete(SQLiteDatabase db) {
        db.delete(ThemeContract.ThemeEntry.TABLE_NAME, null, null);
        db.close();
    }
}