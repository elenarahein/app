package com.example.avjindersinghsekhon.minimaltodo.Utility;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class ToDoItem implements Serializable {
    private String mToDoText;
    private boolean mHasReminder;
    //add description
    private String mToDoDescription;
    //    private Date mLastEdited;
    private String mToDoIngredientes;
    private String mToDoModopreparo;
    private int mTodoColor;
    private Date mToDoDate;
    private UUID mTodoIdentifier;
    //add description
    private static final String TODODESCRIPTION = "tododescription";
    private static final String TODOTEXT = "todotext";
    private static final String TODOINGREDIENTES = "todoingredientes";
    private static final String TODOMODOPREPARO = "todomodopreparo";
    private static final String TODOREMINDER = "todoreminder";
    //    private static final String TODOLASTEDITED = "todolastedited";
    private static final String TODOCOLOR = "todocolor";
    private static final String TODODATE = "tododate";
    private static final String TODOIDENTIFIER = "todoidentifier";


    public ToDoItem(String todoBody,String tododescription,  boolean hasReminder, Date toDoDate) {
        mToDoText = todoBody;
        mHasReminder = hasReminder;
        mToDoDate = toDoDate;
        mToDoDescription = tododescription;
        mTodoColor = 1677725;
        mTodoIdentifier = UUID.randomUUID();
    }

    public ToDoItem(JSONObject jsonObject) throws JSONException {
        mToDoText = jsonObject.getString(TODOTEXT);
        mToDoDescription = jsonObject.getString(TODODESCRIPTION);
        mHasReminder = jsonObject.getBoolean(TODOREMINDER);
        mTodoColor = jsonObject.getInt(TODOCOLOR);
        mToDoIngredientes = jsonObject.getString(TODOINGREDIENTES);
        mToDoModopreparo = jsonObject.getString(TODOMODOPREPARO);

        mTodoIdentifier = UUID.fromString(jsonObject.getString(TODOIDENTIFIER));

//        if(jsonObject.has(TODOLASTEDITED)){
//            mLastEdited = new Date(jsonObject.getLong(TODOLASTEDITED));
//        }
        if (jsonObject.has(TODODATE)) {
            mToDoDate = new Date(jsonObject.getLong(TODODATE));
        }
    }

    public String getmToDoIngredientes() {
        return mToDoIngredientes;
    }

    public void setmToDoIngredientes(String mToDoIngredientes) {
        this.mToDoIngredientes = mToDoIngredientes;
    }

    public String getmToDoModopreparo() {
        return mToDoModopreparo;
    }

    public void setmToDoModopreparo(String mToDoModopreparo) {
        this.mToDoModopreparo = mToDoModopreparo;
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(TODOTEXT, mToDoText);
        jsonObject.put(TODOREMINDER, mHasReminder);
        jsonObject.put(TODODESCRIPTION, mToDoDescription);
        jsonObject.put(TODOINGREDIENTES, mToDoIngredientes);
        jsonObject.put(TODOMODOPREPARO, mToDoModopreparo);
//        jsonObject.put(TODOLASTEDITED, mLastEdited.getTime());
        if (mToDoDate != null) {
            jsonObject.put(TODODATE, mToDoDate.getTime());
        }
        jsonObject.put(TODOCOLOR, mTodoColor);

        jsonObject.put(TODOIDENTIFIER, mTodoIdentifier.toString());

        return jsonObject;
    }


    public ToDoItem() {
        this("Clean my room","Sweep and Mop my Room", true, new Date());
    }

    public String getmToDoDescription() { return mToDoDescription;}

    public void setmToDoDescription(String mToDoDescription){this.mToDoDescription = mToDoDescription;}

    public String getToDoText() {
        return mToDoText;
    }

    public void setToDoText(String mToDoText) {
        this.mToDoText = mToDoText;
    }

    public boolean hasReminder() {
        return mHasReminder;
    }

    public void setHasReminder(boolean mHasReminder) {
        this.mHasReminder = mHasReminder;
    }

    public Date getToDoDate() {
        return mToDoDate;
    }

    public int getTodoColor() {
        return mTodoColor;
    }

    public void setTodoColor(int mTodoColor) {
        this.mTodoColor = mTodoColor;
    }

    public void setToDoDate(Date mToDoDate) {
        this.mToDoDate = mToDoDate;
    }


    public UUID getIdentifier() {
        return mTodoIdentifier;
    }
}

