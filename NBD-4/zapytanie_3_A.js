printjson(db.people.aggregate(
    {
        $group: {
            _id: 0,
            jobs: {$addToSet: "$job"},
        }
    })
    .toArray())