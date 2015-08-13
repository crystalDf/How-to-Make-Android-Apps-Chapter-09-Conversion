package com.star.conversion;


import java.text.DecimalFormat;

public class Quantity {

    private final double value;
    private final Unit unit;

    public static enum Unit {
        tsp(1.0), cup(0.0208), tbs(0.3333), oz(0.1666), kg(0.0057), quart(0.0052),
        gallon(0.0013), pound(0.0125), ml(4.9289), liter(0.0049), mg(5687.5000), pint(0.0104);

        final static Unit baseUnit = tsp;

        final double byBaseUnit;

        private Unit(double inTsp) {
            this.byBaseUnit = inTsp;
        }

        public double toBaseUnit(double value) {
            return value / byBaseUnit;
        }

        public double fromBaseUnit(double value) {
            return value * byBaseUnit;
        }

    }

    public Quantity(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public Quantity to(Unit newUnit) {

        Unit oldUnit = this.unit;

        return new Quantity(newUnit.fromBaseUnit(oldUnit.toBaseUnit(value)), newUnit);
    }

    @Override
    public String toString() {

        DecimalFormat decimalFormat = new DecimalFormat("#.0000");

        return decimalFormat.format(value) + " " + unit.name();
    }

    public double getValue() {
        return value;
    }

    public Unit getUnit() {
        return unit;
    }
}
