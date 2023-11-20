# Problem
The assignment five problem is related to sentiment analysis of reviews from IMDB database. The goal is to develop a model
that will be able to predict the sentiment of a review - either positive or negative.

# Preprocessing
The preprocessing of this assignment contains the following steps:
1. Loading the data from `reviews.txt` and `labels.txt` file into a variable.
2. Mapping the `positive` label on reviews to integer 1 and `negative` to 0
3. Splitting the data into train, test and validation sets
4. Using `CountVectorizer` with `max_features` set to 10000 to create a Bag-of-Words model representation of the reviews.
It represents text data as a vector of word counts, that ignores the order of the words and grammar. The `max_features` parameter
is used to limit the vocabulary of the model to the most 10000 frequently used words. The transformation allows us to
train the model on the data, as the model cannot easily work with text data.
5. Transforming the reviews into a matrix of token counts
6. Analysing the representation of the reviews

Overall the data was clean and did not need any additional preprocessing.

# Algorithms
* Sequential model
  * Simple model that consists layers triggered in a sequential order
  * Used for its simplicity
  * Structure
    * Dense layer with `relu` activation function and 128 neurons. The layer has been chosen for its simplicity and wide range
      range of use cases. Dense layer is a fully connected layer that introduces non-linearity to the model.
    * Dropout layer with `0.5` rate - regularization technique that randomly drops neurons during training to avoid overwriting of the model 
    * Dense layer with `sigmoid` activation function - final layer for the binary classification
    * Optimizer - Adam - adaptive learning rate optimization algorithm
    * Loss function - binary `crossentropy` - default choice for binary classification problem

# Performance
Sequential Model: 
* Accuracy: 99%
* Loss: 2%
* Val Accuracy: 88%
* Val loss 59%
* Test Accuracy: 87%
* Test loss: 61%

The number of epochs of the model is 10. Overall we could see improvement of test accuracy and validation accuracy.
We could also see the increase of `val_loss`, which is not a good sign, as it may indicate hte model is starting to overfit
the data. 

# Reflection
Reflecting on the assignments, we think that several learning outcomes have been achieved: Leveraging NLP techniques to
analyse text data, using AI to solve real-world problem, apply the model with different layer configurations and learn what does each layer do.
The trained model has been also tested with our own sentences, and it was able to predict the sentiment with high precision,
although some of the sentences were not predicted correctly. We attribute this to the short length of the sentences, as the model
has been trained on long sentences. Overall we think that the model is simple, but yet effective at predicting the sentiment
of the reviews. We have also realised, that the manual parameter tuning is a very time-consuming process, and for the future
we should find more automated ways of tuning the parameters.
