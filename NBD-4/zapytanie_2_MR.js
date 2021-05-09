const mapFunction = function () {
    this.credit.forEach(x => emit(x.currency, parseFloat(x.balance)))
}
const reduceFunction = function (_, values) {
    return Array.sum(values);
}
printjson(db.people.mapReduce(
    mapFunction,
    reduceFunction,
    {
        out: {inline: 1},
    })
);