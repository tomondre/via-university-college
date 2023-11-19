Sure, here are brief descriptions for each topic:

1. Machine Learning vs Statistical Learning
	* Machine Learning is more interested in prediction accuracy
	* Statistical Learning is more interested in interpretability uncertainty
2. Machine Learning Methods
   - Supervised Learning: This is a type of machine learning where an algorithm learns from labeled training data, and uses this learning to classify new inputs or predict outcomes.
     - Regression Problem: A type of predictive modeling technique which investigates the relationship between a dependent (target) and independent variable(s) (predictor).
       - Linear Regression: This technique predicts a dependent variable based on one independent variable.
       - Multiple Linear Regression: This technique predicts a dependent variable based on multiple independent variables.
     - Classification Problem: This involves predicting the class or category of an object or sample.
       - Logistic Regression: A classification algorithm used to predict a binary outcome.
       - Bayes Optimal Classifier: A classification technique that minimizes the probability of misclassification.
       - Nearest-neighbour Method: A type of instance-based learning where the class of a test sample is determined by the classes of its nearest neighbors in the training set.
       - Discriminant Analysis: A statistical analysis used to predict a categorical dependent variable by one or more continuous or binary independent variables.
   - Unsupervised Learning: This type of machine learning finds patterns in data without prior guidance or labels.
     - Principal Component Analysis: A method used to reduce dimensionality in a dataset while retaining as much variability as possible.
     - Clustering: The task of dividing the data points into several groups such that data points in the same group are more similar to other data points in the same group and dissimilar to the data points in other groups.
       - K-means Clustering: A type of unsupervised learning used to classify data into clusters based on certain shared characteristics.
       - Hierarchical Clustering: This method creates a hierarchy of clusters which may be represented in a tree structure.
3. Approach Types
   - Parametric Approach: This approach assumes a specific form for the functional relationship between the features and the response. Easier to interpret depending on model
   - Non-parametric Approach: This approach doesn't make strong assumptions about the functional form of the relationship between the features and the response. Hard to interpret.
4. Feature Selection
   - Subset Selection: Techniques used for selecting a subset of features from the dataset that are most relevant to the prediction.
     - Forward Selection: A type of stepwise regression that begins with an empty model and adds in variables one by one. Uses lowest RSS to evaluate performance of predictor. Do this until a criteria is met.
     - Best Subset: This approach considers all possible subsets of the predictors and selects the subset that provides the best fit to the data. Very hard on computation
5. Advanced Modelling Techniques
   - Beyond Linearity: These techniques are used when the relationship between predictors and response is non-linear.
     - Polynomial Regression: A type of regression where the relationship between the input variables and the output variable is modelled as an nth degree polynomial.
     - Step Function: A function that increases or decreases abruptly from one constant value to another.
     - Piecewise Polynomials: Also known as spline, it's a type of function created by joining polynomial segments together.
     - Linear Splines: A type of spline created from pieces of linear functions.
     - Natural Cubic Splines: A cubic spline with additional constraints that the function is linear beyond the boundary knots.
     - Knot Placement: The process of deciding where to place the knots in spline functions.
   - Tree-Based Methods: These methods partition the feature space into a set of rectangles, and then fit a simple model (like a constant) in each one. Pruning is used to take complex trees to obtain a subtree - to create fewer tree regions and avoid overfitting of training data
     - Regression: The output variable is a real or continuous value, like salary or weight.
     - Classification: The output variable is a category, like red or blue, spam or not spam
       - Gini Index: A metric to measure how often a randomly chosen element would be incorrectly identified.
   - Trees Improvements: Techniques used to improve the performance of decision trees.
     - Bagging: An ensemble technique primarily used to reduce the variance of our predictions by combining the result of multiple classifiers modeled on different sub-samples of the same data set.
     - Random Forest: An ensemble of decision trees, generally trained via the bagging method.
     - Boosting: An ensemble method that combines multiple weak classifiers to form a strong classifier.
6. Predictors
   - Qualitative and Quantitative Predictors: The input variables which can be either categorical (qualitative) like gender, or numerical (quantitative) like age.
7. Special Considerations
   - Outliers: These are data points that are significantly different from other observations.
   - High Leverage Points: These are observations with extreme predictor (x) values that may potentially influence the results of the analysis.
8. Hypothesis Testing: It's a statistical method used to make inferences or draw conclusions about a population based on a sample.
9. Regularisation Methods
   - Shrinkage: A method used to reduce the complexity of a model.
     - Ridge Regression: A regularisation technique that uses L2 penalty to shrink the coefficients towards zero to prevent overfitting.
     - Lasso: A regularisation technique that uses L1 penalty to not only prevent overfitting but can help in feature selection by making some coefficients zero.. Performs better with small number of predictors
   * Dimensionality Reduction
     - PCR Principal Components Regression: A method that combines principal component analysis and regression. It first extracts the principal components of the features and then performs regression on these components.
     - PLS Partial Least Squares: A method that projects the predictors and the response onto a new space and performs the linear regression in this new space. Can be more effective due to a fact that it also considers response variable
10. Error Estimation
    - Estimating Errors: Evaluating the performance of the model.
      - AIC (Akaike Information Criterion): A measure of the relative quality of a statistical model for a given set of data.
      - BIC (Bayesian Information Criterion): Similar to AIC, it's a criterion for model selection among a class of models.
      - Adjusted $R^2$: A statistical measure that offers an adjustment to the $R^2$ value of a regression model to account for each predictor variable included in the model.
11. Resampling Methods
    - K-fold Cross-validation: A technique used to assess the accuracy of a model by dividing the original sample into a training set to train the model, and a validation set to evaluate it.
    - Bootstrap: A method of estimating the sampling distribution of a statistic by creating a large number of resamples with replacement from the original data.
    - Validation Set: A subset of the data used to provide an unbiased evaluation of a model fit on the training set.
12. Model Evaluation Trade-offs
    - Flexibility - Interpretability: The trade-off between a model's ability to fit complex patterns (flexibility) and its simplicity and understandability (interpretability).
    - Bias-Variance Trade-off: The balance that must be achieved between bias (oversimplification) and variance (overfitting).