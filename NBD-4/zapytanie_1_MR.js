const mapFunction = function () {
    emit(this.sex, {"height": parseFloat(this.height), "weight": parseFloat(this.weight), "count": 1})
}
const reduceFunction = function (_, values) {
    return {
        "height": Array.sum(values.map(x => x["height"])),
        "weight": Array.sum(values.map(x => x["weight"])),
        "count": Array.sum(values.map(x => x["count"]))
    }
}
const finalizeFunction = function (_, value) {
    return {
        "avgHeight": (value["height"] / value["count"]),
        "avgWeight": (value["weight"] / value["count"])
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