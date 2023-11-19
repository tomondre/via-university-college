* Linear regression is a simple approach to supervised learning
* It assumes that the dependence of Y on X1, X2, ..., Xp is linear
* True regression functions are never linear
* Linear is useful both conceptually and practically

## Case Advertising data
* Is there a relationship between advertising budget and sales?
* How strong is the relationship between advertising budget and sales?
* Which media contribute to sales?
* How accurately can we predict future sales?
* Is the relationship linear?
* Is the synergy among the advertising media?

* Model
$$ Y=β_{0}+β_{1}X+ε $$
* Model with estimates $$ yˆ = βˆ_{0} + βˆ_{1}x $$
* Residual $$ e_{i}=y_{i}-yˆ_{i} $$
* Residual sum of squares
$$ RSS=e^2_{1} + e^2_{2} + ... + e^2_{n} $$
* Minimize RSS 
$$ βˆ_{1}=\frac {\sum_{i=1}^n(x_{i}-x̄)(y_{i}-ȳ_{})}{\sum_{i=1}^n(x_{i}-x̄)^2}  $$
$$ βˆ_{0}= ȳ-βˆ_{1}x̄$$

* Y Mean  $$ȳ≡\frac{1}{n} \sum_{i=1}^n y_{i} $$
* X Mean 
$$x̄≡\frac{1}{n} \sum_{i=1}^n x_{i} $$
* Variance
$$ Var=\frac {\sum_{i=1}^n(y_{i}-ȳ_{})^2}{n} $$
* Standard Error β1
$$ SE(β_{1})^2 = \frac {σ^2}{\sum_{i=1}^n(x_{i} - x̄)^2}  $$
* Standard Error β2
$$ SE(β_{1})^2 = σ^2 [\frac{1}{n} + \frac {x̄^2}{\sum_{i=1}^n(x_{i} - x̄)^2}]  $$
* Standard diviation
$$ σ = \sqrt{\; var(x)} $$
* Degrees of freedom - number of values in calculation that are free to vary without vioalting any constraints or assumptions in a statistical model
* Confidence interval
	* Gives us a range in which the true mean is likely to be found with certain probability
	* Defined as a range of values such that with 95% chance, the range will contain the trie unknown value of the parameter
$$ βˆ_{1} ± 2 * SE(βˆ_{1}) $$
## Hypothesis testing
* Standard errors can also be used to performa hypothesis tests in the coefficients
* The most common hypothesis test involves the null hypothesis of
	* H0 : β1 = 0 
	* H1 : β1 != 0
* Since β1 = 0, the the model redices to Y = β0 + e

* RSE - Residual Standard Error - can be seen as a measure of lack of fit
* TSS - Total Sum of Squares
* RSS - Residual Sum of Squares

* R-squared is mostly used to measure to determine the godness of fit
$$ R^2 = 1 - \frac{RSS}{TSS} $$
$$ r = \frac {\sum_{i=1}^n(x_{i} - x̄) * (y_{i} - ȳ)}{\sqrt{\sum_{i=1}^n(x_{i} - x̄)^2} * \sqrt{\sum_{i=1}^n(y_{i} - ȳ)^2}}  $$

# Multiple Linear Regression
Squared Residuals - Same as with single linear regression, but we take into account all input variables
$$ RSS=\sum(y_{i}- βˆ_{0} - βˆ_{1} - βˆ_{1}x_{i1} - ... - βˆ_{p}x_{ip})^2 $$

# Forward Selection
* Start with null model - model that contains intercept, but no predictors
* Fit p simple linear regressions and add to the null model the variable taht resilt in the lowest RSS
* Add to that model the bariable that results in the lowest RSS amongsg all two variables
* Continue until some stopping rule is satisfied, for example when all remaining vriavles have a p-value above some threshold

# Backward Selection
* Start with all variables in the model
* Remove the variable with the largest p-value - that is the variable that is the least statistically significant
* The new p-1 variable model is fir, and the variable with the largest p-value is removed
* Continue until a stopping rule is reached. For instance, we may when all remaining variables have significant p-value defined by some sifnificance threshold
* Which one to use
	* Depends

# Selection
* The very optimal is not quaranteed to be returned by forward and backward selection
* Why we would like to use forward/backward selection if it does not always returns the very optimal subset
	* Computionaly feasable
	* Faster than going through all options

