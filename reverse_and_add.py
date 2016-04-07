import sys

def is_palindrome(number):
  if number == number[::-1]:
    return True

  return False

def get_next_value(number):
  return str(int(number) + int(number[::-1]))

def get_palindrome(number):
  iterations = 0

  while not is_palindrome(number):
    number = get_next_value(number)
    iterations += 1

  return '%s %s' % (iterations, number)

with open(sys.argv[1], 'r') as numbers:
  for number in numbers:
    number = number.rstrip()
    print get_palindrome(number)
