In this exercise we use the IMDb-dataset, which we will use to perform a sentiment analysis. The code below assumes that the data is placed in the same folder as this notebook. We see that the reviews are loaded as a pandas dataframe, and print the beginning of the first few reviews.

**(a)** Split the reviews and labels in test, train and validation sets. The train and validation sets will be used to train your model and tune hyperparameters, the test set will be saved for testing. Use the `CountVectorizer` from `sklearn.feature_extraction.text` to create a Bag-of-Words representation of the reviews. Only use the 10,000 most frequent words (use the `max_features`-parameter of `CountVectorizer`).

**(b)** Explore the representation of the reviews. How is a single word represented? How about a whole review?

**(c)** Train a neural network with a single hidden layer on the dataset, tuning the relevant hyperparameters to optimize accuracy.

**(d)** Test your sentiment-classifier on the test set.

**(e)** Use the classifier to classify a few sentences you write yourselves.

# Problem
The assignment five problem is related to sentiment analysis of reviews from IMDB database. The goal is to develop a model
that will be able to predict the sentiment of a review - either positive or negative.

# Preprocessing
The preprocessing of this assignment consisted of the following steps:
1. Loading the data from `reviews.txt` and `labels.txt` file into a variable.
2. Mapping the `positive` label on reviews to integer 1 and `negative` to 0
3. Splitting the data into train, test and validation sets
4. Using `CountVectorizer` with `max_features` set to 10000 to create a Bag-of-Words representation of the reviews
5. Transforming the reviews into a matrix of token counts
6. Analysing the representation of the reviews

# Algorithms
* Sequential model
  * Simple model that consists layers triggered in a sequential order
  * Used for its simplicity
  * Layers
    * Dense with `relu` activation function with 128 neurons
    * Dropout with 0.5 rate - regularization technique that randomly drops neurons during training to avoid overwriting of the model 
    * Dense with `sigmoid` activation function - final layer for the binary classification
    * Optimizer - Adam - adaptive learning rate optimization algorithm
    * Loss function - binary `crossentropy` - default choice for binary classification problem

# Performance
* Sequential Model 
  * Accuracy: 99%
  * Loss: 2%
  * Val Accuracy: 59%
  * Val loss 59%
  * Val Accuracy: 88%
  * Test accuracy: 87%

# Reflection

We have also tested the prediction correctness on our own sentences. The model was able to predict the sentiment mostly correctly,
except a few cases. We attribute this inaccuracy also to the short length of teh reviews.