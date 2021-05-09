const mapFunction = function () {
    emit("", this.job)
}
const reduceFunction = function (_, values) {
    return [...new Set(values)]
}
printjson(db.people.mapReduce(
    mapFunction,
    reduceFunction,
    {
        out: {inline: 1},
    })
);