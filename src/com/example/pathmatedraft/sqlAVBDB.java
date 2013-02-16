package com.example.pathmatedraft;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class sqlAVBDB {

	public static final String KEY_ROWID = "_id";
	public static final String KEY_AVB_INGREDIENT_NAME = "ingredient_name"; 
	public static final String KEY_AVB_INGREDIENT_QTY = "ingredient_quantity";
	public static final String KEY_AVB_INGREDIENT_CTG = "ingredient_category";
	
	private static final String DATABASE_NAME = "PathMateDB";
	private static final String DATABASE_AVB_TABLE = "availableIngredientDB";
	private static final int DATABASE_VERSION = 1;
	
	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;
	
	private static class DbHelper extends SQLiteOpenHelper{

		public DbHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		//setup database for available ingredient
		public void onCreate(SQLiteDatabase db) {
			db.execSQL("CREATE TABLE " + DATABASE_AVB_TABLE + " (" +
					KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
					KEY_AVB_INGREDIENT_NAME + " TEXT NOT NULL, " +
					KEY_AVB_INGREDIENT_QTY + " TEXT, " +
					KEY_AVB_INGREDIENT_CTG + " TEXT);"
			);	
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + DATABASE_AVB_TABLE);
			onCreate(db);
		}		
	}
	
	public sqlAVBDB(Context c){
		ourContext = c;
	}

	public sqlAVBDB open() throws SQLException{
		ourHelper = new DbHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;
	}
	 public void close(){
		 ourHelper.close();
	 }

	public long createEntry(String name, String qty, String ctg) {
		// TODO Auto-generated method stub
		ContentValues cv = new ContentValues();
		cv.put(KEY_AVB_INGREDIENT_NAME, name);
		cv.put(KEY_AVB_INGREDIENT_QTY, qty);
		cv.put(KEY_AVB_INGREDIENT_CTG, ctg);
		return ourDatabase.insert(DATABASE_AVB_TABLE, null, cv);
	}

	public String getData() {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ KEY_ROWID, KEY_AVB_INGREDIENT_NAME, KEY_AVB_INGREDIENT_QTY, KEY_AVB_INGREDIENT_CTG};
		Cursor c = ourDatabase.query(DATABASE_AVB_TABLE, columns, null, null, null, null, null);
		String result = "";
		
		int iRow = c.getColumnIndex(KEY_ROWID);
		int iName = c.getColumnIndex(KEY_AVB_INGREDIENT_NAME);
		int iQty = c.getColumnIndex(KEY_AVB_INGREDIENT_QTY);
		
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			result = result + c.getString(iRow) + " " + c.getString(iName) + " " + c.getString(iQty) + "\n";
		}
		
		return result;
	}

	public String getName(long l) throws SQLException{
		// TODO Auto-generated method stub
		String[] columns = new String[]{ KEY_ROWID, KEY_AVB_INGREDIENT_NAME, KEY_AVB_INGREDIENT_QTY, KEY_AVB_INGREDIENT_CTG};
		Cursor c = ourDatabase.query(DATABASE_AVB_TABLE, columns, KEY_ROWID + "=" + l, null, null, null, null);
		if (c != null){
			c.moveToFirst();
			String name = c.getString(1);
			return name;
		}
		return null;
	}

	public String getQty(long l) throws SQLException{
		// TODO Auto-generated method stub
		String[] columns = new String[]{ KEY_ROWID, KEY_AVB_INGREDIENT_NAME, KEY_AVB_INGREDIENT_QTY, KEY_AVB_INGREDIENT_CTG};
		Cursor c = ourDatabase.query(DATABASE_AVB_TABLE, columns, KEY_ROWID + "=" + l, null, null, null, null);
		if (c != null){
			c.moveToFirst();
			String qty = c.getString(2);
			return qty;
		}
		return null;
	}

	public void updateEntry(long lRow, String mName, String mQty, String mCtg) throws SQLException{
		// TODO Auto-generated method stub
		ContentValues cvUpdate = new ContentValues();
		cvUpdate.put(KEY_AVB_INGREDIENT_NAME, mName);
		cvUpdate.put(KEY_AVB_INGREDIENT_QTY, mQty);
		cvUpdate.put(KEY_AVB_INGREDIENT_CTG, mCtg);
		ourDatabase.update(DATABASE_AVB_TABLE, cvUpdate, KEY_ROWID + "=" + lRow, null);	
	}

	public void deleteEntry(long lRow1) throws SQLException{
		// TODO Auto-generated method stub
		ourDatabase.delete(DATABASE_AVB_TABLE, KEY_ROWID + "=" + lRow1, null);
	}

	
}

