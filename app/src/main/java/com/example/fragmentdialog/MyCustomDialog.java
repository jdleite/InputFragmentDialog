package com.example.fragmentdialog;

import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MyCustomDialog extends DialogFragment {

    private static final String TAG = "MyCustomDialog";

    public OnListener onListener;
    private EditText mInput;
    private TextView mActionOk,mActionCancel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_custom,container,false);

        mActionCancel = view.findViewById(R.id.action_cancel);
        mActionOk = view.findViewById(R.id.action_ok);
        mInput = view.findViewById(R.id.input);

        mActionCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"OnClick: closing dialog");
                getDialog().dismiss();
            }
        });

        mActionOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"OnClick: capturing input");
                String input = mInput.getText().toString();

                onListener.input(input);

                getDialog().dismiss();


            }
        });



        return view;
    }

    public interface OnListener{
        void input(String input);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {

            onListener = (OnListener) getActivity();
        }catch (ClassCastException e){
            Log.e(TAG,"OnAtach: ClassCastException: " + e.getMessage());
        }
    }
}
