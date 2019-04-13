/*
 * Copyright 2018, Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.SimpleCalcUnitTest;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * JUnit4 unit tests for the calculator logic. These are local unit tests; no device needed
 */
@RunWith(JUnit4.class)
@SmallTest
public class CalculatorTest {

    private Calculator mCalculator;

    /**
     * Set up the environment for testing
     */
    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }

    /**
     * Test for simple addition
     */
    @Test
    public void addTwoNumbers() {
        double resultAdd = mCalculator.add(1d, 1d);
        assertThat(resultAdd, is(equalTo(2d)));
    }

    @Test
    public void addTwoNumbersNegative() {
        double resultAdd = mCalculator.add(-1d, 2d);
        assertThat(resultAdd, is(equalTo(1d)));
    }

    @Test
    public void addTwoNumbersFloats() {
        double resultAdd = mCalculator.add(1.111f, 1.111d);

        //use close to for when precision is not too acurate but close.
        assertThat(resultAdd, is(closeTo(2.222, 0.01)));



    }
    @Test
    public void subTwoNumbers(){
        double result =mCalculator.sub(2d,2d);
        assertThat(result,is(equalTo(0d)));
    }

    @Test
    public void subWorksWithNegativeResults(){
        double result=mCalculator.sub(4d,-2d);
        assertThat(result,is(equalTo(6d)));

    }

    @Test
    public void mulTwoNumbers(){
        double result=mCalculator.mul(2d,2d);
        assertThat(result,is(equalTo(4d)));

    }
    @Test
    public void mulTwoNumbersZero(){
        double result=mCalculator.mul(2d,0d);
        assertThat(result,is(equalTo(0d)));
        double result1=mCalculator.mul(0d,3d);
        assertThat(result1,is(equalTo(0d)));
    }

    @Test
    public void divTwoNumbers(){
        double result=mCalculator.div(10d,2d);
        assertThat(result,is(equalTo(5d)));

        double result1=mCalculator.div(10d,3d);
        //delta number should be in range
        assertThat(result1,is(closeTo(3d,0.34)));
    }
/*    @Test
    public void divTwoNumbersZero() {
        double resultDiv = mCalculator.div(32d,0);
        assertThat(resultDiv, is(equalTo(Double.POSITIVE_INFINITY)));
    }*/

@Rule
public ExpectedException thrown = ExpectedException.none();
@Test
    public void divTwoNumbersZero() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("must not be zero");
        double resultDiv = mCalculator.div(32d, 0);
        //assertThat(resultDiv, is(equalTo(Double.POSITIVE_INFINITY)));

    }
    @Test(expected = IllegalArgumentException.class)
    public void divTwoNumbersZeroo() {
 /*       thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("must not be zero");*/
        double resultDiv = mCalculator.div(32d, 0);
        //assertThat(resultDiv, is(equalTo(Double.POSITIVE_INFINITY)));

    }


        //The assertThat() method
    // is used with matchers. Matchers are the chained method calls in the second operand of this assertion,



}