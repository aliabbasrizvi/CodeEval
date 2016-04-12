import sys

def get_stepwise_string(test_case):
  words = test_case.split()
  longest_word = words[0]
  for idx in xrange(1, len(words)):
    if len(words[idx]) > len(longest_word):
      longest_word = words[idx]

  stepwise_string = ''
  for idx in xrange(len(longest_word)):
    for count in xrange(idx):
      stepwise_string += '*'
    stepwise_string += longest_word[idx] + ' '

  return stepwise_string.rstrip()

with open(sys.argv[1], 'r') as test_cases:
  for test_case in test_cases:
    test_case = test_case.rstrip()
    print get_stepwise_string(test_case)
