# Parametric methods
* Parametric ML ALgorithms
	* Regression
	* LDA
	* Perceptors
* Parametric methods involve a two-step model approach
* If it learns from a predefined function
1. Making an assumption about the functional form or shape of f - e.g. f is linear
2. After the model has been selected, we need a procedure that uses the training data to fit or train the model
* Advantages
	* Simple
	* Fast
	* Fewer Data
* Disadvantages
	* Constrained
	* Limited Complexity
	* Poor fit depending on data


# Non-Parametric methods
* Any machine learning algorithm that does not make an assumption about the model function
* Good for big data with no prior knowledge
* Doesn't need the features to be extracted
* By not making an assumption, the function of the model is more flexible and can fit more possible shapes for f
* Algorithms
	* KNN - K-Nearest Neighbour
	* Naive Bayes
	* Neural networks
* Advantages
	* Flexibility
	* Power
	* Performance
* Disadvantages
	* More data to learn
	* Slower
	* Overfitting

# Semi-supervised learning
* Occurs when only part of the data set is labelled
* Often used if the labelling of data is expensive to do, so part of the dataset get s labelled, then is used to train the model, and rest get's labeled based on a model that labels the data

# Regression vs Classification
* Regression - Quantitative variables
* Classification - Qualitative variables


# Measuring the quality of fit
* Needed to evaluate the predictions against the observed data
* In regression, MSE is mostly used - Mean Squared Errors
$$ MSE= \frac{1}{n} \sum_{i=1}^n (y_{i} - f(x_{i}))^2 $$
* Errors are squared to remove negative signs
* Looking for the average of all errors
*