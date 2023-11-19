# Solution01 - 5.4 Q4
* We can use RSE and 
* The RSE is calculated via: 
$RSE=sqrt(SSE/(n-p-1))$ 
* The standard deviation of perdiction response can be calculated as: $SD(y_hat) = RSE * sqrt(1 + 1/n + (x - \overline{x})^2 / ((n-1) * SD(x)^2))$
# Solution02 - 5.4 Q8
1. 
* n is 100
* p is 1
* $Y = β0 + β1X + ε = X - 2*X^2 + ε$
2. The data is non-linear. Quadratic model that seems to fit the data correctly
3. The LOOCV errors (MSE) for randomly generated data with 0.5 see are:
	* Linear - 5.458
	* Quadratic - 0.907
	* Cubic - 0.902
	* Quartic - 0.889
4. Different seed yields data and models with similar error patterns, but of course, the LOOCV errors are a bit different
5. The smallest LOOCV error was observed in Quartic model. This was not expected because the model used to generate the data was cubic. Seems like randomness came into play.
6. The statistical significance of the coefficient estimates was best for $x^2$ because the model used to generate the data was also cubic 
# Solution03 - 6.6 Q1c
1. TRUE
2. FALSE
3. FALSE
4. FALSE
5. TRUE
# Solution04 - 6.6 Q2
1. Correct is ii - lasso is more flexible than least squares due to shrinking of coefficients towards zero
2. Correct is iii - ridge is less flexible than least squares due to effect of shrinking all coefficients towards 0
3. Correct is ii - non-linear methods are more likely to be more flexible and lasso is better for it
# Solution05 - 6.6 Q9a-d
1. 
```
set.seed(1)
train_index <- sample(1:nrow(College), size = 0.8*nrow(College))
train_data <- College[train_index, ]
test_data <- College[-train_index, ]
```
2. Error is 1567324
3. Error is 1761006
4. Error is 1695842 and number of non-zero coefficients is 3
# Solution06 - 6.6 Q10
3. ![[Pasted image 20230514170738.png]]
4. ![[Pasted image 20230514171158.png]]
Where black line represents training set and red line represents testing set
5. My result is that the lowest MSE is with 21 predictors. This can happen, but the model will be prone to overfitting
6. The values of the coefficients in the model with the minimum test set error tend to be smaller in size than the coefficients in the model with the minimum training set error.