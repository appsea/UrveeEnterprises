package com.exuberant.urveeenterprises;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.exuberant.urveeenterprises.delegates.ServerSocketDelegate;
import com.exuberant.urveeenterprises.model.Product;
import com.exuberant.urveeenterprises.model.ProductBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.exuberant.urveeenterprises.R.id.autotextview;
import static com.exuberant.urveeenterprises.R.id.quantity;
import static com.exuberant.urveeenterprises.R.id.unit;

public class PlaceOrderActivity extends AppCompatActivity {

    private ServerSocketDelegate serverSocketDelegate = new ServerSocketDelegate();
    private ViewGroup parentLayout;
    private List<String> productNames;

    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        //getActionBar().setIcon(R.mipmap.ic_launcher);
        setContentView(R.layout.place_order);
        parentLayout = (ViewGroup) findViewById(R.id.parentPanel);
        productNames = serverSocketDelegate.getProductNames();
    }

    public void addNewRow(View view) {
        if (isValidForm()) {
            View singleItem = LayoutInflater.from(this).inflate(R.layout.single_item, parentLayout, false);
            final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) singleItem.findViewById(autotextview);
            final EditText quantityView = (EditText) singleItem.findViewById(quantity);
            final EditText unitView = (EditText) singleItem.findViewById(unit);
            addDropdownList(autoCompleteTextView, quantityView);
            parentLayout.addView(singleItem);
            autoCompleteTextView.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    autoCompleteTextView.setError(null);
                    if (keyCode == 66) {
                        quantityView.requestFocus();
                    }
                    return false;
                }
            });
            quantityView.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    quantityView.setError(null);
                    if (keyCode == 66) {
                        unitView.requestFocus();
                    }
                    return false;
                }
            });
            unitView.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    unitView.setError(null);
                    /*if (keyCode == 66) {
                        addNewRow(null);
                    }*/
                    return false;
                }
            });
        }
    }

    public void placeOrder(View view) {
        List<View> children = getAllChildren(parentLayout);
        ProductBuilder productBuilder = new ProductBuilder();
        for (View child : children) {
            if(isDataView(child) && !isEmpty(child)){
                final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) child.findViewById(autotextview);
                final EditText quantityView = (EditText) child.findViewById(quantity);
                final EditText unitView = (EditText) child.findViewById(unit);
                productBuilder.add(autoCompleteTextView.getText().toString(), quantityView.getText().toString(), unitView.getText().toString());
            }
        }
        Collection<Product> products = productBuilder.build();
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"girase.rakesh@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "Urvee Enterprise: First Order");
        i.putExtra(Intent.EXTRA_TEXT   , products.toString());
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean isValidForm() {
        List<View> children = getAllChildren(parentLayout);
        for (View child : children) {
            if (!validateAndShowErrorMessage(child)) {
                return false;
            }
        }
        return true;
    }

    private boolean validateAndShowErrorMessage(View view) {
        boolean isValid = true;
        if (isDataView(view)) {
            AutoCompleteTextView autotextView = (AutoCompleteTextView) view.findViewById(autotextview);
            EditText quantityView = (EditText) view.findViewById(R.id.quantity);
            EditText unitView = (EditText) view.findViewById(R.id.unit);
            if (TextUtils.isEmpty(autotextView.getText())) {
                autotextView.setError("Please select item here!!!");
                autotextView.requestFocus();
                isValid = false;
            }
            if (isValid && TextUtils.isEmpty(quantityView.getText())) {
                quantityView.setError("Please enter quantity here!!!");
                quantityView.requestFocus();
                isValid = false;
            }
            if (isValid && TextUtils.isEmpty(unitView.getText())) {
                unitView.setError("Please enter unit here!!!");
                unitView.requestFocus();
                isValid = false;
            }
        }
        return isValid;
    }

    private boolean isEmpty(View view) {
        boolean isEmpty = false;
        if (isDataView(view)) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) view.findViewById(autotextview);
            EditText quantityView = (EditText) view.findViewById(R.id.quantity);
            EditText unitView = (EditText) view.findViewById(R.id.unit);
            isEmpty = TextUtils.isEmpty(autoCompleteTextView.getText()) && TextUtils.isEmpty(quantityView.getText()) && TextUtils.isEmpty(unitView.getText());
        }
        return isEmpty;
    }

    private boolean isDataView(View view) {
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) view.findViewById(autotextview);
        EditText quantityView = (EditText) view.findViewById(R.id.quantity);
        EditText unitView = (EditText) view.findViewById(R.id.unit);
        return autoCompleteTextView != null && quantityView != null && unitView != null;
    }

    public void review(View view) {
        List<View> children = getAllChildren(parentLayout);
        for (View child : children) {
            if (!isEmpty(child)) {
                disbaleItem(child, autotextview, R.id.quantity, R.id.unit);
            } else {
                parentLayout.removeView(child);
            }
        }
    }

    private void disbaleItem(View child, int... elements) {
        for (int element : elements) {
            View item = child.findViewById(element);
            if (item != null) {
                item.setEnabled(false);
            }
        }
    }

    private List<View> getAllChildren(View v) {

        if (!(v instanceof ViewGroup)) {
            ArrayList<View> viewArrayList = new ArrayList<>();
            viewArrayList.add(v);
            return viewArrayList;
        }

        List<View> result = new ArrayList<>();

        ViewGroup viewGroup = (ViewGroup) v;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {

            View child = viewGroup.getChildAt(i);

            ArrayList<View> viewArrayList = new ArrayList<>();
            viewArrayList.add(v);
            viewArrayList.addAll(getAllChildren(child));
            result.addAll(viewArrayList);
        }
        return result;
    }

    public void addDropdownList(final AutoCompleteTextView autoCompleteTextView, final View focusView) {

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
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                autoCompleteTextView.setError(null);
                focusView.requestFocus();
            }
        });
        autoCompleteTextView.requestFocus();
        autoCompleteTextView.showDropDown();
    }
}