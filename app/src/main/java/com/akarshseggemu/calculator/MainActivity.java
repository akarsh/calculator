/*
 * Copyright 2017 Akarsh Seggemu
 *
 * This file is part of the android application project Calculator.
 *
 * This program is free software: you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.akarshseggemu.calculator;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.akarshseggemu.calculator.databinding.MainActivityBinding;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    DecimalFormat decimalFormat = new DecimalFormat("#.##########");
    private double valueOne = Double.NaN;
    private double valueTwo;
    private char CURRENT_ACTION;
    private MainActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity);


    /*Butoon zero*/
        binding.buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "0");
            }
        });
        /*Button One*/
        binding.buttonOne.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.editText.setText(binding.editText.getText() + "1");
            }
        });
        /*Button Two*/
        binding.buttonTwo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.editText.setText(binding.editText.getText() + "2");
            }
        });
        /*Button Three*/
        binding.buttonThree.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.editText.setText(binding.editText.getText() + "3");
            }
        });
        /*Button Four*/
        binding.buttonFour.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.editText.setText(binding.editText.getText() + "4");
            }
        });
        /*Button Five*/
        binding.buttonFive.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.editText.setText(binding.editText.getText() + "5");
            }
        });
        /*Button Six*/
        binding.buttonSix.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.editText.setText(binding.editText.getText() + "6");
            }
        });
        /*Button Seven*/
        binding.buttonSeven.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.editText.setText(binding.editText.getText() + "7");
            }
        });
        /*Button Eight*/
        binding.buttonEight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.editText.setText(binding.editText.getText() + "8");
            }
        });
        /*Button Nine*/
        binding.buttonNine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.editText.setText(binding.editText.getText() + "9");
            }
        });
        /*Button Add*/
        binding.buttonAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                computeCalculation();
                CURRENT_ACTION = ADDITION;
                binding.informationTextView.setText(decimalFormat.format(valueOne) + "+");
                binding.editText.setText(null);
            }
        });
        /*Button Subtract*/
        binding.buttonSubtract.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                computeCalculation();
                CURRENT_ACTION = SUBTRACTION;
                binding.informationTextView.setText(decimalFormat.format(valueOne) + "-");
                binding.editText.setText(null);
            }
        });
        /*Button Multiply*/
        binding.buttonMultiply.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                computeCalculation();
                CURRENT_ACTION = MULTIPLICATION;
                binding.informationTextView.setText(decimalFormat.format(valueOne) + "*");
                binding.editText.setText(null);
            }
        });
        /*Button Division*/
        binding.buttonDivision.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                computeCalculation();
                CURRENT_ACTION = DIVISION;
                binding.informationTextView.setText(decimalFormat.format(valueOne) + "/");
                binding.editText.setText(null);
            }
        });
        /*Button Equal*/
        binding.buttonEqual.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                computeCalculation();
                binding.informationTextView.setText(binding.informationTextView.getText().toString() + decimalFormat.format(valueTwo) + " = " + decimalFormat.format(valueOne));
                valueOne = Double.NaN;
                CURRENT_ACTION = '0';
            }
        });
        /*Button Clear*/
        binding.buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.editText.getText().length() >0){
                    CharSequence currentText = binding.editText.getText();
                    binding.editText.setText(currentText.subSequence(0, currentText.length()-1));
                }
                else {
                    valueOne = Double.NaN;
                    valueTwo = Double.NaN;
                    binding.editText.setText("");
                    binding.informationTextView.setText("");
                }
            }
        });
    }

    /*Perform calculation*/
    private void computeCalculation(){
        if(!Double.isNaN(valueOne)){
            valueTwo = Double.parseDouble(binding.editText.getText().toString());
            binding.editText.setText(null);

            if(CURRENT_ACTION == ADDITION)
                valueOne = this.valueOne + valueTwo;
            else if(CURRENT_ACTION == SUBTRACTION)
                valueOne = this.valueOne - valueTwo;
            else if(CURRENT_ACTION == MULTIPLICATION)
                valueOne = this.valueOne * valueTwo;
            else if (CURRENT_ACTION == DIVISION)
                valueOne = this.valueOne / valueTwo;
        }
        else {
            try {
                valueOne = Double.parseDouble(binding.editText.getText().toString());
            }
            catch (Exception e){
            }
        }
    }
}
