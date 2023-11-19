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
9. Creating a model that predicts whether a listing is affordable or expensive

# Preprocessing
The solution to the mentioned problems/insights were different for each problem type. Before analysing any problem, 
a Data Preprocessing needed to be implemented. The following preprocessing steps have been implemented to ensure 
the data correctness and cleanliness of data:
1. Loading the data from `listings.csv` file into a variable
2. Taking only subset of features from the data to avoid unneccessary metrics
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
9. Creating dummy columns based on `room_type` to make sure that one-hot encoding is implemented on the categorical data to make su,

# Algorithms

# Performance

# Reflection
Removing outliers, as some of the plots (especially in problem no. 4) were not plotted correctly
[//]: # (Dummy categorization)



[//]: # (TODO Check the conversion from US to DKK)
[//]: # (TODO Check the missing list of the top 10 rated listings)