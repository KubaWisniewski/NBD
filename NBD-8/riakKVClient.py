import requests
import json

requests.post('http://127.0.0.1:8098/buckets/s15662/keys/PY9999',
              data=json.dumps({'type': 'Kabriolet', 'name': 'Python', 'seats': 4, 'weight': 1325.95}),
              headers={'cache-control': 'no-cache', 'content-type': 'application/json'})

responsePOST = requests.get('http://127.0.0.1:8098/buckets/s15662/keys/PY9999')
print(f"{responsePOST} -> {responsePOST.json()}")

requests.put('http://127.0.0.1:8098/buckets/s15662/keys/PY9999',
             data=json.dumps(
                 {'type': 'Kabriolet', 'name': 'NewPython', 'seats': 99, 'weight': 999.99, 'isNew': 'true'}),
             headers={'cache-control': 'no-cache', 'content-type': 'application/json'})

responsePUT = requests.get('http://127.0.0.1:8098/buckets/s15662/keys/PY9999')
print(f"{responsePUT} -> {responsePUT.json()}")

requests.delete('http://127.0.0.1:8098/buckets/s15662/keys/PY9999')

responseDELETE = requests.get('http://127.0.0.1:8098/buckets/s15662/keys/PY9999')
print(f"{responseDELETE} -> {responseDELETE.text}")
