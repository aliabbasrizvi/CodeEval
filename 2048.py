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

def get_next_iteration(rows, direction, grid):
  already_added = []

  if direction == UP:
    for k in xrange(rows - 1):
      for i in xrange(rows - k - 1):
        for j in xrange(rows):
          if (grid[i][j] == grid[i + 1][j] and (i, j) not in already_added) or grid[i][j] == 0 or grid[i + 1][j] == 0:
            if grid[i][j] == grid[i + 1][j]:
              already_added.append((i, j))
            grid[i][j] += grid[i + 1][j]
            grid[i + 1][j] = 0

  if direction == DOWN:
    for k in xrange(rows - 1):
      for i in xrange(rows - 1, k, -1):
        for j in xrange(rows):
          if (grid[i][j] == grid[i - 1][j] and (i, j) not in already_added) or grid[i][j] == 0 or grid[i - 1][j] == 0:
            if grid[i][j] == grid[i - 1][j]:
              already_added.append((i, j))
            grid[i][j] += grid[i - 1][j]
            grid[i - 1][j] = 0

  if direction == RIGHT:
    for k in xrange(rows - 1):
      for j in xrange(rows - 1, k, -1):
        for i in xrange(rows):
          if (grid[i][j] == grid[i][j - 1] and (i, j) not in already_added) or grid[i][j] == 0 or grid[i][j - 1] == 0:
            if grid[i][j] == grid[i][j - 1]:
              already_added.append((i, j))
            grid[i][j] += grid[i][j - 1]
            grid[i][j - 1] = 0

  if direction == LEFT:
    for k in xrange(rows - 1):
      for j in xrange(rows - k - 1):
        for i in xrange(rows):
          if (grid[i][j] == grid[i][j + 1] and (i, j) not in already_added) or grid[i][j] == 0 or grid[i][j + 1] == 0:
            if grid[i][j] == grid[i][j + 1]:
              already_added.append((i, j))
            grid[i][j] += grid[i][j + 1]
            grid[i][j + 1] = 0

  return grid

def get_solution(test_case):
  direction, rows, data = (test_data.strip() for test_data in test_case.split(';'))
  current_grid = generate_grid(data)
  next_grid = get_next_iteration(int(rows), direction, current_grid)
  return format_for_printing(next_grid)

with open(sys.argv[1], 'r') as test_cases:
  for test_case in test_cases:
    test_case = test_case.rstrip()
    print get_solution(test_case)
