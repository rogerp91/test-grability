package com.grability.domain.source.local;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.util.Log;

import com.grability.TestGrability;
import com.grability.domain.entity.Child;
import com.grability.domain.entity.Data_;
import com.grability.ui.activity.theme.ThemeContract;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.grability.ui.activity.theme.ThemeContract.ThemeEntry.COLUMN_BANNER_IMG;
import static com.grability.ui.activity.theme.ThemeContract.ThemeEntry.COLUMN_CREATED;
import static com.grability.ui.activity.theme.ThemeContract.ThemeEntry.COLUMN_CREATED_UTC;
import static com.grability.ui.activity.theme.ThemeContract.ThemeEntry.COLUMN_DESCRIPTION;
import static com.grability.ui.activity.theme.ThemeContract.ThemeEntry.COLUMN_DESCRIPTION_HTML;
import static com.grability.ui.activity.theme.ThemeContract.ThemeEntry.COLUMN_DISPLAY_NAME;
import static com.grability.ui.activity.theme.ThemeContract.ThemeEntry.COLUMN_HEADER_IMG;
import static com.grability.ui.activity.theme.ThemeContract.ThemeEntry.COLUMN_HEADER_TITLE;
import static com.grability.ui.activity.theme.ThemeContract.ThemeEntry.COLUMN_ICON_IMG;
import static com.grability.ui.activity.theme.ThemeContract.ThemeEntry.COLUMN_ID;
import static com.grability.ui.activity.theme.ThemeContract.ThemeEntry.COLUMN_ID_AUX;
import static com.grability.ui.activity.theme.ThemeContract.ThemeEntry.COLUMN_KEY_COLOR;
import static com.grability.ui.activity.theme.ThemeContract.ThemeEntry.COLUMN_LANG;
import static com.grability.ui.activity.theme.ThemeContract.ThemeEntry.COLUMN_NAME;
import static com.grability.ui.activity.theme.ThemeContract.ThemeEntry.COLUMN_PUBLIC_DESCRIPTION;
import static com.grability.ui.activity.theme.ThemeContract.ThemeEntry.COLUMN_SUBMIT_TEX;
import static com.grability.ui.activity.theme.ThemeContract.ThemeEntry.COLUMN_SUBMIT_TEXT_HTML;
import static com.grability.ui.activity.theme.ThemeContract.ThemeEntry.COLUMN_SUBMIT_TEXT_LABEL;
import static com.grability.ui.activity.theme.ThemeContract.ThemeEntry.COLUMN_SUBSCRIBERS;
import static com.grability.ui.activity.theme.ThemeContract.ThemeEntry.COLUMN_TITLE;
import static com.grability.ui.activity.theme.ThemeContract.ThemeEntry.TABLE_NAME;

/**
 * Created by rogerp91 on 19/01/17.
 */

public class ThemeLocalDataSource implements ThemeContract.ThemeLocalDataSource {

    private String TAG = ThemeLocalDataSource.class.getSimpleName();

    private SQLiteDBHelper sqliteDBHelper = null;
    private SQLiteDatabase db = null;

    @Inject
    ThemeLocalDataSource() {
        sqliteDBHelper = new SQLiteDBHelper(TestGrability.getContext());
    }

