package com.example.vladislav.fragmentsvideo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;//can talk to main activity
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


//Creating a fragment
public class TopSectionFragment extends Fragment {

    private static EditText topTextInput;
    private static EditText bottomTextInput;

    TopSectionListener activityCommander;

    public interface TopSectionListener{
             public void createMeme(String top, String bottom);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            activityCommander = (TopSectionListener) activity;
        } catch (ClassCastException e){
            throw new ClassCastException(activity.toString());
        }
    }

    //press "alt insert" press "Overide Methods", press "onCreateView" press ok

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.top_section_fragment, container, false);


        topTextInput = (EditText) view.findViewById(R.id.topTextInput);
        bottomTextInput = (EditText) view.findViewById(R.id.bottomTextInput);
        final Button button = (Button) view.findViewById(R.id.button);

        button.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        buttonClicked(v);
                    }
                }
        );

        return view;
    }
    //Calls this when the button is clicked
    public void buttonClicked(View view)
    {
        activityCommander.createMeme(topTextInput.getText().toString(),bottomTextInput.getText().toString());
    }
}