//Copyright 2006 Stephane GINER
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.

package com.rongdu.expression4j.test.simple;

import java.math.MathContext;

import com.rongdu.expression4j.core.Expression;
import com.rongdu.expression4j.core.exception.EvalException;
import com.rongdu.expression4j.core.exception.ParsingException;
import com.rongdu.expression4j.factory.ExpressionFactory;
import com.rongdu.expression4j.util.MathUtil;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * test addition in expression
 * @author SGINER
 *
 */
public class TestSoustraction extends TestCase {
    private static MathContext mc=MathUtil.getDefaultMathContext();
	public static Test suite() {
		return new TestSuite(TestSoustraction.class);
	}

	public void testSoustraction1() {
		String expressionString = "f()=2-1";
		try {
			Expression expression = ExpressionFactory.createExpression(expressionString);
			assertEquals(1.0,expression.evaluate(null).getRealValue(mc).doubleValue(),0);
		}
		catch (ParsingException pe) {
			fail("Cannot parse simple expression. " + pe);
		}
		catch (EvalException ee) {
			fail("Cannot evaluate expression " + expressionString + ", " + ee);
		}
		
	}

	public void testSoustraction2() {
		String expressionString = "f()=1-2-3";
		try {
			Expression expression = ExpressionFactory.createExpression(expressionString);
			assertEquals(-4.0,expression.evaluate(null).getRealValue(mc).doubleValue(),0);
		}
		catch (ParsingException pe) {
			fail("Cannot parse simple expression. " + pe);
		}
		catch (EvalException ee) {
			fail("Cannot evaluate expression " + expressionString + ", " + ee);
		}
	}

	public void testSoustraction3() {
		String expressionString = "f()=4-3-2-1";
		try {
			Expression expression = ExpressionFactory.createExpression(expressionString);
			assertEquals(-2.0,expression.evaluate(null).getRealValue(mc).doubleValue(),0);
		}
		catch (ParsingException pe) {
			fail("Cannot parse simple expression. " + pe);
		}
		catch (EvalException ee) {
			fail("Cannot evaluate expression " + expressionString + ", " + ee);
		}
	}
	
	public void testSoustractionUnariOperator1() {
		String expressionString = "f()=1";
		try {
			Expression expression = ExpressionFactory.createExpression(expressionString);
			assertEquals(1.0,expression.evaluate(null).getRealValue(mc).doubleValue(),0);
		}
		catch (ParsingException pe) {
			fail("Cannot parse simple expression. " + pe);
		}
		catch (EvalException ee) {
			fail("Cannot evaluate expression " + expressionString + ", " + ee);
		}
	}

	public void testSoustractionUnariOperator2() {
		String expressionString = "f()=-1";
		try {
			Expression expression = ExpressionFactory.createExpression(expressionString);
			assertEquals(-1.0,expression.evaluate(null).getRealValue(mc).doubleValue(),0);
		}
		catch (ParsingException pe) {
			fail("Cannot parse simple expression. " + pe);
		}
		catch (EvalException ee) {
			fail("Cannot evaluate expression " + expressionString + ", " + ee);
		}
	}

	public void testSoustractionUnariOperator3() {
		String expressionString = "f()=1--1";
		try {
			Expression expression = ExpressionFactory.createExpression(expressionString);
			assertEquals(2.0,expression.evaluate(null).getRealValue(mc).doubleValue(),0);
		}
		catch (ParsingException pe) {
			fail("Cannot parse simple expression. " + pe);
		}
		catch (EvalException ee) {
			fail("Cannot evaluate expression " + expressionString + ", " + ee);
		}
	}

	public void testSoustractionUnariOperator4() {
		String expressionString = "f()=-1--1--1";
		try {
			Expression expression = ExpressionFactory.createExpression(expressionString);
			assertEquals(1.0,expression.evaluate(null).getRealValue(mc).doubleValue(),0);
		}
		catch (ParsingException pe) {
			fail("Cannot parse simple expression. " + pe);
		}
		catch (EvalException ee) {
			fail("Cannot evaluate expression " + expressionString + ", " + ee);
		}
	}
	
	public void testSoustractionInvalidExpression1() {
		String expressionString = "f()=-1---1--1";
		try {
			ExpressionFactory.createExpression(expressionString);
			fail("Can parse an invalid expression.");
		}
		catch (ParsingException pe) {
		}
	}

	public void testSoustractionInvalidExpression2() {
		String expressionString = "f()=-1-";
		try {
			ExpressionFactory.createExpression(expressionString);
			fail("Can parse an invalid expression.");
		}
		catch (ParsingException pe) {
		}
	}
	
	public void testSoustractionInvalidExpression3() {
		String expressionString = "f()=--1";
		try {
			ExpressionFactory.createExpression(expressionString);
			fail("Can parse an invalid expression.");
		}
		catch (ParsingException pe) {
		}
	}
	
	public void testSoustractionInvalidExpression4() {
		String expressionString = "f()=-1--1--1--1--1--1--1--1--1--1--1--1---1";
		try {
			ExpressionFactory.createExpression(expressionString);
			fail("Can parse an invalid expression.");
		}
		catch (ParsingException pe) {
		}
	}
	
}
