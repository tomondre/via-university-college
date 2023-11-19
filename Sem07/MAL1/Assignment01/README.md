# Problem
The assignment number one is related to analyzing recent AirBnb listings in Copenhagen area. The main analysis goals were:
1. Analysing ocurrences of words in the listing names
2. Analysing ocurrences of words in names of hosts
3. Analysing the landscape of listings in Copenhagen and their respective prices
4. Analysing differences in prices between neighbourhoods
5. Analysing the top hosts of listings in Copenhagen
6. Analysing the neighbourhoods in terms of room type
7. Analysing the top 10 highest rated listings
8. Analysing the neighbourhoods in terms of whether they are expensive or affordable
9. Creating a model that classifies whether a listing is affordable or expensive

# Preprocessing
The solution to the mentioned problems/insights were different for each problem type. Before analysing any problem, 
a Data Preprocessing needed to be implemented. The following preprocessing steps have been implemented to ensure 
the data correctness and cleanliness of data:
1. Loading the data from `listings.csv` file into a variable
2. Taking only subset of features from the data to avoid unnecessary metrics
3. Removing the `$` from the price column
4. Dropping all reviews where `number_of_reviews=0`
5. Dropping all rows with null values to avoid inconsistencies
6. Making sure `neighbourhood_cleansed` values are not missing danish letters like `æ` `ø` `å`

There have also been a problem-related data cleansing implemented, related to the problem statements mentioned above:
1. The ocurrences of words in the listing names needed to have some of the words filtered out, as these did not bring 
value or were so many times mentioned that the scale of other words was too small. Some of the words included: `copenhagen`,
`with`, `in`, `the`,...
2. A listing host named `apartmentincopenhagen` needed to be filtered out, as it this is not a danish name.
3. An evenly-distributed bins have been created by applying the `log` function on the price column. The bins have been 
then used for easier to understand plotting of the landscape in Copenhagen and its prices
4. No additional preprocessing have been implemented
5. For the analysis of top hosts, the data needed to be grouped by `host_id` and sorted by `apartmentincopenhagen` 
to make sure that the head() of the data will show relevant rows
6. No additional preprocessing have been implemented
7. The data needed to be sorted by `review_scores_rating` and the first 10 data entries needed to be taken into 
consideration  
8. Creating a feature `price_category` responsible for holing a value 0 or 1 representing whether the listing is affordable or expensive.
9. Creating dummy columns based on `room_type` to make sure that one-hot encoding is implemented on the categorical data 
so that the ML algorithms can take this data into consideration. Also, the data has been scaled with `StandardScaler` 
to adjust the distances between data for each feature. This way we ensure that all features contribute to the result comparatively similar.
The `GaussianNB` model assumes that the underlying data has Gaussian distribution, therefore this was a important 
pre-processing step to ensure the `GaussianNB` has a good performance.

# Algorithms
There have been two algorithms used in the assignment - `GaussianNB` and `KNN`. The problem that the algorithms are solving is 
the classification of listing into `affordable` or `expensive` 
Reason for choosing the two algorithms are:
* `GaussianNB`: Often used for classification tasks with high-dimensional data. In the case of our assignment, the dataset has
22 features, making the data hard to train on certain ML models. The simplicity and efficiency of the model makes it fast and easy to implement. 
* `KNN`: Is a non-parametric algorithm, that can be used for different types of data - both categorical and numerical. 
The model is also suitable for `latitude` and `longitude`, as KNN is finding the distances between features and can find 
relationships in spatial data. We have manually tested different values of `k`, and found number 60 as the best parameter. 
The KNN does not have underlying assumption of the data, although scaling the data before training the model can 
improve performance, to make sure the distance calculation is not biased.

# Performance
* `GaussianNB`: 
  * Accuracy of 61%
  * Classifying `affordable` listings shows:
    * High Precision - 82%
    * Low Recall - 27%
  * Classifying `expensive` listings shows:
    * Lower Precision - 57%
    * Very High Recall - 94% 
* `KNN`:
  * Accuracy of 71% 
  * Classifying affordable listings shows:
    * Balanced Precision - 71% 
    * Similar Recall - 70% 
  * Classifying expensive listings shows:
    * Similar Precision - 71% 
    * Slightly Higher Recall - 73%

# Reflection
Making this assignment we have applied our knowledge gained from theory lessons in practice. The AirBnb dataset is from
real data, therefore it included many inconsistencies and a data preprocessing needed to be implemented correctly to ensure
the model accuracy. We have applied the following preprocessing theories:
* Data Subset selection
* Missing Value Handling
* Data Cleaning for text analysis
* Data binning
* One-hot encoding for categorical data
* Data Scaling
* Handling spatial data

When it comes to the algorithms used, we have realised, how important it is to choose the right model for 
underlying dataset types. From the performance results, it seems like `KNN` has performed better as it can handle spatial data,
like `longitude` and `latitude`.
Another learning is that we should better handle outliers and `high-leverage` points, as this has skewed the scale of our graphs, 
impacting their interpretations.
The `k` in `KNN` was tested manually, which looking back was not an optimal solution. An automated way of finding `k` 
should be implemented next time, via a loop that would fit the model with different k and compare the accuraccy. 
This way we make sure that the chosen k is really the most accurate. 