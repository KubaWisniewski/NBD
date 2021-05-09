const mapFunction = function () {
    const bmi = parseFloat(this.weight) / Math.pow(parseFloat(this.height) / 100, 2)
    if (bmi > 0 && bmi !== Infinity && !isNaN(bmi))
        emit(this.nationality, {"minBmi": bmi, "avgBmi": {"sum": bmi, "count": 1}, "maxBmi": bmi})
}
const reduceFunction = function (_, values) {
    return {
        "minBmi": Math.min(...(values.map(x => x["minBmi"]))),
        "avgBmi": {
            "sum": Array.sum(values.map(x => x["avgBmi"]["sum"])),
            "count": Array.sum(values.map(x => x["avgBmi"]["count"]))
        },
        "maxBmi": Math.max(...(values.map(x => x["maxBmi"]))),
    }
}
const finalizeFunction = function (_, value) {
    return {
        "minBmi": value["minBmi"],
        "avgBmi": value["avgBmi"]["sum"] / value["avgBmi"]["count"],
        "maxBmi": value["maxBmi"],
    }
}
printjson(db.people.mapReduce(
    mapFunction,
    reduceFunction,
    {
        finalize: finalizeFunction,
        out: {inline: 1},
    })
);