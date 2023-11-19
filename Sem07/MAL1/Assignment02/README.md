# Problem
The main aim of the assignment two is to use data from K2 Kepler mission to build ML model to classify whether a planet 
is exoplanet or not. An exoplanet is a planet that orbits a star outside the solar system.

# Preprocessing
The preprocessing of this assignment consisted of the following steps:
1. Loading the data from `exoplanet_dataset.csv` file into a variable.
2. Mapping the column names to more readable feature names.
3. Plotting the `DispositionUsingKeplerData` labels from the data frame - `CANDIDATE` and `FALSE POSITIVE` 
to see the distribution of labels, and plotting the `DispositionUsingKeplerData` labels from the data frame - `CONFIRMED`, `CANDIDATE` and `FALSE POSITIVE`
4. Identifying missing values in the dataset
5. Plotting the missing percentage of values in features with the top 5 missing values 
6. Identifying outliers in the dataset
7. Deciding that the outliers should be kept in the dataset, as they are not errors, but rather a part of the dataset.
8. Removing null columns from the dataset - `EquilibriumTemperatureUpperUnc`, `EquilibriumTemperatureLowerUnc`
9. Removing irrelevant columns - `KepID`, `KOIName`, `KeplerName`, `TCEDeliver`
10. Removing rows with at least one null value in the remaining columns
11. Creating a correlation matrix to see the correlation between features. The result is that the correlation is low.
12. Dropping the features with correlation higher than 0.9 - `OrbitalPeriodLowerUnc`, `TransitEpochLowerUnc`, `TransitDurationLowerUnc`
`TransitDepthLowerUnc`, `PlanetaryRadiusUpperUnc`, `PlanetaryRadiusLowerUnc`, `InsolationFluxLowerUnc`, `InsolationFluxUpperUnc`
13. Mapping the `KeplerDispositionStatus` labels from the data frame - `FALSE POSITIVE`, `CANDIDATE` and `CONFIRMED` to `0`, `1` and `2` respectively
14. Mapping the `ArchiveDispositionStatus` labels from the data frame - `FALSE POSITIVE`, `CANDIDATE` and `CONFIRMED` to `0`, `1` and `2` respectively
15. Dropping the original `KeplerDispositionStatus` and `ArchiveDispositionStatus` columns
16. Displaying table with the created numeric labels
17. Scaling the data with `StandardScaler` to adjust the distances between data for each feature. This way we ensure that all the features are contributing to the result similarly.

Overall, the processing had man, steps, but the steps were easy to implement. The most time-consuming part was to 
identify the missing values and deciding what to do with outliers.

# Algorithms
It was chosen to use the following algorithms:
* `GaussianNB`: Chosen because it is often used for classification tasks with high-dimensional data. In our case, the dataset has
32 features, making the data expensive to train on certain ML models. The efficiency of the model makes it fast and easy to implement.
* `GridSearchCV`: Uses cross-validation to find the best parameters for the model. The models have been used to find the best parameters for `KNN` classifier.
Due to hyperparameter tuning, the model is more accurate than the `KNN` classifier with default parameters or `KNN` with manually tuned parameters.
As mentioned, we have used KNN for GridSearchCV, as it is a non-parametric algorithm, that can be used for different types of data - both categorical and numerical.

# Performance
* `GaussianNB`:
    * Accuracy of 95%
    * High Precision - 94%
    * High Recall - 98%
```
          Predicted: 
          1      0
Actual 1: 1014      63
       0: 17      857
```

* `GridSearchCV` with `KNN`:
    * Accuracy of 96%
    * High Precision - 96%
    * High Recall - 97%
```
          Predicted: 
          1      0
Actual 1: 1004      38
       0: 27      882
```

After fitting the model, we have plotted the feature importance for each class, as this information can be used to assess the
weight of each feature in the model.

Part of the assignment was to create functions for evaluating the models. The functions are:
* `confusion_matrix`: Creates a confusion matrix for the model
* `accuraccy`: Calculates the accuracy of the model
* `precision`: Calculates the precision of the model
* `recall`: Calculates the recall of the model
* `f1_score`: Calculates the f1-score of the model
* `specificity`: Calculates the specificity of the model

We have implemented these function in a way where a confusion matrix needs to be created first, and then used for evaluating the model
in terms of accuracy, precision, recall, f1-score and specificity. This way the functions can be used to evaluate any classification model.

One of the tools we wanted to use for assessing the model was the ROC curve. However, we were not able to implement it, as the
fitted models were producing very high probabilities, indicating that the model is very confident in its predictions. Therefore,
the only probabilities in ROC curve were higher than 0,90, making the ROC curve useless for assessing the model.

Part of the accuracy assessment was plotting the significance of each feature in the model. The plot shows that the most significant
features for both of the models were:
* `koi_fpflag_ss`
* `CentroidOffsetFalsePositiveFlag`
* `EphemerisMatchInidicatedContaminationFalsePositiveFlag`

These finding can be used to derive the importance these values in the context of the domain knowledge. As we are lacking this,
we won't be creating any conclusions based on these findings.

Overall the models seemed like a good fit for the data, as the accuracy was high. The `GaussianNB` model was slightly less accurate, 
with the difference of 1 percent, which is not significant and can change when the randomness seed is changed. Therefore both models
can be used for predicting whether a planet is exoplanet or not.

# Reflection
The assignment was a good opportunity for us to deeper our understanding in several topics. When it comes to preprocessing,
we have applied new techniques, such as creating correlation matrices and dropping highly correlated features.
One of the biggest differences from the previous assignment was that we have leveraged GridSearchCV to find the best parameters
for our `KNN` model, avoiding the need for manual hyperparameter tuning. In the context of `KNN`, the parameter is `k`. 
This made our work easier and made sure we fit the best model for the data.
We have also applied knowledge gained from school related to assessing model accuracy, such as confusion matrix, precision, recall, f1-score and specificity.
We have also learned how to plot the ROC curve, although we were not able to leverage it in this assignment (as mentioned above).
The domain knowledge of the data is important when it comes to any conclusions in the subject. There have been interesting findings,
but we have realised that without a proper domain knowledge, we cannot derive any conclusions.
