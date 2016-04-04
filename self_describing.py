import sys

def is_self_describing(number):
  counts = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
  for digit in number:
    counts[int(digit)] += 1

  for idx in xrange(len(number)):
    if int(number[idx]) != counts[idx]:
      return 0
  return 1

with open(sys.argv[1], 'r') as numbers:
  for number in numbers:
    number = number.rstrip()
    print is_self_describing(number)
