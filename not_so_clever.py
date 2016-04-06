import sys

def sort_once(list_of_num):
  for i in xrange(len(list_of_num) - 1):
    if list_of_num[i] > list_of_num[i + 1]:
      temp = list_of_num[i]
      list_of_num[i] = list_of_num[i + 1]
      list_of_num[i + 1] = temp
      return list_of_num

  return list_of_num

def stupidly_sorted_list(test_case):
  numbers, iterations = test_case.split(' | ')
  iterations = int(iterations)
  list_of_num = [int(num) for num in numbers.split()]

  for i in xrange(iterations):
    list_of_num = sort_once(list_of_num)

  return (' ').join([str(num) for num in list_of_num])

with open(sys.argv[1], 'r') as test_cases:
  for test_case in test_cases:
    test_case = test_case.rstrip()
    print stupidly_sorted_list(test_case)
