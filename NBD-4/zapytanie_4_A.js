printjson(db.people.aggregate(
    {
        $group: {
            _id: "$nationality",
            minBmi: {$min: {$divide: [{$toDouble: "$weight"}, {$pow: [{$divide: [{$toDouble: "$height"}, 100]}, 2]}]}},
            avgBmi: {$avg: {$divide: [{$toDouble: "$weight"}, {$pow: [{$divide: [{$toDouble: "$height"}, 100]}, 2]}]}},
            maxBmi: {$max: {$divide: [{$toDouble: "$weight"}, {$pow: [{$divide: [{$toDouble: "$height"}, 100]}, 2]}]}},
        }
    })
    .toArray())