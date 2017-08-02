#!/usr/bin/env python
# -*- coding:utf-8 -*-
import argparse
import json


def main():
    parser = argparse.ArgumentParser(description='Process some integers.')
    parser.add_argument('--iters', dest="num_of_iters",
                        type=int, required=True,
                        default=10,
                        help='Num of book entry')
    parser.add_argument('-o', dest="output_file",
                        type=str, required=True,
                        help='File path for the json to be written')

    args = parser.parse_args()

    obj = [{"category" : "reference", "author": "xxx", "title": {"a":{"b":{"c":{"d":{"e":"f"}}}}}} for i in range(args.num_of_iters)]
    with open(args.output_file, "w+") as fw:
        fw.write(json.dumps({"store" : {"book": obj}}, indent=2))

if __name__ == "__main__":
    main()