import sys
import urllib

def get_consistent_representation(url):
  url = url.lower()
  url = url.replace(':80', '')
  url = urllib.unquote(url)
  return url

def uris_match(test_case):
  url_1, url_2 = test_case.split(';')
  url_1 = get_consistent_representation(url_1)
  url_2 = get_consistent_representation(url_2)

  if url_1 == url_2:
    return True

  return False

with open(sys.argv[1], 'r') as test_cases:
  for test_case in test_cases:
    test_case = test_case.rstrip()
    print uris_match(test_case)
