Installed:
- Python 3.9
- pip

```
pip install -r requirements.txt
```

Run RiakKV:
```
docker run --name=riak -d -p 8087:8087 -p 8098:8098 basho/riak-kv
```

Run script:
```
python3 .\riakKVClient.py
```