    @Override
    public void getThemes(@NonNull LoadThemeCallback callback) {
        open();
        List<Child> children = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Child child = new Child();
                Data_ data_ = new Data_();
                data_.setId_aux(cursor.getInt(cursor.getColumnIndex(COLUMN_ID_AUX)));
                data_.setBannerImg(cursor.getString(cursor.getColumnIndex(COLUMN_BANNER_IMG)));
                data_.setSubmitTextHtml(cursor.getString(cursor.getColumnIndex(COLUMN_SUBMIT_TEXT_HTML)));
                data_.setId(cursor.getString(cursor.getColumnIndex(COLUMN_ID)));
                data_.setTitle(cursor.getString(cursor.getColumnIndex(COLUMN_TITLE)));
                data_.setSubmitText(cursor.getString(cursor.getColumnIndex(COLUMN_SUBMIT_TEX)));
                data_.setDisplayName(cursor.getString(cursor.getColumnIndex(COLUMN_DISPLAY_NAME)));
                data_.setHeaderImg(cursor.getString(cursor.getColumnIndex(COLUMN_HEADER_IMG)));
                data_.setDescriptionHtml(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION_HTML)));
                data_.setIconImg(cursor.getString(cursor.getColumnIndex(COLUMN_ICON_IMG)));
                data_.setHeaderTitle(cursor.getString(cursor.getColumnIndex(COLUMN_HEADER_TITLE)));
                data_.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)));
                data_.setSubscribers(cursor.getInt(cursor.getColumnIndex(COLUMN_SUBSCRIBERS)));
                data_.setSubmitTextLabel(cursor.getString(cursor.getColumnIndex(COLUMN_SUBMIT_TEXT_LABEL)));
                data_.setLang(cursor.getString(cursor.getColumnIndex(COLUMN_LANG)));
                data_.setKeyColor(cursor.getString(cursor.getColumnIndex(COLUMN_KEY_COLOR)));
                data_.setName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)));
                data_.setCreated(cursor.getDouble(cursor.getColumnIndex(COLUMN_CREATED)));
                data_.setCreatedUtc(cursor.getString(cursor.getColumnIndex(COLUMN_CREATED_UTC)));
                data_.setPublicDescription(cursor.getString(cursor.getColumnIndex(COLUMN_PUBLIC_DESCRIPTION)));
                child.setData(data_);
                children.add(child);
            } while (cursor.moveToNext());
        }
        cursor.close();
        close();
        if (children.isEmpty()) {
            callback.onDataNotAvailable();
        } else {
            callback.onThemeLoaded(children);
        }
    }

    @Override
    public void getThemesLocal(@NonNull GetThemesLocalCallback callback) {
        open();
        List<Child> children = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Child child = new Child();
                Data_ data_ = new Data_();
                data_.setId_aux(cursor.getInt(cursor.getColumnIndex(COLUMN_ID_AUX)));
                data_.setBannerImg(cursor.getString(cursor.getColumnIndex(COLUMN_BANNER_IMG)));
                data_.setSubmitTextHtml(cursor.getString(cursor.getColumnIndex(COLUMN_SUBMIT_TEXT_HTML)));
                data_.setId(cursor.getString(cursor.getColumnIndex(COLUMN_ID)));
                data_.setTitle(cursor.getString(cursor.getColumnIndex(COLUMN_TITLE)));
                data_.setSubmitText(cursor.getString(cursor.getColumnIndex(COLUMN_SUBMIT_TEX)));
                data_.setDisplayName(cursor.getString(cursor.getColumnIndex(COLUMN_DISPLAY_NAME)));
                data_.setHeaderImg(cursor.getString(cursor.getColumnIndex(COLUMN_HEADER_IMG)));
                data_.setDescriptionHtml(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION_HTML)));
                data_.setIconImg(cursor.getString(cursor.getColumnIndex(COLUMN_ICON_IMG)));
                data_.setHeaderTitle(cursor.getString(cursor.getColumnIndex(COLUMN_HEADER_TITLE)));
                data_.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)));
                data_.setSubscribers(cursor.getInt(cursor.getColumnIndex(COLUMN_SUBSCRIBERS)));
                data_.setSubmitTextLabel(cursor.getString(cursor.getColumnIndex(COLUMN_SUBMIT_TEXT_LABEL)));
                data_.setLang(cursor.getString(cursor.getColumnIndex(COLUMN_LANG)));
                data_.setKeyColor(cursor.getString(cursor.getColumnIndex(COLUMN_KEY_COLOR)));
                data_.setName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)));
                data_.setCreated(cursor.getDouble(cursor.getColumnIndex(COLUMN_CREATED)));
                data_.setCreatedUtc(cursor.getString(cursor.getColumnIndex(COLUMN_CREATED_UTC)));
                data_.setPublicDescription(cursor.getString(cursor.getColumnIndex(COLUMN_PUBLIC_DESCRIPTION)));
                child.setData(data_);
                children.add(child);
            } while (cursor.moveToNext());
        }
        cursor.close();
        close();
        if (children.isEmpty()) {
            callback.onDataNotAvailable();
        } else {
            callback.onThemeLoaded(children);
        }
    }

    @Override
    public void getTheme(@NonNull String themeId, @NonNull GetThemeCallback callback) {
        open();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE id= '" + themeId + "'";
        Log.d(TAG, "getTheme: " + query);
        Cursor cursor = db.rawQuery(query, null);
        Data_ data_ = null;
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            data_ = new Data_();
            data_.setId_aux(cursor.getInt(cursor.getColumnIndex(COLUMN_ID_AUX)));
            data_.setBannerImg(cursor.getString(cursor.getColumnIndex(COLUMN_BANNER_IMG)));
            data_.setSubmitTextHtml(cursor.getString(cursor.getColumnIndex(COLUMN_SUBMIT_TEXT_HTML)));
            data_.setTitle(cursor.getString(cursor.getColumnIndex(COLUMN_TITLE)));
            data_.setId(cursor.getString(cursor.getColumnIndex(COLUMN_ID)));
            data_.setSubmitText(cursor.getString(cursor.getColumnIndex(COLUMN_SUBMIT_TEX)));
            data_.setDisplayName(cursor.getString(cursor.getColumnIndex(COLUMN_DISPLAY_NAME)));
            data_.setHeaderImg(cursor.getString(cursor.getColumnIndex(COLUMN_HEADER_IMG)));
            data_.setDescriptionHtml(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION_HTML)));
            data_.setIconImg(cursor.getString(cursor.getColumnIndex(COLUMN_ICON_IMG)));
            data_.setHeaderTitle(cursor.getString(cursor.getColumnIndex(COLUMN_HEADER_TITLE)));
            data_.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)));
            data_.setSubscribers(cursor.getInt(cursor.getColumnIndex(COLUMN_SUBSCRIBERS)));
            data_.setSubmitTextLabel(cursor.getString(cursor.getColumnIndex(COLUMN_SUBMIT_TEXT_LABEL)));
            data_.setLang(cursor.getString(cursor.getColumnIndex(COLUMN_LANG)));
            data_.setKeyColor(cursor.getString(cursor.getColumnIndex(COLUMN_KEY_COLOR)));
            data_.setName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)));
            data_.setCreated(cursor.getDouble(cursor.getColumnIndex(COLUMN_CREATED)));
            data_.setCreatedUtc(cursor.getString(cursor.getColumnIndex(COLUMN_CREATED_UTC)));
            data_.setPublicDescription(cursor.getString(cursor.getColumnIndex(COLUMN_PUBLIC_DESCRIPTION)));
        }

        if (cursor != null) {
            cursor.close();
        }
        close();
        if (data_ != null) {
            Child child = new Child();
            child.setData(data_);
            callback.onThemeLoaded(child);
        } else {
            callback.onDataNotAvailable();
        }
    }

    @Override
    public void saveTheme(@NonNull Child child) {
        open();
        checkNotNull(child);
        checkNotNull(child.getData());
        Data_ data = child.getData();
        ContentValues values = new ContentValues();
        values.put(COLUMN_BANNER_IMG, data.getBannerImg());
        values.put(COLUMN_SUBMIT_TEXT_HTML, data.getSubmitTextHtml());
        values.put(COLUMN_ID, data.getId());
        values.put(COLUMN_SUBMIT_TEX, data.getSubmitText());
        values.put(COLUMN_DISPLAY_NAME, data.getDisplayName());
        values.put(COLUMN_HEADER_IMG, data.getHeaderImg());
        values.put(COLUMN_DESCRIPTION_HTML, data.getDescriptionHtml());
        values.put(COLUMN_TITLE, data.getTitle());
        values.put(COLUMN_ICON_IMG, data.getIconImg());
        values.put(COLUMN_DESCRIPTION_HTML, data.getDescriptionHtml());
        values.put(COLUMN_ICON_IMG, data.getIconImg());
        values.put(COLUMN_HEADER_TITLE, data.getHeaderTitle());
        values.put(COLUMN_DESCRIPTION, data.getDescription());
        values.put(COLUMN_SUBSCRIBERS, data.getSubscribers());
        values.put(COLUMN_SUBMIT_TEXT_LABEL, data.getSubmitTextLabel());
        values.put(COLUMN_LANG, data.getLang());
        values.put(COLUMN_KEY_COLOR, data.getKeyColor());
        values.put(COLUMN_NAME, data.getName());
        values.put(COLUMN_CREATED, data.getCreated());
        values.put(COLUMN_CREATED_UTC, data.getCreatedUtc());
        values.put(COLUMN_PUBLIC_DESCRIPTION, data.getPublicDescription());
        db.insert(TABLE_NAME, null, values);
        close();
    }

    @Override
    public void refreshThemes(@NonNull LoadThemeCallback callback) {

    }

    @Override
    public void deleteAllThemes() {
        open();
        db.delete(TABLE_NAME, null, null);
        close();
    }

    private void open() {
        db = sqliteDBHelper.getWritableDatabase();
    }

    private void close() {
        db.close();
        sqliteDBHelper.close();
    }

}