
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

const circles = [];

circles.push(createCircle(createPoint(10, 20), 10));
circles.push(createCircle(createPoint(20, 30), 20));
circles.push(createCircle(createPoint(30, 40), 30));
circles.push(createCircle(createPoint(40, 50), 40));
circles.push(createCircle(createPoint(50, 60), 50));
circles.forEach((circle) => console.log(circle.toString()))

