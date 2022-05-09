package com.example.project2;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefUtils {
    // name of save file
    private static final String PREF_FILE_NAME = "com.example.project2.preference_file_name";

    /** key-name **/
    // userId
    private static final String KEY_USER_ID = "com.example.project2.key_user_id";

    /** default valie **/
    // userId
    public static final int DEFAULT_USER_ID = -1;

    public static void putUserIdToSharedSharedPreference(Context context, int userId) {
        SharedPreferences sp = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(KEY_USER_ID, userId);
        editor.commit();
    }

    public static int getUserIdFromSharedPreference(Context context) {
        SharedPreferences sp = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        return sp.getInt(KEY_USER_ID, DEFAULT_USER_ID);
    }

    public static void removeUserIdFromSharedPreference(Context context) {
        SharedPreferences sp = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(KEY_USER_ID);
        editor.commit();
    }
}
