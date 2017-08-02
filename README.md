# Example of Test message Parser

Date : 2017-08-02
 
# How to use it

## Step 1 : Generate large files

JSON

```sh
python gen_json.py --iters 100 -o sources/jsonfiles/100.json
```

XML

```sh
python gen_xml.py --iters 100 -o sources/xmlfiles/100.json
```

## Step 2 : Do Benchmarking

```sh
./gradlew run
```

# You will see

```text

```

## Reference
https://dom4j.github.io/
http://www.json.org/
https://www.w3.org/XML/
