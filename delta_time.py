import sys

def get_hms(time_string):
  h, m, s = [int(comp) for comp in time_string.split(':')]
  return h, m, s

def compute_difference(h1, m1, s1, h2, m2, s2):
  if h1 > h2:
    pass
  elif h1 < h2:
    h, m, s = h2, m2, s2
    h2, m2, s2 = h1, m1, s1
    h1, m1, s1 = h, m, s
  else:
    if m1 > m2:
      pass
    elif m1 < m2:
      h, m, s = h2, m2, s2
      h2, m2, s2 = h1, m1, s1
      h1, m1, s1 = h, m, s
    else:
      if s1 > s2:
        pass
      else:
        h, m, s = h2, m2, s2
        h2, m2, s2 = h1, m1, s1
        h1, m1, s1 = h, m, s

  s = s1 - s2
  if s < 0:
    s += 60
    m1 -= 1

  m = m1 - m2
  if m < 0:
    m += 60
    h1 -= 1

  h = h1 - h2

  return '%s:%s:%s' % (str(h).zfill(2), str(m).zfill(2), str(s).zfill(2))

def get_difference(test_case):
  time_1, time_2 = test_case.split()
  h1, m1, s1 = get_hms(time_1)
  h2, m2, s2 = get_hms(time_2)

  return compute_difference(h1, m1, s1, h2, m2, s2)

with open(sys.argv[1], 'r') as test_cases:
  for test_case in test_cases:
    test_case = test_case.rstrip()
    print get_difference(test_case)
