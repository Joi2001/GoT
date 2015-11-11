package com.example.android.gotcharacters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yhu on 11/10/15.
 */
public class CharacterListAdapter extends ArrayAdapter<GoTCharacter> {
    Context mContext;
    List<GoTCharacter> mCharacters;

    public CharacterListAdapter(
            Context context,
            int layoutResourceId,
            List<GoTCharacter> characters) {
        super(context, layoutResourceId, characters);
        mContext = context;
        mCharacters = characters;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        TextView textView = (TextView) view.findViewById(R.id.character_list_item_text);
        textView.setText(mCharacters.get(position).name);
        return view;
    }
}
