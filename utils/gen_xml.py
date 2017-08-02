#！/usr/bin/env python
# -*- coding:utf-8 -*-
from lxml import etree
import argparse

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
    root_name = "root"
    root = etree.Element(root_name)
    for i in range(args.num_of_iters):
        child_name = "child" + str(i)
        child = etree.Element(child_name)
        child.text = "some text"
        root.append(child)
    res = etree.tostring(root, pretty_print=True)
    print res
    with open(args.output_file, "w+") as fw:
        fw.write(res)
if __name__ == "__main__":
    main()
