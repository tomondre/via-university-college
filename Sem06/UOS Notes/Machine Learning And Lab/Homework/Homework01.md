## Solution01 - 2.4, Q2
* CEO affect salary 
	* Regression problem due to the reason that the CEO's salary is a quantitative prediction.
	* Inference, in this case, because we are interested  in factors that affect the salary
	* n = 500 (500 companies are included in the data set)
	* p = 3 (3 predictors/independent values: profit, number of employees, industry)
* Launch of new product
	* Classification - We should predict whether a product will be a success or a failure - two categories.
	* Prediction - the task is to predict success/failure
	* p = 13 (price charged for the product, marketing budget, competition price, and ten other variables)
	* n = 20 (number of products)
* USD/Euro exchange rate
	* Regression - the value we are predicting is quantitative - % change
	* Prediction - we are predicting the value and not looking for relationships
	* n = 52 (number of weeks)
	* p = 3 (number of market which we use for the prediction - US, British, German)

## Solution02 - 2.4, Q10 - Boston Housing Data Set
### a. 
* The data set has 14 columns and 4506 rows. 
* The rows represent a suburb and the columns contain different data for the suburb
### b. 
	![[Pasted image 20230403115001.png]]
### c.  
* A correlation exists between "per capita crime rate" and medv (median value of the owner-occupied home). The lower the value, the more the crime rate
* Also, a correlation exists between "per capita crime rate" and age (proportion of owner-occupied units built prior to 1940s). The older the unit, the more the crime rate
### d. 

* Crime rate: 0.00632 to 88.976 - range(Boston$crim)
* Tax rates: 187 to 711 - range(Boston$tax)
* Pupil-teacher: 12.6 to 22.0 - range(Boston$ptratio)
### e.
* There are 35 suburbs in the data set bound to the Charles river
* sum(Boston$chas == 1)
### f.
* Median pupil-teacher ratio is 19.05
* median(Boston$ptratio)
### g.
* Boston[which.min(Boston$medv),]![[Pasted image 20230403122501.png]]
* The least median value of owner-occupied homes is in a suburb that has the oldest homes by age.
### h.
* How many of the suburbs average more than seven rooms per dwlling?
	* sum(Boston$rm > 7)
	* 64
* More than eight rooms per dwelling?
	* sum(Boston$rm > 8)
	* 13
## Solution03 - 3.7, Q5 - Linear and Cubic regression
### a.
* RSS is expected to be lower for linear regression, due to the fact that the relationship between X and Y is linear and not cubic
* The lower the RSS, the better the model fit of the data
### b.
* There can be a difference between test and training data, therefore also the RSS may change significantly.
* The test RSS is used to validate the model fit on the data that the model has not seen before, therefore there can be a difference
### c.
* There is not enough information to tell
* The RSS changes depending on the fit (as already mentioned)
* The nature of data can be significantly different, and in some cases cubic model is better than the linear and vice versa.
* The linear model is usually best choice in most of the cases due to the fact that the model can avoid overfitting the data
### d.
* Same as in answer b - the data can be different between training and test data, therefore we cannot assume RSS without actually calculating it.

## Solution04 - 3.7, Q7 - Prove that Y, X's R^2 statistics is equal to X, Y's cor^2

$$
R^2 = 1 - [(∑(Y_i - Ŷ_i)^2) / (∑(Y_i - Ȳ)^2)]
$$
$$
Ŷ_i = b_0 + b_1X_i
$$
$$
Ŷ_i = b_0 + b_1X_i
$$
$$
Ŷ_i = Ȳ + [(∑(X_i - X̄)(Y_i - Ȳ)) / (∑(X_i - X̄)^2)](X_i - X̄)
$$
$$
R^2 = 1 - [{∑(Y_i - Ȳ)^2 - [(∑(X_i - X̄)(Y_i - Ȳ))^2 / ∑(X_i - X̄)^2]} / ∑(Y_i - Ȳ)^2]
$$
$$
(∑(X_i - X̄)^2 * ∑(Y_i - Ŷ_i)^2) / (∑(X_i - X̄)^2 * ∑(Y_i - Ȳ)^2)
$$
$$
R^2 = (∑(X_i - X̄)(Y_i - Ȳ))^2 / (∑(X_i - X̄)^2 * ∑(Y_i - Ȳ)^2)
$$
$$
R^2 = (∑(X_i - X̄)(Y_i - Ȳ))^2 / (∑(X_i - X̄)^2 * ∑(Y_i - Ȳ)^2) = (Corr(X,Y))^2
$$

