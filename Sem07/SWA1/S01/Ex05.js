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
    if (n === 1)
        return m;
    let res = m;
    for (let i = 0; i < n; i++) {
        res *= m;
    }
    return res;
}

function advanced(m, n) {
    if (!n)
        return factorial(m);
    return power(m, n)
}

console.log(advanced(10, 1));
