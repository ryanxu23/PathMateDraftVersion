package com.example.pathmatedraft;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class sqlDSRDB {

	public static final String KEY_ROWID = "_id";
	public static final String KEY_DSR_INGREDIENT_NAME = "ingredient_name"; 
	public static final String KEY_DSR_INGREDIENT_CTG = "ingredient_category";
	
	private static final String DATABASE_NAME = "PathMateDSRDB";
	private static final String DATABASE_DSR_TABLE = "desiredIngredientDB";
	private static final int DATABASE_VERSION = 1;
	
	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;
	
	private static class DbHelper extends SQLiteOpenHelper{

		public DbHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);

		}

		//setup database for desired ingredient
		public void onCreate(SQLiteDatabase db) {
			db.execSQL("CREATE TABLE " + DATABASE_DSR_TABLE + " (" +
					KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
					KEY_DSR_INGREDIENT_NAME + " TEXT NOT NULL, " +
					KEY_DSR_INGREDIENT_CTG + " TEXT);"
			);	
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DROP TABLE IF EXISTS " + DATABASE_DSR_TABLE);
			onCreate(db);
		}		
	}
	
	public sqlDSRDB(Context c){
		ourContext = c;
	}

	public sqlDSRDB open() throws SQLException{
		ourHelper = new DbHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;
	}
	 public void close(){
		 ourHelper.close();
	 }

	public void createEntry(String name, String ctg) {
		// TODO add a return value 0 or 1, if the ingredient name already exists, cannot add, return 1 to add view
		ContentValues cv = new ContentValues();
		cv.put(KEY_DSR_INGREDIENT_NAME, name);
		cv.put(KEY_DSR_INGREDIENT_CTG, ctg);
		ourDatabase.insert(DATABASE_DSR_TABLE, null, cv);
		
	}

	public String getData() {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ KEY_ROWID, KEY_DSR_INGREDIENT_NAME, KEY_DSR_INGREDIENT_CTG};
		Cursor c = ourDatabase.query(DATABASE_DSR_TABLE, columns, null, null, null, null, null);
		String result = "";
		
		int iRow = c.getColumnIndex(KEY_ROWID);
		int iName = c.getColumnIndex(KEY_DSR_INGREDIENT_NAME);
		
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			result = result + c.getString(iRow) + " " + c.getString(iName) + "\n";
		}
		
		return result;
	}

	public String getName(long l) throws SQLException{
		// TODO Auto-generated method stub
		String[] columns = new String[]{ KEY_ROWID, KEY_DSR_INGREDIENT_NAME, KEY_DSR_INGREDIENT_CTG};
		Cursor c = ourDatabase.query(DATABASE_DSR_TABLE, columns, KEY_ROWID + "=" + l, null, null, null, null);
		if (c != null){
			c.moveToFirst();
			String name = c.getString(1);
			return name;
		}
		return null;
	}

	public void updateEntry(String mName, String mCtg) throws SQLException{
		ContentValues cvUpdate = new ContentValues();
		cvUpdate.put(KEY_DSR_INGREDIENT_NAME, mName);
		cvUpdate.put(KEY_DSR_INGREDIENT_CTG, mCtg);
		ourDatabase.update(DATABASE_DSR_TABLE, cvUpdate, KEY_DSR_INGREDIENT_NAME + "='" + mName + "'", null);	
	}

	public void deleteEntry(String name) throws SQLException{
		ourDatabase.delete(DATABASE_DSR_TABLE, KEY_DSR_INGREDIENT_NAME + "='" + name + "'", null);
	}

	public int numDSREntries() throws SQLException{
		String[] columns = new String[]{ KEY_ROWID, KEY_DSR_INGREDIENT_NAME, KEY_DSR_INGREDIENT_CTG};
		Cursor c = ourDatabase.query(DATABASE_DSR_TABLE, columns, null, null, null, null, null);
		int num = c.getCount();
		return num;
	}

	public boolean findEntry(String name) throws SQLException{
		
		String[] columns = new String[]{ KEY_ROWID, KEY_DSR_INGREDIENT_NAME, KEY_DSR_INGREDIENT_CTG};
		Cursor c = ourDatabase.query(DATABASE_DSR_TABLE, columns, KEY_DSR_INGREDIENT_NAME +  "='" + name + "'", null, null, null, null);
		if (c != null){
			return true;
		}else{
			return false;
		}
	}
	
	
	
	public void initSomeEntries() {
		ContentValues cv = new ContentValues();
		cv.put(KEY_DSR_INGREDIENT_NAME, "Birnen");
		cv.put(KEY_DSR_INGREDIENT_CTG, "Obst");
		ourDatabase.insert(DATABASE_DSR_TABLE, null, cv);
		
		ContentValues cv1 = new ContentValues();
		cv1.put(KEY_DSR_INGREDIENT_NAME, "Eier");
		cv1.put(KEY_DSR_INGREDIENT_CTG, "NA");
		ourDatabase.insert(DATABASE_DSR_TABLE, null, cv1);
		
		ContentValues cv2 = new ContentValues();
		cv2.put(KEY_DSR_INGREDIENT_NAME, "Kiwi");
		cv2.put(KEY_DSR_INGREDIENT_CTG, "Obst");
		ourDatabase.insert(DATABASE_DSR_TABLE, null, cv2);
		
		ContentValues cv3 = new ContentValues();
		cv3.put(KEY_DSR_INGREDIENT_NAME, "Backpulver");
		cv3.put(KEY_DSR_INGREDIENT_CTG, "Zutate");
		ourDatabase.insert(DATABASE_DSR_TABLE, null, cv3);	
		
	}
	
	public String[] getAllEntries(){
		
		String[] columns = new String[]{ KEY_ROWID, KEY_DSR_INGREDIENT_NAME, KEY_DSR_INGREDIENT_CTG};
		Cursor c = ourDatabase.query(DATABASE_DSR_TABLE, columns, null, null, null, null, KEY_DSR_INGREDIENT_NAME);
		int num = c.getCount();
		
		String[] dList = new String[num];
		
		int iRow = c.getColumnIndex(KEY_ROWID);
		int iName = c.getColumnIndex(KEY_DSR_INGREDIENT_NAME);
		int iCtg = c.getColumnIndex(KEY_DSR_INGREDIENT_CTG);
		int loc = 0;
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			dList[loc] =  c.getString(iName);
			loc ++;
		}	
		
		return dList;
	}
	
	public DDRow[] getAllEntriesForDelete(){
		
		String[] columns = new String[]{ KEY_ROWID, KEY_DSR_INGREDIENT_NAME, KEY_DSR_INGREDIENT_CTG};
		Cursor c = ourDatabase.query(DATABASE_DSR_TABLE, columns, null, null, null, null, KEY_DSR_INGREDIENT_NAME);
		int num = c.getCount();
		
		DDRow[] ddList = new DDRow[num];
		
		int iRow = c.getColumnIndex(KEY_ROWID);
		int iName = c.getColumnIndex(KEY_DSR_INGREDIENT_NAME);
		int iCtg = c.getColumnIndex(KEY_DSR_INGREDIENT_CTG);
		int loc = 0;
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			ddList[loc] = new DDRow(R.drawable.delete, c.getString(iName));
			loc ++;
		}	
		
		return ddList;
	}
}

