
# Classification
* Qualitative variables take values in an unordered set C, such as
	* eye color ∈ {brown, blue, green}
	* email ∈ {spam, ham}
* Given feature vector X and a qualitative response Y taking values in the set C, the classification task is to build a function C(X) that take as input the feature vector X and predicts its value for Y; i.e. C(X) ∈ C
* Often we are more interested in estimating the probabilities that X belongs to each category in C
* For example, it is more valuable to have an estimate of the probability that an insurance claim is fraudulent than a classification fraudulent or not

## Can Linear regression be used?
* Suppose for the default classification task that we code
	![[Pasted image 20230404151358.png]]
* Can linear regression of Y on X be performed and classified as yes if Y^ > 0.5?
* In the case of a binary outcome, linear regression does a good job as classifies, equivalent to linear discriminant analysis, which will be discussed later
* Since the population E(Y|X = x) Pr(Y = 1|X=x), we might think that regression is perfect for this task
* Linear regression might not produce probabilities less than zero or bigger than one - Logistic regression is more appropriate

# Logistic Regression
* One of the most popular Machine Learning algorithms
* Comes under supervised learning
* Mostly used for classification
* The output of logistic regression is used to predict the categorical dependent variable with the help of the independent variables
* Output can be only between 0 and 1
* Can be used where the probabilities between two classes are required

## Example
* Suposse we have a response variable with three possible values - patient presents at the emergency room and needs to be classified according to their symptoms
* Y = {     1      if stroke;
		2     if drug overdose
		3     if epileptic seizure
* This coding suggests an ordering, and in fact implies that the difference between strok and drug overdose is the same as between drug overdose and epileptic seizure
* Linear regression is not appropriate here
* Multiclass Logistic Regression or Doscirminant Analysis are more appropriate
* Let's write p(x) = PR(Y = 1|X) for short and consider using balance to predict default
* Logistic regression uses the form 
![[Pasted image 20230404153400.png]]
* Euler's number => e ≈ 2.71828
* It is easy to see that no matter what values β0, β1 or X take, p (X) will have values between 0 and 1
* Rearrangement gives
![[Pasted image 20230404153705.png]]
* The transformation is called the log odds or logit transformation of p(x) ( - by log, we mean natural log: In)
* We use maximum likelihood to estimate the parameters
![[Pasted image 20230404153833.png]]
* The likelihood function gibes a probability of the observed zeros and ones in the data. We pick β0 and β1 to maximize the likelihood of the observed data
* Most statistical packages can fit linear logistic regression models by maximum likelihood
* In R we use the glm function
![[Pasted image 20230404155914.png]]
![[Pasted image 20230404160355.png]]

# Example Student predictor
![[Pasted image 20230404160438.png]]

## Logistic regression with more than two classes
* One version (used in the R package glmnet) has the symmetric form
![[Pasted image 20230404163529.png]]
* Here there is a linear function for each class
* Mather students will recognize that some cancellation is possible, and only K - 1 lienar functions are needed as in 2-class logistic regression
* Multiclass logistic regression is also referred to as multinomial regression
* Log odds ratio between the kth and k'th classes
![[Pasted image 20230404163839.png]]

# Discriminant Analysis
* Model the distribution of X in each of the classes separately, and then use Bayes theorem to flip things around and obtain Pr(Y | X)
* Thomas Bayes - famous mathematician
* Bayes Theorem:
![[Pasted image 20230404164835.png]]
* Can be used for discriminant analysis:
![[Pasted image 20230404164926.png]]
fx(x) => is the ==density== for X in class K. Normal densities are used for these, separately in each class
* πk => is the marginal or prior probability for class k

* When the classes are well-separated, the parameter estimates for the logistic regression model are surprisingly unstable
* The linear discriminant analysis does not suffer from this problem
* If n is small and the distribution of the predictors X is approximately normal in each of the classes, the linear discriminant model is again more stable than the logistic regression model
* Linear discriminant analysis is popular when we have more than two response classes because it also provides low-dimensional views of the data

// TODO Discriminant Analysis
// Bayes Theorem
// Logistics Regression

