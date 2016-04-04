import sys

UP = 'UP'
DOWN = 'DOWN'
RIGHT = 'RIGHT'
LEFT = 'LEFT'

def generate_grid(data):
  grid = []
  rows_data = data.split('|')
  for row_data in rows_data:
    grid.append([int(num) for num in row_data.split()])

  return grid

def format_for_printing(grid):
  row_strings = []
  for idx in xrange(len(grid)):
    row_strings.append(' '.join(str(num) for num in grid[idx]))

  return '|'.join(row_strings)

def get_solution(test_case):
  direction, rows, data = (test_data.strip() for test_data in test_case.split(';'))
  current_grid = generate_grid(data)
  return format_for_printing(current_grid)

with open(sys.argv[1], 'r') as test_cases:
  for test_case in test_cases:
    test_case = test_case.rstrip()
    print get_solution(test_case)