## Solution05 - 3.7, Q13 - Simulated data linear regression model creation

### a., b., c.,
```
set.seed(1)
x <- rnorm(n = 100, mean = 0, sd = 1)
eps <- rnorm(n = 100, mean = 0, sd = 0.5)

linear_calculation <- function(x, eps) {
  Y <- -1 + (0.5 * x) + eps
  return(Y)
}

linear_calculation(x, eps)
```

The length of vector y is 100 - same length as the two input vectors
β0 = -1
β1 = 0.5
### d. 
![[Pasted image 20230403144623.png]]
I observe a linear relationship between the two values x and y
### e.
* lm.fit <- lm(y ~ x)
* summary(lm.fit)
* The estimated intercept equals to -0.97117, and the estimated slope equals to 0.47216,
* The results are very similar to the actual β0 and β1. If the dataset would be bigger than 100 points, the data would be even closer to these two values
### f.
* plot(x, y)
* abline(lm.fit, col = "red")
* ![[Pasted image 20230403160013.png]]
* ![[Pasted image 20230403160032.png]]
### g.
* polynomial_regression_model <- lm(y ~ poly(x, 2))
* summary(polynomial_regression_model)
* The polynomial regression model improves the mode fit due to the fact that its p value is smaller than the linear regression model's
![[Pasted image 20230403160047.png]]
![[Pasted image 20230403160053.png]]
### h.
* I have chosen a variance of 0.1, which equals approximately to standard deviation of 0.3162. 
* The linear regression has very similar intercept and slope value after fitting the model
* ![[Pasted image 20230403155922.png]]
* ![[Pasted image 20230403155929.png]]
* ![[Pasted image 20230403155943.png]]
* ![[Pasted image 20230403155952.png]]

### i.
* I have chosen a variance of 0.5, which equals approximately to standard deviation of 0.7071
* ![[Pasted image 20230403155811.png]]
* ![[Pasted image 20230403155824.png]]
* ![[Pasted image 20230403155847.png]]
* ![[Pasted image 20230403155857.png]]
### j.
Original Linear
![[Pasted image 20230403161302.png]]
Original Cubic
![[Pasted image 20230403161333.png]]
Less noisy Linear
![[Pasted image 20230403161349.png]]
Less noisy Cubic
![[Pasted image 20230403161408.png]]
More noisy Linear
![[Pasted image 20230403161426.png]]
More noisy Cubic
![[Pasted image 20230403161439.png]]
* Results:
	* The bigger the noisiness, the lower confidence we have that the value will be in a confidence interval

## Solution06 - 3.7, Q14 - Collinearity problem
### a.
The form of the model is as following:
$$ Y=β_{0}+β_{1}X+β_{2}X+ε $$

### b.
There seems to be a linear collection between independent variables x1 and x2. This is bad because they are not actually independent
![[Pasted image 20230403162329.png]]

### c.
![[Pasted image 20230403163117.png]]
* We can reject the null hypothesis in case of β1, due to the fact that β1 is smaller than 0.05.
* However, we cannot reject the null hypothesis for β2, due to the value being signifiantly bigger than 0.05
### d.
![[Pasted image 20230403163636.png]]
![[Pasted image 20230403163704.png]]
x1 is statistically significant due to the p value being smaller than 0.05, therefore we can reject null hypothesis
### e.
![[Pasted image 20230403163755.png]]
![[Pasted image 20230403163804.png]]
x2 is not statistically significant due to the value being bigger than 0,05. Therefore we cannot reject the null hypothesis
### f.
The results obtained contradict each other, because only when we separate the independent variables, we can see what relationship there is between y and x
### g. 
#### Least square regression
![[Pasted image 20230403164607.png]]
The conclusion is that the x2 is now statistically significant after we add the value 0.8 to x2. 
#### Least square regression with only x1
![[Pasted image 20230403165450.png]]
#### Least square regression with only x2
![[Pasted image 20230403165548.png]]

In both of the cases (x1, x2) the value reject non null hypothesis due to the p value being smaller than 0.05

The added point x2 = 0.8 and x1 = 0.1 is a high leverage point due to the fact that its x2 value does not follow any trend on their and x1 axis and is the biggest value of the set