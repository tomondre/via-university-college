# Solution01 - 6.6 Q9
1. 
```
train_indices <- sample(nrow(College), nrow(College) * 0.7)
train_data <- College[train_indices, ]
test_data <- College[-train_indices, ]
```
2. 
```
lm_model <- lm(Apps ~ ., data = train_data) 
test_error_lm <- sqrt(mean((test_data$Apps - predict(lm_model, newdata = test_data))^2))
test_error_lm # 1286.721
```
3. 
```
cv_ridge <- cv.glmnet(as.matrix(train_data[, -1]), train_data$Apps)
test_predictions_ridge <- predict(cv_ridge$glmnet.fit, newx = as.matrix(test_data[, -1]))
test_error_ridge <- sqrt(mean((test_data$Apps - test_predictions_ridge)^2))
test_error_ridge # 1688.747
```
4. 
```
cv_lasso <- cv.glmnet(as.matrix(train_data[, -1]), train_data$Apps, alpha = 1)
lasso_model <- cv_lasso$glmnet.fit
test_predictions_lasso <- predict(lasso_model, newx = as.matrix(test_data[, -1]))
test_error_lasso <- sqrt(mean((test_data$Apps - test_predictions_lasso)^2))
non_zero_coeffs <- sum(coef(lasso_model) != 0)
test_error_lasso # 1688.747
non_zero_coeffs # 77
```
5. 
```
ctrl <- trainControl(method = "repeatedcv", number = 10, repeats = 3)
tuned_pcr <- train(Apps ~ ., data = train_data, method = "pcr", trControl = ctrl)
test_error_pcr <- RMSE(predict(tuned_pcr, test_data), test_data$Apps)
test_error_pcr # 2398.833
tuned_pcr$bestTune$ncomp # 3
```
6. As we have learned in class, the choice of the model depends a lot on the data provided. Overall the test error seemed to be the smallest on linear mored using least squares. This is suprising because I thought the results should be better for lasso and redge regression, but it may be that the data set is very linear. Overall, there is a quite big difference in the test errors between the different methods

# Solution02 - 7.9 Q1

We need to match corresponding powers of x
1. 
$a1 = β0 (constant)$ 
$b1 = β1$ 
$c1 = β2$ 
$d1 = β3$

2. 
$f2(x) = a2 + b2x + c2x^2 + d2x^3$
$f(ξ) = β0 + β1ξ + β2ξ^2 + β3ξ^3 + β4(ξ - ξ)^3+2 = β0 + β1ξ + β2ξ^2 + β3ξ^3$
$2(x) = β0 + β1x + β2x^2 + β3x^3$
$a2 = β0$ 
$b2 = β1$ 
$c2 = β2$ 
$d2 = β3$
3. 
$f1(ξ) = β0 + β1ξ + β2ξ^2 + β3ξ^3 f2(ξ) = β0 + β1ξ + β2ξ^2 + β3ξ^3$
4. 
$f1(x) = a1 + b1x + c1x^2 + d1x^3$
$f1′(x) = b1 + 2c1x + 3d1x^2$
$f2(x) = a2 + b2x + c2x^2 + d2x^3$
$f2′(x) = b2 + 2c2x + 3d2x^2$
$f1′(ξ) = β1 + 2β2ξ + 3β3ξ^2 f2′(ξ) = β1 + 2β2ξ + 3β3ξ^2$
$f1′(ξ) = f2′(ξ)$ => derivative is continuous
5. 
$f1′′(x) = 2c1 + 6d1x$
$f2(x) = a2 + b2x + c2x^2 + d2x^3$
$f2′′(x) = 2c2 + 6d2x$
$f1′′(ξ) = 2β2 + 6β3ξ f2′′(ξ) = 2β2 + 6β3ξ$
$f1′′(ξ) = f2′′(ξ)$ => derivative is continuous

# Solution03 - 7.9 Q5
1. $g_1$ will likely have smaller RSS 
2. $g_1$ will likely have smaller RSS
3. both $g_1$ $g_2$ will likely have same RSS
# Solution04 - 7.9 Q9
1. ![[Pasted image 20230531143226.png]]![[Pasted image 20230531143317.png]]
2. ![[Pasted image 20230531144252.png]]
	RSS: $2.768563, 2.035262, 1.934107, 1.932981, 1.915290, 1.878257, 1.849484, 1.835630, 1.833331, 1.832171$
3. ![[Pasted image 20230531144758.png]]![[Pasted image 20230531144846.png]]
RSS: $1.934107, 1.934107, 1.934107, 1.922775, 1.840173, 1.833966, 1.829884, 1.816995, 1.825653, 1.792535$
4. By selecting optimal degree for polynomial regression, we can determine the best degree. The results of the model after using cross-validation were better, when considering that the model is predicting unseen data with bigger accuracy.
5. ![[Pasted image 20230531145014.png]]