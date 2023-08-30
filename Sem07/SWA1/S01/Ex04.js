function fun(m, n) {
    if (!n)
        return !m;

}

function factorial(n) {
    if (n === 0) {
        return 0;
    }

    return n + factorial(n - 1);
}

function power(m, n) {
    let res = m;
    for (let i = 0; i < n; i++) {
        res *= m;
    }
    return res;
}

console.log(power(5, 3));
console.log(factorial(10));
