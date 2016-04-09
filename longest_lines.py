import sys

def print_n_longest(num, phrases):
  phrases.sort(key=lambda item: (-len(item), item))
  for idx in xrange(num):
    print phrases[idx]

with open(sys.argv[1], 'r') as lines:
  phrases = []
  count = 0
  number = 0
  for line in lines:
    if count == 0:
      number = int(line.rstrip())
      count = 1
      continue
    phrases.append(line.rstrip())
  print_n_longest(number, phrases)
