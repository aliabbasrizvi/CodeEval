#include <stdio.h>
#include <string.h>
#define LEN 80

int isTrailing(char str[], char phrase[]) {
  int strLen = strlen(str);
  int phraseLen = strlen(phrase);
  int i, j;
  if (phraseLen > strLen) {
    return 0;
  }

  for (i = phraseLen - 1, j = strLen - 1; i >= 0; i--, j--) {
    if (str[j] != phrase[i]) {
      return 0;
    }
  }
  return 1;
}

int main(int argc, char *argv[]) {
  FILE *fp;
  char *line;
  char phrase[LEN];
  char str[LEN];
  size_t len;
  int i, j;

  if (argc != 2) {
    printf("Unsupported number of parameters passed. Exiting.\n");
    return 1;
  }

  fp = fopen(argv[1], "r");
  getline(&line, &len, fp);
  while (!feof(fp)) {
    i = 0;
    j = 0;
    while (line[i] != ',') {
      str[i] = line[i];
      i++;
    }
    str[i] = '\0';
    i++;
    while (line[i] != '\n' && line[i] != '\0') {
      phrase[j] = line[i];
      i++;
      j++;
    }
    if (line[i] == '\0') {
      continue;
    }
    phrase[j] = '\0';
    printf("%d\n", isTrailing(str, phrase));
    getline(&line, &len, fp);
  }

  fclose(fp);
  return 0;
}
