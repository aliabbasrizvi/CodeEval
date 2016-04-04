import sys

def get_words_in_sentence(sentence):
  return sentence.split(' ')

def get_longest_word(sentence):
  words = get_words_in_sentence(sentence)

  longest_word = words[0]
  for idx in xrange(1, len(words)):
    if len(words[idx]) > len(longest_word):
      longest_word = words[idx]

  return longest_word

with open(sys.argv[1], 'r') as sentences:
  for sentence in sentences:
    sentence = sentence.rstrip()
    print get_longest_word(sentence)
