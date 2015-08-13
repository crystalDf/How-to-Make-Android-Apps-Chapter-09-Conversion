package com.star.conversion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Spinner unitTypeSpinner;
    private EditText amountEditText;

    private TextView
        teaspoonTextView, cupTextView, tablespoonTextView, ounceTextView, kilogramTextView,
        quartTextView, gallonTextView, poundTextView, milliliterTextView, literTextView,
        milligramTextView, pintTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addItemsToUnitTypeSpinner();

        addListenerToUnitTypeSpinner();

        amountEditText = (EditText) findViewById(R.id.amount_edit_text);

        initializeTextViews();

    }

    private void addItemsToUnitTypeSpinner() {

        unitTypeSpinner = (Spinner) findViewById(R.id.unit_type_spinner);

        ArrayAdapter<CharSequence> unitTypeSpinnerAdapter = ArrayAdapter.createFromResource(
                this, R.array.conversion_types, android.R.layout.simple_spinner_item
        );

        unitTypeSpinnerAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        unitTypeSpinner.setAdapter(unitTypeSpinnerAdapter);
    }

    private void addListenerToUnitTypeSpinner() {

        unitTypeSpinner = (Spinner) findViewById(R.id.unit_type_spinner);

        unitTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemSelectedInSpinner = (String) parent.getItemAtPosition(position);

                checkIfConvertingFromTsp(itemSelectedInSpinner);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void initializeTextViews() {

        teaspoonTextView = (TextView) findViewById(R.id.tsp_text_view);
        cupTextView = (TextView) findViewById(R.id.cup_text_view);
        tablespoonTextView = (TextView) findViewById(R.id.tbs_text_view);
        ounceTextView = (TextView) findViewById(R.id.oz_text_view);
        kilogramTextView = (TextView) findViewById(R.id.kg_text_view);
        quartTextView = (TextView) findViewById(R.id.quart_text_view);
        gallonTextView = (TextView) findViewById(R.id.gallon_text_view);
        poundTextView = (TextView) findViewById(R.id.pound_text_view);
        milliliterTextView = (TextView) findViewById(R.id.ml_text_view);
        literTextView = (TextView) findViewById(R.id.liter_text_view);
        milligramTextView = (TextView) findViewById(R.id.mg_text_view);
        pintTextView = (TextView) findViewById(R.id.pint_text_view);

    }

    private void checkIfConvertingFromTsp(String currentUnit) {

        if (currentUnit.equals("teaspoon")) {
            updateUnitTypeUsingTsp(Quantity.Unit.tsp);
        } else {
            if (currentUnit.equals("cup")) {
                updateUnitTypeUsingOther(Quantity.Unit.cup);
            } else if (currentUnit.equals("tablespoon")) {
                updateUnitTypeUsingOther(Quantity.Unit.tbs);
            } else if (currentUnit.equals("ounce")) {
                updateUnitTypeUsingOther(Quantity.Unit.oz);
            } else if (currentUnit.equals("kilogram")) {
                updateUnitTypeUsingOther(Quantity.Unit.kg);
            } else if (currentUnit.equals("quart")) {
                updateUnitTypeUsingOther(Quantity.Unit.quart);
            } else if (currentUnit.equals("gallon")) {
                updateUnitTypeUsingOther(Quantity.Unit.gallon);
            } else if (currentUnit.equals("pound")) {
                updateUnitTypeUsingOther(Quantity.Unit.pound);
            } else if (currentUnit.equals("milliliter")) {
                updateUnitTypeUsingOther(Quantity.Unit.ml);
            } else if (currentUnit.equals("liter")) {
                updateUnitTypeUsingOther(Quantity.Unit.liter);
            } else if (currentUnit.equals("milligram")) {
                updateUnitTypeUsingOther(Quantity.Unit.mg);
            } else if (currentUnit.equals("pint")) {
                updateUnitTypeUsingOther(Quantity.Unit.pint);
            }
        }

    }

    private void updateUnitTypeUsingTsp(Quantity.Unit currentUnit) {

        double doubleToConvert = Double.parseDouble(amountEditText.getText().toString());

        String teaspoonValueAndUnit = doubleToConvert + " tsp";

        teaspoonTextView.setText(teaspoonValueAndUnit);

        updateUnitTextFieldUsingTsp(doubleToConvert, Quantity.Unit.tsp, teaspoonTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, Quantity.Unit.cup, cupTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, Quantity.Unit.tbs, tablespoonTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, Quantity.Unit.oz, ounceTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, Quantity.Unit.kg, kilogramTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, Quantity.Unit.quart, quartTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, Quantity.Unit.gallon, gallonTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, Quantity.Unit.pound, poundTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, Quantity.Unit.ml, milliliterTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, Quantity.Unit.liter, literTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, Quantity.Unit.mg, milligramTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, Quantity.Unit.pint, pintTextView);
    }

    private void updateUnitTypeUsingOther(Quantity.Unit currentUnit) {

        double doubleToConvert = Double.parseDouble(amountEditText.getText().toString());

        Quantity currentQuantitySelected = new Quantity(doubleToConvert, currentUnit);

        String valueInTeaspoons = currentQuantitySelected.to(Quantity.Unit.tsp).toString();

        teaspoonTextView.setText(valueInTeaspoons);

        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit, Quantity.Unit.cup, cupTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit, Quantity.Unit.tbs, tablespoonTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit, Quantity.Unit.oz, ounceTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit, Quantity.Unit.kg, kilogramTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit, Quantity.Unit.quart, quartTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit, Quantity.Unit.gallon, gallonTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit, Quantity.Unit.pound, poundTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit, Quantity.Unit.ml, milliliterTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit, Quantity.Unit.liter, literTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit, Quantity.Unit.mg, milligramTextView);
        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit, Quantity.Unit.pint, pintTextView);

        if (currentUnit.name().equals(currentQuantitySelected.getUnit().name())) {

            String currentUnitTextViewText = doubleToConvert + " " +
                    currentQuantitySelected.getUnit().name();

            String currentTextViewName = currentQuantitySelected.getUnit().name() + "_text_view";

            int currentId = getResources().getIdentifier(currentTextViewName, "id",
                    this.getPackageName());

            TextView currentTextView = (TextView) findViewById(currentId);

            currentTextView.setText(currentUnitTextViewText);
        }

    }

    private void updateUnitTextFieldUsingTsp(double doubleToConvert,
                                             Quantity.Unit unitConvertTo, TextView theTextView) {

        Quantity unitQuantity = new Quantity(doubleToConvert, Quantity.Unit.tsp);

        String tempUnit = unitQuantity.to(unitConvertTo).toString();

        theTextView.setText(tempUnit);
    }

    private void updateUnitTextFieldUsingTsp(double doubleToConvert, Quantity.Unit currentUnit,
                                             Quantity.Unit preferredUnit, TextView theTextView) {

        Quantity unitQuantity = new Quantity(doubleToConvert, currentUnit);

        String tempUnit = unitQuantity.to(preferredUnit).toString();

        theTextView.setText(tempUnit);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
