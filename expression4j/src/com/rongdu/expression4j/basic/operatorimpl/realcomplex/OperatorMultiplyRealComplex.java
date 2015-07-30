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

package com.rongdu.expression4j.basic.operatorimpl.realcomplex;

import java.math.BigDecimal;
import java.math.MathContext;

import com.rongdu.expression4j.basic.MathematicalElement;
import com.rongdu.expression4j.basic.MathematicalException;
import com.rongdu.expression4j.basic.Operator;
import com.rongdu.expression4j.basic.OperatorImpl;
import com.rongdu.expression4j.basic.impl.ComplexImpl;
import com.rongdu.expression4j.core.exception.EvalException;
import com.rongdu.expression4j.util.MathUtil;

public class OperatorMultiplyRealComplex implements OperatorImpl {

	public boolean isUnaryOperator() {
		return false;
	}

	public int getLeftOperandeType() {
		return 1;
	}

	public int getRightOperandeType() {
		return 2;
	}

	public String getOperatorName() {
		return Operator.OPERATOR_MULTIPLY;
	}

	public MathematicalElement compute(MathContext mc,MathematicalElement leftElement,
			MathematicalElement rightElement) throws EvalException {
	    if(mc==null){
            mc=MathUtil.getDefaultMathContext();
        }
		try {
			BigDecimal realValue;
			BigDecimal complexValue;

			if (leftElement.getType() == 1 && rightElement.getType() == 2) {
				realValue = leftElement.getRealValue(mc).multiply(rightElement.getRealValue(mc), mc) ;
				complexValue = leftElement.getRealValue(mc) .multiply(rightElement.getComplexValue(mc),mc);
				return new ComplexImpl(realValue,complexValue);
			}
			else if (leftElement.getType() == 2 && rightElement.getType() == 1) {
				realValue = leftElement.getRealValue(mc).multiply(rightElement.getRealValue(mc),mc);
				complexValue = leftElement.getComplexValue(mc).multiply(rightElement.getRealValue(mc),mc);
				return new ComplexImpl(realValue,complexValue);
			}
			else {
				throw new EvalException("Incosistent element type for operator multiply real complex.");
			}
			
		}
		catch (MathematicalException me) {
			throw new EvalException("Cannot evaluate value for multiply real complex.",me);
		}
	}

}