

# Parametric Approach
## Notation
* X - Variants
* Y - Response -> Y = f(X) + ε
* ε
	* Epsilon
	* Measurements Errors and Discrepancies
	* Difference from the perfect scenario

## f(X)
* With a good *f*, we can make predictions of Y at new points X = x
* We can understand, which components of X = (X1, X2, ... , Xp) and which are irrelevant
	* E.g. Seniority, Years of Education have a big impact on Income and Marital Status typically does not
	![[Pasted image 20230314152140.png]]
* *f*(X) is the blue line
* Depending on the complexity of *f*, we may be able to understand how each component X*j* of X affects *Y*
* The goal is to find *f(X)* so that future Y values of X can be predicted


# Regression Function
![[Pasted image 20230314152606.png]]
* What is the ideal of *F(X)* at any selected value of X (e.g. X = 4)
* There can be many Y values at X = 4
* A good value is $$f(4) = E(Y | X = 4)$$
* E(Y | X = 4) => means expected (average) value of Y given X = 4
* This ideal *f(x) = E(Y | X = x)* is called the regression function
* Also defined for vector X $$ f(x) = f(x_ { 1 }, x_ { 2 }, x_ { 3 }) = E (Y|X_ {1} = x_{1}, X_ {2} = x_ {2}, X_ {3} = x_ {3}) $$
* The ideal or optimal predictor of Y with regard to mean-squared prediction error: $$ f(x)=E(Y|X = x) $$ is a function that minimizes $$ E[(Y - g(X))^2|X=x] $$ overall functions g at all points X = x
* ε = Y - f(x) is the irreducible error - even if we knew f(x), we would still make errors in prediction, since at each X=x there is typically  a distribution of possible Y values
* Typically, we have few if any data points with X = 4 exactly
* We cannot compute $$ E(Y|X=x) $$
* The goal is to borrow power of neighbours - these neighbours 
* It is important to require a specific region of points for accuracy
	* If the radius is small, we won't include enough points
	* If the radius is too big, we will include too many points

## Linear Model
![[Pasted image 20230314161602.png]]

## Quadratic Model
![[Pasted image 20230314161553.png]]


# Non-parametric Approach

![[Pasted image 20230314161718.png]]

# Flexibility vs. Interpretability
* The goal is to choose a proper method based on the input data
* The higher Interpretability, the lower flexibility
* The higher flexibility, the lower Interpretability
![[Pasted image 20230314162240.png]]

## Assessing Model Accuracy
* The goal is to have the smallest offset between the mean squared prediction error in the training data (MSETr) and fresh data (MSETe)
$$ MSE_{Tr} = Ave_ {iet}[(yi -F(x_{i})]^2 $$
 $$ MSE_{Te} = Ave_ {iet}[(yi -F(x_{i})]^2 $$
 
# Qualitative Classification
* e.g. email is one of C = (spam, ham)(ham = good email)
* e.g. digit class is one of C = {0, 1, 2, ... ,9}
* The goal is to 
	* Build a classifier C(X) that assigns a class level form C to a future unlabeled observation X
	* Assess the uncertainty in each classification
	* Understand the role of the different predictors amon X = (X1, X2, ... , Xp)
* Bayes optimal classifier
* Nearest neighbor method
## Bayes optimal classifier
![[Pasted image 20230314170258.png]]
## Nearest-Neighbour classifier
![[Pasted image 20230314170324.png]]


## Assessing Model Accuracy
* We measure the performance of C(x) - classifier using the misclassification error rate
* The Bayes classifier has the smallest error in the population
* Other methods - Support-vector

![[Pasted image 20230314171100.png]]
X = Number of neigbours in KNN
Y = Number of errors
