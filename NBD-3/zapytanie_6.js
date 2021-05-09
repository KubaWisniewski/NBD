printjson(db.people.insertOne({
    "sex": "Male",
    "first_name": "Jakub",
    "last_name": "Wiśniewski",
    "job": "Programmer",
    "email": "s15662@pjwstk.edu.com",
    "location": {
        "city": "Warsaw",
        "address": {
            "streetname": "Xyz",
            "streetnumber": "120"
        }
    },
    "description": "Test description",
    "height": "193",
    "weight": "95.5",
    "birth_date": "1996-10-25T01:55:00Z",
    "nationality": "Poland",
    "credit": [
        {
            "type": "switch",
            "number": "1119888939100333222",
            "currency": "USD",
            "balance": "5000.05"
        }
    ]
}));
