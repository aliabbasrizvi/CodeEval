import sys

def get_sets(test_case):
  sets = test_case.split(';')

  set_1 = set(sets[0].split(','))
  set_2 = set(sets[1].split(','))

  return set_1, set_2

def get_intersection(test_case):
  set_1, set_2 = get_sets(test_case)

  return (',').join(sorted(set_1.intersection(set_2)))

with open(sys.argv[1], 'r') as test_cases:
  for test_case in test_cases:
    test_case = test_case.rstrip()
    print get_intersection(test_case)
