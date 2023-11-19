# Regularization
* Implemented to avoid overfitting of the data - especially when there is a lrage variance between rain and test set performance
* It involves adding a penalty term to the loss function (MSE calculation)
* Can take different forms
	* L1 regularisation - Lasso
	* L2 regularisation - Ridge

## Lasso
* Lasso
	* Tends to shrink some of the model coefficients to exactly zero - removing some feature from the model
* 
## Ridge
* Tends to shrink the coefficient values to the zero without setting any coefficient to zero - the feature is still part of the model
* Useful for improving model stability and reducing the impact of multicollinearity between predictors

# Both
* In general, lasso has a better performance than the ridge

## Selecting regularization hyperparameters
* Problem: For ridge regression and lasso, we require a method to determin which models under consideration is the best => we require method for selecting a value for $\lambda$ or equivalently, the value of constrain s
* Cross-validation n provides a simple way to tackle the corss validation error late for each value of $\lambda$
* We select tuning parameter value for which the cross-validaiton error is smallest
* Finally, the model is re-fit using all of the available observations and the selected value of then tuning parameter

# Dimension reduction methods
* Class of approaches that transform the predictors and then fit a least squares model using the transformed variables
* Proccess do reducing the number of variables or features in a dataset while retaining as much information as possible
* High-dimensional models can be difficult to analyze and may lead to overfittign or other problems
* Examples
	* Principal Component Analysis (PCA)
	* Linear Discriminant Analysis (LDA)
## PCA
* Principal Component Analysis
* Consist of first principal component and optionally second
* The second principal component is orthonogal to the first one

# Moving beyond linearity
* 