
function createCircle(point, radius) {
    function getRadius() {return radius}
    function getCenterX() {return point.getX();}
    function getCenterY() {return point.getY();}
    function moveCenterTo(_x, _y) {point.move(_x, _y)}
    function toString() {return `Point: ${point.toString()}, radius: ${radius}`}
    return {getRadius, getCenterX, getCenterY, moveCenterTo, toString};
}

function createPoint(x, y) {
    function getX() {return x}
    function getY() {return y}
    function move(_x, _y) {x = _x; y = _y}
    function toString() {return `X: ${x}, Y: ${y}`}
    return {getX, getY, move, toString}
}

function createInheritance(x, y, radius) {
    let p = createPoint(x, y);
    let c = createCircle(createPoint(1, 1), radius)
    let toString = () => 'New toString'
    return {
        ...p,
        ...c,
        toString
    }
}

const inheritance = createInheritance(10, 10, 10);
console.log(inheritance.toString());
console.log(inheritance.getCenterX());
console.log(inheritance.getX());
