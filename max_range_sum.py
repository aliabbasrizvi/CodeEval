import sys

def get_sum(range_val, numbers):
  max_sum = 0
  for i in xrange(range_val):
    max_sum += numbers[i]

  for i in xrange(len(numbers) - range_val):
    temp_sum = 0
    for j in xrange(i + 1, i + range_val + 1):
      temp_sum += numbers[j]

    if temp_sum > max_sum:
      max_sum = temp_sum

  return max_sum if max_sum > 0 else 0


def get_max_range_sum(test_case):
  range_val, num_list = test_case.split(';')
  range_val = int(range_val)
  numbers = [int(num) for num in num_list.split()]
  return get_sum(range_val, numbers)

with open(sys.argv[1], 'r') as test_cases:
  for test_case in test_cases:
    test_case = test_case.rstrip()
    print get_max_range_sum(test_case)
