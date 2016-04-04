import sys

def get_direction(test_case):
  x1, y1, x2, y2 = test_case.split()

  direction = 'N' if y1 < y2 else 'S'
  direction = direction + ('E' if x1 < x2 else 'W')
  if x1 == x2:
    direction = direction.replace('E', '')
    direction = direction.replace('W', '')
  if y1 == y2:
    direction = direction.replace('N', '')
    direction = direction.replace('S', '')
  if direction == '':
    direction = 'here'

  return direction

with open(sys.argv[1], 'r') as test_cases:
  for test_case in test_cases:
    test_case = test_case.rstrip()
    print get_direction(test_case)
