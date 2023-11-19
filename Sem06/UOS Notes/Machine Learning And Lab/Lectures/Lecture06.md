# Classification Machine Learning Models
# Linear Regression
* Can be also used for classification problems
* e.g. - Y = { (0 if No) (1 if yes)
* The output of the linear regression can be more than 1 and less than 0. Therefore this value cannot be used as a probability of the dependent variable being 1 or 0
* Due to the problem with output values bigger than 1 and smaller than 0, we can use logistic regression that uses the basis of linear regression but outputs a probability instead of quantitative number

# Logistic regression
* The method used for the analysing dataset, in which there are one of more independent variables that determine the outcome - mostly binary, but can also output to multiple classes
* Supervised learning technique
### Binary prediction
* The output variable represents 0 / 1 in binary prediction
* Used to predict probability of result being 0 or 1
* Uses logistic function to model the relationship between independent variables and probability of the outcome
* Uses logistic function to output the probability of the result being 0 or 1
* Logistic function uses an S - shaped line that predicts two maximum values
* Estimates the coefficients of the independent variables (inputs) to predict the probability of the outcome (output). The coefficients represents one-unit change in the corresponding independent variable
* The mostly used threshold for prediction is 0.5 >= y  => e.g. - if the probability is bigger than 0.5, we say that the predicted class is 1, else 0
### Multinomial Regression
* Supervised learning technique that is commonly used in machine learning for multi-class classification task
* The output (dependent variable) is a categorical with three or more unordered levels - not ordinal
* Not ordinal outcomes - the outcome does not have a meaningful level/of ordering
* The outcomes of the variables can be
	* Continous: age, height, weight, temperature, time, blood pressure
	* Discrete: Number of children, number of pets, number of cars
	* Categorical: Gender, race, education level, occupation
* The method is used to calculate the log odds of each outcome in category. These log odds are then transformed into probability scores using the softmax function, which ensures that the probabilities for all outcome categories sum to 1

# Naive Bayes
* Probabilistic machine learning algorithm based on Bayes theorem
* Used widely for classification problems, mainly for text classification and spam filtering
* The main idea is to predict the probability of a particular class (or label), given set of features using Bayes theorem
* Bayes theorem
	* States that the probability of a hypothesis given some observed evidence is proportinal to the probability of the evidence given the hypothesis, multiplied by the prior probability of the hypothesis
	* Uses two main pieces of information:
		1. Prior probability of the class, which is out estimate of how likely it is for a particular class to occur before we've seen any of the pbserved features
		2. The probability of observing the features, given the class - this is also called the likelihood
	* These two probabilities are multiplied together, and as a result, we get the probability of class
* Makes strong assumption that the features are independent of each other, given the class level
$$P(\text{class} \mid \text{data}) = \frac{P(\text{data} \mid \text{class}) P(\text{class})}{P(\text{data})}$$


# Discriminant Analysis
* Statistical technique used for classification and prediction og categorical outcome based on a set of continuous or categorical predictor variables
* Aims to find relationships between
* Two main subcategories
	* Linear Discriminant Analysis (LDA)
	* Quadratic discriminant analysis
|                 | Linear Discriminant Analysis (LDA)         | Quadratic Discriminant Analysis (QDA)         |
|-----------------|--------------------------------------------|----------------------------------------------|
| Input data type  | Continuous                                 | Continuous                                   |
| Number of classes| Can handle multiple classes                | Can handle multiple classes                  |
| Assumptions      | Assumes equal covariance matrix for classes| Allows for different covariance matrix for each class |
| Decision boundary| Linear                                     | Non-linear                                   |
| Computation      | Simpler and faster than QDA                | More computationally expensive than LDA       |
| Overfitting      | Less prone to overfitting                   | More prone to overfitting                     |
| Applications     | Good for large datasets with few features  | Good for small datasets with complex features |

## Assumptions
* LDA
	* Assumes that the input data follows the multivariate normal distribution () with the same covariance matrix for all classes
	* The shape of the distribution is the same for all classes and the only difference is the location of the mean
* QDA
	* Each class to have its own covariance matrix
	* Assumes that the covariance matrices are different for each class
	* Can capture more complex relationships between the input variables and the target classes, but requires more data to estimate the covariance matrix accurately

# Resampling methods
* Used to estimate the performance of a model on unseen data by repeatedly sample subsets of data
* The idea is to simulate situation where the model encounters new unseen data
* Used for crucial for assessing the generalizability of the model
* Helpful when the data available for training is limited, or when there is an imbalance in the dataset
* By resampling, we ca generate new training datasets that better reflect the true distribution of the data, that can improve the performance of the model

## Cross-Validation
* The main idea is to split available data into multiple subsets/folds and use each fold as validation set while using the remaining folds for training
* Steps
	1. Split available data into k folds of equals size
	2. For each fold i use it as validation set and train the model on the remaining k-1 folds
	3. Computer the performance of the model on the validation set i
	4. Repeat steps 2-3 for each fold, using a different fold as the validation set each time
	5. Compute the average performance of the model over all k folds
* Allows to obtain the model's performance on unseen data and to assess its generalizability
* Helps to prevent overfitting by using diffferent subsets of the data for training and validation
### Cross-validation methods
* K-fold cross-validation
	* The most commonly used cross-validation method
	* Model is trained on K-1 folds and validated on the remaining fold
	* Process is repeated K times, each fold is used once for validation
	* Common number of folds (K) is 5 or 10, but other values can be used as well
* Leave-one-out cross-validation (LOOCV)
	* A special case of k-fold cross-validation, where the K (number of folds/subsets) is equal to the number of samples in the data (n)
	* Each model is trained on all samples except the left out
	* The process is repeated for each sample and the performance of the model is based on the average of performance of all subsets/folds

### Comparison between k-fold and loocv
| **Method** | **Bias** | **Variance** | **Estimated Prediction Error** |
| --- | --- | --- | --- |
| K-fold CV | Higher | Moderate | Decreases as K increases, more stable |
| Leave-One-Out CV | Low | Higher | Higher variance, computationally expensive, more prone to overfitting |

## Bootstrap
* Resampling technique used in machine learning to estimate statistical properties of a model, such as the bias and variance of the estimate
* Involves repeatedly sampling the data with replacement and fitting the model to the resampled data
* Works by creating multiple datasets by randomly selecting samples from the original dataset with replacement
* Each bootstrap sample can contain duplicate instances from the original dataset
* The size of each bootstrap sample is typically equal to the size of the original dataset
* The samples are created and originated from the original sample - around 2/3
* The values used from original sample are selected randomly
* The original