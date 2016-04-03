import sys

def get_lowercase_sentence(sentence):
  return sentence.lower()

with open(sys.argv[1], 'r') as sentences:
  for sentence in sentences:
    sentence = sentence.rstrip()
    print get_lowercase_sentence(sentence)
