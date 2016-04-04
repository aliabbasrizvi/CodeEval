import math
import re
import sys

def get_distance(test_case):
  x1, y1, x2, y2 = re.findall('[-\d]+', test_case)
  return int(math.sqrt(math.pow((int(x1) - int(x2)), 2) + math.pow((int(y1) - int(y2)), 2)))

with open(sys.argv[1], 'r') as test_cases:
  for test_case in test_cases:
    test_case = test_case.rstrip()
    print get_distance(test_case)
