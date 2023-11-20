# Problem
The assignment three consisted of analysing meso and mast data provided by Vestas, a wind turbine company. The two datasets
represent wind speed and direction at two different heights at a specific location. The main analysis goals were:
1. Developing a regression model that can be used for the prediction of time series data
2. Evaluation whether a regression model is a good model for predicting time series data

# Preprocessing
The preprocessing steps have been implemented in the assignment:
1. Loading the Mast data from `risoe_m_all.nc` to a variable
2. Taking only subset of features from the data - `ws77`,`wd77`,`ws125`,`wd125`, `time`
3. Changing the time zone to `Erurope/Copenhagen`
4. Creating a data frame with the filtered and modified attributes
5. Resample the data to 1 hour frequency and make sure that the angle values are merged with a circular mean
6. Loading the Meso data from `meso_Risoe.csv` and create a data frame 
7. Merge the two data frames on the `time` column by using mean for the wind speed and circular mean for direction values
8. Drop the not merged columns
9. Fill the missing values via a forward fill
10. Introduce `season` dummies into dataset that represent the season of the year
11. Analyze outliers via Interquartile Range
12. Analyze the wind directions and speed of the data set
13. Fit a Weibull distribution to wind speed
14. Split the data into training and test set

# Algorithms - Linear Regression
* Has been chosen as a model for predicting time series data. It was decided due to the simplicity of the model and the
computational efficiency. As stated in the problem statement, the model should be used to assess whether linear regression
is a good model for predicting time series data, replacing more complex models.
* The data used it the model: `windDirectionAt125_120Meters`, `windDirectionAt80_77Meters`, `windSpeedAt125_120Meters`, 
`windSpeedAt80_77Meters`, `season_spring`, `season_summer`, `season_winter`, `season_fall`
* One of the limitations of using the model is non-flexibility. The model is not able to capture non-linear relationships,
which can be a problem in the case of wind speed and direction.
* We have tried to fit a polynomial regression model to the data, but the model was not able to capture the non-linear
  relationships in the data.

# Performance
Model Performance: Displayed the MSE, R² score, and cross-validation results.
Weibull Distribution Comparison: Presented the calculated "Error-in-A" and "Error-in-k".
The output of the model has the folllowing properties:
```
Mean Squared Error: 6.531001255648547
R^2 Score: 0.440805712545426
R^2 Scores from Cross-validation: [ 0.26525529  0.45942029  0.68362417  0.34398863 -1.39635742]
Average R^2 Score: 0.0711861890934963
Error-in-A: 1.6672655242391121
Error-in-k: 1.435270291770571
```
* R² score - shows that the model explains 44% of the variance in the data, which is not satisfactory.
* The cross-validation results show that the model is not robust, as the R² scores vary significantly. 
* The Error-in-A and Error-in-k we do not have a reference for, so we cannot conclude anything from these values 
without a domain knowledge.

# Reflection
The goal of the assignment was to assess whether we can reliably predict Meso and Mast data, based on the wind speed 
and direction via a regression model. We think that regression model is bad at explaining the variance of the data,
as the directions and speeds of the wind are very complex and not linearly correlated. 
Models that can capture non-linear relationships would probably perform better.
Overall, we have learned how to work with timeseries data, how to use linear regression model and how to assess the
performance of the model.
