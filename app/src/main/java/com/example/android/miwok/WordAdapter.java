package com.example.android.miwok;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class WordAdapter extends ArrayAdapter<Word> {

    private int colorResourceID;

    public WordAdapter(Activity context, List<Word> words, int colorResourceID) {
        super(context, 0, words);
        this.colorResourceID = colorResourceID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Word currentWord = getItem(position);

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiwokTranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceID());
            imageView.setVisibility(View.VISIBLE);
        } else
            imageView.setVisibility(View.GONE);

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), colorResourceID);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
