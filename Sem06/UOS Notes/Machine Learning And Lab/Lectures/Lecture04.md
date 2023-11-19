# Model Accuracy
* Residual standard Error
![[Pasted image 20230328150930.png]]
* R-squared value - the larger the value, the better the model
![[Pasted image 20230328150944.png]]

# Model uncertainties
* *The gap between the actual model and the estimation* Y' - Y
* *Model bias* - model function is just a guess - but good approximation in many use-cases
* *The randomness of the data*

* Prediction Interval - Estimate of an interval in which a future observation will fall, with a certain probability, given what has already been observed
* Confidence Interval - Range of estimates for an unknown parameter. Probability that a population parameter will fall between a set of values

## Qualitative Predictors
* Some of the predictors are not quantitative but are qualitative, taking a discrete set of values
* There are also called categorical predictors or factor variables
* Example
	* Investigate differences in credit card balance between males and gemales ignoring the other variables
	* xi = 1 if the person is female or 0 if the person is male
	* Resulting model
		![[Pasted image 20230328154235.png]]
### Qualitative predictors with more than two levels
* With more than two levels, we create additional dummy variables
* For example ethnicity variable we create two dummy variables
* The first ![[Pasted image 20230328154741.png]]
* The second
![[Pasted image 20230328154756.png]]
* Then both of these variables can be used in the regression equation in order to obtain the model
![[Pasted image 20230328154918.png]]
* There will always be one fewer dummy variable than the number of levels
* For example, the African American in the example does not exist - this is known as *baseline*

# Linear Model Synergy
* Removing the additive assumption - interactions and nonlinearity
* Interactions - In our previous analysis, advertising data, we assumed that the effect on sales of increasing one advertising medium is independent of the amount spen on the other media
![[Pasted image 20230328155712.png]]
States that the average effect on sales of one-unit increase in TV is always β1, regardless of the amount spent on radio
* Suppose that spending money on radio advertising actually increases the effectiveness of TV advertising so that the slope tern for TV should increase as radio increases
* In this situation, given a fixed budget of 100000 dolars, spending half on radio and half on TV may increase sales more than allocating the entire amount to either TV or to radio
* In marketing, this is known as the synergy effect, and in statistics, it is referred to as an interaction
* We can see the synergy by adding an additional feature to the model that consist of the multiplication of TV and radio. This way, we can see the number of sales after advertising in TV and radio together
![[Pasted image 20230328160253.png]]

### Results
* Interactions are important
* P-value for the interaction term TV x radio is extremely low, indicating that there is strong evidence for Ha : β3 != 0
* The r^2 for the interaction model is 96.8%, compared to only 89,7% for the model that predicts sales using TV and radio without an interaction term
* This means that (96.8 − 89.7)/(100 − 89.7) = 69% of the variability in sales that remains after fitting the additive model has been explained by the interaction term
* The coefficient estimates in the table suggest that an increase in TV advertising of $1000 is associated with increased sales of (βˆ 1 + βˆ 3 × radio) x 1000 = 19 + 1.1 x radio units
* An increase in radio advertising of $1000 will be associated with an increase in sales

## Synergy between qualitative and quantitative variables
* Consider the credit data set, and suppose that we wish to predict balance using income (quantitative) and student (qualitative)
* Without an interaction term, the model takes the form of
![[Pasted image 20230328163412.png]]
With interactions
![[Pasted image 20230328163659.png]]
### Non-linear effects of predictors
* Exponential predictor - horsepower - may provide a better fit
![[Pasted image 20230328164451.png]]
### Problems
* Outliers
	* Data points significantly different from the predicted value y
	* It can be removed but it depends on the situation
* High leverage points
	* Observation with high leverage that has an unusual value for xi
* Correlated or non-constant variance or error terms
* Collinearity - Collinearity refers to the situation in which two or more predictor variables are closely related to one another
## Variance Inflation Factor
* Is the ratio of the variance of Bj when fitting the full model divided by the variance of Bj if fit on its own
// TODO Check collinearity

## Generalisation of the Linear Model
* Rest of the course will be addressing methods that expand the scope of linear models and how they are fit:
	* Classification problems - logistic regression, support vector machines
	* Non-linearity - kernel smoothing, spiling and generalized additive models
	* Interactions













### Check
* Hypothesis testing
* ![[Pasted image 20230328164406.png]]