package com.exuberant.urvitraders;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import com.exuberant.urvitraders.delegates.ServerSocketDelegate;
import com.exuberant.urvitraders.urvitraders.R;

import java.util.List;

public class PlaceOrderActivity extends Activity {

    private ServerSocketDelegate serverSocketDelegate = new ServerSocketDelegate();
    private ViewGroup placeOrderLayout;
    private List<String> productNames;

    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.place_order);
        placeOrderLayout = (ViewGroup) findViewById(R.id.placeOrderLayout);

        productNames = serverSocketDelegate.getProductNames();

    }

    public void inflate(View view) {
        View singleItem = LayoutInflater.from(this).inflate(R.layout.single_item, placeOrderLayout, false);
        addDropdownList((AutoCompleteTextView) singleItem.findViewById(R.id.autotextview));
        placeOrderLayout.addView(singleItem);
    }

    public void addDropdownList(final AutoCompleteTextView autoCompleteTextView) {

        final ArrayAdapter<String> autoCompleteAdapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, productNames);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(autoCompleteAdapter);
        autoCompleteTextView.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
                if (!autoCompleteTextView.getText().toString().equals(""))
                    autoCompleteAdapter.getFilter().filter(null);
                autoCompleteTextView.showDropDown();
                return false;
            }
        });
    }
}