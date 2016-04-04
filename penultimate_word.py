import sys

def get_penultimate_word(sentence):
  words = sentence.split()
  return words[len(words) - 2]

with open(sys.argv[1], 'r') as sentences:
  for sentence in sentences:
    sentence = sentence.rstrip()
    print get_penultimate_word(sentence)
